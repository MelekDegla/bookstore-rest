package tn.esprit.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.repository.CategoryRepository;
import tn.esprit.bookstore.services.ICategoryService;

import java.util.Optional;

@RestController
@RequestMapping("api/category/")
public class CategoryController {
    final ICategoryService categoryService;



    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getcategory")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){return ResponseEntity.ok(categoryService.findById(id));}

    @PostMapping("addcategory")
    public ResponseEntity<?> save(@RequestBody Category category){

            Optional<Category> category1 = Optional.of(categoryService.save(category));
            return ResponseEntity.created(null).body(category1);


    }

    @PutMapping("updatecategory")
    public ResponseEntity<?> update(@RequestBody Category category){
        if(category.getId() != null){
            Category category1 = categoryService.save(category);
            return ResponseEntity.accepted().body(category1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}


