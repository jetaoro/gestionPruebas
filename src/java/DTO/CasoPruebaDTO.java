/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Jennifer
 */
public class CasoPruebaDTO implements Comparable{
    private int identificador;
    private String descripcion;
    private String datos_entrada;
    private String resultado_esperado;
    private String resultado_obtenido;
    private String tipo_resultado;
    private String observacion;

    public CasoPruebaDTO() {
    }

    public CasoPruebaDTO(int identificador, String descripcion, String datos_entrada, String resultado_esperado, String resultado_obtenido, String tipo_resultado, String observacion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.datos_entrada = datos_entrada;
        this.resultado_esperado = resultado_esperado;
        this.resultado_obtenido = resultado_obtenido;
        this.tipo_resultado = tipo_resultado;
        this.observacion = observacion;
    }

    public CasoPruebaDTO(String descripcion, String datos_entrada, String resultado_esperado, String resultado_obtenido, String tipo_resultado, String observacion) {
        this.descripcion = descripcion;
        this.datos_entrada = datos_entrada;
        this.resultado_esperado = resultado_esperado;
        this.resultado_obtenido = resultado_obtenido;
        this.tipo_resultado = tipo_resultado;
        this.observacion = observacion;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDatos_entrada() {
        return datos_entrada;
    }

    public String getResultado_esperado() {
        return resultado_esperado;
    }

    public String getResultado_obtenido() {
        return resultado_obtenido;
    }

    public String getTipo_resultado() {
        return tipo_resultado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDatos_entrada(String datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public void setResultado_esperado(String resultado_esperado) {
        this.resultado_esperado = resultado_esperado;
    }

    public void setResultado_obtenido(String resultado_obtenido) {
        this.resultado_obtenido = resultado_obtenido;
    }

    public void setTipo_resultado(String tipo_resultado) {
        this.tipo_resultado = tipo_resultado;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "CasoPrueba{" + "identificador=" + identificador + ", descripcion=" + descripcion + ", datos_entrada=" + datos_entrada + ", resultado_esperado=" + resultado_esperado + ", resultado_obtenido=" + resultado_obtenido + ", tipo_resultado=" + tipo_resultado + ", observacion=" + observacion + '}';
    }
    
    @Override
    public int compareTo(Object o) {
        CasoPruebaDTO x=(CasoPruebaDTO)o;
        return (this.identificador-x.identificador);
    }
    
}
