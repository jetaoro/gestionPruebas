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
            tabla+="\n<td>"+caso.getIdentificador()+"</td>";
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
    
    public String insertarCasoPrueba(CasoPruebaDTO nuevo){
        String resultado = "La inserción falló";
        boolean insercion= new CasoPruebaDAO().insertar(nuevo);
        
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
