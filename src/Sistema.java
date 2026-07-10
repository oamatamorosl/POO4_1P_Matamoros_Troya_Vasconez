import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sistema {

    //  ATRIBUTOS 
    //Variables estáticas

    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Partido> listaPartidos;
    public static ArrayList<Kit> listaKits;
    public static ArrayList<Compra> listaCompras;

    // CONSTRUCTOR 

    public Sistema(ArrayList<Usuario> listaUsuarios, ArrayList<Partido> listaPartidos,
                   ArrayList<Kit> listaKits, ArrayList<Compra> listaCompras) {
        this.listaUsuarios = listaUsuarios;
        this.listaPartidos = listaPartidos;
        this.listaKits = listaKits;
        this.listaCompras = listaCompras;
    }

    //  CARGA DE DATOS 

    public void cargarUsuarios() {

    }

    public void cargarPartidos() {

    }

    public void cargarKits() {

    }

    public void cargarCompras() {

    }

    // SESIÓN Y MENÚ

    // static 
    //INICIAR SESION
       public static void iniciarSesion() {
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("===== INICIO DE SESIÓN =====");
            System.out.print("Usuario: ");
            String usuarioIngresado = scanner.nextLine();
    
            System.out.print("Contraseña: ");
            String contrasenaIngresada = scanner.nextLine();
    
            Usuario usuarioEncontrado = null;
            for (Usuario u : listaUsuarios) {
                if (u.getUsuario().equals(usuarioIngresado) && u.getContrasena().equals(contrasenaIngresada)) {
                    usuarioEncontrado = u;
                    break;
                }
            }
    
            if (usuarioEncontrado == null) {
                System.out.println("Usuario o contraseña incorrectos.");
                return;
            }
    
            System.out.println("Usuario autenticado correctamente.");
    
            if (usuarioEncontrado instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) usuarioEncontrado;
                System.out.println("Rol detectado: AFICIONADO");
                System.out.println("Bienvenido/a, " + aficionado.getNombres() + " " + aficionado.getApellidos());
                System.out.println("Celular registrado: " + aficionado.getCelular());
                System.out.print("¿Este número de celular es correcto? (S/N): ");
                String confirmacion = scanner.nextLine();
                if (confirmacion.equalsIgnoreCase("N")) {
                    System.out.println("Verificación fallida.");
                    System.out.println("Por motivos de seguridad se cerrará la sesión.");
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                System.out.println("Identidad confirmada.");
                mostrarMenu(aficionado);
    
            } else if (usuarioEncontrado instanceof Organizador) {
                Organizador organizador = (Organizador) usuarioEncontrado;
                System.out.println("Rol detectado: ORGANIZADOR");
                System.out.println("Bienvenido/a, " + organizador.getNombres() + " " + organizador.getApellidos());
                System.out.println("Empresa asignada: " + organizador.getEmpresa());
                System.out.print("¿Esta empresa es correcta? (S/N): ");
                String confirmacion = scanner.nextLine();
                if (confirmacion.equalsIgnoreCase("N")) {
                    System.out.println("Verificación fallida.");
                    System.out.println("Por motivos de seguridad se cerrará la sesión.");
                    System.out.println("Saliendo del sistema...");
                    return;
                }
                System.out.println("Identidad confirmada.");
                mostrarMenu(organizador);
            }
    }
//MOSTRAR EL MENU
    public static void mostrarMenu(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        if (usuario instanceof Aficionado) {
            Aficionado aficionado = (Aficionado) usuario;
            int opcion = 0;

            while (opcion != 5) {
                System.out.println("\n===== MENÚ AFICIONADO =====");
                System.out.println("1. Consultar partidos");
                System.out.println("2. Comprar entrada");
                System.out.println("3. Comprar kit de entradas");
                System.out.println("4. Consultar entradas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        aficionado.consultarPartidos();
                        break;
                    case 2:
                        aficionado.comprar(null, null, 0, null);
                        break;
                    case 3:
                        aficionado.comprar(null, null);
                        break;
                    case 4:
                        aficionado.consultarEntradas();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } else if (usuario instanceof Organizador) {
            Organizador organizador = (Organizador) usuario;
            int opcion = 0;

            while (opcion != 3) {
                System.out.println("\n===== MENÚ ORGANIZADOR =====");
                System.out.println("1. Consultar entradas");
                System.out.println("2. Generar reporte");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        organizador.consultarEntradas();
                        break;
                    case 2:
                        organizador.generarReporte();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        }
    }
    // NOTIFICAR (sobrecarga) 
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
        int totalCompras = compras.size();
        int totalEntradas = 0;
        int totalKits = 0;
        double montoTotal = 0;

        for (Compra c : compras) {
            if (c.getTipo() == TipoCompra.ENTRADA) {
                totalEntradas++;
            } else if (c.getTipo() == TipoCompra.KIT) {
                totalKits++;
            }
            montoTotal += c.getValorPagado();
        }

        System.out.println("De: correoSistema");
        System.out.println("Para: " + organizador.getCorreo());
        System.out.println("Asunto: Reporte de compras registradas");
        System.out.println("Estimado/a " + organizador.getNombres() + " " + organizador.getApellidos() + ",");
        System.out.println("Se ha generado el reporte de compras del sistema.");
        System.out.println("Fecha de generación del reporte: " + new Date());
        System.out.println("Total de compras registradas: " + totalCompras);
        System.out.println("Total de compras de entradas individuales: " + totalEntradas);
        System.out.println("Total de compras de kits: " + totalKits);
        System.out.println("Monto total recaudado: $" + montoTotal);
    }

    // GETTERS Y SETTERS 

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

    //  MAIN 
    //Se define el main en esta clase ya que es la principal, desde donde se ejecutará el programa.
    public static void main(String[] args) {

    }
}
