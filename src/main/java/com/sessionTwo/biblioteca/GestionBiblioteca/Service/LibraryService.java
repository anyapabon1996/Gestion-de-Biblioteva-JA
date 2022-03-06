package com.sessionTwo.biblioteca.GestionBiblioteca.Service;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Autor;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Book;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Category;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Editorial;
import com.sessionTwo.biblioteca.GestionBiblioteca.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    BookRepositiry bookRepositiry;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EditorialRepository editorialRepository;

    //Metodo INSERTS
    public void insertBook(){
        Book book = new Book();
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        Category category = new Category();

        autor.setName("J.K Rowling");
        autor.setBornYear("1987");

        editorial.setEditorial("Salamandra");
        editorial.setStar(5);

        category.setCategory("Fantasy");

        //No importa q yo lo defina, es sobreescrito
        book.setId(123);
        book.setPages(201);
        book.setTitle("Harry Potter and the sorcerers stone");
        book.setYear("2001");
        book.setCategory(this.categoryRepository.save(category));
        book.setEditorial(this.editorialRepository.save(editorial));
        book.setAutor(this.autorRepository.save(autor));

        Book go = this.bookRepositiry.existsById(book.getId()) ? null : this.bookRepositiry.save(book);

        if (go != null) System.out.printf("Has recorded book %s\n", book.getTitle());

    }

    //metodo SELECT
    public List<Book> getAllBooks(){

        return this.bookRepositiry.findAllBooks();
    }

    //metodo de DELETE
    public void deleteByid(Integer id){

        try {
            this.bookRepositiry.deleteById(id);
        } catch (IllegalArgumentException iae){
            System.out.printf("You must put an ID. Error: %s\n\n", iae.getMessage());
        } catch (NullPointerException npe){
            System.out.printf("You putted an unexisted ID. Error: %s\n\n", npe.getMessage());

        }
    }

}
