/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DAO.*;
import DTO.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Jennifer
 */
public class Prueba {

    public Prueba() {
    }
    
    public String getPruebas(){
        TreeSet<PruebaDTO> pruebas = new PruebaDAO().getPruebas();
        String tabla = "<table border='1'>";
                       
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);        

        for (PruebaDTO prueba : pruebas) {
            tabla+="\n<tr>";
            tabla+="\n<tr><th>M&oacute;dulo</th>"+"\n<td>"+prueba.getModulo().getNombre()+"</td>";
            tabla+="\n<tr><th>Sitio de Prueba</th>"+"\n<td>"+prueba.getSitioPrueba().getNumero_puerto()+"</td>";
            tabla+="\n<tr><th>Fecha de Inicio</th>"+"\n<td>"+df1.format(prueba.getFecha_inicio())+"</td>";
            tabla+="\n<tr><th>Fecha Fin</th>"+"\n<td>"+df1.format(prueba.getFecha_fin())+"</td>";            
            tabla+="\n<tr><th>Responsable</th>"+"\n<td>"+prueba.getResponsable().getNombre()+"</td>";
            tabla+="\n<tr><th>Identificador</th>"+"\n<td>"+"PR_"+prueba.getNumero_requerimiento()+"_"+prueba.getIdentificador()+"</td>";
            tabla+="\n<tr><th>Nombre</th>"+"\n<td>"+prueba.getNombre()+"</td>";            
            tabla+="\n<tr><th>Fecha Ejecuci&oacute;n</th>"+"\n<td>"+df1.format(prueba.getFecha_ejecucion())+"</td>";
            tabla+="\n<tr><th>Elemento a probar</th>"+"\n<td>"+prueba.getElemento_prueba()+"</td>";
            tabla+="\n<tr><th>Tipo de Prueba</th>"+"\n<td>"+prueba.getTipoPrueba().getDescripcion()+"</td>";
            tabla+="\n<tr><th>Elemento a probar</th>"+"\n<td>"+prueba.getElemento_prueba()+"</td>";
            tabla+="\n<tr><th>Modos de Ejecución</th>"+"\n<td>"+prueba.getModosEjecucion().toString()+"</td>";
            tabla+="\n<tr><th>Descripción de la Prueba</th>"+"\n<td>"+prueba.getDescripcion()+"</td>";
            tabla+="\n<tr><th>Caso de éxito</th>"+"\n<td>"+prueba.getCaso_exito()+"</td>";
            tabla+="\n<tr><th>Caso de Fallo</th>"+"\n<td>"+prueba.getCaso_fallo()+"</td>";
            tabla+="\n<tr><th>Casos de Prueba"+"</th></tr>";
            tabla+= new CasoPrueba().getCasosPrueba(prueba);
            tabla+="\n</tr></table></br>";
        }
        return (tabla);
    }
    
    //PENDIENTE POR TERMINAR
    public String getPrueba(int idPrueba){
        PruebaDTO prueba = new PruebaDAO().getUnaPrueba(new PruebaDTO(idPrueba));
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String tabla = "Evidencia de las pruebas realizadas sobre el Módulo "+ prueba.getModulo().getNombre();
        tabla += ", en el puerto "+ prueba.getSitioPrueba().getNumero_puerto() + "</br>";
        tabla+= "Fecha de Inicio: "+ df1.format(prueba.getFecha_inicio());
        tabla+= "</br>Fecha de Terminación: "+ df1.format(prueba.getFecha_fin());
        tabla+= "</br>Pruebas realizadas por: "+ prueba.getResponsable().getNombre() + "</br>";
        tabla += "</br><table border='1'>";           
        tabla += "\n<tr>"; 
        tabla += "\n<tr><th>Registro de Ejecución de Pruebas</th></tr>";
        tabla += "\n<tr><th>Identificador</th>" + "\n<td>" + "<input type='text' name='idPrueba' readonly='readonly' value='" + prueba.getIdentificador() + "'></td>";
        tabla += "\n<tr><th>Número de requerimiento</th>" + "\n<td>" + "<input type='text' name='numero_requerimiento' readonly='readonly' value='" + prueba.getNumero_requerimiento() + "'></td>";
        tabla += "\n<tr><th>Nombre</th>" + "\n<td>" + "<input type='text' name='nombre' readonly='readonly' value='" + prueba.getNombre() + "'></td>";
        tabla += "\n<tr><th>Fecha Ejecuci&oacute;n</th>" + "\n<td>" + "<input type='text' name='fecha_ejecucion' readonly='readonly' value='" + df1.format(prueba.getFecha_ejecucion()) + "'></td>";
        tabla += "\n<tr><th>Elemento a probar</th>" + "\n<td>" + "<input type='text' name='elemento_prueba' readonly='readonly' value='" + prueba.getElemento_prueba() + "'></td>";
        tabla += "\n<tr><th>Tipo de Prueba</th>" + "\n<td>" + "<input type='text' name='tipo_prueba' readonly='readonly' value='" + prueba.getTipoPrueba().getDescripcion() + "'></td>";
        tabla += "\n<tr><th>Modos de Ejecución</th>" + "\n<td>" + "<input type='text' name='modo_ejecucion' readonly='readonly' value='" + prueba.getModosEjecucion().toString() + "'></td>";
        tabla += "\n<tr><th>Descripción de la Prueba</th>" + "\n<td>" + "<input type='text' name='descripcion' readonly='readonly' value='" + prueba.getDescripcion() + "'></td>";
        tabla += "\n<tr><th>Caso de éxito</th>" + "\n<td>" + "<input type='text' name='caso_exito' readonly='readonly' value='" + prueba.getCaso_exito() + "'></td>";
        tabla += "\n<tr><th>Caso de Fallo</th>" + "\n<td>" + "<input type='text' name='caso_fallo' readonly='readonly' value='" + prueba.getCaso_fallo() + "'></td>";        
        tabla+="\n<tr><th>Casos de Prueba"+"</th></tr>";
        tabla+= new CasoPrueba().getCasosPrueba(prueba);
        tabla += "\n</tr></table></br>";
        
        return (tabla);
    }
    
    public String getUnaPrueba(int idPrueba){
        PruebaDTO prueba = new PruebaDAO().getUnaPrueba(new PruebaDTO(idPrueba));
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String tabla = "Evidencia de las pruebas realizadas sobre el Módulo "+ prueba.getModulo().getNombre();
        tabla += ", en el puerto "+ prueba.getSitioPrueba().getNumero_puerto() + "</br>";
        tabla+= "Fecha de Inicio: "+ "<input type='text' name='fecha_inicio' value='" + df1.format(prueba.getFecha_inicio()) + "' required>";
        tabla+= "</br>Fecha de Terminación: "+ "<input type='text' name='fecha_fin' value='" + df1.format(prueba.getFecha_inicio()) + "' required>";
        tabla+= "</br>Pruebas realizadas por: "+ prueba.getResponsable().getNombre() + "</br>";
        tabla += "</br><table border='1'>";           
        tabla += "\n<tr>"; 
        tabla += "\n<tr><th>Registro de Ejecución de Pruebas</th></tr>";
        tabla += "\n<tr><th>Identificador</th>" + "\n<td>" + "<input type='text' name='identificador' readonly='readonly' value='" + prueba.getIdentificador() + "'></td>";
        tabla += "\n<tr><th>Nombre</th>" + "\n<td>" + "<input type='text' name='nombre' value='" + prueba.getNombre() + "' required></td>";
         tabla += "\n<tr><th>Número de requerimiento</th>" + "\n<td>" + "<input type='text' name='numero_requerimiento' value='" + prueba.getNumero_requerimiento() + "' required></td>";
        tabla += "\n<tr><th>Fecha Ejecuci&oacute;n</th>" + "\n<td>" + "<input type='text' name='fecha_ejecucion' value='" + df1.format(prueba.getFecha_ejecucion()) + "' required></td>";
        tabla += "\n<tr><th>Elemento a probar</th>" + "\n<td>" + "<input type='text' name='elemento_prueba' value='" + prueba.getElemento_prueba() + "' required></td>";
        tabla += "\n<tr><th>Tipo de Prueba</th>" + "\n<td>" + "<input type='text' name='tipo_prueba' readonly='readonly' value='" + prueba.getTipoPrueba().getDescripcion() + "' required></td>";
        tabla += "\n<tr><th>Modos de Ejecución</th>" + "\n<td>" + "<input type='text' name='modo_ejecucion' readonly='readonly' value='" + prueba.getModosEjecucion().toString() + "'></td>";
        tabla += "\n<tr><th>Descripción de la Prueba</th>" + "\n<td>" + "<input type='text' name='descripcion' value='" + prueba.getDescripcion() + "' required></td>";
        tabla += "\n<tr><th>Caso de éxito</th>" + "\n<td>" + "<input type='text' name='caso_exito' value='" + prueba.getCaso_exito() + "' required></td>";
        tabla += "\n<tr><th>Caso de Fallo</th>" + "\n<td>" + "<input type='text' name='caso_fallo' value='" + prueba.getCaso_fallo() + "' required></td>";
        tabla += "\n</tr></table></br>";
        
        return (tabla);
    }
    
    public String buscarPrueba(){
        String tabla = "<table class=\"table table-bordered table-mod-2\">";
        tabla+="\n<tr><th>Nombre prueba: </th>"+"\n<td>"+"<input type='text' size='30' maxlength='30' name='nombre_prueba'></td>";
        tabla+="\n<tr><th>Número de requerimiento: </th>"+"\n<td>"+"<input type='text' size='30' maxlength='30' name='numero_requerimiento'></td>";
        tabla+="\n<tr><th>Módulo: </th>"+"\n<td>"+ new Modulo().listadoModulos() +"</td>";
        tabla+="\n<tr><th>Responsable: </th>"+"\n<td>"+new Responsable().listadoResponsables() +"</td>";
        tabla+="\n<tr><th>Sitio Prueba: </th>"+"\n<td>"+new SitioPrueba().listadoSitiosPrueba()+"</td>";
        tabla+="</table>";
        return tabla;
    }
    
    public String buscarPrueba(String nombre, String numero_requerimiento, int modulo, int responsable, int sitio_prueba){
        TreeSet<PruebaDTO> pruebas = new TreeSet<>();
        PruebaDAO pruebaDAO = new PruebaDAO();
        if(nombre==null && numero_requerimiento==null && responsable==0 && sitio_prueba==0 && modulo==0)
            pruebas = pruebaDAO.getPruebas();
        else
            pruebas = pruebaDAO.getPruebas(nombre, numero_requerimiento, modulo, responsable, sitio_prueba);
        String tabla = "<table border = '1'>"+
                "\n<tr>"+
                "\n<th></th>"+
                "\n<th>Número de requerimiento</th>"+
                "\n<th>Nombre</th>"+
                "\n<th>Módulo</th>"+
                "\n<th>Responsable</th>"+
                "\n</tr>";
        
        if (!pruebas.isEmpty()){
            for (PruebaDTO prueba : pruebas) {
                tabla+="\n<tr>";
                tabla+="\n<td>"+"<input type = 'radio' name = 'prueba' value = '"+prueba.getIdentificador()+"' checked>" + "</td>";
                tabla+="\n<td>"+ prueba.getNumero_requerimiento()+"</td>";
                tabla+="\n<td>"+ prueba.getNombre()+"</td>";
                tabla+="\n<td>"+ prueba.getModulo().getNombre()+"</td>";
                tabla+="\n<td>"+ prueba.getResponsable().getNombre()+"</td>";
                tabla+="\n</tr>";
            }
        }
        else 
            tabla+="\n<table border='1'><td>No se encontraron pruebas registradas.</td></table>";
        tabla+="</table></br>";
        return (tabla);
    }
    
    public String agregarPruebaFormulario(){
        String tabla = "Evidencias de las pruebas realizadas sobre el Módulo " + new Modulo().listadoModulos();
        tabla+=", de Gnosoft Académico, en el puerto " + new SitioPrueba().listadoSitiosPrueba();
        tabla+="</br>"+"Fecha de Inicio: " + "<input type='text' size='30' maxlength='30' name='fecha_inicio' required>";
        tabla+="</br>"+"Fecha de Terminación: " + "<input type='text' size='30' maxlength='30' name='fecha_fin' required>";
        tabla+="</br>"+"Pruebas realizadas por: " + new Responsable().listadoResponsables();
        tabla+="</br>"+"<table border='1'> <th><h3>REGISTRO DE EJECUCIÓN DE PRUEBA</h3></th>";
        tabla+="<tr><th><h4>Descripción de las pruebas</h4></th></tr>";        
        tabla+="<tr><th>Nombre de la prueba: </th>" + "<td><textarea rows='4' cols='40' name='nombre' required></textarea></td></tr>";
        tabla+="<tr><th>Número de requerimiento: </th>" + "<td><input type='text' size='30' maxlength='30' name='numero_requerimiento' required></td></tr>";
        tabla+="<tr><th>Fecha de Ejecución: </th>" + "<td><input type='text' size='30' maxlength='30' name='fecha_ejecucion' required></td></tr>";
        tabla+="<tr><th>Elemento a probar: </th>" + "<td><input type='text' size='30' maxlength='30' name='elemento_prueba' required></td></tr>";
        tabla+="<tr><th>Tipo de Prueba: </th>" + "<td>" + new TipoPrueba().listadoTiposPrueba() + "</td></tr>";
        tabla+="<tr><th>Modo de Ejecución: </th>" + "<td>" + new ModoEjecucion().listadoModosEjecucion() + "</td></tr>";
        tabla+="<tr><th>Descripción de la prueba: </th>" + "<td><textarea rows='4' cols='40' name='descripcion' required></textarea></td></tr>";
        tabla+="<tr><th>Caso de Éxito: </th>" + "<td><textarea rows='4' cols='40' name='caso_exito' required></textarea></td></tr>";
        tabla+="<tr><th>Caso de Fallo: </th>" + "<td><textarea rows='4' cols='40' name='caso_fallo' required></textarea></td></tr>";
        tabla+="</table>";
        return tabla;
    }
    
    public String insertarPrueba(PruebaDTO nueva){
        String resultado = "La inserción falló";
        boolean insercion= new PruebaDAO().insertar(nueva);
        
        if (insercion)
            resultado = "La inserción fue exitosa";        
        return (resultado);
    }
    
    public String insertarUnaPrueba(int idModulo, int idSitio, int idResponsable, String fechaInicio, String fechaFin, String nombre, String numero_requerimiento, String fechaEjecucion, String elementoPrueba, int idTipoPrueba, String [] modosEjecucion, String descripcion, String casoExito, String casoFallo) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio2 = formato.parse(fechaInicio);
        Date fechaFin2 = formato.parse(fechaFin); 
        Date fechaEjecucion2 = formato.parse(fechaEjecucion);      
        
        int idModo2;
        ArrayList<ModoEjecucionDTO> modos = new ArrayList<>();
        if (modosEjecucion!=null){
            for (String idModo : modosEjecucion) {
                idModo2 = Integer.parseInt(idModo);
                modos.add(new ModoEjecucionDTO(idModo2));
            }
        }
        String resultado = "La inserción falló";
        PruebaDTO nueva = new PruebaDTO(nombre, numero_requerimiento, fechaInicio2, fechaFin2, fechaEjecucion2, elementoPrueba, descripcion, casoExito, casoFallo, idResponsable, idModulo, idSitio, idTipoPrueba);
        for (ModoEjecucionDTO modo : modos) {
            nueva.getModosEjecucion().add(modo);            
        }        
        
        boolean insercion= new PruebaDAO().insertar(nueva);
        
        if (insercion)            
            resultado = "La inserción fue exitosa";         
        return (resultado);
    } 
    
    public String modificarPrueba(int idPrueba, String fechaInicio, String fechaFin, String nombre, String numero_requerimiento, String fechaEjecucion, String elementoPrueba, String descripcion, String casoExito, String casoFallo) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio2 = formato.parse(fechaInicio);
        Date fechaFin2 = formato.parse(fechaFin); 
        Date fechaEjecucion2 = formato.parse(fechaEjecucion);
        PruebaDTO prueba = new PruebaDTO(idPrueba, nombre, numero_requerimiento, fechaInicio2, fechaFin2, fechaEjecucion2, elementoPrueba, descripcion, casoExito, casoFallo);
        String resultado = "La actualización falló";
        boolean actualizacion= new PruebaDAO().modificar(prueba);
        
        if (actualizacion)
            resultado = "La actualización fue exitosa";        
        return (resultado);
    }
    
    public String eliminarPrueba(PruebaDTO eliminada){
        String resultado = "La eliminación de la prueba falló";
        boolean casosPruebaBorrados = new CasoPruebaDAO().eliminarCasosUnaPrueba(eliminada.getIdentificador());
        if(!casosPruebaBorrados){
            resultado = "La eliminación de los casos de prueba de la prueba seleccionada, falló";
            return (resultado);
        }
        boolean modosEjecucionBorrados = new ModoEjecucionDAO().eliminarModosUnaPrueba(eliminada.getIdentificador());
        if(!modosEjecucionBorrados){
            resultado = "La eliminación de los modos de ejecución de la prueba seleccionada, falló";
            return (resultado);
        }
        boolean pruebaBorrada= new PruebaDAO().eliminar(eliminada);
        
        if (pruebaBorrada)
            resultado = "La eliminación de la prueba fue exitosa";        
        return (resultado);
    }
    
    public String obtenerPruebaEjemplo(){
        String result = new PruebaDAO().fechaInicio();
        return result;
    }
    
}
