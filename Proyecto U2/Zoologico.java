import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Zoologico {

    public Scanner leer = new Scanner(System.in);
    private List<Empleado> empleados = new ArrayList<>();
    private List<Visitante> visitantes = new ArrayList<>();
    private List<Visita> visitas = new ArrayList<>();
    private List<Animales> animales = new ArrayList<>();
    private List<String> enfermedades = new ArrayList<>();
    private List<Mantenimiento> mantenimientos = new ArrayList<>();
    private int idEmpleado = 1;
    private int idVisitante = 1;
    private int idAnimal =1;

    //Asignacion de algunos objetos de clase empleado y visitante
    public void temporal(){
        Empleado empleado = new Empleado(10, "JUAN", "TRYHARD", "", "", "", "", 2, 2, 2, "Guia");
        empleados.add(empleado);
        empleado = new Empleado(11, "PEPE", "TRYHARD", "", "", "", "", 2, 2, 2, "Mantenimiento");
        empleados.add(empleado);
        Visitante visitante = new Visitante(10, "Pedro", "Perez", "23/09/2004", "XD", "23/09/2024");
        visitantes.add(visitante);
    }
    public void registrarEmpleado() {
        System.out.println("\n------------------------\n**Registro de Empleado**\n------------------------\n");
        System.out.print("Nombre: ");
        String nombre = leer.next();
        leer.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = leer.nextLine();
        System.out.print("Fecha de nacimiento (DD/MM/AAAA): ");
        String fechaDeNacimiento = leer.nextLine();
        System.out.print("Fecha de Ingreso (DD/MM/AAAA): ");
        String fechaDeIngreso = leer.nextLine();
        System.out.print("RFC: ");
        String RFC = leer.nextLine();
        System.out.print("CURP: ");
        String CURP = leer.nextLine();
        System.out.print("Salario: $");
        double salario = leer.nextInt();
        int horaEntrada;
        int horaSalida;
        do {
            System.out.print("Hora de entrada (24H): ");
            horaEntrada = leer.nextInt();
            if (horaEntrada < 0 || horaEntrada > 23){
                System.out.println("Error, Introduzca una hora valida");
            }
        }while (horaEntrada < 0 || horaEntrada > 23);
        do {
            System.out.print("Hora de salida (24H): ");
            horaSalida = leer.nextInt();
            if (horaSalida < 0 || horaSalida > 23){
                System.out.println("Error, Introduzca una hora valida");
            }
        }while (horaSalida < 0 || horaSalida > 23);
        int selector;
        String rol = "Guia";
        do {
            System.out.print("Rol (1.Veterinario 2.Guia 3.Mantenimiento 4.Administracion): ");
            selector = leer.nextInt();
            switch (selector) {
                case 1:
                    rol = "Veterinario";
                    break;
                case 2:
                    rol = "Guia";
                    break;
                case 3:
                    rol = "Mantenimiento";
                    break;
                case 4:
                    rol = "Administracion";
                    break;
                default:
                    System.out.println("Seleccione incorrecta, intente nuevamente");
            }
        } while (selector < 1 || selector > 4);

        Empleado empleado = new Empleado(idEmpleado, nombre, apellidos, fechaDeNacimiento, fechaDeIngreso, RFC, CURP, salario, horaEntrada, horaSalida, rol);
        empleados.add(empleado);
        idEmpleado += 1;
        System.out.println("\n\n\n\n\n----------------------------\n**Registrado exitosamente**\n----------------------------\n");
    }

    public void registrarVisitante() {
        System.out.println("\n-------------------------\n**Registro de Visitante**\n-------------------------\n");
        System.out.print("Nombre: ");
        String nombre = leer.next();
        leer.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = leer.nextLine();
        System.out.print("Fecha de nacimiento (DD/MM/AAAA): ");
        String fechaDeNacimiento = leer.nextLine();
        System.out.print("CURP: ");
        String CURP = leer.nextLine();
        System.out.print("Fecha de Registro (DD/MM/AAAA): ");
        String fechaDeRegistro = leer.nextLine();

        Visitante visitante = new Visitante(idVisitante, nombre, apellidos, fechaDeNacimiento, CURP, fechaDeRegistro);
        visitantes.add(visitante);
        idVisitante += 1;
        System.out.println("\n\n\n\n\n----------------------------\n**Registrado exitosamente**\n----------------------------\n");
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void registrarVisita() {
        boolean band=false;
        System.out.println("\n----------------------\n**Registro de Visita**\n----------------------\n");
        System.out.println("Seleccione el guia a cargo: ");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados\n");
            return;
        } else {
            for (Empleado empleado : empleados) {
                if (empleado.rol == "Guia") {
                    System.out.println(String.format("ID: %d. Nombre: %s.", empleado.id, empleado.nombre));
                    band = true;
                }
            }
        }
        if (band == false) {
            System.out.println("No hay guias disponibles\n");
            return;
        }
        String guia=null;
        int idGuia;
        do {
            System.out.print("Introduzca el id del guia: ");
            idGuia = leer.nextInt();
            for (Empleado empleado : empleados ) {
                if (empleado.id == idGuia) {
                    guia = empleado.nombre;
                    idGuia = empleado.id;
                }
            }
            if (guia == null){
                System.out.println("La id no coincide con ningun guia");
            }
        } while (guia == null);

        System.out.println("Seleccione los visitantes: ");
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados\n");
            return;
        } else {
            for (Visitante visitante : visitantes) {
                System.out.println(String.format("ID: %d. Nombre: %s", visitante.id, visitante.nombre));
            }
        }
        System.out.print("Introduzca los id de los visitantes (Separado por \"-\"): ");
        String auxIds = leer.next();
        leer.nextLine();
        String[] IDs = auxIds.split("-");
        List<Visitante> visitantesVisita = new ArrayList<>();
        for (int i = 0; i < IDs.length; i++) {
            boolean existe = false;
            for (Visitante visitante : visitantes) {
                if (Integer.parseInt(IDs[i]) == visitante.id) {
                    visitante.aumentarVisitas();
                    visitantesVisita.add(visitante);
                    existe = true;
                }
            }
            if (existe == false){
                System.out.println("El id \""+ IDs[i] +"\" no existe");
            }
        }
        System.out.print("Introduzca la fecha de la visita (DD/MM/AAAA):");
        String fechaDeLaVisita = leer.nextLine();

        Visita visita = new Visita(idGuia, guia, visitantesVisita, fechaDeLaVisita);
        visitas.add(visita);

        System.out.println("\n-----Resumen-----");
        visita.consultarVisita();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void registrar_animales(){
        System.out.println("\n------------------------\n**Registro de Animales**\n------------------------\n");

        System.out.println("Tipo de animal");
        String tipoAnimal = leer.next();
        leer.nextLine();
        System.out.println("Fecha de nacimiento");
        String fechaNacimiento = leer.nextLine();
        System.out.println("Fecha de llegada al zoologico");
        String llegadaZoo = leer.nextLine();
        System.out.println("Peso");
        float peso = leer.nextFloat();
        System.out.println("Enfermedades");
        System.out.println("Ingrese una enfermedad por linea e ingrese 'Fin' para terminar la lista");
        String enfermedad;
        while (!(enfermedad = leer.nextLine()).equals("Fin")) {
            enfermedades.add(enfermedad);
        }
        System.out.println("Frecuencia de alimentacion (en números)");
        int frecuenciaAlimentacion = leer.nextInt();
        System.out.println("Tipo de alimentacion");
        String tipoAlimentacion = leer.next();
        leer.nextLine();
        System.out.println("¿Cuenta con vacunas? (true/false)");
        boolean vacunas = leer.nextBoolean();
        Animales animal = new Animales(idAnimal, tipoAnimal, fechaNacimiento, llegadaZoo, peso, enfermedades, frecuenciaAlimentacion, tipoAlimentacion, vacunas);
        animales.add(animal);
        idAnimal += 1;
        System.out.println("\n\n\n\n\n-------------------------------------\n**Animal Registrado Exitosamente**\n-------------------------------------\n");

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  void registrar_mantenimiento(){
        boolean band = false;
        System.out.println("\n----------------------\n**Registro de Procesos**\n----------------------\n");
        System.out.println("Seleccione el empleado a cargo: ");
        if (empleados.isEmpty()){
            System.out.println("No hay empleados de mantenimiento registrados");
            return;
        } else {
            for (Empleado empleado : empleados){
                if (empleado.rol == "Mantenimiento"){
                    System.out.println(String.format("ID: %d. Nombre: %s.", empleado.id, empleado.nombre));
                    band = true;
                }
            }
        }
        if (band == false) {
            System.out.println("No hay personal de mantenimiento disponibles\n");
            return;
        }
        String nombreMantenimiento=null;
        int idMantenimiento;
        do {
            System.out.print("Introduzca el id del personal de mantenimiento: ");
            idMantenimiento = leer.nextInt();
            for (Empleado empleado : empleados ) {
                if (empleado.id == idMantenimiento) {
                    nombreMantenimiento = empleado.nombre;
                    idMantenimiento = empleado.id;
                }
            }
            System.out.println("La id no coincide con ningun guia");
        } while (nombreMantenimiento == null);

        System.out.println("ID del animal");
        int id_animal;
        if (animales.isEmpty()){
            System.out.println("No hay animales registrados");
            return;
        } else {
            id_animal = leer.nextInt();
            for (Animales animales : animales){
                if (id_animal != animales.idAnimal){
                    System.out.println("El ID no coincide con ninguno existente");
                    return;
                }
            }
        }

        System.out.println("Proceso que se realizo: ");
        String proceso = leer.next();
        leer.nextLine();

        System.out.println("Fecha del proceso (DD/MM/AAAA)");
        String fechaProceso = leer.nextLine();

        System.out.println("¿Hay alguna observacion? (Si/No)");
        String observaciones;
        String yesNo = leer.nextLine();
        if (yesNo == "Si"){
            System.out.println("Escriba las observaciones");
            observaciones = leer.nextLine();
        } else {
            observaciones = "No hay observaciones";
        }

        Mantenimiento mantenimiento = new Mantenimiento(idMantenimiento, nombreMantenimiento, id_animal, proceso, fechaProceso, observaciones);
        System.out.println("\n\n\n\n\n-------------------------------------\n**Mantenimiento Registrado Exitosamente**\n-------------------------------------\n");

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void modificaciones(){
        System.out.println("\n----------------------\n**Modificaciones a archvos**\n----------------------\n");
        int selector;
        do {
            System.out.println("\n--Seleccione una opcion--\n" +
                    "1.Registrar\n" +
                    "2.Modificar\n" +
                    "3.Eliminar\n" +
                    "4.Consultar\n" +
                    "0. Salir" );

            selector = leer.nextInt();

            switch (selector){
                case 1:
                    int selectorRegistro;
                    do {
                        System.out.println("\n¿Que desea registrar?\n" +
                                "1.Empleado\n" +
                                "2.Visitante\n" +
                                "3.Visita\n" +
                                "4.Animales\n" +
                                "5.Mantenimiento\n" +
                                "0.Salir\n" );
                        selectorRegistro = leer.nextInt();

                        switch (selectorRegistro){
                            case 1:
                                registrarEmpleado();
                                break;
                            case 2:
                                registrarVisitante();
                                break;
                            case 3:
                                registrarVisita();
                                break;
                            case 4:
                                registrar_animales();
                                break;
                            case 5:
                                registrar_mantenimiento();
                                break;
                            default:
                                System.out.println("Error, introduzca una opción válida");
                        }

                    }while (selectorRegistro != 0);
                    break;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    int selectorModificar;
                    do {
                        System.out.println("\n¿Que desea modificar?\n" +
                                "1.Empleado\n" +
                                "2.Visitante\n" +
                                "3.Animales\n" +
                                "0.Salir\n" );
                        selectorModificar = leer.nextInt();
                        switch (selectorModificar){
                            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//EMPLEADOS
                            case 1:
                                System.out.println("Seleccione al empleado que desea modificar (COLOQUE EL ID)");
                                System.out.println("Empleados actuales");
                                for (Empleado empleado : empleados) {
                                    System.out.println(String.format("ID: %d, Nombre: %s ", empleado.id, empleado.nombre));
                                }
                                int idEmpleado = leer.nextInt();
                                boolean taOcupao = false;
                                for (Empleado empleado : empleados) {
                                    for (Visita visita : visitas) {
                                        if (idEmpleado == visita.idGuia) {
                                            taOcupao = true;
                                        }
                                    }
                                    for (Mantenimiento mantenimiento : mantenimientos) {
                                        if (idEmpleado == mantenimiento.idMantenimiento) {
                                            taOcupao = true;
                                        }
                                    }
                                }
                                if (taOcupao) {
                                    System.out.println("No se puede modificar, debido a que tiene actividades");
                                }
                                //ENTRA PARA MODIFICAR AL EMPLEADO
                                else {
                                    System.out.println("¿Qué desea modificar del empleado");
                                    int selectorAtributoEmpleado;
                                    do {
                                        System.out.println(
                                                "\n1.Id\n" +
                                                        "2.Nombre\n" +
                                                        "3.Apellidos\n" +
                                                        "4.Fecha de nacimiento\n" +
                                                        "5.Fecha de ingreso\n" +
                                                        "6.RFC\n" +
                                                        "7.CURP\n" +
                                                        "8.Salario\n" +
                                                        "9.Hora de ingreso\n" +
                                                        "10.Hora de Salida\n" +
                                                        "11.Rol\n" +
                                                        "0.Salir\n" );
                                        selectorAtributoEmpleado = leer.nextInt();


                                        switch (selectorAtributoEmpleado){
                                            case 1:
                                                boolean band;
                                                do {
                                                    band = false;
                                                    System.out.println("Nuevo ID");
                                                    int id = leer.nextInt();
                                                    for (Empleado empleado : empleados) {
                                                        if (empleado.id == id) {
                                                            band = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band) {
                                                        System.out.println("El ID ingresado ya esta en uso, coloque otro");
                                                    } else {
                                                        for (Empleado empleado : empleados) {
                                                            if (idEmpleado == empleado.id) {
                                                                empleado.setId(id);
                                                            }
                                                        }
                                                        System.out.println("ID modificado exitosamente!");
                                                    }
                                                } while (band == true);

                                                break;
                                                ////////////////////////////////////////////////////////////////
                                            case 2:
                                                System.out.println("Nuevo Nombre");
                                                String nuevoNombre = leer.next();
                                                leer.nextLine();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setNombre(nuevoNombre);
                                                    }
                                                }
                                                System.out.println("Nombre modificado exitosamente!");
                                                break;
                                                /////////////////////////////////////////////////////////////////
                                            case 3:
                                                System.out.println("Nuevo Apellido");
                                                String nuevoApellido = leer.next();
                                                leer.nextLine();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setApellidos(nuevoApellido);
                                                    }
                                                }
                                                System.out.println("Apellido modificado exitosamente!");

                                                break;
                                                //////////////////////////////////////////////////////////////////
                                            case 4:
                                                System.out.println("Nueva Fecha de nacimiento");
                                                String nuevaFechaNacimiento = leer.next();
                                                leer.nextLine();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setFechaDeNacimiento(nuevaFechaNacimiento);
                                                    }
                                                }
                                                System.out.println("Fecha de nacimiento modificado exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 5:
                                                System.out.println("Nueva Fecha de ingreso");
                                                String nuevaFechaIngreso = leer.next();
                                                leer.nextLine();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setFechaDeIngreso(nuevaFechaIngreso);
                                                    }
                                                }
                                                System.out.println("Fecha de ingreso modificada exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 6:
                                                boolean band1 = false;
                                                do {
                                                    System.out.println("Nuevo RFC");
                                                    String nuevoRFC = leer.next();
                                                    leer.nextLine();
                                                    for (Empleado empleado : empleados) {
                                                        if (empleado.getRFC() == nuevoRFC) {
                                                            band1 = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band1) {
                                                        System.out.println("El RFC ingresado ya esta en uso, coloque otro");
                                                    } else {
                                                        for (Empleado empleado : empleados) {
                                                            if (idEmpleado == empleado.id) {
                                                                empleado.setRFC(nuevoRFC);
                                                            }
                                                        }
                                                        System.out.println("RFC modificado exitosamente!");
                                                    }
                                                } while (band1 == true);
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 7:
                                                boolean band2 = false;
                                                do {
                                                    System.out.println("Nueva CURP");
                                                    String nuevaCurp = leer.next();
                                                    leer.nextLine();
                                                    for (Empleado empleado : empleados) {
                                                        if (empleado.getCURP() == nuevaCurp) {
                                                            band2 = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band2) {
                                                        System.out.println("La CURP ingresada ya esta en uso, coloque otra");
                                                    } else {
                                                        for (Empleado empleado : empleados) {
                                                            if (idEmpleado == empleado.id) {
                                                                empleado.setCURP(nuevaCurp);
                                                            }
                                                        }
                                                        System.out.println("CURP modificada exitosamente!");
                                                    }
                                                } while (band2 == true);

                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 8:
                                                System.out.println("Nuevo Salario");
                                                int nuevoSalario = leer.nextInt();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setSalario(nuevoSalario);
                                                    }
                                                }
                                                System.out.println("Salario modificado exitosamente!");

                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 9:
                                                System.out.println("Nueva Hora de ingreso");
                                                int nuevaHoraIngreso = leer.nextInt();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setHoraIngreso(nuevaHoraIngreso);
                                                    }
                                                }
                                                System.out.println("Hora de ingreso modificada exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 10:
                                                System.out.println("Nueva Hora de salida");
                                                int nuevaHoraSalida = leer.nextInt();
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        empleado.setHoraSalida(nuevaHoraSalida);
                                                    }
                                                }
                                                System.out.println("Hora de salida modificada exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 11:
                                                for (Empleado empleado : empleados) {
                                                    if (idEmpleado == empleado.id) {
                                                        do {
                                                            System.out.print("Seleccione nuevo Rol (1.Veterinario 2.Guia 3.Mantenimiento 4.Administracion): ");
                                                            selector = leer.nextInt();
                                                            switch (selector) {
                                                                case 1:
                                                                    empleado.setRol("Veterinario");
                                                                    break;
                                                                case 2:
                                                                    empleado.setRol("Guia");
                                                                    break;
                                                                case 3:
                                                                    empleado.setRol("Mantenimiento");
                                                                    break;
                                                                case 4:
                                                                    empleado.setRol("Administracion");
                                                                    break;
                                                                default:
                                                                    System.out.println("Seleccione incorrecta, intente nuevamente");
                                                            }
                                                        } while (selector < 1 || selector > 4);
                                                    }
                                                }
                                                System.out.println("Hora de ingreso modificada exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////

                                            default:
                                                System.out.println();

                                        }
                                    }while (selectorAtributoEmpleado != 0);
                                    break;
                                }
                                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            break;
                            case 2:
//VISITANTES
                                System.out.println("Seleccione al visitante que desea modificar (COLOQUE EL ID)");
                                System.out.println("Visitantes actuales");
                                for (Visitante visitante : visitantes) {
                                    System.out.println(String.format("ID: %d, Nombre: %s ", visitante.id, visitante.nombre));
                                }
                                int idVisitante = leer.nextInt();
                                taOcupao = false;
                                for (Visita visita : visitas) {
                                    for (Visitante visitante : visita.getVisitantes()) {
                                        if (idVisitante == visitante.id){
                                            taOcupao = true;
                                        }
                                    }
                                }

                                if (taOcupao) {
                                    System.out.println("No se puede modificar, debido a que tiene actividades");
                                }
                                //ENTRA PARA MODIFICAR AL VISITANTE
                                else {
                                    System.out.println("¿Qué desea modificar del visitante?");

                                    int selectorAtributoVisitante;
                                    do {
                                        System.out.println(
                                                "1.Id\n" +
                                                        "2.Nombre\n" +
                                                        "3.Apellidos\n" +
                                                        "4.Fecha de nacimiento\n" +
                                                        "5.CURP\n" +
                                                        "6.Fecha de registro\n" +
                                                        "0.Salir\n" );
                                        selectorAtributoVisitante = leer.nextInt();


                                        switch (selectorAtributoVisitante){
                                            case 1:
                                                boolean band = false;
                                                do {
                                                    System.out.println("Nuevo ID");
                                                    int nuevoId = leer.nextInt();
                                                    for (Visitante visitante: visitantes) {
                                                        if (visitante.id == nuevoId) {
                                                            band = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band) {
                                                        System.out.println("El ID ingresado ya esta en uso, coloque otro");
                                                    } else {
                                                        for (Visitante visitante : visitantes) {
                                                            if (idVisitante == visitante.id) {
                                                                visitante.setId(nuevoId);
                                                            }
                                                        }
                                                        System.out.println("ID modificado exitosamente!");
                                                    }
                                                } while (band == true);

                                                break;
                                            ////////////////////////////////////////////////////////////////
                                            case 2:
                                                System.out.println("Nuevo Nombre");
                                                String nuevoNombre = leer.next();
                                                leer.nextLine();
                                                for (Visitante visitante : visitantes) {
                                                    if (idVisitante == visitante.id) {
                                                        visitante.setNombre(nuevoNombre);
                                                    }
                                                }
                                                System.out.println("Nombre modificado exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 3:
                                                System.out.println("Nuevo Apellido");
                                                String nuevoApellido = leer.next();
                                                leer.nextLine();
                                                for (Visitante visitante : visitantes) {
                                                    if (idVisitante == visitante.id) {
                                                        visitante.setApellidos(nuevoApellido);
                                                    }
                                                }
                                                System.out.println("Apellido modificado exitosamente!");

                                                break;
                                            //////////////////////////////////////////////////////////////////
                                            case 4:
                                                System.out.println("Nueva Fecha de nacimiento");
                                                String nuevaFechaNacimiento = leer.next();
                                                leer.nextLine();
                                                for (Visitante visitante : visitantes) {
                                                    if (idVisitante == visitante.id) {
                                                        visitante.setFechaDeNacimiento(nuevaFechaNacimiento);
                                                    }
                                                }
                                                System.out.println("Fecha de nacimiento modificado exitosamente!");
                                                break;
                                            /////////////////////////////////////////////////////////////////

                                            case 5:
                                                boolean band2 = false;
                                                do {
                                                    System.out.println("Nueva CURP");
                                                    String nuevaCurp = leer.next();
                                                    leer.nextLine();
                                                    for (Visitante visitante : visitantes) {
                                                        if (visitante.getCURP() == nuevaCurp) {
                                                            band2 = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band2) {
                                                        System.out.println("La CURP ingresada ya esta en uso, coloque otra");
                                                    } else {
                                                        for (Visitante visitante : visitantes) {
                                                            if (idVisitante == visitante.id) {
                                                                visitante.setCURP(nuevaCurp);
                                                            }
                                                        }
                                                        System.out.println("CURP modificada exitosamente!");
                                                    }
                                                } while (band2 == true);

                                                break;
                                            /////////////////////////////////////////////////////////////////
                                            case 6:
                                                System.out.println("Nueva Fecha de registro");
                                                String nuevaFechaRegistro= leer.next();
                                                leer.nextLine();
                                                for (Visitante visitante : visitantes) {
                                                    if (idVisitante == visitante.id) {
                                                        visitante.setFechaDeRegistro(nuevaFechaRegistro);
                                                    }
                                                }
                                                System.out.println("Fecha de registro modificada exitosamente!");
                                                break;
                                            default:
                                                System.out.println();

                                        }
                                    }while (selectorAtributoVisitante != 0);

                                }
                                break;
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case 3:
                                //ANIMALES
                                System.out.println("\nSeleccione el animal que desea modificar (COLOQUE EL ID)");
                                System.out.println("Aniamles actuales");
                                for (Animales animales : animales) {
                                    System.out.println(String.format("ID: %d, Tipo de animal: %s ", animales.idAnimal, animales.getTipoAnimal()));
                                }
                                int idAnimal = leer.nextInt();
                                taOcupao = false;
                                for (Mantenimiento mantenimiento :  mantenimientos) {
                                    for (Animales animales : animales) {
                                        if (idAnimal == mantenimiento.getId_animal() ){
                                            taOcupao = true;
                                        }
                                    }
                                }

                                if (taOcupao) {
                                    System.out.println("No se puede modificar, debido a que tiene un proceso de mantenimiento");
                                }else{
                                    System.out.println("¿Qué desea modificar del animal?");

                                    int selectorAnimal;
                                    do {
                                        System.out.println(
                                                "\n1.Id\n" +
                                                        "2.Tipo de aniaml\n" +
                                                        "3.Fecha de nacimiento\n" +
                                                        "4.Llegada al zoologico\n" +
                                                        "5.Peso\n" +
                                                        "6.Enfermedades\n" +
                                                        "7.Frecuencia de alimentación\n" +
                                                        "8.Tipo de alimentacion\n" +
                                                        "9.Vacunas\n" +
                                                        "0.Salir\n" );
                                        selectorAnimal = leer.nextInt();

                                        switch (selectorAnimal){
                                            case 1:
                                                boolean band = false;
                                                do {
                                                    System.out.println("Nuevo ID");
                                                    int nuevoId = leer.nextInt();
                                                    for (Animales animales: animales) {
                                                        if (animales.idAnimal == nuevoId) {
                                                            band = true;
                                                            break;
                                                        }
                                                    }
                                                    if (band) {
                                                        System.out.println("El ID ingresado ya esta en uso, coloque otro");
                                                    } else {
                                                        for (Animales animales: animales) {
                                                            if (idAnimal == animales.idAnimal) {
                                                                animales.setIdAnimal(nuevoId);
                                                            }
                                                        }
                                                        System.out.println("ID modificado exitosamente!");
                                                    }
                                                } while (band == true);
                                                ////////////////////////////////////////////////////////////////////////
                                                break;

                                            case 2:
                                                System.out.println("Nuevo tipo de animal");
                                                String nuevoTipoAnimal = leer.next();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setTipoAnimal(nuevoTipoAnimal);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 3:
                                                System.out.println("Nueva fecha de nacimiento");
                                                String nuevaFechaNacimiento = leer.next();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setFechaNacimiento(nuevaFechaNacimiento);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 4:
                                                System.out.println("Cambiar llegada al zoologico");
                                                String nuevaLlegaZoo = leer.next();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setLlegadaZoo(nuevaLlegaZoo);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////


                                            case 5:
                                                System.out.println("Cambiar peso");
                                                float nuevoPeso = leer.nextFloat();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setPeso(nuevoPeso);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 6:
                                                System.out.println("Nueva(s) enfermedades");
                                                String nuevaEnfermedad = leer.next();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        enfermedades.add(nuevaEnfermedad);
                                                    }
                                                }

                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 7:
                                                System.out.println("Cambiar frecuencia de alimentación");
                                                int nuevaFrecuenciaAlimentacion = leer.nextInt();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setFrecuenciaAlimentacion(nuevaFrecuenciaAlimentacion);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 8:
                                                System.out.println("Cambiar tipo de alimentación");
                                                String nuevoTipoAlimentacion = leer.next();
                                                leer.nextLine();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setTipoAlimentacion(nuevoTipoAlimentacion);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            case 9:
                                                System.out.println("Cambiar si tiene vacunas (True/False");
                                                boolean nuevaVacuna = leer.nextBoolean();
                                                for (Animales animales: animales) {
                                                    if (idAnimal == animales.idAnimal){
                                                        animales.setVacunas(nuevaVacuna);
                                                    }
                                                }
                                                break;
                                            ////////////////////////////////////////////////////////////////////////

                                            default:
                                                System.out.println("Seleccione una opción correcta");
                                        }
                                    }while (selectorAnimal != 0);
                                }
                                break;
                            }
                    }while (selectorModificar != 0);
                    break;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 3:
                    int selectorEliminar;
                    do {
                        System.out.println("\n¿Que desea eliminar?\n" +
                                "1.Empleado\n" +
                                "2.Visitante\n" +
                                "3.Animales\n" +
                                "0.Salir\n" );
                        selectorEliminar = leer.nextInt();

                        switch (selectorEliminar){
                            case 1:
                                System.out.println("\nSeleccione al empleado que desea eliminar (COLOQUE EL ID)");
                                System.out.println("Empleados actuales");
                                for (Empleado empleado : empleados) {
                                    System.out.println(String.format("ID: %d, Nombre: %s ", empleado.id, empleado.nombre));
                                }
                                int idEmpleado = leer.nextInt();
                                boolean taOcupao = false;
                                for (Empleado empleado : empleados) {
                                    for (Visita visita : visitas) {
                                        if (idEmpleado == visita.idGuia) {
                                            taOcupao = true;
                                        }
                                    }
                                    for (Mantenimiento mantenimiento : mantenimientos) {
                                        if (idEmpleado == mantenimiento.idMantenimiento) {
                                            taOcupao = true;
                                        }
                                    }
                                }
                                if (taOcupao) {
                                    System.out.println("No se puede eliminar, debido a que tiene actividades");
                                }
                                else
                                {
                                    Iterator<Empleado> iterator = empleados.iterator();
                                    while (iterator.hasNext()){
                                        Empleado empleado = iterator.next();
                                        if (empleado.id == idEmpleado){
                                            iterator.remove();
                                            System.out.println("Empleado eliminado exitosamente");
                                        }
                                    }
                                }

                                break;
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case 2:
                                System.out.println("\nSeleccione al visitante que desea eliminar (COLOQUE EL ID)");
                                System.out.println("Visitantes actuales");
                                for (Visitante visitante :  visitantes) {
                                    System.out.println(String.format("ID: %d, Nombre: %s ", visitante.id, visitante.nombre));
                                }
                                int idVisitante = leer.nextInt();
                                taOcupao = false;
                                for (Visita visita : visitas) {
                                    for (Visitante visitante : visita.getVisitantes()) {
                                        if (idVisitante == visitante.id){
                                            taOcupao = true;
                                        }
                                    }
                                }

                                if (taOcupao) {
                                    System.out.println("No se puede eliminar por que esta en una visitaVii");
                                }
                                else
                                {
                                    Iterator <Visitante> iterator = visitantes.iterator();
                                    while (iterator.hasNext()){
                                        Visitante visitante = iterator.next();
                                        if (visitante.id == idVisitante){
                                            iterator.remove();
                                            System.out.println("Visitante eliminado exitosamente");
                                        }
                                    }
                                }

                                break;
                            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            case 3:
                                System.out.println("\nSeleccione al animal que desea eliminar (COLOQUE EL ID)");
                                System.out.println("Animales actuales");
                                for (Animales animales :  animales) {
                                    System.out.println(String.format("ID: %d, Tipo de animal: %s ", animales.idAnimal, animales.getTipoAnimal()));
                                }
                                int idAnimal = leer.nextInt();
                                taOcupao = false;
                                for (Mantenimiento mantenimiento :  mantenimientos) {
                                    for (Animales animales : animales) {
                                        if (idAnimal == mantenimiento.getId_animal() ){
                                            taOcupao = true;
                                        }
                                    }
                                }
                                if (taOcupao) {
                                    System.out.println("No se puede eliminar por que esta en una visitaVii");
                                }
                                else
                                {
                                    Iterator <Animales> iterator = animales.iterator();
                                    while (iterator.hasNext()){
                                        Animales animales = iterator.next();
                                        if (animales.idAnimal == idAnimal){
                                            iterator.remove();
                                            System.out.println("Animal eliminado exitosamente");
                                        }
                                    }
                                }
                                break;

                        }
                    }while (selectorEliminar != 0);
                    break;
                case 4:
                    //Consultar
                    int selectorConsultar;
                    do {
                        System.out.println("\n¿Que desea consultar?\n" +
                                "1.Empleados\n" +
                                "2.Visitantes\n" +
                                "3.Animales\n" +
                                "4.Visitas\n" +
                                "0.Salir\n" );
                        selectorConsultar = leer.nextInt();

                        switch (selectorConsultar){
                            case 1:
                                //Mostrar Empleados
                                if (empleados.isEmpty()) {
                                    System.out.println("No hay empleados registrados");
                                } else {
                                    for (Empleado empleado : empleados) {
                                        System.out.println(empleado.consultarEmpleado());
                                    }
                                }
                                break;
                            case 2:
                                //Mostrar Visitantes
                                if (visitantes.isEmpty()) {
                                    System.out.println("No hay visitantes registrados");
                                } else {
                                    for (Visitante visitante : visitantes) {
                                        System.out.println(visitante.consultarVisitante());
                                    }
                                }
                                break;
                            case 3:
                                //Mostrar Animales
                                if (animales.isEmpty()) {
                                    System.out.println("No hay animales registrados");
                                } else {
                                    for (Animales animal : animales) {
                                        System.out.println(animal.consultarAnimal());
                                    }
                                }
                                break;
                            case 4:
                                //Mostrar Visitas
                                if (visitas.isEmpty()) {
                                    System.out.println("No hay visitas registradas");
                                } else {
                                    for (Visita visita : visitas) {
                                        visita.consultarVisita();
                                    }
                                }
                                break;
                            default:
                                System.out.println("Error, introduzca una opcion valida");
                                break;
                        }
                    }while (selectorConsultar != 0);
                    break;
                default:
                    System.out.println("Error, introduzca una opcion valida");
            }
        }while (selector != 0);
        }
}
