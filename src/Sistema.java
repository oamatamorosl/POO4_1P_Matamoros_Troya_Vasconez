import java.util.ArrayList;

public class Sistema {

    // ===================== ATRIBUTOS =====================
    //Variables estáticas

    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Partido> listaPartidos;
    public static ArrayList<Kit> listaKits;
    public static ArrayList<Compra> listaCompras;

    // ===================== CONSTRUCTOR =====================

    public Sistema(ArrayList<Usuario> listaUsuarios, ArrayList<Partido> listaPartidos,
                   ArrayList<Kit> listaKits, ArrayList<Compra> listaCompras) {
        this.listaUsuarios = listaUsuarios;
        this.listaPartidos = listaPartidos;
        this.listaKits = listaKits;
        this.listaCompras = listaCompras;
    }

    // ===================== CARGA DE DATOS =====================

    public void cargarUsuarios() {

    }

    public void cargarPartidos() {

    }

    public void cargarKits() {

    }

    public void cargarCompras() {

    }

    // ===================== SESIÓN Y MENÚ =====================

    // static 
    public static void iniciarSesion() {

    }

    public void mostrarMenu(Usuario usuario) {

    }

    // ===================== NOTIFICAR (sobrecarga) =====================
    //Se sobrecarga el método con atributos de diferentes tipos.

    public void notificar(Aficionado aficionado, Compra compra) {

    }

    public void notificar(Aficionado aficionado, Compra compra, Kit kit) {

    }

    public void notificar(Organizador organizador, ArrayList<Compra> compras) {

    }

    // ===================== GETTERS Y SETTERS =====================

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public ArrayList<Kit> getListaKits() {
        return listaKits;
    }

    public void setListaKits(ArrayList<Kit> listaKits) {
        this.listaKits = listaKits;
    }

    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    // ===================== MAIN =====================
    //Se define el main en esta clase ya que es la principal, desde donde se ejecutará el programa.
    public static void main(String[] args) {

    }
}