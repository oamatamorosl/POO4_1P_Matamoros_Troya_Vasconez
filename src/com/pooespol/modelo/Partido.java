package com.pooespol.modelo;
import java.util.Date;

/**
 * Clase que representa un partido del Mundial.
 * Contiene la información del partido, estadio, ciudad,
 * disponibilidad de entradas por zona y precios.
 *
 * @author Oscar Matamoros
 * @version 1.0
 */
public class Partido {

    /** Código único del partido. */
    private String codigo;

    /** Selección local del partido. */
    private String local;

    /** Selección visitante del partido. */
    private String visitante;

    /** Estadio donde se juega el partido. */
    private String estadio;

    /** Ciudad donde se juega el partido. */
    private String ciudad;

    /** Fase del torneo en la que se juega el partido. */
    private String fase;

    /** Fecha del partido. */
    private Date fecha;

    /** Capacidad total del estadio. */
    private int capacidad;

    /** Entradas disponibles en zona general. */
    private int dispGeneral;

    /** Entradas disponibles en zona preferencial. */
    private int dispPreferencial;

    /** Entradas disponibles en zona VIP. */
    private int dispVIP;

    /** Precio de la entrada en zona general. */
    private double precioGeneral;

    /** Precio de la entrada en zona preferencial. */
    private double precioPreferencial;

    /** Precio de la entrada en zona VIP. */
    private double precioVIP;

    /**
     * Constructor de la clase Partido.
     *
     * @param codigo código único del partido
     * @param local selección local
     * @param visitante selección visitante
     * @param estadio estadio del partido
     * @param ciudad ciudad del partido
     * @param fase fase del torneo
     * @param fecha fecha del partido
     * @param capacidad capacidad total del estadio
     * @param dispGeneral entradas disponibles zona general
     * @param dispPreferencial entradas disponibles zona preferencial
     * @param dispVIP entradas disponibles zona VIP
     * @param precioGeneral precio zona general
     * @param precioPreferencial precio zona preferencial
     * @param precioVIP precio zona VIP
     */
    public Partido(String codigo, String local, String visitante, String estadio, String ciudad, String fase, Date fecha, int capacidad, int dispGeneral, int dispPreferencial, int dispVIP, double precioGeneral, double precioPreferencial, double precioVIP) {
        this.codigo = codigo;
        this.local = local;
        this.visitante = visitante;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.fase = fase;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.dispGeneral = dispGeneral;
        this.dispPreferencial = dispPreferencial;
        this.dispVIP = dispVIP;
        this.precioGeneral = precioGeneral;
        this.precioPreferencial = precioPreferencial;
        this.precioVIP = precioVIP;
    }

    // Getters y setters

    /**
     * Retorna el código del partido.
     *
     * @return código
     */
    public String getCodigo() { 
        return codigo; 
    }

