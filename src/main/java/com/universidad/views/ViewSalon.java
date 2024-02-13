package com.universidad.views;

import com.universidad.exceptions.salonexceptions.SalonNullException;
import com.universidad.repository.models.Salon;

public class ViewSalon extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearSalon();
                    break;
                case 2:
                    listarSalones();
                    break;
                case 3:
                    buscarSalon();
                    break;
                case 4:
                    modificarSalon();
                    break;
                case 5:
                    eliminarSalon();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarSalon() {
        System.out.println("Busqueda de Salon ");
        leer.nextLine();
        System.out.print("Serial del Salon: ");
        String serial_salon = leer.nextLine();

        try {
            Salon salon = ServiceSalon.porSalon(serial_salon);
            System.out.println();
            salon.imprimir();
        } catch (SalonNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Salon buscarGetSalon() {
        System.out.println("Busqueda de Salon "); 
        leer.nextLine();       
        System.out.print("Serial del Salon: ");
        String serial = leer.nextLine();

        try {
            return ServiceSalon.porSalon(serial);

        } catch (SalonNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearSalon() {
        leer.nextLine();
        System.out.print("Ingrese el Cupo del Salon: ");
        int cupo = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el Id del Edificio al que pertenece: ");
        int edificio = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el Piso del Salon: ");
        int piso = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el Serial del Salon: ");
        String serial = leer.nextLine();
        Salon salon = new Salon(cupo,edificio,piso,serial);
        ServiceSalon.crear(salon,0);

    }

    public static void listarSalones() {
        System.out.println("Lista de Salones");
        for (Salon salon : ServiceSalon.listar()) {
            salon.imprimir();
            System.out.println();
        }
    }

    public static void modificarSalon() {

        Salon salonActual = buscarGetSalon();
        
        if (salonActual != null) {
            System.out.println();
            salonActual.imprimir();

            System.out.println("Modificar Cupo del Salon?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Cupo del Salon: ");
                int nuevoCupo = Integer.parseInt(leer.nextLine());
                salonActual.setCupo(nuevoCupo);
            }    
            
           
            ServiceSalon.editar(salonActual);

        }

    }

    public static void eliminarSalon() {
        Salon salon = buscarGetSalon();
        if (salon != null) {
            ServiceSalon.eliminar(salon);
            System.out.println("Elmininado el Salon con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Departamento");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Salon.");
        System.out.println("2. Listar Salon.");
        System.out.println("3. Buscar Salon.");
        System.out.println("4. Modificar Salon.");
        System.out.println("5. Eliminar Salon.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
