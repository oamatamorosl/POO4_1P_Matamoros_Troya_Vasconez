import java.util.Date;

public class Partido {
    private String codigo;
    private String local;
    private String visitante;
    private String estadio;
    private String ciudad;
    private String fase;
    private Date fecha;
    private int capacidad;
    private int dispGeneral;
    private int dispPreferencial;
    private int dispVIP;
    private double precioGeneral;
    private double precioPreferencial;
    private double precioVIP;

    // Constructor
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
    public String getCodigo() { 
        return codigo; 
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }

    public String getLocal() { 
        return local; 
    }
    public void setLocal(String local) { 
        this.local = local; 
    }

    public String getVisitante() { 
        return visitante; 
    }
    public void setVisitante(String visitante) { 
        this.visitante = visitante; 
    }

    public String getEstadio() { 
        return estadio; 
    }
    public void setEstadio(String estadio) { 
        this.estadio = estadio; 
    }

    public String getCiudad() { 
        return ciudad; 
    }
    public void setCiudad(String ciudad) { 
        this.ciudad = ciudad; 
    }

    public String getFase() { 
        return fase; 
    }
    public void setFase(String fase) { 
        this.fase = fase; 
    }

    public Date getFecha() { 
        return fecha; 
    }
    public void setFecha(Date fecha) { 
        this.fecha = fecha; 
    }

    public int getCapacidad() { 
        return capacidad; 
    }
    public void setCapacidad(int capacidad) { 
        this.capacidad = capacidad; 
    }

    public int getDispGeneral() { 
        return dispGeneral; 
    }
    public void setDispGeneral(int dispGeneral) { 
        this.dispGeneral = dispGeneral; 
    }

    public int getDispPreferencial() { 
        return dispPreferencial; 
    }
    public void setDispPreferencial(int dispPreferencial) { 
        this.dispPreferencial = dispPreferencial; 
    }

    public int getDispVIP() { 
        return dispVIP; 
    }
    public void setDispVIP(int dispVIP) { 
        this.dispVIP = dispVIP; 
    }

    public double getPrecioGeneral() { 
        return precioGeneral; 
    }
    public void setPrecioGeneral(double precioGeneral) { 
        this.precioGeneral = precioGeneral; 
    }

    public double getPrecioPreferencial() { 
        return precioPreferencial; 
    }
    public void setPrecioPreferencial(double precioPreferencial) { 
        this.precioPreferencial = precioPreferencial; 
    }

    public double getPrecioVIP() { 
        return precioVIP; 
    }
    public void setPrecioVIP(double precioVIP) { 
        this.precioVIP = precioVIP; 
    }

    // toString
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
