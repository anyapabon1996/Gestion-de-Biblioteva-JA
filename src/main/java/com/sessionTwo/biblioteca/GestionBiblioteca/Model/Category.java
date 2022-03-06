package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id")
    private Integer id;

    @Column(name = "str_category")
    private String category;

    @OneToOne
    private Book book;

    public Category(Integer id, String category, Book book) {
        this.id = id;
        this.category = category;
    }

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
