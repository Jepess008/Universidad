package com.universidad.views;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.universidad.exceptions.docenteexceptions.DocenteNullException;

import com.universidad.repository.models.Docente;


public class ViewDocente extends ViewMain {
    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearDocente();
                    break;
                case 2:
                    listarDocente();
                    break;
                case 3:
                    buscarDocente();
                    break;
                case 4:
                    modificarDocente();
                    break;
                case 5:
                    eliminarDocente();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static void buscarDocente() {
        System.out.println("Busqueda de Docente ");
        leer.nextLine();
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            Docente docente = ServiceDocente.porDocumento(documento);
            System.out.println();
            docente.imprimir();
        } catch (DocenteNullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Docente buscarGetDocente() {
        System.out.println("Busqueda de Docente "); 
        leer.nextLine();       
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            return ServiceDocente.porDocumento(documento);

        } catch (DocenteNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearDocente() {
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
        Docente docente = new Docente(tipo_documento, documento, nombre1, nombre2, apellido1, apellido2, telefono, fecha_nacimiento,genero,idDireccion, idCiudad, tipo_persona );
        ServiceDocente.crear(docente);

    }

    public static void listarDocente() {
        System.out.println("Lista de Docente");
        for (Docente docente : ServiceDocente.listar()) {
            docente.imprimir();
            System.out.println();
        }
    }

    public static void modificarDocente() {

        Docente docenteActual = buscarGetDocente();
        
        if (docenteActual != null) {
            System.out.println();
            docenteActual.imprimir();

            System.out.println("Modificar Tipo de Documento: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Tipo de Documento: ");
                String nuevoTipoDocumento = leer.nextLine();
                docenteActual.setTipo_documento(nuevoTipoDocumento);
            }


            System.out.println("Modificar primer nombre: si o no? ");
            opcion = leer.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Primer Nombre: ");
                String nuevoNombre = leer.nextLine();
                docenteActual.setNombre1(nuevoNombre);
            }

            System.out.println("Modificar segundo nombre: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Segundo Nombre: ");
                String nuevoNombre2 = leer.nextLine();
                docenteActual.setNombre2(nuevoNombre2);
            }

            System.out.println("Modificar Primer Apellido: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Primer Apellido: ");
                String nuevoApellido1 = leer.nextLine();
                docenteActual.setApellido1(nuevoApellido1);
            }

            System.out.println("Modificar Segundo Apellido: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Segundo Apellido: ");
                String nuevoApellido2 = leer.nextLine();
                docenteActual.setApellido2(nuevoApellido2);
            }

            System.out.println("Modificar Telefono: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Telefono: ");
                String nuevoTelefono = leer.nextLine();
                docenteActual.setTelefono(nuevoTelefono);
            }

            System.out.println("Modificar genero: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Genero: ");
                String nuevoGenero = leer.nextLine();
                docenteActual.setGenero(nuevoGenero);
            }

            
           
            ServiceDocente.editar(docenteActual);

        }

    }

    public static void eliminarDocente() {
        Docente docente = buscarGetDocente();
        if (docente != null) {
            ServiceDocente.eliminar(docente);
            System.out.println("Elmininado el Docente con exito");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Docente");
        }

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear Docente.");
        System.out.println("2. Listar Docente.");
        System.out.println("3. Buscar Docente.");
        System.out.println("4. Modificar Docente.");
        System.out.println("5. Eliminar Docente.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }
}
