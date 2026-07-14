package com.pooespol.sistema;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.pooespol.enums.TipoCompra;
import com.pooespol.modelo.Aficionado;
import com.pooespol.modelo.Compra;
import com.pooespol.modelo.Kit;
import com.pooespol.modelo.Organizador;
import com.pooespol.modelo.Partido;
import com.pooespol.modelo.Usuario;
import com.pooespol.util.ManejoArchivos;

import java.text.SimpleDateFormat;

//todo lo necesario para lo del Mundial
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;


public class Sistema {

    // ===================== ATRIBUTOS =====================
    // public y static
    
    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Partido> listaPartidos;
    public static ArrayList<Kit> listaKits;
    public static ArrayList<Compra> listaCompras;
    private static final String CORREO_SISTEMA = "oamatamorosuni@gmail.com";
    private static final String CONTRASENA_SISTEMA = "ohok zgfd whaz uvhe";    

    // ===================== CONSTRUCTOR =====================
    public Sistema(ArrayList<Usuario> listaUsuarios, ArrayList<Partido> listaPartidos,
                   ArrayList<Kit> listaKits, ArrayList<Compra> listaCompras) {
        Sistema.listaUsuarios = listaUsuarios;
        Sistema.listaPartidos = listaPartidos;
        Sistema.listaKits = listaKits;
        Sistema.listaCompras = listaCompras;
    }

    // ===================== CARGA DE DATOS =====================

    public void cargarUsuarios() {
        ArrayList<String> lineasUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> lineasAficionados = ManejoArchivos.LeeFichero("aficionados.txt");
        ArrayList<String> lineasOrganizadores = ManejoArchivos.LeeFichero("organizadores.txt");

        boolean primeraLineaUsuarios = true;
        for (String linea : lineasUsuarios) {
            if (primeraLineaUsuarios) { primeraLineaUsuarios = false; continue; }

            String[] datos = linea.split("\\|");
            String codigoUnico = datos[0];
            String cedula = datos[1];
            String nombres = datos[2];
            String apellidos = datos[3];
            String usuario = datos[4];
            String contrasena = datos[5];
            String correo = datos[6];
            String rolTexto = datos[7];

            if (rolTexto.equals("A")) {
                boolean primeraLineaAf = true;
                for (String lineaAf : lineasAficionados) {
                    if (primeraLineaAf) { primeraLineaAf = false; continue; }
                    String[] datosAf = lineaAf.split("\\|");
                    if (datosAf[0].equals(codigoUnico)) {
                        String celular = datosAf[4];
                        String paisFavorito = datosAf[5];
                        Aficionado af = new Aficionado(codigoUnico, cedula, nombres, apellidos,
                                usuario, contrasena, correo, celular, paisFavorito);
                        listaUsuarios.add(af);
                        break;
                    }
                }
            } else if (rolTexto.equals("O")) {
                boolean primeraLineaOrg = true;
                for (String lineaOrg : lineasOrganizadores) {
                    if (primeraLineaOrg) { primeraLineaOrg = false; continue; }
                    String[] datosOrg = lineaOrg.split("\\|");
                    if (datosOrg[0].equals(codigoUnico)) {
                        String empresa = datosOrg[4];
                        String cargo = datosOrg[5];
                        Organizador org = new Organizador(codigoUnico, cedula, nombres, apellidos,
                                usuario, contrasena, correo, empresa, cargo);
                        listaUsuarios.add(org);
                        break;
                    }
                }
            }
        }
    }

