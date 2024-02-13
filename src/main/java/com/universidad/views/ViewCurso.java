package com.universidad.views;

import com.universidad.exceptions.cursoexceptions.CursoNullException;
import com.universidad.repository.models.Curso;

public class ViewCurso extends ViewMain{
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    buscarCurso();
                    break;
                case 4:
                    modificarCurso();
                    break;
                case 5:
                    eliminarCurso();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarCurso() {
        System.out.println("Busqueda de Curso ");
        leer.nextLine();
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            Curso curso = ServiceCurso.porCodigo(codigo);
            System.out.println();
            curso.imprimir();
        } catch (CursoNullException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static Curso buscarGetCurso() {
        System.out.println("Busqueda de Curso "); 
        leer.nextLine();       
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();

        try {
            return ServiceCurso.porCodigo(codigo);

        } catch (CursoNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearCurso() {
        leer.nextLine();
        System.out.print("Ingrese el Nombre del Curso: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese la Guia Catedra del Curso: ");
        String guia_catedra = leer.nextLine();
        System.out.print("Ingrese el Codigo del Curso: ");
        String codigo = leer.nextLine();
        Curso curso = new Curso(nombre,guia_catedra,codigo);
        ServiceCurso.crear(curso);

    }

    public static void listarCursos() {
        System.out.println("Lista de Cursos");
        for (Curso curso : ServiceCurso.listar()) {
            curso.imprimir();
            System.out.println();
        }
    }

    public static void modificarCurso() {

        Curso cursoActual = buscarGetCurso();
        
        if (cursoActual != null) {
            System.out.println();
            cursoActual.imprimir();

            System.out.println("Modificar Nombre del Curso?: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre del Curso: ");
                String nuevoNombreCurso = leer.nextLine();
                cursoActual.setNombre_curso(nuevoNombreCurso);
            }    
            
            System.out.println("Modificar Guia Catedra del Curso?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre del Curso: ");
                String nuevaGuiaCatedra = leer.nextLine();
                cursoActual.setGuia_catedra(nuevaGuiaCatedra);
            }  

            System.out.println("Modificar Codigo del Curso?: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Codigo del Curso: ");
                String nuevoCodigoCurso = leer.nextLine();
                cursoActual.setCodigo_curso(nuevoCodigoCurso);
            }  
           
            ServiceCurso.editar(cursoActual);

        }

    }

    public static void eliminarCurso() {
        Curso curso = buscarGetCurso();
        if (curso != null) {
            ServiceCurso.eliminar(curso);
            System.out.println("Elmininado el Curso con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Departamento");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Curso.");
        System.out.println("2. Listar Curso.");
        System.out.println("3. Buscar Curso.");
        System.out.println("4. Modificar Curso.");
        System.out.println("5. Eliminar Curso.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
