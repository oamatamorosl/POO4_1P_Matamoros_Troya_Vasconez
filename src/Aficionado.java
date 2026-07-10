//Aficionado clase hija de Usuario

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

    // Implementación temporal: la lógica real depende de la clase Compra que aún no
    // existe.
    @Override
    public void consultarEntradas() {
        System.out.println("Consultando entradas como aficionado...");
    }

    // temporal

    public void consultarPartidos() {
        System.out.println("Consultando partidos...");
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
