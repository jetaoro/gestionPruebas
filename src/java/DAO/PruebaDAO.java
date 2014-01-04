/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import DTO.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ufps.util.*;

/**
 *
 * @author Jennifer
 */
public class PruebaDAO {

    public PruebaDAO() {
    }
    
    // Date en postgres aaaa/mm/dd
    //int identificador, String nombre, String numero_requerimiento, Date fecha_inicio, Date fecha_fin, 
    //Date fecha_ejecucion, String elemento_prueba, String descripcion, String caso_exito, String caso_fallo, 
    //int id_responsable, int id_modulo, int id_sitio, int id_tipo, int id_modo
    public TreeSet<PruebaDTO> getPruebas(){
        TreeSet<PruebaDTO> pruebas=new TreeSet<>();
        BaseDeDatos.conectar();
        String sql="select * from prueba";
        ArrayList<String> lista=BaseDeDatos.getConsultaSQL(sql);
        BaseDeDatos.desconectar();

        for(String datos:lista){
            String vdatos[]=datos.split("-");
            String nombre = vdatos[0];
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaInicio = null;
            try {
                fechaInicio = formato.parse(vdatos[1]);
            }catch (ParseException ex) {
            }
            Date fechaFin = null;
            try {
                fechaFin = formato.parse(vdatos[2]);
            }catch (ParseException ex) {
            }
            Date fechaEjecucion = null;
            try {
                fechaEjecucion = formato.parse(vdatos[3]);
            }catch (ParseException ex) {
            }
            String elemento_prueba = vdatos[4];
            String descripcion = vdatos[5];
            String caso_exito = vdatos[6];
            String caso_fallo = vdatos[7];
            int id_prueba = Integer.parseInt(vdatos[13]);
            int id_tipo = Integer.parseInt(vdatos[8]);
            int id_modulo = Integer.parseInt(vdatos[9]);
            int id_responsable = Integer.parseInt(vdatos [10]);
            int id_sitio = Integer.parseInt(vdatos[11]);
            String numeroRequerimiento = vdatos[12];
            PruebaDTO prueba = new PruebaDTO(id_prueba, nombre, numeroRequerimiento, fechaInicio, fechaFin, fechaEjecucion, elemento_prueba, descripcion, caso_exito, caso_fallo, id_responsable, id_modulo, id_sitio, id_tipo);
            pruebas.add(prueba);            
        }   
   
           return (pruebas);
    
        }
    
    public TreeSet<PruebaDTO> getPruebas(String nombre, String numero_requerimiento, int modulo, int responsable, int sitio_prueba){
        TreeSet<PruebaDTO> pruebas=new TreeSet<>();
        BaseDeDatos.conectar();
        boolean primero = false;
        String sql="select * from prueba where ";
        if (nombre != null){
            if (!primero)
                primero=true;
            sql+="nombre like '%" + nombre + "%'";
        }
        
        if (numero_requerimiento != null){
            if (!primero){
                primero=true;
                sql+="numero_requerimiento like '%" +numero_requerimiento + "%'";
            }
            else sql+="and numero_requerimiento like '%" +numero_requerimiento + "%'";
        }
        
        if (modulo != 0){
            if (!primero){
                primero=true;
                sql+="id_modulo=" +modulo;
            }
            else sql+="and id_modulo=" +modulo;
        }
        
        if (responsable != 0){
            if (!primero){
                primero=true;
                sql+="id_responsable=" +responsable;
            }
            else sql+="and id_responsable=" +responsable;
        }
        
        if (sitio_prueba != 0){
            if (!primero){
                primero=true;
                sql+="id_sitio=" +sitio_prueba;
            }
            else sql+="and id_sitio=" +sitio_prueba;
        }
            
        ArrayList<String> lista=BaseDeDatos.getConsultaSQL(sql);
        BaseDeDatos.desconectar();

        for(String datos:lista){
            String vdatos[]=datos.split("-");
            String nombre2 = vdatos[0];
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaInicio = null;
            try {
                fechaInicio = formato.parse(vdatos[1]);
            }catch (ParseException ex) {
            }
            Date fechaFin = null;
            try {
                fechaFin = formato.parse(vdatos[2]);
            }catch (ParseException ex) {
            }
            Date fechaEjecucion = null;
            try {
                fechaEjecucion = formato.parse(vdatos[3]);
            }catch (ParseException ex) {
            }
            String elemento_prueba = vdatos[4];
            String descripcion = vdatos[5];
            String caso_exito = vdatos[6];
            String caso_fallo = vdatos[7];
            int id_prueba = Integer.parseInt(vdatos[13]);
            int id_tipo = Integer.parseInt(vdatos[8]);
            int id_modulo = Integer.parseInt(vdatos[9]);
            int id_responsable = Integer.parseInt(vdatos [10]);
            int id_sitio = Integer.parseInt(vdatos[11]);
            String numeroRequerimiento = vdatos[12];
            PruebaDTO prueba = new PruebaDTO(id_prueba, nombre2, numeroRequerimiento, fechaInicio, fechaFin, fechaEjecucion, elemento_prueba, descripcion, caso_exito, caso_fallo, id_responsable, id_modulo, id_sitio, id_tipo);
            pruebas.add(prueba);            
        }   
   
           return (pruebas);
    
        }
    
