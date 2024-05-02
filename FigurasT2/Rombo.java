public class Rombo implements Shape {
    private double diagonalMenor;
    private double diagonalMayor;
    private double ladoR;

    public Rombo(double diagonalMenor, double diagonalMayor, double ladoR) {
        this.diagonalMenor = diagonalMenor;
        this.diagonalMayor = diagonalMayor;
        this.ladoR = ladoR;
    }
    @Override
    public double calcularArea(){
        return (diagonalMayor*diagonalMenor)/2;
    }
    @Override
    public double calcularPerimetro(){
        return ladoR*4.0;
    }
}
