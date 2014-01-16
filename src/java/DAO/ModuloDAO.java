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
public class ModuloDAO {
    public ModuloDAO() {
    }
    
    
    public TreeSet<ModuloDTO> getModulo(){
        BaseDeDatos.conectar();
        String sql="select * from modulo";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<ModuloDTO> rta=new TreeSet<ModuloDTO>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            ModuloDTO nuevo=new ModuloDTO(Integer.parseInt(dd[2]), dd[0], dd[1]);
            rta.add(nuevo);

        }
        return rta;    
    }
    
    
    public ModuloDTO getUnModulo(ModuloDTO buscado){
    
        BaseDeDatos.conectar();
        String sql="select * from modulo where id_modulo ="+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new ModuloDTO(Integer.parseInt(dd[2]), dd[0], dd[1]));
    }
    
   
    public boolean insertar(ModuloDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into modulo values ('@', '#')";
        sql=sql.replaceAll("@", nuevo.getNombre());
        sql=sql.replaceAll("#", nuevo.getDescripcion());
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean modificar(ModuloDTO nuevo){
        //update responsable set documento = 5, nombre = 'Rosa', usuario = 'user', contrasena = 'contra'
        //where id_responsable = 1
        String sql="update modulo set nombre ='"+nuevo.getNombre()+"', descripcion = '" +nuevo.getDescripcion()+"' where id_modulo = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean eliminar(ModuloDTO nuevo){
        //delete from responsable
        //where id_responsable = 1
        String sql="delete from modulo "+ 
                "where id_modulo = " +nuevo.getIdentificador();
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    } 
}
