package com.sessionTwo.biblioteca.GestionBiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_id")
    private Integer id;

    @Column(name = "str_name")
    private String name;

    @Column(name = "str_born_year")
    private String bornYear;

    @OneToOne
    private Book book;

    public Autor(Integer id, String name, String bornYear) {
        this.id = id;
        this.name = name;
        this.bornYear = bornYear;
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


    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bornYear='" + bornYear + '\'' +
                '}';
    }
}
