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
public class ModoEjecucion {

    public ModoEjecucion() {
    }
    
    public String listadoModosEjecucion(){
        TreeSet<ModoEjecucionDTO> modosEjecucion = new ModoEjecucionDAO().getModoEjecucion();
        String listado = "";
        for (ModoEjecucionDTO modo : modosEjecucion) {
            listado+="<input type='checkbox' name='modoEjecucion' value='>"+modo.getIdentificador()+"'>" + modo.getDescripcion() + " ";
        }       
        return listado;
    }
}
