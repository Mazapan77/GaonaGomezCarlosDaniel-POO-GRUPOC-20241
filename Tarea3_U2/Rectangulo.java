package Tarea3_U2;

public class Rectangulo {

    public double ancho;
    public double altura;

    // Constructor
    public Rectangulo(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    public double calcularArea() {
        return  ancho * altura;
    }

    public double calcularPerimetro() {
        return 2 * (ancho + altura);
    }

    public void mostrarInformacion() {
        System.out.println("Ancho: " + ancho);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }

}

