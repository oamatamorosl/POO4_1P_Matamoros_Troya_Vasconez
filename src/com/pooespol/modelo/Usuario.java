package com.pooespol.modelo;
import com.pooespol.enums.Rol;

/**
 * Clase abstracta que representa a un usuario del sistema de venta de entradas
 * para el Mundial. Es la clase padre de Aficionado y Organizador.
 *
 * @author Aidan Troya
 * @author Sebastian Vasconez
 * @version 1.0
 */
public abstract class Usuario {

    /** Código único del usuario. */
    protected String codigoUnico;

    /** Cédula del usuario. */
    protected String cedula;

    /** Nombres del usuario. */
    protected String nombres;

    /** Apellidos del usuario. */
    protected String apellidos;

    /** Nombre de usuario para iniciar sesión. */
    protected String usuario;

    /** Contraseña del usuario. */
    protected String contrasena;

    /** Correo electrónico del usuario. */
    protected String correo;

    /** Rol del usuario en el sistema. */
    protected Rol rol;

    /**
     * Constructor de la clase Usuario.
     *
     * @param codigoUnico código único del usuario
     * @param cedula cédula del usuario
     * @param nombres nombres del usuario
     * @param apellidos apellidos del usuario
     * @param usuario nombre de usuario para iniciar sesión
     * @param contrasena contraseña del usuario
     * @param correo correo electrónico del usuario
     */
    public Usuario(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo) {
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    /**
     * Método abstracto para consultar las entradas del usuario.
     * Implementado de forma diferente en Aficionado y Organizador.
     */
    public abstract void consultarEntradas();

    /**
     * Retorna una representación en texto del usuario.
     *
     * @return String con los datos del usuario
     */
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

    /**
     * Retorna el código único del usuario.
     *
     * @return código único
     */
    public String getCodigoUnico() {
        return codigoUnico;
    }

    /**
     * Establece el código único del usuario.
     *
     * @param codigoUnico código único
     */
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    /**
     * Retorna la cédula del usuario.
     *
     * @return cédula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del usuario.
     *
     * @param cedula cédula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Retorna los nombres del usuario.
     *
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     *
     * @param nombres nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Retorna los apellidos del usuario.
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Retorna el nombre de usuario.
     *
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna la contraseña del usuario.
     *
     * @return contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena contraseña
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Retorna el correo electrónico del usuario.
     *
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo correo electrónico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Retorna el rol del usuario.
     *
     * @return rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol rol del usuario
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

}