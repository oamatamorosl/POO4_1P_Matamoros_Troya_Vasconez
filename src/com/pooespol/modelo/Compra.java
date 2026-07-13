package com.pooespol.modelo;
import java.util.Date;

import com.pooespol.enums.TipoCompra;

public class Compra {

    // ===================== ATRIBUTOS =====================
    // Todos privados (encapsulamiento): solo accesibles mediante getters/setters.
    private static int contador = 0;

    private String codigo;
    private TipoCompra tipo;
    private String codigoReferencia;
    private Date fechaCompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;

    // ===================== CONSTRUCTOR =====================
    // El código se genera aquí mismo usando el contador estático,
    // en vez de recibirse como parámetro.

    public Compra(TipoCompra tipo, String codigoReferencia, Date fechaCompra,
                  int cantidad, double valorPagado, String codigoAficionado) {
        contador++;
        this.codigo = "C" + String.format("%03d", contador);
        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
    }

    // ===================== MÉTODOS =====================
    // Se comenta el método toString() hasta que se establezca lo que se desea imprimir.

    //@Override
    //public String toString() {
    //    return;
    //}

    // ===================== GETTERS Y SETTERS =====================

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
    }

    public static int getContador() {
        return contador;
    }
}