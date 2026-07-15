package com.pooespol.modelo;
import java.util.Date;

import com.pooespol.enums.TipoCompra;

/**
 * Clase que representa una compra realizada por un aficionado.
 * Puede ser de tipo ENTRADA o KIT. El código se genera
 * automáticamente usando un contador estático.
 *
 * @author Aidan Troya
 * @version 1.0
 */
public class Compra {

    /** Contador estático para generar códigos únicos de compra. */
    private static int contador = 0;

    /** Código único de la compra. */
    private String codigo;

    /** Tipo de compra: ENTRADA o KIT. */
    private TipoCompra tipo;

    /** Código de referencia del partido o kit comprado. */
    private String codigoReferencia;

    /** Fecha en que se realizó la compra. */
    private Date fechaCompra;

    /** Cantidad de entradas o kits comprados. */
    private int cantidad;

    /** Valor total pagado por la compra. */
    private double valorPagado;

    /** Código del aficionado que realizó la compra. */
    private String codigoAficionado;

    /**
     * Constructor de la clase Compra.
     * El código se genera automáticamente con el contador estático.
     *
     * @param tipo tipo de compra (ENTRADA o KIT)
     * @param codigoReferencia código del partido o kit comprado
     * @param fechaCompra fecha de la compra
     * @param cantidad cantidad de entradas o kits
     * @param valorPagado valor total pagado
     * @param codigoAficionado código del aficionado que compra
     */
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

    /**
     * Retorna una representación en texto de la compra.
     *
     * @return String con los datos de la compra
     */
    @Override
    public String toString() {
        return "Código: " + codigo +
            "\n Tipo: " + tipo +
            "\nCódigo  referencia: " + codigoReferencia +
            "\nFeCha  de compra: " + fechaCompra +
            "\nCantidad: " + cantidad +
            "\nValor pagado: " + valorPagado +
            "\nCódigo  aficionado: " + codigoAficionado;
    }

    /**
     * Retorna el código de la compra.
     *
     * @return código de la compra
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la compra.
     *
     * @param codigo código de la compra
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el tipo de compra.
     *
     * @return tipo de compra
     */
    public TipoCompra getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de compra.
     *
     * @param tipo tipo de compra
     */
    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el código de referencia del partido o kit.
     *
     * @return código de referencia
     */
    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    /**
     * Establece el código de referencia del partido o kit.
     *
     * @param codigoReferencia código de referencia
     */
    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    /**
     * Retorna la fecha de la compra.
     *
     * @return fecha de compra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha de la compra.
     *
     * @param fechaCompra fecha de la compra
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Retorna la cantidad de entradas o kits comprados.
     *
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de entradas o kits comprados.
     *
     * @param cantidad cantidad comprada
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retorna el valor total pagado.
     *
     * @return valor pagado
     */
    public double getValorPagado() {
        return valorPagado;
    }

    /**
     * Establece el valor total pagado.
     *
     * @param valorPagado valor pagado
     */
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    /**
     * Retorna el código del aficionado que realizó la compra.
     *
     * @return código del aficionado
     */
    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    /**
     * Establece el código del aficionado que realizó la compra.
     *
     * @param codigoAficionado código del aficionado
     */
    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
    }

    /**
     * Retorna el valor actual del contador estático.
     *
     * @return contador de compras
     */
    public static int getContador() {
        return contador;
    }
}