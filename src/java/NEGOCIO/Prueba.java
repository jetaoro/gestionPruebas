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
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String tabla = "<strong>Evidencia de las pruebas realizadas sobre el Módulo "+ prueba.getModulo().getNombre();
        tabla += ", en el puerto "+ prueba.getSitioPrueba().getNumero_puerto() + "</strong></br>";
        tabla+= "Fecha de Inicio: "+ "<input type='text' id=\"dp4\"  data-date-format=\"dd/mm/yyyy\" name='fecha_inicio' value='" + formateador.format(prueba.getFecha_inicio()) + "' required>";
        tabla+= "</br>Fecha de Terminación: "+ "<input  type='text' id=\"dp5\"  data-date-format=\"dd/mm/yyyy\" name='fecha_fin' value='" + formateador.format(prueba.getFecha_inicio()) + "' required>";
        tabla+= "</br>Fecha Ejecuci&oacute;n" +  "<input id=\"dp6\"  data-date-format=\"dd/mm/yyyy\" type='text' name='fecha_ejecucion' value='" + formateador.format(prueba.getFecha_ejecucion()) + "' required>";
        tabla+= "</br>Pruebas realizadas por: "+ prueba.getResponsable().getNombre() + "</br>";
        tabla += "</br><table class=\"table table-bordered\">";           
        tabla += "\n<tr><th>Registro de Ejecución de Pruebas</th></tr>";
        tabla += "\n<tr><th>Identificador</th>" + "\n<td>" + "<input type='text' name='identificador' readonly='readonly' value='" + prueba.getIdentificador() + "'></td></tr>";
        tabla += "\n<tr><th>Nombre</th>" + "\n<td>" + "<input type='text' name='nombre' value='" + prueba.getNombre() + "' required></td></tr>";
         tabla += "\n<tr><th>Número de requerimiento</th>" + "<td>" + "<input type='text' name='numero_requerimiento' value='" + prueba.getNumero_requerimiento() + "' required></td></tr>";
       
        tabla += "\n<tr><th>Elemento a probar</th>" + "<td>" + "<input type='text' name='elemento_prueba' value='" + prueba.getElemento_prueba() + "' required></td></tr>";
        tabla += "\n<tr><th>Tipo de Prueba</th>" + "<td>" + "<input type='text' name='tipo_prueba' readonly='readonly' value='" + prueba.getTipoPrueba().getDescripcion() + "' required></td></tr>";
        tabla += "\n<tr><th>Modos de Ejecución</th>" + "<td>" + "<input type='text' name='modo_ejecucion' readonly='readonly' value='" + prueba.getModosEjecucion().toString() + "'></td></tr>";
        tabla += "\n<tr><th>Descripción de la Prueba</th>" + "<td>" + "<input type='text' name='descripcion' value='" + prueba.getDescripcion() + "' required></td></tr>";
        tabla += "\n<tr><th>Caso de éxito</th>" + "<td>" + "<input type='text' name='caso_exito' value='" + prueba.getCaso_exito() + "' required></td></tr>";
        tabla += "\n<tr><th>Caso de Fallo</th>" + "<td>" + "<input type='text' name='caso_fallo' value='" + prueba.getCaso_fallo() + "' required></td></tr>";
        tabla += "</table></br>";
        
        return (tabla);
    }
    
    public String buscarPrueba(){
        String tabla = "<div class=\"formRow\">";
        
        tabla+="<label>Nombre prueba: </label>"+"<div class=\"formRight\">" +"<input type='text' size='30' maxlength='30' name='nombre_prueba'></div></div>";
        tabla+="<div class=\"formRow\"><label>Número de requerimiento: </label>"+"<div class=\"formRight\"><input type='text' size='30' maxlength='30' name='numero_requerimiento'></div></div>";
        tabla+="<div class=\"formRow\">";
        tabla+="<label>Módulo: </label>"+"<div class=\"formRight\">"+ new Modulo().listadoModulos()+"</div>";
        tabla+="</div>";
        tabla+="<div class=\"formRow\">";
        tabla+="<label>Responsable: </label>"+"<div class=\"formRight\">"+new Responsable().listadoResponsables() +"</div>";
        tabla+="</div>";
        tabla+="<div class=\"formRow\">";
        tabla+="<label>Sitio Prueba: </label>"+"<div class=\"formRight\">"+"<td>"+new SitioPrueba().listadoSitiosPrueba()+"</div>";
        tabla+="</div>";
        tabla+="</br></br></br>";
        return tabla;
    }
    
    public String buscarPrueba(String nombre, String numero_requerimiento, int modulo, int responsable, int sitio_prueba){
        TreeSet<PruebaDTO> pruebas = new TreeSet<PruebaDTO>();
        PruebaDAO pruebaDAO = new PruebaDAO();
        if(nombre==null && numero_requerimiento==null && responsable==0 && sitio_prueba==0 && modulo==0)
            pruebas = pruebaDAO.getPruebas();
        else
            pruebas = pruebaDAO.getPruebas(nombre, numero_requerimiento, modulo, responsable, sitio_prueba);
        String tabla = "<table class=\"table table-bordered table-mod-2\" id=\"datatable_3\">"+
                "<thead>"+
                "<tr>"+
                "<th></th>"+
                "<th>Número de requerimiento</th>"+
                "<th>Nombre</th>"+
                "<th>Módulo</th>"+
                "<th>Responsable</th>"+
                "</tr>"+
                "</thead>"+
                "<tbody>";
        
        if (!pruebas.isEmpty()){
            for (PruebaDTO prueba : pruebas) {
                tabla+="<tr>";
                tabla+="<td class=\"t_center\"><input  type = 'radio' name = 'prueba' id = '"+prueba.getIdentificador()+"' value = '"+prueba.getIdentificador()+"' >" + "<label for='"+prueba.getIdentificador()+"'><span></span></label></td>";
                tabla+="<td>"+ prueba.getNumero_requerimiento()+"</td>";
                tabla+="<td>"+ prueba.getNombre()+"</td>";
                tabla+="<td>"+ prueba.getModulo().getNombre()+"</td>";
                tabla+="<td>"+ prueba.getResponsable().getNombre()+"</td>";
                tabla+="</tr>";
               
            }
        }
        else 
            tabla+="\n<table  class=\"table table-bordered table-mod-2\"><td>No se encontraron pruebas registradas.</td></table>";
        tabla+="</tbody></table></br>";
        return (tabla);
    }
    
    public String agregarPruebaFormulario(){
        String tabla = "Evidencias de las pruebas realizadas sobre el Módulo " + new Modulo().listadoModulos();
        tabla+=", de Gnosoft Académico, en el puerto " + new SitioPrueba().listadoSitiosPrueba();
        tabla+="</br>"+"Fecha de Inicio: " + "<input id='dp4' type='text' data-date-format=\"dd/mm/yyyy\" size='30' maxlength='30' name='fecha_inicio' required>";
        tabla+="</br>"+"Fecha de Terminación: " + "<input type='text' data-date-format=\"dd/mm/yyyy\" id='dp5' size='30' maxlength='30' name='fecha_fin' required>";
        tabla+="</br>"+"Pruebas realizadas por: " + new Responsable().listadoResponsables();
        tabla+="</br>"+"<h4>REGISTRO DE EJECUCIÓN DE PRUEBA</h4>";
        tabla+="<div class=\"formRow\">";
        tabla+="<strong>Descripción de las pruebas</strong>"; 
        tabla+="</div>";
        tabla+="<div class='formRow'>";
        tabla+="Fecha de Ejecución: " + "<input id='dp6' type='text' data-date-format=\"dd/mm/yyyy\" size='30' maxlength='30' name='fecha_ejecucion' required></br>";
        tabla+="<label>Nombre de la prueba: </label>" + "<div class='formRight'> <textarea rows='4' cols='40' name='nombre' required></textarea></div></div>";
        tabla+="<div class='formRow'> <label>Número de requerimiento: </label>" + "<div class='formRight'><input type='text' size='30' maxlength='30' name='numero_requerimiento' required></div></div>";
        tabla+="<div class='formRow'><label>Elemento a probar: </label>" + "<div class='formRight'><input type='text' size='30' maxlength='30' name='elemento_prueba' required></div></div>";
        tabla+="<div class='formRow'><label>Tipo de Prueba: </label>" + "<div class='formRight'>" + new TipoPrueba().listadoTiposPrueba() + "</div></div>";
        tabla+="<div class='formRow'><label>Modo de Ejecución: </label>" + "<div class='formRight'>" + new ModoEjecucion().listadoModosEjecucion() + "</div></div>";
        tabla+="<div class='formRow'><label>Descripción de la prueba: </label>" + "<div class='formRight'><textarea rows='4' cols='40' name='descripcion' required></textarea></div></div>";
        tabla+="<div class='formRow'><label>Caso de Éxito: </label>" + "<div class='formRight'><textarea rows='4' cols='40' name='caso_exito' required></textarea></div></div>";
        tabla+="<div class='formRow'><label>Caso de Fallo: </label>" + "<div class='formRight'><textarea rows='4' cols='40' name='caso_fallo' required></textarea></div></div>";
        
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
        String resultado = "La inserción falló";        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio2 = formato.parse(fechaInicio);
        Date fechaFin2 = formato.parse(fechaFin); 
        Date fechaEjecucion2 = formato.parse(fechaEjecucion);      
        
        int idModo2;
        ArrayList<ModoEjecucionDTO> modos = new ArrayList<ModoEjecucionDTO>();
        if (modosEjecucion!=null){
            for (String idModo : modosEjecucion) {
                idModo2 = Integer.parseInt(idModo);
                modos.add(new ModoEjecucionDTO(idModo2));
            }
        }
        
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
    
}
