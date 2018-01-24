/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import javax.ejb.Local;
import cl.model.Persona;
import java.util.*;
/**
 *
 * @author Esteban
 */
@Local
public interface PersonaBeanLocal {
    
    Persona buscar(String rut);
    Persona loguear(String rut,String clave);
    void editar(String rut, boolean activo);
    List<Persona> getPersonaList();
    String add(Persona person);
}
