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
public class TipoPruebaDAO {

    public TipoPruebaDAO() {
    }
    
    
    public TreeSet<TipoPruebaDTO> getTipoPrueba(){
        BaseDeDatos.conectar();
        String sql="select * from tipo_prueba";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<TipoPruebaDTO> rta=new TreeSet<>();
        BaseDeDatos.desconectar();
        for(String dato:consulta)
        {
            String dd[]=dato.split("-");
            TipoPruebaDTO nuevo=new TipoPruebaDTO(Integer.parseInt(dd[1]), dd[0]);
            rta.add(nuevo);

        }
        return rta;    
    }
    
    
    public TipoPruebaDTO getUnTipoPrueba(TipoPruebaDTO buscado){
    
        BaseDeDatos.conectar();
        //select * from responsable where nombre in ('Jennifer Orejuela')
        String sql="select * from tipo_prueba where id_tipo ="+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new TipoPruebaDTO(Integer.parseInt(dd[1]), dd[0]));
    }
    
   
    public boolean insertar(TipoPruebaDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into tipo_prueba values ('@')";
        sql=sql.replaceAll("@", nuevo.getDescripcion());
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
}
