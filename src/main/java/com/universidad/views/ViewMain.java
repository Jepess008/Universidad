package com.universidad.views;

import java.util.Scanner;

import com.universidad.repository.impl.implAsignatura.RepositoryAsignaturaMysqlImpl;
import com.universidad.repository.impl.implDepartamento.ReposirotyDepartamentoMysqlImp;
import com.universidad.repository.impl.implDocente.RepositoryDocenteMysqlImpl;
import com.universidad.repository.impl.implEstudiante.ReposirotyEstudianteMysqlImpl;
import com.universidad.repository.impl.implHorario.RepositoryHorarioMysqlImpl;
import com.universidad.repository.impl.implMatricula.RepositoryMatriculaMysqlImpl;
import com.universidad.repository.impl.implPeriodo.RepositoryPeriodoMysqlImpl;
import com.universidad.repository.impl.implPrograma.RepositoryProgramaMysqlImpl;
import com.universidad.repository.impl.implSalon.RepositorySalonMysqlImpl;
import com.universidad.repository.impl.implTarifas.RepositoryTarifasMysqlImpl;
import com.universidad.repository.impl.impleCurso.RepositoryCursoMysqlImpl;
import com.universidad.services.ServiceAsignatura;
import com.universidad.services.ServiceCurso;
import com.universidad.services.ServiceDepartamento;
import com.universidad.services.ServiceDocente;
import com.universidad.services.ServiceEstudiante;
import com.universidad.services.ServiceHorario;
import com.universidad.services.ServiceMatricula;
import com.universidad.services.ServicePeriodo;
import com.universidad.services.ServicePrograma;
import com.universidad.services.ServiceSalon;
import com.universidad.services.ServiceTarifa;
import com.universidad.services.impl.ServiceAsignaturaImpl;
import com.universidad.services.impl.ServiceCursoImpl;
import com.universidad.services.impl.ServiceDepartamentoImpl;
import com.universidad.services.impl.ServiceDocenteImp;
import com.universidad.services.impl.ServiceEstudianteImpl;
import com.universidad.services.impl.ServiceHorarioImpl;
import com.universidad.services.impl.ServiceMatriculaImpl;
import com.universidad.services.impl.ServicePeriodoImpl;
import com.universidad.services.impl.ServiceProgramaImpl;
import com.universidad.services.impl.ServiceSalonImpl;
import com.universidad.services.impl.ServiceTarifaImpl;


public class ViewMain {
    public static final ServiceDocente ServiceDocente = new ServiceDocenteImp(new RepositoryDocenteMysqlImpl()); 
    public static final ServiceHorario ServiceHorario= new ServiceHorarioImpl(new RepositoryHorarioMysqlImpl());
    public static final ServiceMatricula ServiceMatricula= new ServiceMatriculaImpl(new RepositoryMatriculaMysqlImpl());
    public static final ServiceEstudiante serviceEstudiante = new ServiceEstudianteImpl(new ReposirotyEstudianteMysqlImpl());
    public static final ServiceDepartamento ServiceDepartamento=new ServiceDepartamentoImpl(new ReposirotyDepartamentoMysqlImp());
    public static final ServicePrograma ServicePrograma= new ServiceProgramaImpl(new RepositoryProgramaMysqlImpl());
    public static final ServicePeriodo ServicePeriodo= new ServicePeriodoImpl(new RepositoryPeriodoMysqlImpl());
    public static final ServiceCurso ServiceCurso= new ServiceCursoImpl(new RepositoryCursoMysqlImpl());
    public static final ServiceSalon ServiceSalon= new ServiceSalonImpl(new RepositorySalonMysqlImpl());
    public static final ServiceTarifa ServiceTarifa= new ServiceTarifaImpl(new RepositoryTarifasMysqlImpl());
    public static final ServiceAsignatura ServiceAsignatura= new ServiceAsignaturaImpl(new RepositoryAsignaturaMysqlImpl());
    public static final Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {      
        int op = 0;

        do {

            op = menuMain();
            switch (op) {
                case 1:
                    ViewEstudiante.startMenu();
                    break;
                case 2:
                    ViewDocente.startMenu();
                    break;
                case 3:
                    ViewDepartamento.startMenu();
                    break;
                case 4:
                    ViewPrograma.startMenu();
                    break;
                case 5:
                    ViewPeriodo.startMenu();
                    break;
                case 6:
                    ViewCurso.startMenu();
                    break;
                case 7:
                    ViewSalon.startMenu();
                case 8:
                    ViewTarifas.startMenu();
                case 9:
                    ViewAsignatura.startMenu();
                case 10:
                    ViewHorario.startMenu();
                case 11:
                    ViewMatricula.startMenu();
                default:
                    System.out.println("Fin");
                    break;
            }

        } while (op >= 1 && op < 12);

    }

    public static int menuMain() {
        System.out.println("---Aplicación de Facturación-----");
        System.out.println("1. Modulo de Estudiante: ");
        System.out.println("2. Modulo de Docente: ");
        System.out.println("3. Modulo de Departamento: ");
        System.out.println("4. Modulo de Programa: ");
        System.out.println("5. Modulo de Periodo: ");
        System.out.println("6. Moduclo de Curso: ");
        System.out.println("7. Modulo de Salon");
        System.out.println("8: Modulo de Tarifas");
        System.out.println("9: Modulo de Asignatura");
        System.out.println("10: Modulo de Horario");
        System.out.println("11. Mattricular");
        System.out.println("12: Salir");
        return leer.nextInt();
    }

}
