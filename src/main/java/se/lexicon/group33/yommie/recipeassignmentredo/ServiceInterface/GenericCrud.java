package se.lexicon.group33.yommie.recipeassignmentredo.ServiceInterface;

import java.util.Collection;

public interface GenericCrud <ID, DTO>{
    Collection<DTO> findAll();
    DTO findById(ID id);
    DTO create (DTO form);
    DTO update (ID id, DTO form);
    boolean delete(ID id);
}
