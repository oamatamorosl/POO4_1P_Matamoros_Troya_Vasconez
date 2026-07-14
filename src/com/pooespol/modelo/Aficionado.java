package com.pooespol.modelo;
//Aficionado clase hija de Usuario

import com.pooespol.enums.Rol;
import com.pooespol.enums.Zona;
import com.pooespol.sistema.Sistema;

public class Aficionado extends Usuario {
    private String celular;
    private String paisFavorito;

    // Constructor clase Aficionado
    public Aficionado(String codigoUnico, String cedula, String nombres,
            String apellidos, String usuario, String contrasena,
            String correo, String celular, String paisFavorito) {

        // LLamando a constructor de clase padre
        super(codigoUnico, cedula, nombres,
                apellidos, usuario, contrasena,
                correo);

        // Asignación de atributos propios de Aficionado
        this.celular = celular;
        this.paisFavorito = paisFavorito;
        this.rol = Rol.A; // El rol de aficionado siempre es A
    }

    
    @Override
    public void consultarEntradas() {
        
        boolean bandera = false;

        for (Compra compra : Sistema.listaCompras){
            if (compra.getCodigoAficionado().equals(this.getCodigoUnico())){
                bandera = true;
                System.out.println(compra);
            }
        }

        if (bandera == false){
            System.out.println("No tienes compras registradas");  
        }

    }

    public void consultarPartidos() {
        for (Partido partido : Sistema.listaPartidos){
            System.out.println(partido);
            System.out.println("--------------------");
        }

    }

    public void comprar(Partido partido, Zona zona, int cantidad, String tarjeta) {
        System.out.println("Comprando entrada...");
    }

    public void comprar(Kit kit, String tarjeta) {
        System.out.println("Comprando kit...");
    }
    // Getters

    public String getCelular() {
        return celular;
    }

    public String getPaisFavorito() {
        return paisFavorito;
    }

    // Setters

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setPaisFavorito(String paisFavorito) {
        this.paisFavorito = paisFavorito;
    }

    // Sobrescritura de toString() con super.toString()

    @Override
    public String toString() {
        return super.toString() +
                ", Datos únicos de Aficionado: {Celular = " + this.celular +
                ", País Favorito = " + this.paisFavorito + "}";

    }

}
