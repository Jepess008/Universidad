package com.universidad.views;

import com.universidad.exceptions.asignaturaexceptions.AsignaturaNullException;
import com.universidad.repository.models.Asignatura;
import com.universidad.repository.models.Curso;
import com.universidad.repository.models.Docente;
import com.universidad.repository.models.Periodo;
import com.universidad.repository.models.Programa;

public class ViewAsignatura extends ViewMain {
   

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearAsignatura();
                    break;
                case 2:
                    listarAsignatura();
                    break;
                case 3:
                    buscarAsignatura();
                    break;
                case 4:
                    modificarAsignatura();
                    break;
                case 5:
                    eliminarAsignatura();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarAsignatura() {
        System.out.println("Busqueda de Asignatura ");
        leer.nextLine();
        System.out.print("Id de la Asignatura: ");
        int id_asignatura = Integer.parseInt(leer.nextLine());

        try {
            Asignatura asignatura = ServiceAsignatura.porIdAsignatura(id_asignatura);
            System.out.println();
            asignatura.imprimir();
        } catch (AsignaturaNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Asignatura buscarGetAsignatura() {
        System.out.println("Busqueda de Asignatura "); 
        leer.nextLine();       
        System.out.print("Id de la Asignatura: ");
        int asignatura = Integer.parseInt(leer.nextLine());

        try {
            return ServiceAsignatura.porIdAsignatura(asignatura);

        } catch (AsignaturaNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearAsignatura() {
        leer.nextLine();
        System.out.print("Ingrese el Nombre de la Asignatura: ");
        String nombreAsignatura = leer.nextLine();
        System.out.print("Ingrese Numero de Creditos: ");
        int creditos = leer.nextInt();
        
        System.out.print("Ingrese el ID del Docente: ");
        System.out.println("Doncentes Disponibles");
         for (Docente docente : ServiceDocente.listarDocentes()) {
                    docente.imprimirDocente();
                    System.out.println();
                } ;
        int id_docente = leer.nextInt();

        System.out.print("Ingrese el ID del Programa: ");
        System.out.println("Programas Disponibles: " );
        for (Programa programa : ServicePrograma.listaProgramas()) {
                programa.imprimirPrograma();
                System.out.println();
        } ;
        int id_programa = leer.nextInt();

        System.out.println("Ingrese el ID del Curso");
        System.out.println("Cursos Disponibles: ");
        for (Curso curso : ServiceCurso.listaCursos()) {
            curso.imprimirCurso();
            System.out.println();
        } ;
        int id_curso= leer.nextInt();
        
        System.out.println("Ingrese el ID del Periodo");
        System.out.println("Periodos Disponibles: ");
        for (Periodo periodo : ServicePeriodo.listar()) {
            periodo.imprimir();
            System.out.println();
        } ;
        int id_periodo= leer.nextInt();
        Asignatura asignatura = new Asignatura(nombreAsignatura,creditos,id_docente,id_programa,id_curso,id_periodo);
        ServiceAsignatura.crear(asignatura);

    }

    public static void listarAsignatura() {
        System.out.println("Lista de Asignaturas");
        for (Asignatura asignatura : ServiceAsignatura.listar()) {
            asignatura.imprimir();
            System.out.println();
        }
    }

    public static void modificarAsignatura() {

        Asignatura asignaturaActual = buscarGetAsignatura();
        
        if (asignaturaActual != null) {
            System.out.println();
            asignaturaActual.imprimir();

            System.out.println("Modificar Nombre de la Asignatura?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre de la Asignatura: ");
                String nuevoNombreAsignatura = leer.nextLine();
                asignaturaActual.setNombre_asignatura(nuevoNombreAsignatura);;
            }

            System.out.println("Modificar Número de creditos?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Números de Credito: ");
                int creditos = Integer.parseInt(leer.nextLine());
                asignaturaActual.setCreditos(creditos);
            }  

            System.out.println("Modificar Docente?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Id Docente: ");
                int docente = Integer.parseInt(leer.nextLine());
                asignaturaActual.setId_docente(docente);
            }  
            
            ServiceAsignatura.editar(asignaturaActual);

        }

    }

    public static void eliminarAsignatura() {
        Asignatura asignatura = buscarGetAsignatura();
        if (asignatura != null) {
            ServiceAsignatura.eliminar(asignatura);
            System.out.println("Elmininada la Asignatura con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar la Asignatura");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Asignatura.");
        System.out.println("2. Listar Asignatura.");
        System.out.println("3. Buscar Asignatura.");
        System.out.println("4. Modificar Asignatura.");
        System.out.println("5. Eliminar Asignatura.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
