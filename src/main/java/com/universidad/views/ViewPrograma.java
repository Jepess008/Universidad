package com.universidad.views;

import com.universidad.exceptions.programaexceptions.ProgramaNullException;
import com.universidad.repository.models.Programa;

public class ViewPrograma extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearPrograma();
                    break;
                case 2:
                    listarProgramas();
                    break;
                case 3:
                    buscarPrograma();
                    break;
                case 4:
                    modificarPrograma();
                    break;
                case 5:
                    eliminarPrograma();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarPrograma() {
        System.out.println("Busqueda de Programa ");
        leer.nextLine();
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            Programa programa = ServicePrograma.porCodigo(codigo);
            System.out.println();
            programa.imprimir();
        } catch (ProgramaNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Programa buscarGetPrograma() {
        System.out.println("Busqueda de Programa "); 
        leer.nextLine();       
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            return ServicePrograma.porCodigo(codigo);

        } catch (ProgramaNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearPrograma() {
        leer.nextLine();
        System.out.print("Ingrese el Nombre del Programa: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese el Nivel del Programa: ");
        String nivel = leer.nextLine();
        System.out.print("Ingrese el Codigo del Programa: ");
        String codigo = leer.nextLine();
        Programa programa = new Programa(nombre,nivel,codigo);
        ServicePrograma.crear(programa);

    }

    public static void listarProgramas() {
        System.out.println("Lista de Programas");
        for (Programa programa : ServicePrograma.listar()) {
            programa.imprimir();
            System.out.println();
        }
    }

    public static void modificarPrograma() {

        Programa programaActual = buscarGetPrograma();
        
        if (programaActual != null) {
            System.out.println();
            programaActual.imprimir();

            System.out.println("Modificar Nombre del Programa?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre del Programa: ");
                String nuevoNombrePrograma = leer.nextLine();
                programaActual.setNombre_programa(nuevoNombrePrograma);
            }    
            
            System.out.println("Modificar Nivel del Programa?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre del Programa: ");
                String nuevonivelPrograma = leer.nextLine();
                programaActual.setNivel(nuevonivelPrograma);
            }  

            System.out.println("Modificar Codigo del Programa?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Codigo del Programa: ");
                String nuevoCodigoPrograma = leer.nextLine();
                programaActual.setCodigo_programa(nuevoCodigoPrograma);
            }  
           
            ServicePrograma.editar(programaActual);

        }

    }

    public static void eliminarPrograma() {
        Programa programa = buscarGetPrograma();
        if (programa != null) {
            ServicePrograma.eliminar(programa);
            System.out.println("Elmininado el Programa con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Departamento");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Programa.");
        System.out.println("2. Listar Programa.");
        System.out.println("3. Buscar Programa.");
        System.out.println("4. Modificar Programa.");
        System.out.println("5. Eliminar Programa.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
