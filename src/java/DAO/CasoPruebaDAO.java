/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.*;
import ufps.util.BaseDeDatos;

/**
 *
 * @author Jennifer
 */
public class CasoPruebaDAO {
    public CasoPruebaDAO() {
    }
    
    
    public ArrayList<CasoPruebaDTO> getCasoPrueba(){
        BaseDeDatos.conectar();
        String sql="select * from caso_prueba";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        ArrayList<CasoPruebaDTO> rta=new ArrayList<>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            //String descripcion, String datos_entrada, String resultado_esperado, String resultado_obtenido, String tipo_resultado, String observacion
            CasoPruebaDTO nuevo=new CasoPruebaDTO(dd[0], dd[1], dd[2], dd[3], dd[4], dd[5]);
            rta.add(nuevo);

        }
        return rta;    
    }
    
    
    public CasoPruebaDTO getUnCasoPrueba(CasoPruebaDTO buscado){
    
        BaseDeDatos.conectar();
        String sql="select * from caso_prueba where id_caso="+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new CasoPruebaDTO(dd[0], dd[1], dd[2], dd[3], dd[4], dd[5]));
    }
    
    public TreeSet<CasoPruebaDTO> getCasosPruebaDeUnaPrueba(PruebaDTO buscada){
        BaseDeDatos.conectar();
        String sql="select * from caso_prueba where id_prueba = " + buscada.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<CasoPruebaDTO> rta=new TreeSet<>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            //String descripcion, String datos_entrada, String resultado_esperado, String resultado_obtenido, String tipo_resultado, String observacion
            CasoPruebaDTO nuevo=new CasoPruebaDTO(dd[0], dd[1], dd[2], dd[3], dd[4], dd[5]);
            rta.add(nuevo);

        }
        return rta;
    }
    
   
    public boolean insertar(CasoPruebaDTO nuevo, int idPrueba){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into caso_prueba values ('@', '#', '$', '&', '~', '£', ¥)";
        sql=sql.replaceAll("@", nuevo.getDescripcion());
        sql=sql.replaceAll("#", nuevo.getDatos_entrada());
        sql=sql.replaceAll("$", nuevo.getResultado_esperado());
        sql=sql.replaceAll("&", nuevo.getResultado_obtenido());
        sql=sql.replaceAll("~", nuevo.getTipo_resultado());
        sql=sql.replaceAll("£", nuevo.getObservacion());
        sql=sql.replaceAll("¥", Integer.toString(idPrueba));
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean modificar(CasoPruebaDTO nuevo){
        //update responsable set documento = 5, nombre = 'Rosa', usuario = 'user', contrasena = 'contra'
        //where id_responsable = 1
        String sql="update caso_prueba set descripcion ='"+nuevo.getDescripcion()+"', datos_entrada = '" +nuevo.getDatos_entrada()+
                "', resultado_esperado = '" +nuevo.getResultado_esperado()+"', resultado_obtenido = '" +nuevo.getResultado_obtenido()+
                "', tipo_resultado = '" +nuevo.getTipo_resultado() + "', observacion = '" +nuevo.getObservacion() +
                "' where id_caso = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean eliminar(CasoPruebaDTO nuevo){
        //delete from responsable
        //where id_responsable = 1
        String sql="delete from caso_prueba"+ 
                "where id_caso = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }    
    
}