    /**
     * Establece el código del partido.
     *
     * @param codigo código del partido
     */
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }

    /**
     * Retorna la selección local.
     *
     * @return local
     */
    public String getLocal() { 
        return local; 
    }

    /**
     * Establece la selección local.
     *
     * @param local selección local
     */
    public void setLocal(String local) { 
        this.local = local; 
    }

    /**
     * Retorna la selección visitante.
     *
     * @return visitante
     */
    public String getVisitante() { 
        return visitante; 
    }

    /**
     * Establece la selección visitante.
     *
     * @param visitante selección visitante
     */
    public void setVisitante(String visitante) { 
        this.visitante = visitante; 
    }

    /**
     * Retorna el estadio del partido.
     *
     * @return estadio
     */
    public String getEstadio() { 
        return estadio; 
    }

    /**
     * Establece el estadio del partido.
     *
     * @param estadio estadio del partido
     */
    public void setEstadio(String estadio) { 
        this.estadio = estadio; 
    }

    /**
     * Retorna la ciudad del partido.
     *
     * @return ciudad
     */
    public String getCiudad() { 
        return ciudad; 
    }

    /**
     * Establece la ciudad del partido.
     *
     * @param ciudad ciudad del partido
     */
    public void setCiudad(String ciudad) { 
        this.ciudad = ciudad; 
    }

    /**
     * Retorna la fase del torneo.
     *
     * @return fase
     */
    public String getFase() { 
        return fase; 
    }

    /**
     * Establece la fase del torneo.
     *
     * @param fase fase del torneo
     */
    public void setFase(String fase) { 
        this.fase = fase; 
    }

    /**
     * Retorna la fecha del partido.
     *
     * @return fecha
     */
    public Date getFecha() { 
        return fecha; 
    }

    /**
     * Establece la fecha del partido.
     *
     * @param fecha fecha del partido
     */
    public void setFecha(Date fecha) { 
        this.fecha = fecha; 
    }

    /**
     * Retorna la capacidad total del estadio.
     *
     * @return capacidad
     */
    public int getCapacidad() { 
        return capacidad; 
    }

    /**
     * Establece la capacidad total del estadio.
     *
     * @param capacidad capacidad del estadio
     */
    public void setCapacidad(int capacidad) { 
        this.capacidad = capacidad; 
    }

    /**
     * Retorna las entradas disponibles en zona general.
     *
     * @return dispGeneral
     */
    public int getDispGeneral() { 
        return dispGeneral; 
    }

    /**
     * Establece las entradas disponibles en zona general.
     *
     * @param dispGeneral entradas disponibles zona general
     */
    public void setDispGeneral(int dispGeneral) { 
        this.dispGeneral = dispGeneral; 
    }

    /**
     * Retorna las entradas disponibles en zona preferencial.
     *
     * @return dispPreferencial
     */
    public int getDispPreferencial() { 
        return dispPreferencial; 
    }

    /**
     * Establece las entradas disponibles en zona preferencial.
     *
     * @param dispPreferencial entradas disponibles zona preferencial
     */
    public void setDispPreferencial(int dispPreferencial) { 
        this.dispPreferencial = dispPreferencial; 
    }

    /**
     * Retorna las entradas disponibles en zona VIP.
     *
     * @return dispVIP
     */
    public int getDispVIP() { 
        return dispVIP; 
    }

    /**
     * Establece las entradas disponibles en zona VIP.
     *
     * @param dispVIP entradas disponibles zona VIP
     */
    public void setDispVIP(int dispVIP) { 
        this.dispVIP = dispVIP; 
    }

    /**
     * Retorna el precio de la zona general.
     *
     * @return precioGeneral
     */
    public double getPrecioGeneral() { 
        return precioGeneral; 
    }

    /**
     * Establece el precio de la zona general.
     *
     * @param precioGeneral precio zona general
     */
    public void setPrecioGeneral(double precioGeneral) { 
        this.precioGeneral = precioGeneral; 
    }

    /**
     * Retorna el precio de la zona preferencial.
     *
     * @return precioPreferencial
     */
    public double getPrecioPreferencial() { 
        return precioPreferencial; 
    }

    /**
     * Establece el precio de la zona preferencial.
     *
     * @param precioPreferencial precio zona preferencial
     */
    public void setPrecioPreferencial(double precioPreferencial) { 
        this.precioPreferencial = precioPreferencial; 
    }

    /**
     * Retorna el precio de la zona VIP.
     *
     * @return precioVIP
     */
    public double getPrecioVIP() { 
        return precioVIP; 
    }

    /**
     * Establece el precio de la zona VIP.
     *
     * @param precioVIP precio zona VIP
     */
    public void setPrecioVIP(double precioVIP) { 
        this.precioVIP = precioVIP; 
    }

    /**
     * Retorna una representación en texto del partido.
     *
     * @return String con los datos del partido
     */
    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nPartido: " + local + " vs " + visitante +
               "\nFecha: " + fecha +
               "\nEstadio: " + estadio +
               "\nCiudad: " + ciudad +
               "\nFase: " + fase +
               "\nZonas disponibles:" +
               "\n- GENERAL      | Disponibles: " + dispGeneral + " | Precio: $" + precioGeneral +
               "\n- PREFERENCIAL | Disponibles: " + dispPreferencial + " | Precio: $" + precioPreferencial +
               "\n- VIP          | Disponibles: " + dispVIP + " | Precio: $" + precioVIP;
    }
}