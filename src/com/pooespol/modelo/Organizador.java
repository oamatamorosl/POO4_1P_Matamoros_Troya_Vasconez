package com.pooespol.modelo;
//Organizador clase hija de Usuario

import com.pooespol.enums.Rol;
import com.pooespol.enums.TipoCompra;
import com.pooespol.sistema.Sistema;

/**
 * Clase que representa a un organizador del Mundial.
 * Hereda de Usuario y permite consultar todas las compras
 * del sistema y generar reportes de ventas.
 *
 * @author Sebastian Vasconez
 * @version 1.0
 */
public class Organizador extends Usuario{

    /** Empresa organizadora a la que pertenece. */
    private String empresa;

    /** Cargo del organizador dentro de la empresa. */
    private String cargo;

    /**
     * Constructor clase Organizador.
     *
     * @param codigoUnico código único del organizador
     * @param cedula cédula del organizador
     * @param nombres nombres del organizador
     * @param apellidos apellidos del organizador
     * @param usuario nombre de usuario para iniciar sesión
     * @param contrasena contraseña del organizador
     * @param correo correo electrónico del organizador
     * @param empresa empresa organizadora
     * @param cargo cargo del organizador
     */
public Organizador(String codigoUnico, String cedula, String nombres, 
                    String apellidos, String usuario, String contrasena, 
                    String correo, String empresa, String cargo){

//LLamando a constructor de clase padre           
super(codigoUnico,  cedula, nombres, 
                 apellidos,  usuario, contrasena, 
                 correo);

//Atributos propios de Organizador
this.empresa = empresa;
this.cargo = cargo;
this.rol = Rol.O; //El rol de organizador siempre es O   
}

    /**
     * Muestra todas las compras registradas en el sistema.
     * Sobrescribe el método abstracto de Usuario.
     */
@Override
public void consultarEntradas(){
boolean bandera = false;

for (Compra compra : Sistema.listaCompras){
                bandera = true;
                System.out.println(compra);
}

if (bandera == false){
                System.out.println("No existen compras");
}
}

    /**
     * Genera un reporte de ventas con el total de compras,
     * cantidad por tipo y monto total recaudado.
     * Envía el reporte por correo al organizador.
     */
public void generarReporte(){

int totalEntradas = 0;
int totalKits = 0;
double totalRecaudado = 0;
for (Compra compra : Sistema.listaCompras){
if (compra.getTipo() == TipoCompra.ENTRADA){
                totalEntradas++;

} else if (compra.getTipo() == TipoCompra.KIT) {
                totalKits++;   
}

            totalRecaudado += compra.getValorPagado(); 

}
        System.out.println("===== GENERAR REPORTE DE VENTAS =====");
        System.out.println("Resumen de ventas registradas:");
        System.out.println("Total de compras: " + Sistema.listaCompras.size());
        System.out.println("Compras por tipo: ");
        System.out.println("Entradas: " + totalEntradas);
        System.out.println("Kits: " + totalKits);
        System.out.println("Monto total recaudado:");
        System.out.println("$" + String.format("%.2f", totalRecaudado));

        Sistema.notificar(this, Sistema.listaCompras);
}


//Getters

    /**
     * Retorna la empresa del organizador.
     *
     * @return empresa
     */
public String getEmpresa(){
return empresa;
}

    /**
     * Retorna el cargo del organizador.
     *
     * @return cargo
     */
public String getCargo(){
return cargo;
}

//Setters

    /**
     * Establece la empresa del organizador.
     *
     * @param empresa empresa organizadora
     */
public void setEmpresa(String empresa){
this.empresa = empresa;
}

    /**
     * Establece el cargo del organizador.
     *
     * @param cargo cargo del organizador
     */
public void setCargo(String cargo){
this.cargo = cargo;
}

    /**
     * Retorna una representación en texto del organizador.
     *
     * @return String con los datos del organizador
     */
@Override
public String toString(){
return super.toString() + 
", Datos únicos de Organizador: {Empresa = " +this.empresa+
", Cargo = " + this.cargo+ "}";

}



}