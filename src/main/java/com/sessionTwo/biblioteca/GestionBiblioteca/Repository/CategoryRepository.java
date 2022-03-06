package com.sessionTwo.biblioteca.GestionBiblioteca.Repository;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
