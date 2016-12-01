/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

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
       Hospital hosp=new Hospital();
       Scanner sc=new Scanner(System.in);
       hosp.cargarDatos();
       //System.out.println(hosp.getS().getCedula());
        
            System.out.println("\t\t\tSistema Hospitalario");
            System.out.print("\nIngrese su cedula: ");
            
            String ci;
            ci=sc.nextLine();
            
            int opc;
            opc=hosp.buscar(ci);
            
            //System.out.println(opc);
               
            switch(opc){
                case 1://secretario
                    System.out.println("Bienvenido Sr."+hosp.getS().getNombre()+" "+hosp.getS().getApellido()+"\n");
                    System.out.print("1)Ingresar Nuevo Medico\n2)Ingresar Nuevo Paciente\n3)Ver Lista de Medicos\n4)Ver Lista de Pacientes\n5)Salir\n\nEscoja una opcion: ");
                    int x=sc.nextInt();

                    switch(x){
                        case 1:
                            Medico a=new Medico();
                            hosp.getS().registrarNuevoMedico(hosp.getM(),a);
                            break; 
                        case 2:
                           Paciente b=new Paciente();
                           hosp.getS().registrarNuevoPaciente(hosp.getP(),b);
                            break; 
                            
                        case 3:
                            Medico c=new Medico();
                            hosp.getS().verListadeMedicos(hosp.getM(),c);
                            break;
                        case 4:
                             Paciente d=new Paciente();
                             hosp.getS().verListadePacientes (hosp.getP(),d);
                        default: 
                            break;
                    }

                    break;
                case 2://medico
                    int pos=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Dr."+hosp.getM().get(pos).getNombre()+" "+hosp.getM().get(pos).getApellido()+"\n");
                    System.out.print("1)Ver Pacientes Asignados\n2)Registrar Atencion a un Paciente\n3)Editar Historias Clinicas\n4)Salir\n\nEscoja una opcion: ");
                    int y=sc.nextInt();

                    switch(y){
                        case 1:
                            hosp.getM().get(pos).verPacientes(hosp.getP());
                            break;
                        case 2:
                            hosp.getM().get(pos).atenderPaciente(hosp);
                            break;
                        case 3:
                            break;
                        default: 
                            break;
                    }
                    break;
                case 3://paciente
                    int pos2=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Sr."+hosp.getP().get(pos2).getNombre()+" "+hosp.getP().get(pos2).getApellido());
                    System.out.print("\n1)Agendar una cita\n2)Ver Historia Clinica\n3)Visualisar Informacion de Pagos\n4)Salir\n\nEscoja una opcion: ");
                    int z=sc.nextInt();

                    switch(z){
                        case 1:
                            
                        case 2:
                        case 3:
                        default: 
                            break;
                    }
                    break;
                default:
                    System.out.print("\nUsuario no encontrado\n");
            }
         
      
    }
    
}
