package com.universidad.views;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.universidad.exceptions.estudianteexceptions.EstudianteNullException;
import com.universidad.repository.models.Estudiante;

public class ViewEstudiante extends ViewMain {

    
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearEstudiante();
                    break;
                case 2:
                    listarEstudiante();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    modificarEstudiante();
                    break;
                case 5:
                    eliminarEstudiante();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarEstudiante() {
        System.out.println("Busqueda de Estudiante ");
        leer.nextLine();
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            Estudiante estudiante = serviceEstudiante.porDocumento(documento);
            System.out.println();
            estudiante.imprimir();
        } catch (EstudianteNullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Estudiante buscarGetEstudiante() {
        System.out.println("Busqueda de Estudiante "); 
        leer.nextLine();       
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            return serviceEstudiante.porDocumento(documento);

        } catch (EstudianteNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearEstudiante() {
        leer.nextLine();
        System.out.print("Ingrese el tipo de Documento: ");
        String tipo_documento = leer.nextLine();
        System.out.print("Ingrese el Documento: ");
        String documento = leer.nextLine();
        System.out.print("Ingrese el Nombre 1: ");
        String nombre1 = leer.nextLine();
        System.out.print("Ingrese el Nombre 2: ");
        String nombre2 = leer.nextLine();
        System.out.print("Ingrese el Apellido 1: ");
        String apellido1 = leer.nextLine();
        System.out.print("Ingrese el Apellido 2: ");
        String apellido2 = leer.nextLine();
        System.out.print("Ingrese el Telefono: ");
        String telefono = leer.nextLine();
        System.out.print("Ingrese la Fecha de Nacimiento (YYYY-MM-DD): ");
        String fecha_nacimiento2 = leer.nextLine();
        LocalDate fecha_nacimiento = null;
        try {
            fecha_nacimiento = LocalDate.parse(fecha_nacimiento2);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Utilice el formato YYYY-MM-DD.");
            return;
        }
        System.out.print("Ingrese el Genero: ");
        String genero = leer.nextLine();
        System.out.print("Ingrese el ID de la dirección: ");
        int idDireccion = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el ID de la Ciudad: ");
        int idCiudad = Integer.parseInt(leer.nextLine());
        System.out.print("Ingrese el Tipo de Persona: ");
        String tipo_persona = leer.nextLine();
        Estudiante estudiante = new Estudiante(tipo_documento, documento, nombre1, nombre2, apellido1, apellido2, telefono, fecha_nacimiento,genero,idDireccion, idCiudad, tipo_persona );
        serviceEstudiante.crear(estudiante);

    }

    public static void listarEstudiante(){
        System.out.println("Lista de Docente");
        for (Estudiante estudiante : serviceEstudiante.listar()) {
            estudiante.imprimir();
            System.out.println();
        }
    }

    public static void modificarEstudiante() {

        Estudiante estudianteActual = buscarGetEstudiante();

        if (estudianteActual != null) {
            System.out.println();
            estudianteActual.imprimir();

            System.out.println("Modificar primer nombre: si o no? ");
            String opcion = leer.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Primer Nombre: ");
                String nuevoNombre = leer.nextLine();
                estudianteActual.setNombre1(nuevoNombre);
            }

            System.out.println("Modificar segundo nombre: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Segundo Nombre: ");
                String nuevoNombre2 = leer.nextLine();
                estudianteActual.setNombre2(nuevoNombre2);
            }

            System.out.println("Modificar Primer Apellido: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Primer Apellido: ");
                String nuevoApellido1 = leer.nextLine();
                estudianteActual.setApellido1(nuevoApellido1);
            }

            System.out.println("Modificar Segundo Apellido: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Segundo Apellido: ");
                String nuevoApellido2 = leer.nextLine();
                estudianteActual.setApellido2(nuevoApellido2);
            }

            System.out.println("Modificar Telefono: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Telefono: ");
                String nuevoTelefono = leer.nextLine();
                estudianteActual.setTelefono(nuevoTelefono);
            }

            System.out.println("Modificar genero: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Genero: ");
                String nuevoGenero = leer.nextLine();
                estudianteActual.setGenero(nuevoGenero);
            }
           
            serviceEstudiante.editar(estudianteActual);

        }

    }

    public static void eliminarEstudiante() {
        Estudiante estudiante = buscarGetEstudiante();
        if (estudiante != null) {
            serviceEstudiante.eliminar(estudiante);
            System.out.println("Elmininado el Estudiante con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el cliente");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Estudiante.");
        System.out.println("2. Listar Estudiante.");
        System.out.println("3. Buscar Estudiante.");
        System.out.println("4. Modificar Estudiante.");
        System.out.println("5. Eliminar Estudiante.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

}
