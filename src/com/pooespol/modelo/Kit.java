package com.pooespol.modelo;
import java.util.ArrayList;

/**
 * Clase que representa un kit o paquete de entradas para el Mundial.
 * Contiene varios partidos incluidos, precio y disponibilidad.
 *
 * @author Aidan Troya
 * @version 1.0
 */
public class Kit {

    /** Código único del kit. */
    private String codigo;

    /** Nombre del kit. */
    private String nombre;

    /** Descripción del kit. */
    private String descripcion;

    /** Lista de partidos incluidos en el kit. */
    private ArrayList<Partido> partidos;

    /** Precio del kit. */
    private double precio;

    /** Cantidad de kits disponibles. */
    private int disponibles;

    /**
     * Constructor de la clase Kit.
     *
     * @param codigo código único del kit
     * @param nombre nombre del kit
     * @param descripcion descripción del kit
     * @param partidos lista de partidos incluidos
     * @param precio precio del kit
     * @param disponibles cantidad disponible
     */
    public Kit(String codigo, String nombre, String descripcion,
               ArrayList<Partido> partidos, double precio, int disponibles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.partidos = partidos;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    /**
     * Retorna una representación en texto del kit
     * incluyendo los partidos que contiene.
     *
     * @return String con los datos del kit
     */
    @Override
    public String toString() {
        String elresultado = "Código: " + codigo +
            "\nNombre : " + nombre +
            "\nDeSscripción : " + descripcion +
            "\nPrecio: " + precio +
            "\nDisponible : " + disponibles +
            "\nPartidos incluidos :";
        for (Partido p : partidos) {
            elresultado += "\n  - " + p.getLocal() + " vs " + p.getVisitante();
        }
        return elresultado;
    }

    /**
     * Retorna el código del kit.
     *
     * @return código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del kit.
     *
     * @param codigo código del kit
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del kit.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del kit.
     *
     * @param nombre nombre del kit
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la descripción del kit.
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del kit.
     *
     * @param descripcion descripción del kit
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna la lista de partidos incluidos en el kit.
     *
     * @return lista de partidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Establece la lista de partidos del kit.
     *
     * @param partidos lista de partidos
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    /**
     * Retorna el precio del kit.
     *
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del kit.
     *
     * @param precio precio del kit
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Retorna la cantidad de kits disponibles.
     *
     * @return disponibles
     */
    public int getDisponibles() {
        return disponibles;
    }

    /**
     * Establece la cantidad de kits disponibles.
     *
     * @param disponibles cantidad disponible
     */
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
}