public class Circulo extends Shape{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
    @Override
    public double calcularArea(){
        return 3.14*radio*radio;
    }
    @Override
    public double calcularPerimetro(){
        return 3.14*2.0*radio;
    }
}
