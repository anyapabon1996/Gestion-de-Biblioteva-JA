package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id_autor")
    private Integer id;

    @Column(name = "str_name")
    private String name;

    @Column(name = "str_born_year")
    private String bornYear;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "int_id_autor")
    private List<Book> books;

    public Autor(String name, String bornYear) {
        this.name = name;
        this.bornYear = bornYear;
        this.books = new ArrayList<Book>();

    }

    public Autor() {

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

    public String getBornYear() {
        return bornYear;
    }

    public void setBornYear(String bornYear) {
        this.bornYear = bornYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bornYear='" + bornYear + '\'' +
                '}';
    }
}
