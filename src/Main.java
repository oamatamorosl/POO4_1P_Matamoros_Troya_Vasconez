public class Main{

    public static void main(String[] args){

    Aficionado a1 = new Aficionado("A001","1234567890","Daniel Sebastián",
                                    "Vásconez Jarrín", "SebasDV20", "1234",
                                    "sebasvasc@gmail.com", "09786324782","Ecuador"); 
    
    a1.consultarEntradas();
    System.out.println(a1);                                
    

    Organizador o1 = new Organizador("O001","1234567809", "Pepito",
                                    "BuenaGente","PepitoBG","4321",
                                    "pepito@gmail.com","SigmaEnterprise","Gerente");

    o1.consultarEntradas();
    o1.generarReporte();
    System.out.println(o1);

}
}