    public PruebaDTO getUnaPrueba(PruebaDTO buscado){
    
        BaseDeDatos.conectar();
        //select * from responsable where nombre in ('Jennifer Orejuela')
        String sql="select * from prueba where id_prueba ="+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String vdatos[] = consulta.get(0).split("-");
        String nombre = vdatos[0];
        String fechaInicio[] = vdatos[1].split("/");
        Date fecha_inicio = new Date();
        //este armado debe hacerse en el DTO
        fecha_inicio.setYear(Integer.parseInt(fechaInicio[0]));
        fecha_inicio.setMonth(Integer.parseInt(fechaInicio[1]));
        fecha_inicio.setDate(Integer.parseInt(fechaInicio[2]));
        String fechaFin[] = vdatos[2].split("/");
        Date fecha_fin = new Date(Integer.parseInt(fechaFin[0]), Integer.parseInt(fechaFin[1]), Integer.parseInt(fechaFin[2]));
        String fechaEjecucion[] = vdatos[3].split("/");
        Date fecha_ejecucion = new Date(Integer.parseInt(fechaEjecucion[0]), Integer.parseInt(fechaEjecucion[1]), Integer.parseInt(fechaEjecucion[2]));
        String elemento_prueba = vdatos[4];
        String descripcion = vdatos[5];
        String caso_exito = vdatos[6];
        String caso_fallo = vdatos[7];
        int id_prueba = Integer.parseInt(vdatos[8]);
        int id_tipo = Integer.parseInt(vdatos[9]);
        int id_modulo = Integer.parseInt(vdatos[10]);
        int id_responsable = Integer.parseInt(vdatos[11]);
        int id_sitio = Integer.parseInt(vdatos[12]);
        String numeroRequerimiento = vdatos[13];
        return (new PruebaDTO(id_prueba, nombre, numeroRequerimiento, fecha_inicio, fecha_fin, fecha_ejecucion, elemento_prueba, descripcion, caso_exito, caso_fallo, id_responsable, id_modulo, id_sitio, id_tipo));
    }
    
    public boolean insertar(PruebaDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String sql="insert into prueba values ('@', '€', '§', '«', '#', 'ƒ', 'æ', 'Ø', µ, ¶, ¥, ©, '¤')";
        sql=sql.replaceAll("@", nuevo.getNombre());
        sql=sql.replaceAll("€", df1.format(nuevo.getFecha_inicio()));
        sql=sql.replaceAll("§", df1.format(nuevo.getFecha_fin()));
        sql=sql.replaceAll("«", df1.format(nuevo.getFecha_ejecucion()));
        sql=sql.replaceAll("#", nuevo.getElemento_prueba());
        sql=sql.replaceAll("ƒ", nuevo.getDescripcion());
        sql=sql.replaceAll("æ", nuevo.getCaso_exito());
        sql=sql.replaceAll("Ø", nuevo.getCaso_fallo());
        sql=sql.replaceAll("µ", Integer.toString(nuevo.getTipoPrueba().getIdentificador()));
        sql=sql.replaceAll("¶", Integer.toString(nuevo.getModulo().getIdentificador()));        
        sql=sql.replaceAll("¥", Integer.toString(nuevo.getResponsable().getIdentificador()));
        sql=sql.replaceAll("©", Integer.toString(nuevo.getSitioPrueba().getIdentificador()));
        sql=sql.replaceAll("¤", nuevo.getNumero_requerimiento());
        
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    //Metodo de ejemplo
    public String fechaInicio(){
        BaseDeDatos.conectar();
        String sql = "select fecha_inicio from prueba where id_prueba = 7";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        return (consulta.get(0));
        
    }
    
    public ArrayList<ModoEjecucionDTO> getModosEjecucion(PruebaDTO prueba){
        ArrayList<ModoEjecucionDTO> modos = new ArrayList<>();
        BaseDeDatos.conectar();
        String sql = "select descripcion from modo_ejecucion join prueba_modo_ejecucion ON modo_ejecucion.id_modo = prueba_modo_ejecucion.id_modo and prueba_modo_ejecucion.id_prueba="+prueba.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        BaseDeDatos.desconectar();        
        if(consulta.isEmpty())
            return null;
        for (String descripcion : consulta) {
            ModoEjecucionDTO modo = new ModoEjecucionDTO(descripcion);
            modos.add(modo);
        }
        return (modos);
    }
}
