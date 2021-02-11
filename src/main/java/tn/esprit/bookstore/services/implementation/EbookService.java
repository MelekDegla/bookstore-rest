package tn.esprit.bookstore.services.implementation;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.EBook;
import tn.esprit.bookstore.entities.Event;
import tn.esprit.bookstore.repository.CommentRepository;
import tn.esprit.bookstore.repository.EbookRepository;
import tn.esprit.bookstore.repository.EventRepository;
import tn.esprit.bookstore.services.IEbookService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

@Service

public class EbookService implements IEbookService {
    final EbookRepository ebookRepository;
    @Autowired
    EventService eventService;
    @Autowired
    CommentRepository commentrep;
    @Autowired
    public EbookService(EbookRepository ebookRepository) {
        this.ebookRepository = ebookRepository;
    }
    @Override
    public EBook save(EBook book){
        return ebookRepository.save(book);
    }
    @Override
    public EBook findById(Long id) {
        return  ebookRepository.findById(id).orElse(null);
    }
    @Override
    public List<EBook> findAll() {
        return ebookRepository.findAll();

    }

    @Override
    public void deleteById(Long id) {
        ebookRepository.deleteById(id);

    }

    @Override
    public List<EBook> findByCategory(Long id) {
        return ebookRepository.findByCategory(id);
    }

    @Override
    public List<EBook> filterBooks(String pattern) {
        Iterable<EBook> Books = ebookRepository.findAll();
     List<EBook> filteredBooks = new ArrayList<>();
      Books.forEach(filteredBooks::add);

      filteredBooks = filteredBooks.stream()
                .filter(b ->  (b.getCategory()!=null&& b.getCategory().getName().contains(pattern) )||(b.getDescription()!=null&& b.getDescription().contains(pattern) )||
                          (b.getAuthor()!= null && b.getAuthor().getName().contains(pattern)) ||
                          ( b.getAuthor()!= null && b.getAuthor().getLastname().contains(pattern))||
                        ( b.getTitle()!=null && b.getTitle().contains(pattern))
                )
                .collect(Collectors.toList());
        return filteredBooks;
    }

    @Transactional
    public Event openEventOnBook() {
        List<EBook> books = ebookRepository.findAll();
        Map<Long,Integer> bookAndNumberComment=new HashMap<>();
        Map<Long,Integer> treeval=new HashMap<>();

        books.forEach((eBook -> bookAndNumberComment.put(eBook.getId(), eBook.getComments().size())));
      treeval=bookAndNumberComment.entrySet()
              .stream()
              .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Book exisitngBook= new Book();
        Long bookeventId = treeval.keySet().stream().findFirst().get();
        exisitngBook= ebookRepository.findById(bookeventId).orElse(null);
        Event event = new Event();
        event.setDescription("Book " + exisitngBook.getTitle() + " Event");
        event.setTitle("Book " + exisitngBook.getTitle() + " Event");
        event.setDate(LocalDateTime.now().plusDays(3));
        eventService.add(event);
        return  event;



    }


}
