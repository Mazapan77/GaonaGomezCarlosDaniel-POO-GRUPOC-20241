public class Triangulo extends Shape {
    private double altura;
    private double base;
    private double lado1;

    public Triangulo(double altura, double base, double lado1) {
        this.altura = altura;
        this.base = base;
        this.lado1 = lado1;
    }

 
   @Override
   public double calcularArea(){
    return (base*altura)/2;
   }

   @Override
    public double calcularPerimetro(){
        return 3.0*lado1;
   }

    
}
