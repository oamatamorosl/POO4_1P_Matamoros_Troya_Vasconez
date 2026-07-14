package com.pooespol.modelo;
//Organizador clase hija de Usuario

import com.pooespol.enums.Rol;

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

    
        @Override
        public void consultarEntradas(){
        System.out.println("Consultando entradas como organizador...");

     }
    
     //Método generarReporte() Implementación temporal: la lógica real depende de clases que aún no existen.

     public void generarReporte(){
        System.out.println("Generando reporte...");
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

