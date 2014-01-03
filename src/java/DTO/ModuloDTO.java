/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class ModuloDTO implements Comparable{
    private int identificador;
    private String nombre;
    private String descripcion;

    public ModuloDTO() {
    }

    public ModuloDTO(int identificador, String nombre, String descripcion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ModuloDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ModuloDTO(int identificador) {
        this.identificador = identificador;
    }
    
    
    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int compareTo(Object o) {
        ModuloDTO x=(ModuloDTO)o;
        return (this.identificador-x.identificador);
    }
    
    @Override
    public String toString() {
        return "Modulo{" + "identificador=" + identificador + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
