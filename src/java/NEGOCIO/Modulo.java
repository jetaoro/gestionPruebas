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
public class Modulo {

    public Modulo() {
    }
    
    //Tabla con los módulos que hay
    public String getModulo(){
        TreeSet<ModuloDTO> modulos = new ModuloDAO().getModulo();
        String tabla = "<table border='1'>"+
                "\n<tr>"+
                "\n<th>Nombre</th>"+
                "\n<th>Descripción</th>"+
                "\n</tr>";
        
        for (ModuloDTO modulo : modulos) {
            tabla+="\n<tr>";
            tabla+="\n<td>"+modulo.getNombre()+"</td>";
            tabla+="\n<td>"+modulo.getDescripcion()+"</td>";
            tabla+="\n</tr>";
        }
        return (tabla);        
    }
    
    //Tabla con el listado de módulos, con los radios de selección
    public String getListadoModulos(){
        TreeSet<ModuloDTO> modulos = new ModuloDAO().getModulo();
        String tabla = "<table class=\"table table-bordered table-mod-2\" id=\"datatable_3\">"+
                "<thead>"+
                "<tr>"+
                "<th></th>"+
                "<th>Nombre</th>"+
                "</tr>"+
                "</thead>"+
                "<tbody>";
        if(!modulos.isEmpty()){
            for (ModuloDTO modulo : modulos) {
                tabla+="<tr>";
                tabla+="<td width='5%' class=\"t_center\">"+"<input type = 'radio' name = 'modulo' id='"+modulo.getIdentificador()+"' value = '"+modulo.getIdentificador()+"' />"  + "<label for='"+modulo.getIdentificador()+"'><span></span></label>"+ "</td>";
                tabla+="<td>"+ modulo.getNombre()+"</td>";           
                tabla+="</tr>";
            }
        }
        else
            tabla+="";
        tabla+="</table></br>";
        return (tabla);         
    }
    
    public String agregarModulo(){ 
        String tabla ="<div class='formRow'>";
        tabla += "<label><td>Nombre</label>";
        tabla += "<div class='formRight'><input type='text' name='nombre' required></div></div>";
        tabla += "<div class='formRow'><label>Descripci&oacute;n</label>";
        tabla += "<div class='formRight'><textarea name='descripcion' required></textarea></div></div></br></br></br></br>";

        return (tabla);
    }
    
    public String insertarModulo(ModuloDTO nuevo){
        String resultado = "La inserción falló";
        boolean insercion= new ModuloDAO().insertar(nuevo);
        
        if (insercion)
            resultado = "La inserción fue exitosa";        
        return (resultado);
    }
    
    public String modificarModulo(ModuloDTO actualizado){
        String resultado = "La actualización falló";
        boolean actualizacion= new ModuloDAO().modificar(actualizado);
        
        if (actualizacion)
            resultado = "La actualización fue exitosa";        
        return (resultado);
    }
    
    public String eliminarModulo(ModuloDTO eliminado){
        String resultado = "La eliminación falló";
        boolean borrado= new ModuloDAO().eliminar(eliminado);
        
        if (borrado)
            resultado = "La eliminación fue exitosa";        
        return (resultado);
    }
    
    
    public String getUnModulo(int id_modulo){
        ModuloDTO modulo = new ModuloDAO().getUnModulo(new ModuloDTO(id_modulo));
        String tabla = "No se encontraron registro de Módulos  ";
        if (modulo!=null){
            tabla="<div class='formRow'><label></label><div class='formRight'><input type='hidden' size='30' name='identificador' readonly='readonly' value='"+modulo.getIdentificador()+"'></div></div>";
            tabla+="<div class=\"formRow\"><label>Nombre: </label>";
            tabla+="<div class=\"formRight\"><input type='text' name='nombre' required value='"+modulo.getNombre()+"'></div></div>";
            tabla+="<div class=\"formRow\"><label>Descripci&oacute;n:</label>";
            tabla+="<div class=\"formRight\"><input type='text' name='descripcion' required value='"+modulo.getDescripcion()+"'></div></div></br></br>";
           
        }
        return (tabla);
    }
    
    //Arroja un combo con todos los módulos de prueba que haya registrado en el sistema
    public String listadoModulos(){
        TreeSet<ModuloDTO> modulos = new ModuloDAO().getModulo();
        String listado = "<select class=\"chzn-select chosen_select\" name='modulo'>";
        listado+="<option>"+ "" +"</option>";
        for (ModuloDTO modulo : modulos) {
            listado+="<option value='"+modulo.getIdentificador()+"'>"+modulo.getNombre() +"</option>";

        }
        listado+="</select>";
        return listado;
    }
}
