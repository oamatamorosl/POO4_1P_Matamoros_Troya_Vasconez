package com.pooespol.modelo;
import com.pooespol.enums.Rol;
import com.pooespol.enums.TipoCompra;
import com.pooespol.enums.Zona;
import com.pooespol.sistema.Sistema;
import com.pooespol.util.ManejoArchivos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa a un aficionado del Mundial.
 * Hereda de Usuario y permite consultar partidos, comprar
 * entradas individuales y kits de entradas.
 *
 * @author Sebastian Vasconez
 * @version 1.0
 */
public class Aficionado extends Usuario {

    /** Número de celular del aficionado. */
    private String celular;

    /** País favorito del aficionado. */
    private String paisFavorito;

    /**
     * Constructor clase Aficionado.
     *
     * @param codigoUnico código único del aficionado
     * @param cedula cédula del aficionado
     * @param nombres nombres del aficionado
     * @param apellidos apellidos del aficionado
     * @param usuario nombre de usuario para iniciar sesión
     * @param contrasena contraseña del aficionado
     * @param correo correo electrónico del aficionado
     * @param celular número de celular del aficionado
     * @param paisFavorito país favorito del aficionado
     */
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

    /**
     * Muestra las compras realizadas por este aficionado.
     * Sobrescribe el método abstracto de Usuario.
     */
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

    /**
     * Muestra todos los partidos disponibles en el sistema.
     */
    public void consultarPartidos() {
        for (Partido partido : Sistema.listaPartidos){
            System.out.println(partido);
            System.out.println("--------------------");
        }
    }

    /**
     * Compra una entrada para un partido específico.
     * Valida el stock, calcula el total, registra la compra
     * y envía notificación al aficionado.
     *
     * @param partido partido para el que se compra la entrada
     * @param zona zona de la entrada (GENERAL, PREFERENCIAL, VIP)
     * @param cantidad número de entradas a comprar
     * @param tarjeta número de tarjeta para el pago
     */
    public void comprar(Partido partido, Zona zona, int cantidad, String tarjeta) {

        double precio = 0;
        int stock = 0;

            //Obtener precio y stock dependiendo de la zona
            switch (zona) {
                case GENERAL:
                    precio = partido.getPrecioGeneral();
                    stock = partido.getDispGeneral();
                    break;

                case PREFERENCIAL:
                    precio = partido.getPrecioPreferencial();
                    stock =  partido.getDispPreferencial();
                    break;

                 case VIP:
                    precio = partido.getPrecioVIP();
                    stock = partido.getDispVIP();
                 break;
            }


            //Validación y resta de stock + creación de compra

            if (stock >= cantidad){
                double total = precio * cantidad;

                System.out.println("Total a pagar: "+ total);

                System.out.println("Pago procesado exitosamente");

                Compra compra = new Compra(TipoCompra.ENTRADA, partido.getCodigo(), new Date(), cantidad, total, this.getCodigoUnico());

                Sistema.listaCompras.add(compra);


                int valor;

                switch (zona) {
                case GENERAL:
                    valor = partido.getDispGeneral() - cantidad;
                    partido.setDispGeneral(valor);
                    break;

                case PREFERENCIAL:
                    valor = partido.getDispPreferencial() - cantidad;
                    partido.setDispPreferencial(valor);
                    break;

                 case VIP:
                    valor = partido.getDispVIP() - cantidad;
                    partido.setDispVIP(valor);
                 break;
            }


           //Registrar compra entrada
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
            String linea = compra.getCodigo() + "|" + compra.getTipo() + "|" + compra.getCodigoReferencia() + "|" + sdf.format(compra.getFechaCompra()) + "|" + compra.getCantidad() + "|" + compra.getValorPagado() + "|" + compra.getCodigoAficionado();
            ManejoArchivos.EscribirArchivo("compras.txt", linea);


            //Notificación
            Sistema.notificar(this, compra, partido);


            } else{
                System.out.println("No hay suficientes entradas");
            }


    }

    /**
     * Compra un kit de entradas predefinido.
     * Valida disponibilidad, registra la compra
     * y envía notificación al aficionado.
     *
     * @param kit kit de entradas a comprar
     * @param tarjeta número de tarjeta para el pago
     */
    public void comprar(Kit kit, String tarjeta) {

        if (kit.getDisponibles() < 1) {
            System.out.println("No hay kits disponibles");
            return;
        }

        System.out.println("Precio: " + kit.getPrecio());
        System.out.println("Pago procesado exitosamente");

        Compra compra = new Compra(TipoCompra.KIT, kit.getCodigo(), new Date(), 1, kit.getPrecio(), this.getCodigoUnico());
        Sistema.listaCompras.add(compra);

        kit.setDisponibles(kit.getDisponibles() - 1);

        //Notificación
        Sistema.notificar(this, compra, kit);
        

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
        String linea = compra.getCodigo() + "|" + compra.getTipo() + "|" + compra.getCodigoReferencia() + "|" + sdf.format(compra.getFechaCompra()) + "|" + compra.getCantidad() + "|" + compra.getValorPagado() + "|" + compra.getCodigoAficionado();
        //Registrar compra kit
        ManejoArchivos.EscribirArchivo("compras.txt", linea);

    }

    // Getters

    /**
     * Retorna el celular del aficionado.
     *
     * @return celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Retorna el país favorito del aficionado.
     *
     * @return paisFavorito
     */
    public String getPaisFavorito() {
        return paisFavorito;
    }

    // Setters

    /**
     * Establece el celular del aficionado.
     *
     * @param celular número de celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Establece el país favorito del aficionado.
     *
     * @param paisFavorito país favorito
     */
    public void setPaisFavorito(String paisFavorito) {
        this.paisFavorito = paisFavorito;
    }

    /**
     * Retorna una representación en texto del aficionado.
     *
     * @return String con los datos del aficionado
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Datos únicos de Aficionado: {Celular = " + this.celular +
                ", País Favorito = " + this.paisFavorito + "}";

    }

}