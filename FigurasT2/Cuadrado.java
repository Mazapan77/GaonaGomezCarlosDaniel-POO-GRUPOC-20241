public class Cuadrado implements Shape {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        return lado*lado;
    } 

    @Override
    public double calcularPerimetro(){
        return lado*4;
    }


}
