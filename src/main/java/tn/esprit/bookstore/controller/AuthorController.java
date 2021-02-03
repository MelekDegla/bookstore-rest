package tn.esprit.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.entities.Author;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IAuthorService;
import tn.esprit.bookstore.services.ICategoryService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    final IAuthorService authorService;


    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("findauthors")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(authorService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){return ResponseEntity.ok(authorService.findById(id));}

    @PostMapping("addauthor")
    public ResponseEntity<?> save(@RequestBody Author author){
        if(author.getId() == null){
            Optional<Author> author1 = Optional.of(authorService.save(author));
            return ResponseEntity.created(null).body(author1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }

    @PutMapping("updateauthor")
    public ResponseEntity<?> update(@RequestBody Author author){
        if(author.getId() != null){
            Author author1 = authorService.save(author);
            return ResponseEntity.accepted().body(author1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/file")
    @ResponseBody
    public Author  uploddimg (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("author") Long id ) {
        Author author =authorService.findById(id);
        if(file==null) {
            author.setPhotoUrl("defaultPic.png");
            authorService.save(author);
        }else {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();
                //File f = new File(classLoader.getResource(".").getFile() +"\\public\\resources\\UplodeFile\\UplodeImage\\" +"image" + id+file.getOriginalFilename());
                File f = new File("C:\\upload\\" +"image" + id+file.getOriginalFilename());
                file.transferTo(f);
                author.setPhotoUrl("image"+id+file.getOriginalFilename());
                authorService.save(author);
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return(author);
    }

}
