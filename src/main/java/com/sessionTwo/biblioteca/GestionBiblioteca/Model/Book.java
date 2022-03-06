package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book")
public class Book {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id")
    private Integer id;

    @Column(name = "str_title")
    private String title;

    @Column(name = "int_pages")
    private Integer pages;

    @Column(name = "str_year")
    private String year;

    //relaciones
    @OneToOne
    private Autor autor;

    @OneToOne
    private Category category;

    @OneToOne
    private Editorial editorial;

    //constructores
    public Book(Integer id, String title, Integer pages, String year, Autor autor, Category category, Editorial editorial) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.autor = autor;
        this.category = category;
        this.editorial = editorial;
    }

    public Book() {
    }

    //setters and getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", year='" + year + '\'' +
                ", autor=" + autor +
                ", category=" + category +
                ", editorial=" + editorial +
                '}';
    }
}
