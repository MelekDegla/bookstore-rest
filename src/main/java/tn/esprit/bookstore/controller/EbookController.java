package tn.esprit.bookstore.controller;

import com.sun.istack.Nullable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.entities.EBook;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IEbookService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/ebook/")
public class EbookController {
    final IEbookService ebookService;
    public EbookController(IEbookService ebookService) {
        this.ebookService = ebookService;
    }
    @GetMapping("getall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(ebookService.findAll());
    }

    @PostMapping("ajoutbook")
    public ResponseEntity<?> save(@RequestBody EBook ebook){
        if(ebook.getId() == null){
            Optional<EBook> ebook1 = Optional.of(ebookService.save(ebook));
            return ResponseEntity.created(null).body(ebook1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }
    @GetMapping("id/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(ebookService.findById(id));
    }
    @GetMapping("crit")
    public ResponseEntity<?> searchByCrit(@RequestParam("pattern") String Pattern){
        return ResponseEntity.ok(ebookService.filterBooks(Pattern));
    }
    @PutMapping("updateebook")
    public ResponseEntity<?> update(@RequestBody EBook book){
        if(book.getId() != null){
            EBook book1 = ebookService.save(book);
            return ResponseEntity.accepted().body(book1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        ebookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("category/{id}")
    public ResponseEntity<?> findByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(ebookService.findByCategory(id));
    }
    @PostMapping("file")
    @ResponseBody
    public EBook uploddimg (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("ebook") Long id ) {
        EBook book =ebookService.findById(id);
        if(file==null) {
            book.setImageUrl("defaultPic.png");
            ebookService.save(book);

        }else {

            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();
                //File f = new File(classLoader.getResource(".").getFile() +"\\public\\resources\\UplodeFile\\UplodeImage\\" +"image" + id+file.getOriginalFilename());
                File f = new File("C:\\uploadimg\\" +"image" + id+file.getOriginalFilename());
                file.transferTo(f);
                book.setImageUrl("image"+id+file.getOriginalFilename());
                ebookService.save(book);

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

    @PostMapping("filepdf")
    @ResponseBody
    public EBook uploddiPdf (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("ebook") Long id ) {
        EBook book =ebookService.findById(id);


            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();
                //File f = new File(classLoader.getResource(".").getFile() +"\\public\\resources\\UplodeFile\\UplodeImage\\" +"image" + id+file.getOriginalFilename());
                File f = new File("C:\\uploadpdf\\" +"pdf" + id+file.getOriginalFilename());
                file.transferTo(f);
                book.setFile_url("i"+id+file.getOriginalFilename());
                ebookService.save(book);

            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return(book);
    }

}
