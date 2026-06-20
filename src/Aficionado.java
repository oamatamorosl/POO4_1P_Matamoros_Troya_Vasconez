//Aficioando clase hija de Usuario

public class Aficionado extends Usuario {
    private String celular;
    private String paisFavorito;

    //Constructor clase hija 
    public Aficionado(String codigoUnico, String cedula, String nombres, 
                    String apellidos, String usuario, String contrasena, 
                    String correo, String celular,String paisFavorito){

             //LLamando a constructor de clase padre           
            super(codigoUnico,  cedula, nombres, 
                 apellidos,  usuario, contrasena, 
                 correo);

            //Asignación de atributos propios de Aficionado
            this.celular = celular;
            this.paisFavorito = paisFavorito;
            this.rol = Rol.A; // El rol de aficionado siempre es A
}

    @Override
    public void consultarEntradas(){
        System.out.println("Consultando entradas del aficionado...");

}

//Getters 

public String getCelular(){
    return celular;
}

public String getPaisFavorito(){
    return paisFavorito;
}

//Setters

public void setCelular(String celular){
    this.celular = celular;
}

public void setPaisFavorito(String paisFavorito){
    this.paisFavorito = paisFavorito;
}

// Método toString() usando super.toString() para llamar al método del padre

    @Override
    public String toString(){
    return super.toString() + 
    "Datos únicos de Aficionado[Celular: " +this.celular+
    ", País Favorito: " +this.paisFavorito+ "]";

}

}
