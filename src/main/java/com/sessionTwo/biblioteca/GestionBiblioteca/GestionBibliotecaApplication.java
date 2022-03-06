package com.sessionTwo.biblioteca.GestionBiblioteca;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Autor;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Book;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Category;
import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Editorial;
import com.sessionTwo.biblioteca.GestionBiblioteca.Service.AutorService;
import com.sessionTwo.biblioteca.GestionBiblioteca.Service.BookService;
import com.sessionTwo.biblioteca.GestionBiblioteca.Service.CategoryService;
import com.sessionTwo.biblioteca.GestionBiblioteca.Service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GestionBibliotecaApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	@Autowired
	AutorService autorService;

	@Autowired
	EditorialService editorialService;

	@Autowired
	CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(GestionBibliotecaApplication.class, args);
	}

	@Override
	public void run (String... args){
		
		//Creamos y guardamos categorias
		Category fantasy = new Category("fantasy");
		Category historicalNarration =  new Category("Historical narration");
		Category ScienceFiction = new Category("Science fiction");
		this.categoryService.newCategory(fantasy);
		this.categoryService.newCategory(historicalNarration);
		this.categoryService.newCategory(ScienceFiction);

		//Creamos y guardamos Autores
		Autor JKRowling = new Autor("J.K Rowling", "1965");
		Autor EdithEgger = new Autor("Edith Eger", "1927");
		Autor SuzanneCollins = new Autor("Suzanne Collins", "1962");
		this.autorService.createAutor(JKRowling);
		this.autorService.createAutor(EdithEgger);
		this.autorService.createAutor(SuzanneCollins);

		//Creamos y guardamos Editoriales
		Editorial salamandra = new Editorial("Salamandra", 5);
		Editorial molino = new Editorial("Molino", 4);
		Editorial planeta = new Editorial("Planeta", 5);
		this.editorialService.newEditorial(salamandra);
		this.editorialService.newEditorial(molino);
		this.editorialService.newEditorial(planeta);

		//Creamos libros
		Book harrypotter1 = new Book();
		harrypotter1.setAutor(this.autorService.findAutorByid(1));
		harrypotter1.setEditorial(this.editorialService.findEditorialById(1));
		harrypotter1.setCategory(this.categoryService.findCategoryById(1));
		harrypotter1.setYear("2001");
		harrypotter1.setTitle("Harry Potter and the sorcerer Stone");
		harrypotter1.setPages(201);
		this.bookService.insertBook(harrypotter1);

		Book hungerGames = new Book();
		hungerGames.setEditorial(this.editorialService.findEditorialById(2));
		hungerGames.setPages(401);
		hungerGames.setTitle("Hunger Games");
		hungerGames.setCategory(this.categoryService.findCategoryById(3));
		hungerGames.setAutor(this.autorService.findAutorByid(3));
		hungerGames.setYear("2009");
		this.bookService.insertBook(hungerGames);

		Book theDancerOfAuschwitz = new Book();
		theDancerOfAuschwitz.setYear("2019");
		theDancerOfAuschwitz.setAutor(this.autorService.findAutorByid(8));
		theDancerOfAuschwitz.setCategory(this.categoryService.findCategoryById(8));
		theDancerOfAuschwitz.setTitle("The dancer of Auschwitz");
		theDancerOfAuschwitz.setPages(600);
		theDancerOfAuschwitz.setEditorial(this.editorialService.findEditorialById(8));
		this.bookService.insertBook(theDancerOfAuschwitz);

		//Actualizamos un libro
		this.bookService.updateBookAutoryById(this.autorService.findAutorByid(2),
				3);

		this.bookService.updateBookCategoryById(this.categoryService.findCategoryById(2),
				3);

		this.bookService.updateBookEditorialyById(this.editorialService.findEditorialById(3),
				3);

			//ROMPE
//		List<Book> allbooks = this.bookService.getAllBooks();
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

		//Cómo capturar el error si no existe el ID
		this.bookService.deleteBookByid(1);

		//ROMPE CUANDO INTENTO IMPRIMIR AUTOR
//		Book lookBook = this.bookService.selectbookById(2);
//
//		if (lookBook != null) {
//			System.out.printf("title: %s\nYear: %s\nPages: %d\nAutor: %s\n", lookBook.getTitle(),
//					lookBook.getYear(), lookBook.getPages(), lookBook.getAutor().getName());
//		} else {
//			System.out.printf("The id's book doesn't match with any of our book");
//		}
	}
}

