package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id")
    private Integer id;

    @Column(name = "str_edit")
    private String editorial;

    @Column(name = "int_star")
    private Integer star;

    @OneToOne
    private Book book;

    public Editorial(Integer id, String editorial, Integer star, Book book) {
        this.id = id;
        this.editorial = editorial;
        this.star = star;
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

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", editorial='" + editorial + '\'' +
                ", star=" + star +
                '}';
    }
}
