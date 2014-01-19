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
public class SitioPrueba {
    public SitioPrueba() {
    }
    
    public String getSitioPrueba(){
        TreeSet<SitioPruebaDTO> sitiosPrueba = new SitioPruebaDAO().getSitioPrueba();
        String tabla = "<table border='1'>"+
                "\n<tr>"+
                "\n<th>Número de Puerto</th>"+
                "\n<th>Nombre</th>"+
                "\n</tr>";
        
        for (SitioPruebaDTO sitio : sitiosPrueba) {
            tabla+="\n<tr>";
            tabla+="\n<td>"+sitio.getNumero_puerto()+"</td>";
            tabla+="\n<td>"+sitio.getNombre()+"</td>";
            tabla+="\n</tr>";
        }
        return (tabla);        
    }
    
    public String getListadoSitios(){
        TreeSet<SitioPruebaDTO> sitios = new SitioPruebaDAO().getSitioPrueba();
        String tabla = "<table border = '1'>"+
                "\n<tr>"+
                "\n<th></th>"+
                "\n<th>Número de puerto</th>"+
                "\n<th>Nombre</th>"+
                "\n</tr>";
        if(!sitios.isEmpty()){
            for (SitioPruebaDTO sitio : sitios) {
                tabla+="\n<tr>";
                tabla+="\n<td>"+"<input type = 'radio' name = 'sitio_prueba' value = '"+sitio.getIdentificador()+"' >" + "</td>";
                tabla+="\n<td>"+ sitio.getNumero_puerto()+"</td>";
                tabla+="\n<td>"+ sitio.getNombre()+"</td>";
                tabla+="\n</tr>";
            }
        }
        else
            tabla+="\n<table border='1'><td>No se encontraron sitios de prueba registrados.</td></table>";
        tabla+="</table></br>";
        return (tabla);        
    }
    
    public String agregarSitioPrueba(){ 
        String tabla = "<table border=1>";
        tabla += "<table border=1>";
        tabla += "<tr><td align='center'>Agregar Sitio de Prueba</td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Número de Puerto</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='numero_puerto' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Nombre</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='nombre' required></td></tr></table>";
        tabla += "</table>";

        return (tabla);
    }
    
    public String insertarSitioPrueba(SitioPruebaDTO nuevo){
        String resultado = "La inserción falló";
        boolean insercion= new SitioPruebaDAO().insertar(nuevo);
        
        if (insercion)
            resultado = "La inserción fue exitosa";
        
        return (resultado);
    }
    
    public String modificarSitioPrueba(SitioPruebaDTO actualizado){
        String resultado = "La actualización falló";
        boolean actualizacion= new SitioPruebaDAO().modificar(actualizado);
        
        if (actualizacion)
            resultado = "La actualización fue exitosa";        
        return (resultado);
    }
    
    public String eliminarSitioPrueba(SitioPruebaDTO eliminado){
        String resultado = "La eliminación falló";
        boolean borrado= new SitioPruebaDAO().eliminar(eliminado);
        
        if (borrado)
            resultado = "La eliminación fue exitosa";        
        return (resultado);
    }
    
    public String getUnSitioPrueba(int id_sitio){
        SitioPruebaDTO sitio = new SitioPruebaDAO().getUnSitioPrueba(new SitioPruebaDTO(id_sitio));
        String tabla = "No se ha encontrado el módulo buscado";
        if (sitio!=null){
            tabla="<table border=1>";            
            tabla+="<tr><td align='center'>Modificar Sitio de Prueba</td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Identificador</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='identificador' readonly='readonly' value='"+sitio.getIdentificador()+"'></td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Número de Puerto</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='numero_puerto' required value='"+sitio.getNumero_puerto()+"'></td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Nombre</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='nombre' required value='"+sitio.getNombre()+"'></td></tr></table>";
            tabla+="</table>";
        }
        return (tabla);
    }
    
    //Arroja un combo con todos los sitios de prueba que haya registrado en el sistema
    public String listadoSitiosPrueba(){
        TreeSet<SitioPruebaDTO> sitios = new SitioPruebaDAO().getSitioPrueba();
        String listado = "<select class=\"chzn-select chosen_select\" name='sitio'>";
        listado+="<option>"+ "" +"</option>";
        for (SitioPruebaDTO sitio : sitios) {
            listado+="<option value='"+sitio.getIdentificador()+"'>"+sitio.getNumero_puerto()+" - "+ sitio.getNombre() +"</option>";

        }
        listado+="</select>";
        return listado;
    }
}
