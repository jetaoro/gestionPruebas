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
        String tabla = "<table border = '1'>"+
                "\n<tr>"+
                "\n<th></th>"+
                "\n<th>Nombre</th>"+
                "\n</tr>";
        if(!modulos.isEmpty()){
            for (ModuloDTO modulo : modulos) {
                tabla+="\n<tr>";
                tabla+="\n<td>"+"<input type = 'radio' name = 'modulo' value = '"+modulo.getIdentificador()+"' >" + "</td>";
                tabla+="\n<td>"+ modulo.getNombre()+"</td>";           
                tabla+="\n</tr>";
            }
        }
        else
            tabla+="\n<table border='1'><td>No se encontraron módulos registrados.</td></table>";
        tabla+="</table></br>";
        return (tabla); 
        /*
        String selec="<select name='id'>";
        for(ModuloDTO modulo:modulos)
        {
            selec+="\n<option value='"+modulo.getIdentificador()+"'>"+modulo.getNombre()+"</option>";
        }
        selec+="</select>";
        return (selec); 
        * */
    }
    
    public String agregarModulo(){ 
        String tabla = "<table border=1>";
        tabla += "<table border=1>";
        tabla += "<tr><td align='center'>Agregar M&oacute;dulo</td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Nombre</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='nombre' required></td></tr></table>";
        tabla += "<table border=1><tr align='center'><td>Descripci&oacute;n</td></tr>";
        tabla += "<tr align='center'><td><input type='text' name='descripcion' required></td></tr></table>";
        tabla += "</table></br>";

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
    
    
    //Pendiente, se supone que se obtiene un módulo
    public String getUnModulo(int id_modulo){
        ModuloDTO modulo = new ModuloDAO().getUnModulo(new ModuloDTO(id_modulo));
        String tabla = "No se ha encontrado el módulo buscado";
        if (modulo!=null){
            tabla="<table border=1>";            
            tabla+="<tr><td align='center'>Modificar M&oacute;dulo</td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Identificador</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='identificador' readonly='readonly' value='"+modulo.getIdentificador()+"'></td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Nombre</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='nombre' required value='"+modulo.getNombre()+"'></td></tr></table>";
            tabla+="<table border=1><tr align='center'><td>Descripci&oacute;n</td></tr>";
            tabla+="<tr align='center'><td><input type='text' name='descripcion' required value='"+modulo.getDescripcion()+"'></td></tr></table>";
            tabla+="</table></br>";
        }
        return (tabla);
    }
    
    //Arroja un combo con todos los módulos de prueba que haya registrado en el sistema
    public String listadoModulos(){
        TreeSet<ModuloDTO> modulos = new ModuloDAO().getModulo();
        String listado = "<select name='modulo'>";
        listado+="<option>"+ "" +"</option>";
        for (ModuloDTO modulo : modulos) {
            listado+="<option value='"+modulo.getIdentificador()+"'>"+modulo.getNombre() +"</option>";

        }
        listado+="</select>";
        return listado;
    }
}
