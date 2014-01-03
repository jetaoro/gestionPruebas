/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class ResponsableDTO implements Comparable{
   private int identificador; 
   private String documento;
   private String nombre;
   private String usuario;
   private String contrasena;

    public ResponsableDTO() {
    }

    public ResponsableDTO(int identificador, String documento, String nombre, String usuario, String contrasena) {
        this.identificador = identificador;
        this.documento = documento;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public ResponsableDTO(String documento, String nombre, String usuario, String contrasena) {
        this.documento = documento;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public ResponsableDTO(int identificador) {
        this.identificador=identificador;
    }
        
    public int getIdentificador() {
        return identificador;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Responsable{" + "documento=" + documento + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
    @Override
    public int compareTo(Object o) {
        ResponsableDTO x=(ResponsableDTO)o;
        return (this.getNombre().compareTo(x.getNombre()));
    }   
   
}
