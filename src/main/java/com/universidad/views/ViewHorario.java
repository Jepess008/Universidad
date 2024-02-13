package com.universidad.views;


import com.universidad.repository.models.Asignatura;
import com.universidad.repository.models.Horario;
import com.universidad.repository.models.Salon;

public class ViewHorario extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearHorario();
                    break;
                case 2:
                    listarHorario();
                    break;
                   
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 5);

    }

    

    public static void crearHorario() {
        leer.nextLine();
        System.out.print("Ingrese el dia de la clase: ");
        String dia = leer.nextLine();
        System.out.print("Ingrese el Inicio de la Clase: ");
        String inicio = leer.nextLine();
        System.out.print("Ingrese el Final de la Clase: ");
        String finalclase = leer.nextLine();
        System.out.print("Ingrese el Id del Salon : ");
        System.out.println("Salones Disponibles: ");
        for (Salon salon : ServiceSalon.listarSalones()) {
            salon.imprimir();
            System.out.println();
        };
        int id_salon=leer.nextInt();
        System.out.println("Ingrese el Id de la Asignatura: ");
        System.out.println("Asignaturas Disponibles: ");
        for (Asignatura asignatura : ServiceAsignatura.listar()) {
            asignatura.imprimirAsignaturas();
            System.out.println();
        };
        int id_asignatura=leer.nextInt();
        Horario horario=new Horario(dia,inicio,finalclase,id_salon,id_asignatura);
        ServiceHorario.crear(horario,id_salon,id_asignatura);

    }

    public static void listarHorario() {
        System.out.println("Lista de Horarios");
        for (Horario horario : ServiceHorario.listar()) {
            horario.imprimir();
            System.out.println();
        }
    }




    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Horario.");
        System.out.println("2. Listar Horario.");        
        System.out.println("5. Salir ");
        return leer.nextInt();
    }
}
