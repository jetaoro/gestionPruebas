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
        String listado = "<div class=\"distance distance-2\">";
        int n=modosEjecucion.size();
        n++;
        int i=1;
        for (ModoEjecucionDTO modo : modosEjecucion) {
            listado+="<p><input type='checkbox' id='c"+i+"' name='modoEjecucion' value='"+modo.getIdentificador()+"' checked />" +"<label for='c"+i+"'><span></span>"+ modo.getDescripcion() +"</label></p>";
            i++;           
        }
        listado+="</div>";
        return listado;
    }
}
