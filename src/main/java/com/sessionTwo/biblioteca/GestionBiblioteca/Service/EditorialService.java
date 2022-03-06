package com.sessionTwo.biblioteca.GestionBiblioteca.Service;

import com.sessionTwo.biblioteca.GestionBiblioteca.Model.Editorial;
import com.sessionTwo.biblioteca.GestionBiblioteca.Repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    //create new editorial
    public void newEditorial(Editorial editorial) {
        this.editorialRepository.save(editorial);
    }

    //Update editorial
    public void updateCategory(Integer id, Editorial editorial) {
        Editorial editorialToUpdate = this.editorialRepository.findById(id).orElse(null);

        if (editorialToUpdate != null) {
            editorialToUpdate.setEditorial(editorial.getEditorial());
            editorialToUpdate.setStar(editorial.getStar());

            this.editorialRepository.save(editorialToUpdate);

            System.out.println("Editorial has been updated");
        } else
            System.out.println("The Id's do not match with any edtitorial into DataBase");
    }

    public Editorial findEditorialById(Integer id){
        Editorial exist = this.editorialRepository.findById(id).orElse(null);

        return exist != null ? exist : null;
    }
}
