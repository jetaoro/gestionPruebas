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
public class TipoPrueba {

    public TipoPrueba() {
    }
    
    public String listadoTiposPrueba(){
        TreeSet<TipoPruebaDTO> tiposPrueba = new TipoPruebaDAO().getTipoPrueba();
        String listado = "<select style='width: 40%;' class=\"chzn-select chosen_select\" name='tipoPrueba'>";
        listado+="<option>"+ "" +"</option>";
        for (TipoPruebaDTO tipo : tiposPrueba) {
            listado+="<option value='"+tipo.getIdentificador()+"' selected>"+tipo.getDescripcion() +"</option>";

        }
        listado+="</select>";
        return listado;
    }
}
