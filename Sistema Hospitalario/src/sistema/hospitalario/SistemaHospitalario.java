/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author USRKAP
 */
public class SistemaHospitalario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Hospital hosp = new Hospital();
        Scanner sc = new Scanner(System.in);
        cargarDatos(hosp);
        boolean b = false;
        int opc;

        System.out.println("\t\t\tSistema Hospitalario");
        while (b == false) {

            System.out.println("\nEscriba su cedula para acceder o 'SALIR' para cerrar el programa");
            System.out.print("Ingrese a continuacion: ");

            String ci = sc.nextLine();

            ci = ci.toUpperCase();
            if ("SALIR".equals(ci)) {
                b = true;
                continue;
            }

            opc = buscar(ci, hosp);

            switch (opc) {

                case 1://secretario

                    System.out.println("\n   Bienvenido Sr." + hosp.getSecretario().getNombre() + " " + hosp.getSecretario().getApellido() + "\n");
                    int x = -1;
                    do {
                        System.out.print("1)Ingresar Nuevo Medico\n2)Ingresar Nuevo Paciente\n3)Ver Lista de Medicos\n4)Ver Lista de Pacientes\n5)Salir\n\nEscoja una opcion: ");
                        try {
                            x = sc.nextInt();

                            switch (x) {
                                case 1:
                                    Medico a = new Medico();
                                    hosp.getSecretario().registrarNuevoMedico(hosp.getM(), a);
                                    break;
                                case 2:
                                    Paciente p = new Paciente();
                                    hosp.getSecretario().registrarNuevoPaciente(hosp.getP(), p);
                                    break;

                                case 3:
                                    Medico c = new Medico();
                                    hosp.getSecretario().verListadeMedicos(hosp.getM(), c);
                                    break;
                                case 4:
                                    Paciente d = new Paciente();
                                    hosp.getSecretario().verListadePacientes(hosp.getP(), d);
                                    break;
                                case 5:
                                    System.out.print("\n   Presione enter para continuar...");
                                    break;
                                default:
                                    System.out.println("   Opción inválida, vuelva a ingresar");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("   Opción inválida, vuelva a ingresar");
                        }
                        sc.nextLine();
                    } while (x != 5);
                    break;

                case 2://medico

                    int pos = buscarPoscicion(ci, hosp);
                    System.out.println("\n   Bienvenid@ Dr." + hosp.getM().get(pos).getNombre() + " " + hosp.getM().get(pos).getApellido() + "\n");
                    int y = -1;
                    do {
                        System.out.print("1)Ver Pacientes Asignados\n2)Registrar Atencion a un Paciente\n3)Editar Historias Clinicas\n4)Salir\n\nEscoja una opcion: ");
                        try {
                            y = sc.nextInt();

                            switch (y) {
                                case 1:
                                    hosp.getM().get(pos).verPacientes(hosp.getP());
                                    break;
                                case 2:
                                    hosp.getM().get(pos).atenderPaciente(hosp);
                                    break;
                                case 3:
                                    hosp.getM().get(pos).editarPaciente(hosp);
                                    break;
                                case 4:
                                    System.out.print("\n   Presione enter para continuar...");
                                    break;
                                default:
                                    System.out.println("\n   Opción inválida, vuelva a ingresar\n");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\n   Opción inválida, vuelva a ingresar\n");
                        }
                        sc.nextLine();
                    } while (y != 4);
                    break;

                case 3://paciente

                    int pos2 = buscarPoscicion(ci, hosp);
                    System.out.println("\n   Bienvenid@ Sr." + hosp.getP().get(pos2).getNombre() + " " + hosp.getP().get(pos2).getApellido());
                    int z = -1;
                    do {
                        System.out.print("\n1)Agendar una cita\n2)Ver Historia Clinica\n3)Visualisar Informacion de Pagos\n4)Salir\n\nEscoja una opcion: ");
                        try {
                            z = sc.nextInt();

                            switch (z) {
                                case 1: //Agendar Cita
                                    hosp.getP().get(pos2).verMedico(hosp.getM());
                                    hosp.getP().get(pos2).agendarTurno();
                                    break;
                                case 2: // Ver historia Clínica
                                    System.out.println("\n\tHistoria Clinica:\n\n" + hosp.getP().get(pos2).getHistoriaClinica().toString());
                                    break;
                                case 3: // Ver Turno
                                    System.out.println("Su turno esta agendado para: " + hosp.getP().get(pos2).getTurno());
                                    break;
                                case 4: //Salir
                                    System.out.print("\n   Presione enter para continuar...");
                                    break;
                                default:
                                    System.out.println("Opción inválida, vuelva a ingresar");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("   Opción inválida, vuelva a ingresar");
                        }
                        sc.nextLine();
                    } while (z != 4);
                    break;

                default:
                    System.out.print("\n\tCedula inválida!, presione enter para continuar...");
            }
            sc.nextLine();
            System.out.print("\n\n\n\n");
        }
    }

    public static int buscar(String cadena, Hospital h) {

        int opcion = 0;
        if (cadena.equals(h.getSecretario().getCedula())) {
            opcion = 1;
        }
        for (int i = 0; i < h.getM().size(); i++) {
            if (cadena.equals(h.getM().get(i).getCedula())) {
                opcion = 2;
            }
        }
        for (int i = 0; i < h.getP().size(); i++) {
            if (cadena.equals(h.getP().get(i).getCedula())) {
                opcion = 3;
            }
        }

        return opcion;
    }

    public static int buscarPoscicion(String cadena, Hospital h) {

        for (int i = 0; i < h.getM().size(); i++) {
            if (cadena.equals(h.getM().get(i).getCedula())) {
                return i;
            }
        }
        for (int i = 0; i < h.getP().size(); i++) {
            if (cadena.equals(h.getP().get(i).getCedula())) {
                return i;
            }
        }
        return -1;
    }

    public static void cargarDatos(Hospital h) {
        //Carga de Secretario
        h.getSecretario().setNombre("Juan");
        h.getSecretario().setApellido("Vasconez");
        h.getSecretario().setCedula("0123456789");

        //Medicos
        for (int i = 0; i < 2; i++) {
            Medico med = new Medico();
            h.getM().add(med);
        }
        h.getM().get(0).setNombre("Enrique");
        h.getM().get(0).setApellido("Vasconez");
        h.getM().get(0).setCedula("1234567890");
        h.getM().get(0).setEspecialidad("Cardiologo");
        h.getM().get(1).setNombre("Javier");
        h.getM().get(1).setApellido("Velazques");
        h.getM().get(1).setCedula("1234567891");
        h.getM().get(1).setEspecialidad("Pediatra");

        //Pacientes
        for (int i = 0; i < 6; i++) {
            Paciente pac = new Paciente();
            h.getP().add(pac);
        }
        h.getP().get(0).setNombre("Enrique");
        h.getP().get(0).setApellido("Rivera");
        h.getP().get(0).setCedula("1111111111");
        h.getP().get(0).setSexo("M");
        h.getP().get(0).setMedico(h.getM().get(0));
        h.getP().get(1).setNombre("Juan");
        h.getP().get(1).setApellido("Perez");
        h.getP().get(1).setCedula("2222222222");
        h.getP().get(1).setSexo("M");
        h.getP().get(1).setMedico(h.getM().get(0));
        h.getP().get(2).setNombre("Sebastian");
        h.getP().get(2).setApellido("Hidalgo");
        h.getP().get(2).setCedula("333333333");
        h.getP().get(2).setSexo("M");
        h.getP().get(2).setMedico(h.getM().get(1));
        h.getP().get(3).setNombre("Jose");
        h.getP().get(3).setApellido("Rojas");
        h.getP().get(3).setCedula("4444444444");
        h.getP().get(3).setSexo("M");
        h.getP().get(3).setMedico(h.getM().get(1));
        h.getP().get(4).setNombre("Maria");
        h.getP().get(4).setApellido("Gonzalez");
        h.getP().get(4).setCedula("5555555555");
        h.getP().get(4).setSexo("F");
        h.getP().get(4).setMedico(h.getM().get(0));

    }
}
