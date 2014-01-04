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
public class SitioPruebaDAO {

    public SitioPruebaDAO() {
    }
    
    public TreeSet<SitioPruebaDTO> getSitioPrueba(){
        BaseDeDatos.conectar();
        String sql="select * from sitio_prueba";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<SitioPruebaDTO> rta=new TreeSet<>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            SitioPruebaDTO nuevo=new SitioPruebaDTO(Integer.parseInt(dd[2]),dd[0], dd[1]);
            rta.add(nuevo);

        }
        return (rta);    
    }
    
    
    public SitioPruebaDTO getUnSitioPrueba(SitioPruebaDTO buscado){
    
        BaseDeDatos.conectar();
        String sql="select * from sitio_prueba where id_sitio = "+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new SitioPruebaDTO(Integer.parseInt(dd[2]), dd[0], dd[1]));
    }
    
   
    public boolean insertar(SitioPruebaDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into sitio_prueba  values ('@','#')";
        sql=sql.replaceAll("@", nuevo.getNumero_puerto());
        sql=sql.replaceAll("#", nuevo.getNombre());
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean modificar(SitioPruebaDTO nuevo){
        //update responsable set documento = 5, nombre = 'Rosa', usuario = 'user', contrasena = 'contra'
        //where id_responsable = 1
        String sql="update sitio_prueba set numero_puerto = '"+nuevo.getNumero_puerto()+"', nombre = '" +nuevo.getNombre()+"' where id_sitio = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean eliminar(SitioPruebaDTO nuevo){
        //delete from responsable
        //where id_responsable = 1
        String sql="delete from sitio_prueba "+ 
                "where id_sitio = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    } 
}
