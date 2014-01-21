/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.*;
import UTIL.BaseDeDatos;

/**
 *
 * @author Jennifer
 */
public class ModoEjecucionDAO {
    public ModoEjecucionDAO() {
    }
    
    
    public TreeSet<ModoEjecucionDTO> getModoEjecucion(){
        BaseDeDatos.conectar();
        String sql="select * from modo_ejecucion";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<ModoEjecucionDTO> rta=new TreeSet<ModoEjecucionDTO>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            ModoEjecucionDTO nuevo=new ModoEjecucionDTO(Integer.parseInt(dd[1]), dd[0]);
            rta.add(nuevo);

        }
        return rta;    
    }
    
    
    public ModoEjecucionDTO getUnModoEjecucion(ModoEjecucionDTO buscado){
    
        BaseDeDatos.conectar();
        //select * from responsable where nombre in ('Jennifer Orejuela')
        String sql="select * from modo_ejecucion where id_modo = "+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new ModoEjecucionDTO(Integer.parseInt(dd[1]), dd[0]));
    }
    
   
    public boolean insertar(ModoEjecucionDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into modo_ejecucion values ('@')";
        sql=sql.replaceAll("@", nuevo.getDescripcion());
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public boolean eliminarModosUnaPrueba(int idPrueba){
        //delete from responsable where id_responsable = 1
        String sql="delete from prueba_modo_ejecucion where id_prueba = " +idPrueba;
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
}
