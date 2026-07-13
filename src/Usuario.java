public abstract class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasena;
    protected String correo;
    protected Rol rol;

    public Usuario(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo) {
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public void consultarEntradas();

    @Override
    public String toString() {
        return "Usuario : {" +
                "  CodigoUnico = " + codigoUnico +
                ", Cedula = " + cedula +
                ", Nombres = " + nombres +
                ", Apellidos = " + apellidos +
                ", Usuario = " + usuario +
                ", Correo = " + correo +
                ", Rol = " + rol +
                " }";
    }

    //Getters y Setters

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
