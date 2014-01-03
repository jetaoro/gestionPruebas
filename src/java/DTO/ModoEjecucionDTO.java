/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class ModoEjecucionDTO implements Comparable{
    private int identificador;
    private String descripcion;

    public ModoEjecucionDTO() {
    }

    public ModoEjecucionDTO(int identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }

    public ModoEjecucionDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public ModoEjecucionDTO(int identificador) {
        this.identificador = identificador;
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
        return this.descripcion;
    }
    
    @Override
    public int compareTo(Object o) {
        ModoEjecucionDTO x=(ModoEjecucionDTO)o;
        return (this.getDescripcion().compareTo(x.getDescripcion()));
    }
}
