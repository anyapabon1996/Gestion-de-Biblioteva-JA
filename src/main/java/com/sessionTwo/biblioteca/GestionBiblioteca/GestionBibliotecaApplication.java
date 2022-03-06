package com.sessionTwo.biblioteca.GestionBiblioteca;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Book;
import com.sessionTwo.biblioteca.GestionBiblioteca.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GestionBibliotecaApplication implements CommandLineRunner {

	@Autowired
	LibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(GestionBibliotecaApplication.class, args);
	}

	@Override
	public void run (String... args){

//		this.libraryService.insertBook();
//
//		List<Book> allbooks = this.libraryService.getAllBooks();
//
//		for (Book book : allbooks){
//
//			System.out.printf("title: %s\nYear: %s\nPages: %d\nAutor: %s\n Editorial: %s\n Category: %s\n\n",
//					book.getTitle(), book.getYear(), book.getPages(),
//
//					//Cómo hago para acceder al pbjeto entero que está dentro y sus propiedades?
//					//imprime: Autor: Autor{id=3, name='J.K Rowling', bornYear='1987'}
//					//Yo quiero solo el nombre
//					book.getAutor(),
//
//					book.getEditorial(), book.getCategory()
//			);
//		}

		//Solo funcion si el id existe dentro de la Base de DD
		this.libraryService.deleteByid(0);
	}


}

