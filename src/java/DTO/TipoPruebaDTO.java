/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class TipoPruebaDTO implements Comparable{
    private int identificador;
    private String descripcion;

    public TipoPruebaDTO() {
    }

    public TipoPruebaDTO(int identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }

    public TipoPruebaDTO(int identificador) {
        this.identificador = identificador;
    }

    public TipoPruebaDTO(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoPrueba{" + "identificador=" + identificador + ", descripcion=" + descripcion + '}';
    }
    
     @Override
    public int compareTo(Object o) {
        TipoPruebaDTO x=(TipoPruebaDTO)o;
        return (this.getDescripcion().compareTo(x.getDescripcion()));
    }
}
