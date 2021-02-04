package tn.esprit.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
public class Category  {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64)
    private String name;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Category> children = new HashSet<>();

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }

    public void addChild(Category children) {
        this.children.add(children);
    }

  /*  @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    @Column(nullable=false )
    private String title;

    public void setId(long id) {
        this.id = id;
    }



    @Column(nullable=false )
    private String description;


    @OneToMany(mappedBy = "category")
    private List<EBook> eBooks;

    @OneToMany(mappedBy = "category")
    private List<PBook> pBooks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EBook> geteBooks() {
        return eBooks;
    }

    public void seteBooks(List<EBook> eBooks) {
        this.eBooks = eBooks;
    }

    public List<PBook> getpBooks() {
        return pBooks;
    }

    public void setpBooks(List<PBook> pBooks) {
        this.pBooks = pBooks;
    }*/
}

