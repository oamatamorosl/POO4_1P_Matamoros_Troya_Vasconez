public class Partido {

    private String codigo;
    private String local;
    private String visitante;
    private String estadio;
    private String ciudad;
    private String  fase;

    //Constructor

     public Partido(String codigo, String local, String visitante, String estadio, String ciudad, String fase) {
        this.codigo = codigo;
        this.local =  local ;
        this.visitante = visitante;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.fase =    fase;
    }

    //Getters y setters
    public String getCodigo() { 
        return  codigo; 
    }


    public void setCodigo(String codigo) { 
        this.codigo = codigo ; 
    }


    public String getLocal() { 
        return local; 
    }


    public void setLocal(String local) { 
        this.local =  local ; 
    }

    public String getVisitante() { 
        return visitante; 
    }


    public void setVisitante(String visitante) {
         this.visitante =  visitante ; 
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
        this.ciudad =  ciudad; 
    }

    public String getFase() { 
        return  fase; 
    }
    
    public void setFase(String fase) { 
        this.fase = fase; 
    }
}


