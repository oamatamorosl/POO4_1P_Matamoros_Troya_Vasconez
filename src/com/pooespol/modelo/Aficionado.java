package com.pooespol.modelo;
import com.pooespol.enums.Rol;
import com.pooespol.enums.TipoCompra;
import com.pooespol.enums.Zona;
import com.pooespol.sistema.Sistema;
import com.pooespol.util.ManejoArchivos;
import java.util.Date;
import java.util.Scanner;

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

//Método consultarEntradas()  
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

// Método consultarPartidos()

    public void consultarPartidos() {
        for (Partido partido : Sistema.listaPartidos){
            System.out.println(partido);
            System.out.println("--------------------");
        }
    }

 // Método comprar() para Entrada
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
            String linea = compra.getCodigo() + "|" + compra.getTipo() + "|" + compra.getCodigoReferencia() + "|" + compra.getFechaCompra() + "|" + compra.getCantidad() + "|" + compra.getValorPagado() + "|" + compra.getCodigoAficionado();

            ManejoArchivos.EscribirArchivo("compras.txt", linea);   


            //Notificación
            Sistema.notificar(this, compra, partido);


            } else{
                System.out.println("No hay suficientes entradas");
            }
     
        
    }

// Método comprar() para Kit
    public void comprar(String tarjeta) {

        System.out.println("===== KITS DISPONIBLES =====");

        //Mostrar kits
        for(Kit k : Sistema.listaKits){
            System.out.println(k);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el código del kit: ");
        String codigo = sc.nextLine();

        
        
        Kit kitElegido = null;


        for (Kit k: Sistema.listaKits){
            if(k.getCodigo().equals(codigo)){
                kitElegido = k;
            }
        }




        if (kitElegido == null){
            System.out.println("Código de kit inválido");
        
        }else{
            
            if (kitElegido.getDisponibles() >= 1){

                
                System.out.println("Precio: " + kitElegido.getPrecio());
                System.out.println("Pago procesado exitosamente");

                Compra compra = new Compra(TipoCompra.KIT, kitElegido.getCodigo(), new Date(), 1, kitElegido.getPrecio(), this.getCodigoUnico());
                Sistema.listaCompras.add(compra);

                kitElegido.setDisponibles(kitElegido.getDisponibles() - 1);


                //Notifiación
                Sistema.notificar(this, compra, kitElegido);

                //Registrar compra kit
                String linea = compra.getCodigo() + "|" + compra.getTipo() + "|" + compra.getCodigoReferencia() + "|" + compra.getFechaCompra() + "|" + compra.getCantidad() + "|" + compra.getValorPagado() + "|" + compra.getCodigoAficionado();
                ManejoArchivos.EscribirArchivo("compras.txt", linea);


            }else{
                System.out.println("No hay kits disponibles");
            }

        }
        
    
        
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
