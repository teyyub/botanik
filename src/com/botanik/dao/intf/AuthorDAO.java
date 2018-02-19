package com.botanik.dao.intf;

import com.botanik.model.Author;
import com.botanik.model.Family;
import com.botanik.model.Species;
import java.util.List;

/**
 *
 * @author teyyub , Feb 2, 2018 , 5:48:46 PM
 */
public interface AuthorDAO {

    void saveAuthor(Author author);
    void saveFamily(Family family);
    void saveSpecies(Species species);
    
    List<Author> getAuthors();
    List<Family> getFamilies();
    List<Species>getSpecies(); 
    
    Author authorByID(Number id);
    Author authorByName(String name);
    void deleteAuthorByID(Number id);
    
}
