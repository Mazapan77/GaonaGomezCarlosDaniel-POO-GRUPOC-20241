import java.util.List;

public class Animales {

    public int idAnimal;
    private String tipoAnimal;
    private String fechaNacimiento;
    private String llegadaZoo;
    private float peso;
    private List<String> enfermedades;
    private int frecuenciaAlimentacion;
    private String tipoAlimentacion;
    private boolean vacunas;

    public Animales(int idAnimal, String tipoAnimal, String fechaNacimiento, String llegadaZoo, float peso, List<String> enfermedades,
                    int frecuenciaAlimentacion, String tipoAlimentacion, boolean vacunas) {
        this.idAnimal = idAnimal;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.llegadaZoo = llegadaZoo;
        this.peso = peso;
        this.enfermedades = enfermedades;
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
        this.tipoAlimentacion = tipoAlimentacion;
        this.vacunas = vacunas;
    }

    public String consultarAnimal() {
        return String.format("|ID: %s|Tipo de animal: %s|Fecha de Nacimiento: %s|Llegada al Zoo: %s|Peso: %f" +
                "|Enfermedades: %s|Frecuencia de Alimentacion: %d|Tipo de Alimentacion: %s|Vacunas: %b",
                idAnimal, tipoAnimal, fechaNacimiento, llegadaZoo, peso, enfermedades, frecuenciaAlimentacion, tipoAlimentacion, vacunas);
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLlegadaZoo() {
        return llegadaZoo;
    }

    public void setLlegadaZoo(String llegadaZoo) {
        this.llegadaZoo = llegadaZoo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public List<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public int getFrecuenciaAlimentacion() {
        return frecuenciaAlimentacion;
    }

    public void setFrecuenciaAlimentacion(int frecuenciaAlimentacion) {
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    @Override
    public String toString() {
        return "Animales [tipoAnimal=" + tipoAnimal + ", fechaNacimiento=" + fechaNacimiento + ", llegadaZoo="
                + llegadaZoo + ", peso=" + peso + ", enfermedades=" + enfermedades + ", frecuenciaAlimentacion="
                + frecuenciaAlimentacion + ", tipoAlimentacion=" + tipoAlimentacion + ", vacunas=" + vacunas + "]";
    }












}

