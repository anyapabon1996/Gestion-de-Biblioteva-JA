package com.sessionTwo.biblioteca.GestionBiblioteca.Repository;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}
