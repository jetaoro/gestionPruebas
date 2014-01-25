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
public class CasoPrueba {

    public CasoPrueba() {
    }
    
    public String getCasosPrueba(PruebaDTO prueba){
        TreeSet<CasoPruebaDTO> casosPruebas = new CasoPruebaDAO().getCasosPruebaDeUnaPrueba(prueba);
        String tabla = "<table class=\"table table-bordered table-mod-2\" id=\"datatable_3\">"+
                "\n<thead>"+
                "\n<th>Identificador</th>"+
                "\n<th>Descripción</th>"+
                "\n<th>Datos de entrada</th>"+
                "\n<th>Resultado Esperado</th>"+
                "\n<th>Resultado Obtenido</th>"+
                "\n<th>Tipo de Resultado</th>"+
                "\n<th>Observación</th>"+
                "\n</tr>"+
                "</thead>"+
                "<tbody>";
        
         if(!casosPruebas.isEmpty()){              
            for (CasoPruebaDTO caso : casosPruebas) {
                tabla+="\n<tr>";
                tabla+="<td class=\"t_center\"><input  type = 'radio' name = 'casoPrueba' id = '"+caso.getIdentificador()+"' value = '"+caso.getIdentificador()+"' >" + "<label for='"+caso.getIdentificador()+"'><span></span></label></td>";
                tabla+="\n<td>"+caso.getDescripcion()+"</td>";
                tabla+="\n<td>"+caso.getDatos_entrada()+"</td>";
                tabla+="\n<td>"+caso.getResultado_esperado()+"</td>";
                tabla+="\n<td>"+caso.getResultado_obtenido()+"</td>";
                tabla+="\n<td>"+caso.getTipo_resultado()+"</td>";
                tabla+="\n<td>"+caso.getObservacion()+"</td>";
                tabla+="\n</tr></tbody></table>";
            }
         }
         else
             tabla+="\n<table border='1'><td>No se encontraron casos de prueba registrados, para la prueba seleccionada.</td></table>";
        return (tabla);
    }
    
    public String getUnCasoPrueba(int id_caso){
        CasoPruebaDTO caso = new CasoPruebaDAO().getUnCasoPrueba(new CasoPruebaDTO(id_caso));
        String tabla = "";
        if (caso!=null){            
            tabla="<table border=1><tr align='center'><td>Identificador</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='identificador' readonly='readonly' value='"+caso.getIdentificador()+"'></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Descripción</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='descripcion' required>"+caso.getDescripcion()+"</textarea></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Datos de entrada</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='datos_entrada' required>"+caso.getDatos_entrada()+"</textarea></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Resultado Esperado</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='resultado_esperado' required>"+caso.getResultado_esperado()+"</textarea></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Resultado Obtenido</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='resultado_obtenido' required>"+caso.getResultado_obtenido()+"</textarea></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Tipo de Resultado</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='tipo_resultado' required>"+caso.getTipo_resultado()+"</textarea></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Observación</td></tr>";
            tabla += "<tr align='center'><td><textarea rows='4' cols='40' name='observacion' required>"+caso.getObservacion()+"</textarea></td></tr></table>";
            tabla +="</table></br>";
        }
        return (tabla);
    }
    
    public String agregarCasoPrueba(int idPrueba){ 
        String tabla = "<div class='formRow'>";
        tabla += "<label>Identificador de la prueba</label>";
        tabla += "<div class='formRight'><input type='text' name='idPrueba' readonly='readonly' value='"+ idPrueba +"'></div></div>";
        tabla += "<div class='formRow'><label>Descripción</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='descripcion' required></textarea></div></div>";
        tabla += "<div class='formRow'><label>Datos de entrada</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='datos_entrada' required></textarea></div></div>";
        tabla += "<div class='formRow'><label>Resultado Esperado</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='resultado_esperado' required></textarea></div></div>";
        tabla += "<div class='formRow'><label>Resultado Obtenido</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='resultado_obtenido' required></textarea></div></div>";
        tabla += "<div class='formRow'><label>Tipo de Resultado</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='tipo_resultado' required></textarea></div></div>";
        tabla += "<div class='formRow'><label>Observación</label>";
        tabla += "<div class='formRight'><textarea rows='4' cols='40' name='observacion' required></textarea></div></div></br></br></br></br></br></br>";
        
        return (tabla);
    }
    
    public String insertarCasoPrueba(CasoPruebaDTO nuevo, int idPrueba){
        String resultado = "La inserción falló";
        boolean insercion= new CasoPruebaDAO().insertar(nuevo, idPrueba);
        
        if (insercion)
            resultado = "La inserción fue exitosa";        
        return (resultado);
    }
    
    public String modificarCasoPrueba(CasoPruebaDTO actualizado){
        String resultado = "La actualización falló";
        boolean actualizacion= new CasoPruebaDAO().modificar(actualizado);
        
        if (actualizacion)
            resultado = "La actualización fue exitosa";        
        return (resultado);
    }
    
    public String eliminarCasoPrueba(CasoPruebaDTO eliminado){
        String resultado = "La eliminación falló";
        boolean borrado= new CasoPruebaDAO().eliminar(eliminado);
        
        if (borrado)
            resultado = "La eliminación fue exitosa";        
        return (resultado);
    }
}
