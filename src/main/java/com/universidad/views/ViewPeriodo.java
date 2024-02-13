package com.universidad.views;


import com.universidad.exceptions.periodoexceptions.PeriodoNullException;
import com.universidad.repository.models.Periodo;


public class ViewPeriodo extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearPeriodo();
                    break;
                case 2:
                    listarPeriodo();
                    break;
                case 3:
                    buscarPeriodo();
                    break;
                case 4:
                    modificarPeriodo();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 5);

    }

    public static void buscarPeriodo() {
        System.out.println("Busqueda de Periodo ");
        leer.nextLine();
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            Periodo periodo = ServicePeriodo.porSemestre(codigo);
            System.out.println();
            periodo.imprimir();
        } catch (PeriodoNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Periodo buscarGetPeriodo() {
        System.out.println("Busqueda de Periodo "); 
        leer.nextLine();       
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            return ServicePeriodo.porSemestre(codigo);

        } catch (PeriodoNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearPeriodo() {
        leer.nextLine();
        System.out.print("Ingrese el Codigo del Periodo: ");
        String nombre = leer.nextLine();
        Periodo periodo = new Periodo(nombre);
        ServicePeriodo.crear(periodo);

    }

    public static void listarPeriodo() {
        System.out.println("Lista de Periodos");
        for (Periodo periodo : ServicePeriodo.listar()) {
            periodo.imprimir();
            System.out.println();
        }
    }

    public static void modificarPeriodo() {

        Periodo periodoActual = buscarGetPeriodo();
        
        if (periodoActual != null) {
            System.out.println();
            periodoActual.imprimir();

            System.out.println("Modificar Codigo del Periodo?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Codigo del Periodo: ");
                String nuevoCodigo = leer.nextLine();
                periodoActual.setCodigo_periodo(nuevoCodigo);
            }    
            
           
            ServicePeriodo.editar(periodoActual);

        }

    }


    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Periodo.");
        System.out.println("2. Listar Periodo.");
        System.out.println("3. Buscar Periodo.");
        System.out.println("4. Modificar Periodo.");
        System.out.println("5. Salir ");
        return leer.nextInt();
    }
}
