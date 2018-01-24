/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Esteban
 */
@Singleton
public class PersonaBean implements PersonaBeanLocal {
    
    private List<Persona> list = new ArrayList<>();
    
    public PersonaBean(){
        list.add(new Persona("1-1", "Juan Perez", "Administrador", "jp@gmail.com", "123", true));
        list.add(new Persona("1-2", "Maria Reyes", "Persona", "mr@gmail.com", "123", false));
        list.add(new Persona("1-3", "Tomas Torres", "Administrador", "tt@gmail.com", "123", true));
        list.add(new Persona("1-4", "Hector Roa", "Persona", "hr@gmail.com", "123", true));
        list.add(new Persona("1-5", "Anibal Suazo", "Persona", "as@gmail.com", "123", true));
    }

    @Override
    public Persona buscar(String rut) {
        for (Persona persona : list) {
            if (persona.getRut().equals(rut)){
                return persona;
            }
        }
        return null;
    }

    @Override
    public Persona loguear(String rut, String clave) {
        for (Persona persona : list) {
            if (persona.getRut().equals(rut) && persona.getClave().equals(clave) && persona.isActivo()){
                return persona;
            }
        }
        return null;
    }

    @Override
    public void editar(String rut, boolean activo) {
        Persona person = buscar(rut);
        person.setActivo(activo);
        
    }

    @Override
    public List<Persona> getPersonaList() {
        return list;
    }

    @Override
    public String add(Persona person) {
        Persona p = buscar(person.getRut());
        if(p == null){
            list.add(person);
            return "Persona creada con exito";
        }
        return "El rut ya se encuentra registrado";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