    public void cargarPartidos() {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("partidos.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        boolean primeraLinea = true;
        for (String linea : lineas) {
            if (primeraLinea) { primeraLinea = false; continue; }
            String[] d = linea.split("\\|");
            try {
                String codigo = d[0];
                String local = d[1];
                String visitante = d[2];
                Date fecha = sdf.parse(d[3]);
                String estadio = d[4];
                String ciudad = d[5];
                int capacidad = Integer.parseInt(d[6]);
                int dispGeneral = Integer.parseInt(d[7]);
                int dispPreferencial = Integer.parseInt(d[8]);
                int dispVIP = Integer.parseInt(d[9]);
                String fase = d[10];

                double precioGeneral = 0.0;
                double precioPreferencial = 0.0;
                double precioVIP = 0.0;

                Partido p = new Partido(codigo, local, visitante, estadio, ciudad, fase,
                        fecha, capacidad, dispGeneral, dispPreferencial, dispVIP,
                        precioGeneral, precioPreferencial, precioVIP);
                listaPartidos.add(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cargarKits() {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("kits.txt");

        boolean primeraLinea = true;
        for (String linea : lineas) {
            if (primeraLinea) { primeraLinea = false; continue; }
            String[] d = linea.split("\\|");
            String codigo = d[0];
            String nombre = d[1];
            String descripcion = d[2];
            String[] codigosPartidos = d[3].split(",");
            double precio = Double.parseDouble(d[4]);
            int disponibles = Integer.parseInt(d[5]);

            ArrayList<Partido> partidosDelKit = new ArrayList<>();
            for (String codPartido : codigosPartidos) {
                for (Partido p : listaPartidos) {
                    if (p.getCodigo().equals(codPartido)) {
                        partidosDelKit.add(p);
                        break;
                    }
                }
            }

            Kit kit = new Kit(codigo, nombre, descripcion, partidosDelKit, precio, disponibles);
            listaKits.add(kit);
        }
    }

    public void cargarCompras() {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("compras.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        boolean primeraLinea = true;
        for (String linea : lineas) {
            if (primeraLinea) { primeraLinea = false; continue; }
            String[] d = linea.split("\\|");
            try {
                String codigoArchivo = d[0];
                TipoCompra tipo = TipoCompra.valueOf(d[1]);
                String codigoReferencia = d[2];
                Date fechaCompra = sdf.parse(d[3]);
                int cantidad = Integer.parseInt(d[4]);
                double valorPagado = Double.parseDouble(d[5]);
                String codigoAficionado = d[6];

                Compra c = new Compra(tipo, codigoReferencia, fechaCompra, cantidad, valorPagado, codigoAficionado);
                c.setCodigo(codigoArchivo);
                listaCompras.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ===================== SESIÓN Y MENÚ =====================

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
                scanner.nextLine();

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
                scanner.nextLine();

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

    // ===================== NOTIFICAR (sobrecarga) =====================
    // static para poder llamarse desde Aficionado/Organizador sin
    // necesitar una instancia de Sistema.

    public static void notificar(Aficionado aficionado, Compra compra, Partido partido) {
        System.out.println("\n--- NOTIFICACIÓN ENVIADA ---");
        System.out.println("Para: " + aficionado.getCorreo());
        System.out.println("Asunto: Compra de entrada realizada");

        String cuerpo = "Estimado/a " + aficionado.getNombres() + " " + aficionado.getApellidos() + ",\n\n" +
                "Su compra ha sido registrada exitosamente con el código " + compra.getCodigo() + " el día " + compra.getFechaCompra() + ".\n" +
                "Partido: " + partido.getLocal() + " vs " + partido.getVisitante() + "\n" +
                "Código del partido: " + compra.getCodigoReferencia() + "\n" +
                "Cantidad: " + compra.getCantidad() + "\n" +
                "Valor pagado: $" + compra.getValorPagado() + "\n\n" +
                "Gracias por adquirir sus entradas para el Mundial. Recuerde conservar el código de compra para futuras consultas.";

        enviarCorreo(aficionado.getCorreo(), "Compra de entrada realizada", cuerpo);// Aquí llama al método que permite enviar el correo
    }

    public static void notificar(Aficionado aficionado, Compra compra, Kit kit) {
        System.out.println("\n--- NOTIFICACIÓN ENVIADA ---");
        System.out.println("Para: " + aficionado.getCorreo());
        System.out.println("Asunto: Compra de kit de entradas realizada");

        String cuerpo = "Estimado/a " + aficionado.getNombres() + " " + aficionado.getApellidos() + ",\n\n" +
                "Su compra ha sido registrada exitosamente con el código " + compra.getCodigo() + " el día " + compra.getFechaCompra() + ".\n" +
                "Kit adquirido: " + kit.getNombre() + "\n" +
                "Descripción: " + kit.getDescripcion() + "\n" +
                "Cantidad: " + compra.getCantidad() + "\n" +
                "Valor pagado: $" + compra.getValorPagado() + "\n\n" +
                "Gracias por adquirir su kit para el Mundial. Recuerde conservar el código de compra para futuras consultas.";

        enviarCorreo(aficionado.getCorreo(), "Compra de kit de entradas realizada", cuerpo);// Aquí llama al método que permite enviar el correo
    }


    public static void notificar(Organizador organizador, ArrayList<Compra> compras) {
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

        System.out.println("\n--- NOTIFICACIÓN ENVIADA ---");
        System.out.println("Para: " + organizador.getCorreo());
        System.out.println("Asunto: Reporte de compras registradas");

        String cuerpo = "Estimado/a " + organizador.getNombres() + " " + organizador.getApellidos() + ",\n\n" +
                "Se ha generado el reporte de compras del sistema.\n" +
                "Fecha de generación del reporte: " + new Date() + "\n" +
                "Total de compras registradas: " + totalCompras + "\n" +
                "Total de compras de entradas individuales: " + totalEntradas + "\n" +
                "Total de compras de kits: " + totalKits + "\n" +
                "Monto total recaudado: $" + montoTotal;

        enviarCorreo(organizador.getCorreo(), "Reporte de compras registradas", cuerpo);// Aquí llama al método que permite enviar el correo
    }

    private static void enviarCorreo(String destinatario, String asunto, String cuerpo) { 
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");   
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");  
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");     
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_SISTEMA, CONTRASENA_SISTEMA);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CORREO_SISTEMA));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport.send(message);
            System.out.println("Correo enviado exitosamente a: " + destinatario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
        }
    }



    // ===================== GETTERS Y SETTERS =====================
    //static para que sean consistentes

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        Sistema.listaUsuarios = listaUsuarios;
    }

    public static ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public static void setListaPartidos(ArrayList<Partido> listaPartidos) {
        Sistema.listaPartidos = listaPartidos;
    }

    public static ArrayList<Kit> getListaKits() {
        return listaKits;
    }

    public static void setListaKits(ArrayList<Kit> listaKits) {
        Sistema.listaKits = listaKits;
    }

    public static ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public static void setListaCompras(ArrayList<Compra> listaCompras) {
        Sistema.listaCompras = listaCompras;
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        listaUsuarios = new ArrayList<>();
        listaPartidos = new ArrayList<>();
        listaKits = new ArrayList<>();
        listaCompras = new ArrayList<>();

        Sistema sistema = new Sistema(listaUsuarios, listaPartidos, listaKits, listaCompras);
        sistema.cargarUsuarios();
        sistema.cargarPartidos();
        sistema.cargarKits();
        sistema.cargarCompras();

 

        iniciarSesion();
    }
}