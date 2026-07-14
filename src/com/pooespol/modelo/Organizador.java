package com.pooespol.modelo;
//Organizador clase hija de Usuario

import com.pooespol.enums.Rol;
import com.pooespol.enums.TipoCompra;
import com.pooespol.sistema.Sistema;

public class Organizador extends Usuario{
private String empresa;
private String cargo;

//Constructor clase Organizador 
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

// Método consultarEntradas()

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
// Método generarReporte()
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

public String getEmpresa(){
return empresa;
}

public String getCargo(){
return cargo;
}

//Setters

public void setEmpresa(String empresa){
this.empresa = empresa;
}

public void setCargo(String cargo){
this.cargo = cargo;
}

//Sobrescritura de toString() con super.toString()

@Override
public String toString(){
return super.toString() + 
", Datos únicos de Organizador: {Empresa = " +this.empresa+
", Cargo = " + this.cargo+ "}";

}



}