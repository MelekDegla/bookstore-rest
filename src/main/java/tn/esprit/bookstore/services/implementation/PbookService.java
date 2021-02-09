package tn.esprit.bookstore.services.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.controller.PbookController;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.repository.PbookRepository;
import tn.esprit.bookstore.repository.UserRepository;
import tn.esprit.bookstore.services.IPbookService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PbookService implements IPbookService {
    private static final Logger logger = LogManager.getLogger(PbookController.class);

    final PbookRepository pbookRepository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService customerService;
    @Autowired
    public PbookService(PbookRepository pbookRepository) {
        this.pbookRepository = pbookRepository;
    }
    @Override
    public PBook save(PBook book){
        return pbookRepository.save(book);
    }
    @Override
    public PBook findById(Long id) {
        return  pbookRepository.findById(id).orElse(null);
    }
    @Override
    public List<PBook> findAll() {
        return pbookRepository.findAll();

    }
    @Override
    public void deleteById(Long id) {
        pbookRepository.deleteById(id);

    }

    @Override
    public List<PBook> findByCategory(Long id) {
        return  pbookRepository.findByCategory(id);

    }

    @Override
    public PBook findBookByTitle(String title) {
        return pbookRepository.findBookByTitle(title);
    }

    @Override
    public List<PBook> showRelatedBooks() {
        User customer = customerService.getAuthenticatedCustomer();
        List<PBook> selectedBooks = pbookRepository.getSelectedBooksByCustomerOrdered(customer.getId());
        selectedBooks = selectedBooks.stream().limit(3).collect(Collectors.toList());
        for (Book book : selectedBooks) {
            logger.warn("selected book " + book.getTitle() + " with categories " + book.getCategory());
        }
        String categoriesList = "";
        for (Book book : selectedBooks) {
            Set<Category> categories = (Set<Category>) book.getCategory();
            for (Category category : categories) {
                if (!categoriesList.contains(category.getName()))
                    categoriesList = categoriesList + " " + category.getName();
            }
        }
        categoriesList = categoriesList.substring(1);
        if (customer.calculAge() <= 10 && !(categoriesList.contains("Kids")))
            categoriesList = categoriesList + " " + "Kids";
        else if (customer.calculAge() > 10 && customer.calculAge() <= 30 && !(categoriesList.contains("Action")))
            categoriesList = categoriesList + " " + "Action";
        else
            categoriesList = categoriesList + " " + "History";
        List<PBook> relatedBooks = getBooksFilteredByCategories(categoriesList);

        relatedBooks.removeAll(selectedBooks);
        return relatedBooks;
    }

    @Override
    public List<PBook> getBooksFilteredByCategories(String categoriesList) {
        Set<Category> categories = new HashSet<>();
        String[] liStrings = categoriesList.split(" ");
        for (String xString : liStrings) {
            categories.add(categoryService.getCategoryByName(xString));
        }
        List<PBook> books = pbookRepository.findAll();
        List<PBook> filteredBooks = new ArrayList<>();
        for (PBook book : books) {
                if (categories.contains(book.getCategory())) {
                    filteredBooks.add(book);
                    break;

            }
        }
        return filteredBooks;

    }


}
