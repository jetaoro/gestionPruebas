/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.*;
import DAO.*;

/**
 *
 * @author Jennifer
 */
public class PruebaDTO implements Comparable{
    private int identificador;
    private String nombre;
    private String numero_requerimiento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_ejecucion;
    private String elemento_prueba;
    private String descripcion;
    private String caso_exito;
    private String caso_fallo;
    private ModuloDTO modulo = new ModuloDTO();
    private ResponsableDTO responsable = new ResponsableDTO();
    private SitioPruebaDTO sitioPrueba = new SitioPruebaDTO();
    private TipoPruebaDTO tipoPrueba = new TipoPruebaDTO();
    private ArrayList<ModoEjecucionDTO> modosEjecucion = new ArrayList<ModoEjecucionDTO>();
    private TreeSet<CasoPruebaDTO> casosPrueba = new TreeSet<CasoPruebaDTO>();

    public PruebaDTO() {
    }

    public PruebaDTO(int identificador) {
        this.identificador = identificador;
    }

    public PruebaDTO(int identificador, String nombre, String numero_requerimiento, Date fecha_inicio, Date fecha_fin, Date fecha_ejecucion, String elemento_prueba, String descripcion, String caso_exito, String caso_fallo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.numero_requerimiento = numero_requerimiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_ejecucion = fecha_ejecucion;
        this.elemento_prueba = elemento_prueba;
        this.descripcion = descripcion;
        this.caso_exito = caso_exito;
        this.caso_fallo = caso_fallo;
    }

    public PruebaDTO(int identificador, String nombre, String numero_requerimiento, Date fecha_inicio, Date fecha_fin, Date fecha_ejecucion, String elemento_prueba, String descripcion, String caso_exito, String caso_fallo, int id_responsable, int id_modulo, int id_sitio, int id_tipo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.numero_requerimiento = numero_requerimiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_ejecucion = fecha_ejecucion;
        this.elemento_prueba = elemento_prueba;
        this.descripcion = descripcion;
        this.caso_exito = caso_exito;
        this.caso_fallo = caso_fallo;
        this.responsable = new ResponsableDAO().getUnResponsable(new ResponsableDTO(id_responsable));
        this.modulo = new ModuloDAO().getUnModulo(new ModuloDTO(id_modulo));
        this.sitioPrueba = new SitioPruebaDAO().getUnSitioPrueba(new SitioPruebaDTO (id_sitio));
        this.tipoPrueba = new TipoPruebaDAO().getUnTipoPrueba(new TipoPruebaDTO (id_tipo));
        this.modosEjecucion = new PruebaDAO().getModosEjecucion(this);
        this.casosPrueba = new CasoPruebaDAO().getCasosPruebaDeUnaPrueba(this);
    }
    
    public PruebaDTO(String nombre, String numero_requerimiento, Date fecha_inicio, Date fecha_fin, Date fecha_ejecucion, String elemento_prueba, String descripcion, String caso_exito, String caso_fallo, int id_responsable, int id_modulo, int id_sitio, int id_tipo) {
        this.nombre = nombre;
        this.numero_requerimiento = numero_requerimiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_ejecucion = fecha_ejecucion;
        this.elemento_prueba = elemento_prueba;
        this.descripcion = descripcion;
        this.caso_exito = caso_exito;
        this.caso_fallo = caso_fallo;
        this.responsable = new ResponsableDAO().getUnResponsable(new ResponsableDTO(id_responsable));
        this.modulo = new ModuloDAO().getUnModulo(new ModuloDTO(id_modulo));
        this.sitioPrueba = new SitioPruebaDAO().getUnSitioPrueba(new SitioPruebaDTO (id_sitio));
        this.tipoPrueba = new TipoPruebaDAO().getUnTipoPrueba(new TipoPruebaDTO (id_tipo));                
    }

       public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero_requerimiento() {
        return numero_requerimiento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public Date getFecha_ejecucion() {
        return fecha_ejecucion;
    }

    public String getElemento_prueba() {
        return elemento_prueba;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaso_exito() {
        return caso_exito;
    }

    public String getCaso_fallo() {
        return caso_fallo;
    }

    public ArrayList<ModoEjecucionDTO> getModosEjecucion() {
        return modosEjecucion;
    }

    public TreeSet<CasoPruebaDTO> getCasosPrueba() {
        return casosPrueba;
    }
    
    public ModuloDTO getModulo() {
        return modulo;
    }

    public ResponsableDTO getResponsable() {
        return responsable;
    }

    public SitioPruebaDTO getSitioPrueba() {
        return sitioPrueba;
    }

    public TipoPruebaDTO getTipoPrueba() {
        return tipoPrueba;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero_requerimiento(String numero_requerimiento) {
        this.numero_requerimiento = numero_requerimiento;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setFecha_ejecucion(Date fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public void setElemento_prueba(String elemento_prueba) {
        this.elemento_prueba = elemento_prueba;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCaso_exito(String caso_exito) {
        this.caso_exito = caso_exito;
    }

    public void setCaso_fallo(String caso_fallo) {
        this.caso_fallo = caso_fallo;
    }

    public void setModosEjecucion(ArrayList<ModoEjecucionDTO> modosEjecucion) {
        this.modosEjecucion = modosEjecucion;
    }

    public void setCasosPrueba(TreeSet<CasoPruebaDTO> casosPrueba) {
        this.casosPrueba = casosPrueba;
    }
    
    public void setModulo(ModuloDTO modulo) {
        this.modulo = modulo;
    }

    public void setResponsable(ResponsableDTO responsable) {
        this.responsable = responsable;
    }

    public void setSitioPrueba(SitioPruebaDTO sitioPrueba) {
        this.sitioPrueba = sitioPrueba;
    }

    public void setTipoPrueba(TipoPruebaDTO tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    @Override
    public int compareTo(Object o) {
        PruebaDTO x=(PruebaDTO)o;
        return (this.identificador-x.identificador);
    }
    
    @Override
    public String toString() {
        return "PruebaDTO{" + "identificador=" + identificador + ", nombre=" + nombre + ", numero_requerimiento=" + numero_requerimiento + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", fecha_ejecucion=" + fecha_ejecucion + ", elemento_prueba=" + elemento_prueba + ", descripcion=" + descripcion + ", caso_exito=" + caso_exito + ", caso_fallo=" + caso_fallo + ", modosEjecucion=" + modosEjecucion + ", casosPrueba=" + casosPrueba + '}';
    }
}
