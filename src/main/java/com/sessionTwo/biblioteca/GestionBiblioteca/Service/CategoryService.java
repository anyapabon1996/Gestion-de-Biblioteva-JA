package com.sessionTwo.biblioteca.GestionBiblioteca.Service;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Category;
import com.sessionTwo.biblioteca.GestionBiblioteca.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //create new category
    public void newCategory(Category category){
        this.categoryRepository.save(category);
    }

    //Update Category
    public void updateCategory(Integer id, Category category){
        Category categoryToUpdate = this.categoryRepository.findById(id).orElse(null);

        if(categoryToUpdate != null) {
            categoryToUpdate.setCategory(category.getCategory());

            this.categoryRepository.save(categoryToUpdate);

            System.out.println("Category has been updated");
        } else
            System.out.println("The Id's do not match with any acategory into DataBase");

    }

    //busca categoria por id
    public Category findCategoryById(Integer id){
        return this.categoryRepository.findById(id).orElse(null);
    }

}
