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

    public void notificar(Aficionado aficionado, Compra compra, Partido partido) {
        System.out.println("De: correoSistema");
        System.out.println("Para: " + aficionado.getCorreo());
        System.out.println("Asunto: Compra de entrada realizada");
        System.out.println("Estimado/a " + aficionado.getNombres() + " " + aficionado.getApellidos() + ",");
        System.out.println("Su compra ha sido registrada exitosamente con el código " + compra.getCodigo() + " el día " + compra.getFechaCompra() + ".");
        System.out.println("Partido: " + partido.getLocal() + " vs " + partido.getVisitante());
        System.out.println("Código del partido: " + compra.getCodigoReferencia());
        System.out.println("Cantidad: " + compra.getCantidad());
        System.out.println("Valor pagado: $" + compra.getValorPagado());
        System.out.println("Gracias por adquirir sus entradas para el Mundial. Recuerde conservar el código de compra para futuras consultas.");
    }

public void notificar(Aficionado aficionado, Compra compra, Kit kit) {
        System.out.println("De: correoSistema");
        System.out.println("Para: " + aficionado.getCorreo());
        System.out.println("Asunto: Compra de kit de entradas realizada");
        System.out.println("Estimado/a " + aficionado.getNombres() + " " + aficionado.getApellidos() + ",");
        System.out.println("Su compra ha sido registrada exitosamente con el código " + compra.getCodigo() + " el día " + compra.getFechaCompra() + ".");
        System.out.println("Kit adquirido: " + kit.getNombre());
        System.out.println("Descripción: " + kit.getDescripcion());
        System.out.println("Cantidad: " + compra.getCantidad());
        System.out.println("Valor pagado: $" + compra.getValorPagado());
        System.out.println("Gracias por adquirir su kit para el Mundial. Recuerde conservar el código de compra para futuras consultas.");
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