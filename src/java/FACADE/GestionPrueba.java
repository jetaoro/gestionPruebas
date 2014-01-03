/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;
import NEGOCIO.*;
import DTO.*;

/**
 *
 * @author Jennifer
 */
public class GestionPrueba {

    public GestionPrueba() {
    }
    
    //Sección de Módulos
    public String getModulos() {
        return (new Modulo().getModulo());
    }
    
    public String getListadoModulos(){
        return (new Modulo().getListadoModulos());
    }
    
    public String agregarModulo(){
        return (new Modulo().agregarModulo());
    }
    
    public String insertarModulo(ModuloDTO modulo){
        return (new Modulo().insertarModulo(modulo));
    }
    
    public String modificarModulo(ModuloDTO modulo){
        return (new Modulo().modificarModulo(modulo));
    }
    
    public String eliminarModulo(int idModulo){
        return (new Modulo().eliminarModulo(new ModuloDTO(idModulo)));
    }            
    
    public String getUnModulo(int id_modulo){
        return (new Modulo().getUnModulo(id_modulo));
    }
    
    
    
    //Sección de Sitios de prueba
    public String getSitiosPrueba() {
        return (new SitioPrueba().getSitioPrueba());
    }
    
    public String getListadoSitios(){
        return (new SitioPrueba().getListadoSitios());
    }
    
    public String agregarSitioPrueba(){
        return (new SitioPrueba().agregarSitioPrueba());
    }
    
    public String insertarSitioPrueba(SitioPruebaDTO sitio){
        return (new SitioPrueba().insertarSitioPrueba(sitio));
    }
    
    public String modificarSitioPrueba(SitioPruebaDTO sitio){
        return (new SitioPrueba().modificarSitioPrueba(sitio));
    }
    
    public String eliminarSitioPrueba(SitioPruebaDTO sitio){
        return (new SitioPrueba().eliminarSitioPrueba(sitio));
    }
    
    public String getUnSitioPrueba(int id_sitio){
        return (new SitioPrueba().getUnSitioPrueba(id_sitio));
    }
    
    
    //Sección de Casos de prueba
    public String getCasosPrueba(PruebaDTO prueba){ //Obtiene los casos de prueba de una prueba
        return (new CasoPrueba().getCasosPrueba(prueba));
    }
    
    public String insertarCasoPrueba(CasoPruebaDTO caso){
        return (new CasoPrueba().insertarCasoPrueba(caso));
    }
    
    public String modificarCasoPrueba(CasoPruebaDTO caso){
        return (new CasoPrueba().modificarCasoPrueba(caso));
    }
    
    public String eliminarCasoPrueba (CasoPruebaDTO caso){
        return (new CasoPrueba().eliminarCasoPrueba(caso));
    }
    
    
    //Sección de pruebas
    public String getPruebas(){
        return (new Prueba().getPrueba());
    }
    
    public String paginaBuscarPruebas(){
        return (new Prueba().buscarPrueba());
    }
    
    public String buscarPruebas(String nombre, String numero_requerimiento, int modulo, int responsable, int sitio_prueba){         
        return new Prueba().buscarPrueba(nombre, numero_requerimiento, modulo, responsable, sitio_prueba);
    }
    
    public String agregarPruebaFormulario(){
        
        return (new Prueba().agregarPruebaFormulario());
    }
    
    public String agregarPrueba(PruebaDTO nueva){
        return new Prueba().insertarPrueba(nueva);
    }
    
    public String insertarUnaPrueba(int idModulo2, int idSitio2, int idResponsable2, String fechaInicio, String fechaFin, String nombre, String numero_requerimiento, String fechaEjecucion, String elementoPrueba, int idTipoPrueba, String [] modosEjecucion, String descripcion, String casoExito, String casoFallo){
        return (new Prueba().insertarUnaPrueba(idModulo2, idSitio2, idResponsable2, fechaInicio, fechaFin, nombre, numero_requerimiento, fechaEjecucion, elementoPrueba, idTipoPrueba, modosEjecucion, descripcion, casoExito, casoFallo));
    }
    
    public String insertarPrueba(PruebaDTO prueba){
        return (new Prueba().insertarPrueba(prueba));
    }
   
    //Prueba comprobacion
    public String getFechaInicio(){
        return (new Prueba().obtenerPruebaEjemplo());
    }
    
    public static void main(String args[])
    {
        //System.out.println(new GestionPrueba().clone());
    }
}
