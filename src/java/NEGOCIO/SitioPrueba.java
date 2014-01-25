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
        String tabla = "<table class=\"table table-bordered table-mod-2\" id=\"datatable_3\">"+
                 "<thead>"+
                "\n<tr>"+
                "\n<th></th>"+
                "\n<th>Número de puerto</th>"+
                "\n<th>Nombre</th>"+
                 "</thead>";
        if(!sitios.isEmpty()){
            for (SitioPruebaDTO sitio : sitios) {
                tabla+="\n<tr>";
                tabla+="<td width='5%' class=\"t_center\">"+"<input type = 'radio' name = 'sitio_prueba' id='"+sitio.getIdentificador()+"' value = '"+sitio.getIdentificador()+"' />"  + "<label for='"+sitio.getIdentificador()+"'><span></span></label>"+ "</td>"; 
                tabla+="\n<td>"+ sitio.getNumero_puerto()+"</td>";
                tabla+="\n<td>"+ sitio.getNombre()+"</td>";
                tabla+="\n</tr>";
            }
        }
        else
            tabla+="\n<table border='1'><td>No se encontraron sitios de prueba registrados.</td></table>";
        tabla+="<tbody></table></br></br>";
        return (tabla);        
    }
    
    public String agregarSitioPrueba(){ 
        String tabla = "<div class='formRow'>";
        tabla += "<label>   Número de Puerto</label>";
        tabla += "<div class='formRight'><input type='text' name='numero_puerto' required></div></div>";
        tabla += "<div class='formRow'><label>Nombre</label>";
        tabla += "<div class='formRight'><input type='text' name='nombre' required></div></div></br></br></br>";

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
            tabla+="<div class='formRow'><label>Identificador</label><div class='formRight'><input type='text' name='identificador' readonly='readonly' value='"+sitio.getIdentificador()+"'></div></div>";
            tabla+="<div class='formRow'><label>Número de Puerto</label><div class='formRight'><input type='text' name='numero_puerto' required value='"+sitio.getNumero_puerto()+"'></div></div>";
            tabla+="<div class='formRow'><label>Nombre</label><div class='formRight'><input type='text' name='nombre' required value='"+sitio.getNombre()+"'></div></div></br></br>";
            
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
