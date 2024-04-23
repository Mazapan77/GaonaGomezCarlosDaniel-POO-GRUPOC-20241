import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;

public class Main {
    public static void main(String[] args) {
      
       Cliente cliente = new Cliente("Carlos", "Gomez", "123456789");
       System.out.println(cliente.toString());

       Asistente asistente = new Asistente("Sukuna", "Ryōmen", "987654321", 10500, "SUKU05");
       System.out.println(asistente.toString());

       Gerente gerente = new Gerente("Gojo", "Satoru", "8570546590", 20200, "SATGOJ01", "M1T4DP0RSUKUNA");
        System.out.println(gerente.toString());
    }
    
}
