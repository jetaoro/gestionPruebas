/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class SitioPruebaDTO implements Comparable{
    private int identificador;    
    private String numero_puerto;
    private String nombre;

    public SitioPruebaDTO() {
    }

    public SitioPruebaDTO(int identificador, String numero_puerto, String nombre) {
        this.identificador = identificador;
        this.numero_puerto = numero_puerto;
        this.nombre = nombre;
    }

    public SitioPruebaDTO(String numero_puerto, String nombre) {
        this.numero_puerto = numero_puerto;
        this.nombre = nombre;
    }

    public SitioPruebaDTO(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }
    
    public String getNumero_puerto() {
        return numero_puerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumero_puerto(String numero_puerto) {
        this.numero_puerto = numero_puerto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    @Override
    public int compareTo(Object o) {
        SitioPruebaDTO x=(SitioPruebaDTO)o;
        return (this.identificador-x.identificador);
    }

    @Override
    public String toString() {
        return "SitioPrueba{" + "identificador=" + identificador + ", numero_puerto=" + numero_puerto + ", nombre=" + nombre + '}';
    }
    
}
