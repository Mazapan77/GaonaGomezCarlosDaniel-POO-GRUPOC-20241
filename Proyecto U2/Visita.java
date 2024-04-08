import java.util.ArrayList;
import java.util.List;

public class Visita {
    public int idGuia;
    public String guia;
    private List<Visitante> visitantes = new ArrayList<>();
    private double costoTotal;
    private String fechaDeLaVisita;
    private int cantidadNinos;
    private int cantidadAdultos;

    Visita(int idGuia, String guia, List<Visitante> visitantes, String fechaDeLaVisita) {
        this.idGuia = idGuia;
        this.guia = guia;
        this.visitantes = visitantes;
        this.fechaDeLaVisita = fechaDeLaVisita;

        for (Visitante visitante : visitantes) {
            if (visitante.esMayor) {
                cantidadAdultos += 1;
            } else {
                cantidadNinos += 1;
            }
        }

        for (Visitante visitante : visitantes) {
            costoTotal += visitante.obtenerPrecioBoleto();
        }


    }



    public void consultarVisita() {
        System.out.println(String.format("Guia: %s\nFecha de la visita: %s\nCosto total: %f\n-----Visitantes-----", guia, fechaDeLaVisita, costoTotal));
        for (Visitante visitante : visitantes) {
            System.out.println(String.format("ID: %d. Nombre: %s %s. No. Visitas: %d", visitante.id, visitante.nombre, visitante.apellidos, visitante.numeroDeVisitas));
        }
        System.out.print("--------------------\n");
        System.out.println(String.format("Cantidad de adultos: %d\nCantidad de niños: %d\n", cantidadAdultos, cantidadNinos));
    }



    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFechaDeLaVisita() {
        return fechaDeLaVisita;
    }

    public void setFechaDeLaVisita(String fechaDeLaVisita) {
        this.fechaDeLaVisita = fechaDeLaVisita;
    }

    public int getCantidadNinos() {
        return cantidadNinos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }
}
