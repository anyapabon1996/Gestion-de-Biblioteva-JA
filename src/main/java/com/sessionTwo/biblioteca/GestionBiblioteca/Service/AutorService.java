package com.sessionTwo.biblioteca.GestionBiblioteca.Service;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Autor;
import com.sessionTwo.biblioteca.GestionBiblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public void createAutor(Autor autor) {
        this.autorRepository.save(autor);
    }

    public void updateAutor(Integer id, Autor autor) {
        Autor autorToUpdate = this.autorRepository.findById(id).orElse(null);

        if (autorToUpdate != null) {
            autorToUpdate.setBornYear(autor.getBornYear());
            autorToUpdate.setName(autor.getName());
            this.autorRepository.save(autorToUpdate);

            System.out.println("Autor has been updated");
        } else
            System.out.println("The Id's do not match with any autor into DataBase");
    }

    public Autor findAutorByid(Integer id){
        return this.autorRepository.findById(id).orElse(null);
    }
}
