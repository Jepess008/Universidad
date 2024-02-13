package com.universidad.views;

import com.universidad.exceptions.departamentoexceptions.DepartamentoNullException;

import com.universidad.repository.models.Departamento;

public class ViewDepartamento extends ViewMain {
    
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearDepartamento();
                    break;
                case 2:
                    listarDepartamentos();
                    break;
                case 3:
                    buscarDepartamento();
                    break;
                case 4:
                    modificarDepartamento();
                    break;
                case 5:
                    eliminarDepartamento();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarDepartamento() {
        System.out.println("Busqueda de Departamento ");
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        try {
            Departamento departamento = ServiceDepartamento.porNombre(nombre);
            System.out.println();
            departamento.imprimir();
        } catch (DepartamentoNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Departamento buscarGetDepartamento() {
        System.out.println("Busqueda de Departamento "); 
        leer.nextLine();       
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        try {
            return ServiceDepartamento.porNombre(nombre);

        } catch (DepartamentoNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearDepartamento() {
        leer.nextLine();
        System.out.print("Ingrese el Nombre del Departamento: ");
        String nombre = leer.nextLine();
        Departamento departamento = new Departamento(nombre);
        ServiceDepartamento.crear(departamento);

    }

    public static void listarDepartamentos() {
        System.out.println("Lista de Departamentos");
        for (Departamento departamento : ServiceDepartamento.listar()) {
            departamento.imprimir();
            System.out.println();
        }
    }

    public static void modificarDepartamento() {

        Departamento departamentoActual = buscarGetDepartamento();
        
        if (departamentoActual != null) {
            System.out.println();
            departamentoActual.imprimir();

            System.out.println("Modificar Nombre?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre Departamento: ");
                String nuevoDepartamento = leer.nextLine();
                departamentoActual.setNombre_departamento(nuevoDepartamento);
            }            
           
            ServiceDepartamento.editar(departamentoActual);

        }

    }

    public static void eliminarDepartamento() {
        Departamento departamento = buscarGetDepartamento();
        if (departamento != null) {
            ServiceDepartamento.eliminar(departamento);
            System.out.println("Elmininado el Departamento con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Departamento");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Departamento.");
        System.out.println("2. Listar Departamento.");
        System.out.println("3. Buscar Departamento.");
        System.out.println("4. Modificar Departamento.");
        System.out.println("5. Eliminar Departamento.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}

