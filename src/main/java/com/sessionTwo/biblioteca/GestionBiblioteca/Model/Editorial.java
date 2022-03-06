package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id_editorial")
    private Integer id;

    @Column(name = "str_edit")
    private String editorial;

    @Column(name = "int_star")
    private Integer star;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="editorial_id")
    private List<Book> books;

    public Editorial(String editorial, Integer star) {
        this.editorial = editorial;
        this.star = star;
        this.books = new ArrayList<Book>();
    }

    public Editorial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", editorial='" + editorial + '\'' +
                ", star=" + star +
                '}';
    }
}
