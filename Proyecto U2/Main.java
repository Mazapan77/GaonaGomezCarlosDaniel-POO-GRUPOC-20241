import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        zoologico.temporal();
        Scanner leer = new Scanner(System.in);
        int selector;
        do {
            System.out.println("\n\n--Seleccione una opcion--\n" +
                    "1. Registrar Empleado\n" +
                    "2. Registrar Visitante\n" +
                    "3. Registrar Visita\n" +
                    "4. Registrar Animales\n" +
                    "5. Registrar Mantenimiento\n" +
                    "6. Modificaciones\n" +
                    "0. Salir");

            selector = leer.nextInt();

            switch (selector){
                case 1:
                    zoologico.registrarEmpleado();
                    break;
                case 2:
                    zoologico.registrarVisitante();
                    break;
                case 3:
                    zoologico.registrarVisita();
                    break;
                case 4:
                    zoologico.registrar_animales();
                    break;
                case 5:
                    zoologico.registrar_mantenimiento();
                    break;
                case 6:
                    String contraseña = "Pepitoclavounclavito";
                    boolean contraseñaCorrecta = false;
                    while (!contraseñaCorrecta){
                        System.out.println("Ingrese la contraseña: ");
                        String clave = leer.next();
                        leer.nextLine();
                        if (clave.equals(contraseña)){
                            zoologico.modificaciones();
                            contraseñaCorrecta = true;
                        }else{
                            System.out.println("Constraseña incorrecta, intete de nuevo");
                        }
                    }
                    break;
                default:
                    System.out.println("Hasta la proxima");
            }
        }while (selector != 0);
    }
}