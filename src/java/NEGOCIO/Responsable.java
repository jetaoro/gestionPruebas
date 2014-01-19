/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.*;
import DTO.*;
import java.util.TreeSet;

/**
 *
 * @author Jennifer
 */
public class Responsable {

    public Responsable() {
    }
     
    public boolean esValido(String usuario, String contrasena){
        return new ResponsableDAO().esValido(usuario, contrasena);        
    }
    
    //Arroja un combo con todos los módulos de prueba que haya registrado en el sistema
    public String listadoResponsables(){
        TreeSet<ResponsableDTO> responsables = new ResponsableDAO().getResponsable();
        String listado = "<select class=\"chzn-select chosen_select\" name='responsable'>";
        listado+="<option>"+ "" +"</option>";
        for (ResponsableDTO responsable : responsables) {
            listado+="<option value='"+responsable.getIdentificador()+"'>"+responsable.getNombre() +"</option>";

        }
        listado+="</select>";
        return listado;
    }
}
