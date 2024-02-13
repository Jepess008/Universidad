package com.universidad.views;

import com.universidad.exceptions.tarifaexceptions.TarifaNullException;
import com.universidad.repository.models.Tarifas;

public class ViewTarifas extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearTarifa();
                    break;
                case 2:
                    listarTarifas();
                    break;
                case 3:
                    buscarTarifa();
                    break;
                case 4:
                    modificarTarifa();
                    break;
                case 5:
                    eliminarTarifa();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarTarifa() {
        System.out.println("Busqueda de Tarifa ");
        leer.nextLine();
        System.out.print("Id de la Tarifa: ");
        int tarifa = Integer.parseInt(leer.nextLine());

        try {
            Tarifas tarifas = ServiceTarifa.porIdTarifas(tarifa);
            System.out.println();
            tarifas.imprimir();
        } catch (TarifaNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Tarifas buscarGeTarifas() {
        System.out.println("Busqueda de Tarifa "); 
        leer.nextLine();       
        System.out.print("Id de la Tarifa: ");
        int tarifa = Integer.parseInt(leer.nextLine());

        try {
            return ServiceTarifa.porIdTarifas(tarifa);

        } catch (TarifaNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearTarifa() {
        leer.nextLine();
        System.out.print("Ingrese el ID del Periodo: ");
        int idprograma = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese ID del Programa: ");
        int idperiodo = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el Valor de la Tarifa por Credito: ");
        int valor = Integer.parseInt(leer.nextLine());
        Tarifas tarifas = new Tarifas(idprograma,idperiodo,valor);
        ServiceTarifa.crear(tarifas);

    }

    public static void listarTarifas() {
        System.out.println("Lista de Tarifas");
        for (Tarifas tarifas : ServiceTarifa.listar()) {
            tarifas.imprimir();
            System.out.println();
        }
    }

    public static void modificarTarifa() {

        Tarifas tarifaActual = buscarGeTarifas();
        
        if (tarifaActual != null) {
            System.out.println();
            tarifaActual.imprimir();

            System.out.println("Modificar Valor del Credito?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Valor del Credito: ");
                int nuevoValor = Integer.parseInt(leer.nextLine());
                tarifaActual.setValor_credito(nuevoValor);
            }    
            
            ServiceTarifa.editar(tarifaActual);

        }

    }

    public static void eliminarTarifa() {
        Tarifas tarifas = buscarGeTarifas();
        if (tarifas != null) {
            ServiceTarifa.eliminar(tarifas);
            System.out.println("Elmininada la Tarifa con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Departamento");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Tarifa.");
        System.out.println("2. Listar Tarifa.");
        System.out.println("3. Buscar Tarifa.");
        System.out.println("4. Modificar Tarifa.");
        System.out.println("5. Eliminar Tarifa.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
