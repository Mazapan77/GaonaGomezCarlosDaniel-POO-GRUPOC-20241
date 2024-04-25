import java.util.Scanner;
public class Figuras {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int selector;
        do {
            System.out.println("Selecciona una figura: \n" +  
                             "1. Cuadradro\n" +
                             "2. Triangulo\n" +
                             "3. Circulo\n" +
                             "4. Rombo\n" +
                             "5. Rectangulo\n" +
                             "0. Salir");
            selector = leer.nextInt();
            switch (selector) {
                case 1:
                    System.out.println("***********CUADRADO**********");
                    System.out.println("Introduzca el tamaño de un lado");
                    int lado = leer.nextInt();
                    Cuadrado cuadrado = new Cuadrado(lado);
                    System.out.println("El area es: " + cuadrado.calcularArea());
                    System.out.println("El perimetro es: " + cuadrado.calcularPerimetro());

                break;

                case 2:
                    System.out.println("**********TRIANGULO**********");
                    System.out.println("Introduzca la altura:");
                    double altura = leer.nextDouble();
                    System.out.println("Introduzca la base: ");
                    double base = leer.nextDouble();
                    System.out.println("Introduzca el tamaño de un lado: ");
                    double lado1 = leer.nextDouble();
                    Triangulo triangulo = new Triangulo(altura, base, lado1);
                    System.out.println("El area es: " + triangulo.calcularArea() );
                    System.out.println("El perimetro es: " + triangulo.calcularPerimetro());
                    
                break;
                case 3:
                    System.out.println("**********CIRCULO**********");
                    System.out.println("Introduzca el radio: ");
                    double radio = leer.nextDouble();
                    Circulo circulo = new Circulo(radio);
                    System.out.println("El area es: " + circulo.calcularArea());
                    System.out.println("El perimetro es: " + circulo.calcularPerimetro());
                
                break;
                case 4:
                    System.out.println("**********ROMBO**********");
                    System.out.println("Introduzca la diagonal mayor: ");
                    double diagonalMayor = leer.nextDouble();
                    System.out.println("Introduzca la diagonal menor: ");
                    double diagonlaMenor = leer.nextDouble();
                    System.out.println("Introduzca un el tamaño de un lado: ");
                    double ladoR = leer.nextDouble();
                    Rombo rombo = new Rombo(diagonlaMenor, diagonalMayor, ladoR);
                    System.out.println("El area es: " + rombo.calcularArea());
                    System.out.println("El perimetro es: " + rombo.calcularPerimetro());
                
                break;
                case 5:
                    System.out.println("**********RECTANGULO**********");
                    System.out.println("Introduzca la base: ");
                    double baseRectangulo = leer.nextDouble();
                    System.out.println("Introduzca la altura:");
                    double alturaRectangulo = leer.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(alturaRectangulo, baseRectangulo);
                    System.out.println("El area es: " + rectangulo.calcularArea());
                    System.out.println("El perimetro es: " + rectangulo.calcularPerimetro());
                break;
                default:
                break;
            
            }
        } while (selector != 0);
        leer.close();
    }
}
