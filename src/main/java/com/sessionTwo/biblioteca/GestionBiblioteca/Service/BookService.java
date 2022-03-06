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
public class BookService {

    @Autowired
    BookRepositiry bookRepositiry;

    //Metodo INSERTS
    public void insertBook(Book book){
        this.bookRepositiry.save(book);
    }

    //metodo SELECT
    public List<Book> getAllBooks(){
        return this.bookRepositiry.findAllBooks();
    }

    //metodo de DELETE
    public void deleteBookByid(Integer id){

        try {
            this.bookRepositiry.deleteById(id);

        } catch (IllegalArgumentException iae){
            System.out.printf("You must put an ID. Error: %s\n\n", iae.getMessage());

        } catch (NullPointerException npe){
            System.out.printf("You putted an unexisted ID. Error: %s\n\n", npe.getMessage());
        }
    }

    public void updateBookCategoryById (Category category, Integer id){
        Book bookToUpdate = this.bookRepositiry.findById(id).orElse(null);

        if (bookToUpdate != null) {
            bookToUpdate.setCategory(category);
            this.bookRepositiry.save(bookToUpdate);

            System.out.printf("The book %s has been modifided", bookToUpdate.getTitle());
        } else
            System.out.printf("The id's book doesn't match with any of our book");
    }

    public void updateBookAutoryById (Autor autor, Integer id){
        Book bookToUpdate = this.bookRepositiry.findById(id).orElse(null);

        if (bookToUpdate != null) {
            bookToUpdate.setAutor(autor);
            this.bookRepositiry.save(bookToUpdate);

            System.out.printf("The book %s has been modifided", bookToUpdate.getTitle());
        } else
            System.out.printf("The id's book doesn't match with any of our book");
    }

    public void updateBookEditorialyById (Editorial editorial, Integer id){
        Book bookToUpdate = this.bookRepositiry.findById(id).orElse(null);

        if (bookToUpdate != null) {
            bookToUpdate.setEditorial(editorial);
            this.bookRepositiry.save(bookToUpdate);

            System.out.printf("The book %s has been modifided", bookToUpdate.getTitle());
        } else
            System.out.printf("The id's book doesn't match with any of our book");
    }

    public Book selectbookById(Integer id){
        return this.bookRepositiry.findById(id).orElse(null);
    }
}
