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
    
    public String getPrueba(){
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
            tabla+="\n</tr>";
        }
        return (tabla);
    }
    
    public String buscarPrueba(){
        String tabla = "<table border='1'>";
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
        
        for (PruebaDTO prueba : pruebas) {
            tabla+="\n<tr>";
            tabla+="\n<td>"+"<input type = 'radio' name = 'modulo' value = '"+prueba.getIdentificador()+"' >" + "</td>";
            tabla+="\n<td>"+prueba.getNumero_requerimiento()+"</td>";
            tabla+="\n<td>"+ prueba.getNombre()+"</td>";
            tabla+="\n<td>"+ prueba.getModulo().getNombre()+"</td>";
            tabla+="\n<td>"+ prueba.getResponsable().getNombre()+"</td>";
            tabla+="\n</tr>";
        }
        
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
        tabla+="<tr><th>Fecha de Ejecución: </th>" + "<td><input type='text' size='30' maxlength='30' name='fecha_ejecucucion' required></td></tr>";
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
    
    public String insertarUnaPrueba(int idModulo, int idSitio, int idResponsable, String fechaInicio, String fechaFin, String nombre, String numero_requerimiento, String fechaEjecucion, String elementoPrueba, int idTipoPrueba, String [] modosEjecucion, String descripcion, String casoExito, String casoFallo){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaInicio2 = new Date();
        Date fechaFin2 = new Date();
        Date fechaEjecucion2 = new Date();
        try {
            fechaInicio2 = formato.parse(fechaInicio);
        }catch (ParseException ex) {
        }
        try {
             fechaFin2 = formato.parse(fechaFin);
        }catch (ParseException ex) {
        }
        try {
            fechaEjecucion2 = formato.parse(fechaEjecucion);
        }catch (ParseException ex) {
        }
        
        int idModo2;
        ArrayList<ModoEjecucionDTO> modos = new ArrayList<>();
        if (modosEjecucion!=null){
            for (String idModo : modosEjecucion) {
                idModo2 = Integer.parseInt(idModo);
                modos.add(new ModoEjecucionDTO(idModo2));
            }
        }
        PruebaDTO nueva = new PruebaDTO(nombre, numero_requerimiento, fechaInicio2, fechaFin2, fechaEjecucion2, elementoPrueba, descripcion, casoExito, casoFallo, idResponsable, idModulo, idSitio, idTipoPrueba);
        nueva.setModosEjecucion(modos);
        String resultado = "La inserción falló";
        boolean insercion= new PruebaDAO().insertar(nueva);
        
        if (insercion)
            resultado = "La inserción fue exitosa";        
        return (resultado);
    }
    
    public String obtenerPruebaEjemplo(){
        String result = new PruebaDAO().fechaInicio();
        return result;
    }
    
}