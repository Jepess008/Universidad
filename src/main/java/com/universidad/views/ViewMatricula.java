package com.universidad.views;

import com.universidad.repository.models.Asignatura;
import com.universidad.repository.models.Estudiante;
import com.universidad.repository.models.Matricula;
import com.universidad.repository.models.Periodo;

public class ViewMatricula extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearMatricula();
                    break;
                case 2:
                    listarMatricula();
                    break;
                   
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 3);

    }

     public static void crearMatricula() {
        leer.nextLine();
        System.out.print("Ingrese el Id del Estudiante: ");
        System.out.println("Lista Estudiantes: ");
        for (Estudiante estudiante : serviceEstudiante.listar()) {
            estudiante.imprimirEstudiante();
            System.out.println();
        };
        int id_estudiante  = leer.nextInt();

        System.out.print("Ingrese el Id de la Asignatura: ");
        System.out.println("Lista de Asignaturas: ");
        for (Asignatura asignatura : ServiceAsignatura.listar()) {
            asignatura.imprimirAsignaturas();
            System.out.println();
        };
        int id_asignatura = leer.nextInt();

        System.out.print("Ingrese el Id del Periodo: ");
        System.out.println("Lista de Periodos");
        for (Periodo periodo : ServicePeriodo.listar()) {
            periodo.imprimir();
            System.out.println();
        };
        int id_periodo = leer.nextInt();
        
        Matricula matricula=new Matricula(id_estudiante,id_asignatura,id_periodo);
        ServiceMatricula.matricular(matricula);
    }

    public static void listarMatricula() {
        System.out.println("Lista de Matriculas");
        for (Matricula matricula : ServiceMatricula.listar()) {
            matricula.imprimir();
            System.out.println();
        }
    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Matricula.");
        System.out.println("2. Listar Matriculas3.");        
        System.out.println("3. Salir ");
        return leer.nextInt();
    }
}
