package tn.esprit.bookstore.controller;

import com.sun.istack.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IPbookService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/book/")
public class PbookController {
    final IPbookService pbookService;
    long bookFreeId;
     double bookPrice;
    public PbookController(IPbookService pbookService) {
        this.pbookService = pbookService;
    }


    @GetMapping("listbook")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(pbookService.findAll());
    }
    @GetMapping("byid/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(pbookService.findById(id));
    }

    @PostMapping("addbook")
    public ResponseEntity<?> save(@RequestBody PBook pbook){
        if(pbook.getId() == null){
            Optional<PBook> pbook1 = Optional.of(pbookService.save(pbook));
            return ResponseEntity.created(null).body(pbook1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody PBook Pbook){
        if(Pbook.getId() != null){
            PBook book1 = pbookService.save(Pbook);
            return ResponseEntity.accepted().body(book1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        pbookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("cat/{id}")
    public ResponseEntity<?> findByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(pbookService.findByCategory(id));
    }

    @PostMapping("file")
    @ResponseBody
    public PBook uploddimg (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("book") Long id ) {
        PBook book =pbookService.findById(id);
        if(file==null) {
            book.setImageUrl("defaultPic.png");
            pbookService.save(book);

        }else {

            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();
                //File f = new File(classLoader.getResource(".").getFile() +"\\public\\resources\\UplodeFile\\UplodeImage\\" +"image" + id+file.getOriginalFilename());
                File f = new File("C:\\upload\\" +"image" + id+file.getOriginalFilename());
                file.transferTo(f);
                book.setImageUrl("image"+id+file.getOriginalFilename());
                pbookService.save(book);

            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        return(book);
    }

    @Scheduled(fixedDelay=20000)
    public void freebookRand(){
        List<PBook> books =pbookService.findAll();
        int nbBooks= books.size();
        long nb= nbBooks;
        long rande = ThreadLocalRandom.current().nextLong(nb);
        PBook bookshosen = books.get((int) rande);
         bookFreeId = bookshosen.getId();
        bookPrice =  bookshosen.getPrice();
        if (bookPrice!=0){
            bookshosen.setPrice(0);
        }
        pbookService.save(bookshosen);
        System.out.println("free book");

    }
    @Scheduled(fixedDelay=20000)
    public void endFreebookRand() {
        PBook bookshosen = pbookService.findById(bookFreeId);
        bookshosen.setPrice(bookPrice);
        pbookService.save(bookshosen);
        System.out.println("updated");
    }
}





