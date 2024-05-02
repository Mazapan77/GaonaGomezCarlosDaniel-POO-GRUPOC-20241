public class Rectangulo implements   Shape{
    private double alturaRectangulo;
    private  double baseRectangulo;

    public Rectangulo(double alturaRectangulo, double baseRectangulo) {
        this.alturaRectangulo = alturaRectangulo;
        this.baseRectangulo = baseRectangulo;
    }

    @Override
    public double calcularArea(){
        return alturaRectangulo*baseRectangulo;

    }
    @Override
    public double calcularPerimetro(){
        return alturaRectangulo*4;
    }


}
