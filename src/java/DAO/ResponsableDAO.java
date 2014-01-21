/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import DTO.*;
import UTIL.BaseDeDatos;

/**
 *
 * @author Jennifer
 */
public class ResponsableDAO {

    public ResponsableDAO() {
    }
    
    public boolean esValido(String usuario, String contrasena){
        BaseDeDatos.conectar();
        String sql = "select * from responsable where usuario like '"+usuario+"' and contrasena like '"+contrasena+"'";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        return (!consulta.isEmpty());
    }    
    
    public TreeSet<ResponsableDTO> getResponsable(){
        BaseDeDatos.conectar();
        String sql="select * from responsable";
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);
        TreeSet<ResponsableDTO> rta=new TreeSet<ResponsableDTO>();
        BaseDeDatos.desconectar();
        if (!consulta.isEmpty()){
            for(String dato:consulta){
                String dd[]=dato.split("-");
                ResponsableDTO nuevo=new ResponsableDTO(Integer.parseInt(dd[4]), dd[0], dd[1],dd[2],dd[3]);
                rta.add(nuevo);
            }
        }
        return rta;    
    }
    
    
    public ResponsableDTO getUnResponsable(ResponsableDTO buscado){
    
        BaseDeDatos.conectar();
        String sql="select * from responsable where id_responsable ="+buscado.getIdentificador();
        ArrayList<String> consulta=BaseDeDatos.getConsultaSQL(sql);

        BaseDeDatos.desconectar();
        if(consulta.isEmpty())
            return null;
        String dd[]=consulta.get(0).split("-");
        return (new ResponsableDTO(Integer.parseInt(dd[4]), dd[0], dd[1],dd[2],dd[3]));
    }
    
   
    public boolean insertar(ResponsableDTO nuevo){
        //insert into  responsable values('1','marco adarme','madarme','1235')
        String sql="insert into responsable values ('@','#','&','$')";
        sql=sql.replaceAll("@", nuevo.getDocumento());
        sql=sql.replaceAll("#", nuevo.getNombre());
        sql=sql.replaceAll("&", nuevo.getUsuario());
        sql=sql.replaceAll("$", nuevo.getContrasena());
        BaseDeDatos.conectar();
        return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
}
