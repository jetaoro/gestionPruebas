/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.*;
import DTO.*;
import java.text.DateFormat;
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
        String tabla = "<table border='1'>"+
                "\n<tr>"+
                "\n<th>Identificador</th>"+
                "\n<th>Descripción</th>"+
                "\n<th>Datos de entrada</th>"+
                "\n<th>Resultado Esperado</th>"+
                "\n<th>Resultado Obtenido</th>"+
                "\n<th>Tipo de Resultado</th>"+
                "\n<th>Observación</th>"+
                "\n</tr>";
                       
        for (CasoPruebaDTO caso : casosPruebas) {
            tabla+="\n<tr>";
            tabla+="\n<td>"+"<input type = 'radio' name = 'casoPrueba' value = '"+caso.getIdentificador()+"' >" + "</td>";
            tabla+="\n<td>"+caso.getDescripcion()+"</td>";
            tabla+="\n<td>"+caso.getDatos_entrada()+"</td>";
            tabla+="\n<td>"+caso.getResultado_esperado()+"</td>";
            tabla+="\n<td>"+caso.getResultado_obtenido()+"</td>";
            tabla+="\n<td>"+caso.getTipo_resultado()+"</td>";
            tabla+="\n<td>"+caso.getObservacion()+"</td>";
            tabla+="\n</tr>";
        }
        return (tabla);
    }
    
    public String getUnCasoPrueba(int id_caso){
        CasoPruebaDTO caso = new CasoPruebaDAO().getUnCasoPrueba(new CasoPruebaDTO(id_caso));
        String tabla = "No se ha encontrado el módulo buscado";
        if (caso!=null){
            tabla="<table border=1>";
            tabla+="<tr><td align='center'>Modificar Caso de Prueba</td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Identificador</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='identificador' readonly='readonly' value='"+caso.getIdentificador()+"'></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Descripción</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='descripcion' value='"+caso.getDescripcion()+"' required></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Datos de entrada</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='datos_entrada' value='"+caso.getDatos_entrada()+"' required></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Resultado Esperado</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='resultado_esperado' value='"+caso.getResultado_esperado()+"' required></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Resultado Obtenido</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='resultado_obtenido' value='"+caso.getResultado_obtenido()+"' required></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Tipo de Resultado</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='tipo_resultado' value='"+caso.getTipo_resultado()+"' required></td></tr></table>";
            tabla += "<table border=1><tr align='center'><td>Observación</td></tr>";
            tabla += "<tr align='center'><td><input type='text' name='observacion' value='"+caso.getObservacion()+"'></td></tr></table>";
            tabla +="</table></br>";
        }
        return (tabla);
    }
    
    public String agregarCasoPrueba(int idPrueba){ 
        String tabla = "<table border=1>";
        tabla += "<table border=1>";
        tabla += "<tr><td align='center'>Agregar Caso de Prueba</td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Identificador de la prueba</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='idPrueba' readonly='readonly' value='"+ idPrueba +"'></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Descripción</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='descripcion' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Datos de entrada</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='datos_entrada' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Resultado Esperado</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='resultado_esperado' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Resultado Obtenido</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='resultado_obtenido' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Tipo de Resultado</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='tipo_resultado' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Observación</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='observacion' ></td></tr></table>";
        tabla += "</table></br>";

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
