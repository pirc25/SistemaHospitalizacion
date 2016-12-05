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
        boolean b=false;
        int opc;
        
        System.out.println("\t\t\tSistema Hospitalario");
        while(b==false){ 
            
            b=true;
            System.out.print("\nIngrese su cedula: ");            
            String ci=sc.nextLine();
                        
            opc=buscar(ci,hosp);
               
            switch(opc){
                
                case 1://secretario
                    
                    System.out.println("Bienvenido Sr."+hosp.getS().getNombre()+" "+hosp.getS().getApellido()+"\n");
                    int x;
                    do{
                        System.out.print("1)Ingresar Nuevo Medico\n2)Ingresar Nuevo Paciente\n3)Ver Lista de Medicos\n4)Ver Lista de Pacientes\n5)Salir\n\nEscoja una opcion: ");
                        x=sc.nextInt();

                        switch(x){
                            case 1:
                                Medico a=new Medico();
                                hosp.getS().registrarNuevoMedico(hosp.getM(),a);
                                break; 
                            case 2:
                               Paciente p=new Paciente();
                               hosp.getS().registrarNuevoPaciente(hosp.getP(),p);
                                break; 

                            case 3:
                                Medico c=new Medico();
                                hosp.getS().verListadeMedicos(hosp.getM(),c);
                                break;
                            case 4:
                                 Paciente d=new Paciente();
                                 hosp.getS().verListadePacientes (hosp.getP(),d);
                                 break;
                            case 5:
                                break;
                            default: 
                                System.out.println("Opción inválida, vuelva a ingresar");
                                break;
                        }
                    }while(x!=5);
                break;
                
                case 2://medico
                    
                    int pos=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Dr."+hosp.getM().get(pos).getNombre()+" "+hosp.getM().get(pos).getApellido()+"\n");
                    int y;
                    do{
                        System.out.print("1)Ver Pacientes Asignados\n2)Registrar Atencion a un Paciente\n3)Editar Historias Clinicas\n4)Salir\n\nEscoja una opcion: ");
                        y=sc.nextInt();

                        switch(y){
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
                                break;
                            default: 
                                System.out.println("Opción inválida, vuelva a ingresar");
                                break;
                        }
                    }while(y!=4);
                break;
                
                case 3://paciente
                    
                    int pos2=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Sr."+hosp.getP().get(pos2).getNombre()+" "+hosp.getP().get(pos2).getApellido());
                    int z;
                    do{
                        System.out.print("\n1)Agendar una cita\n2)Ver Historia Clinica\n3)Visualisar Informacion de Pagos\n4)Salir\n\nEscoja una opcion: ");

                        z=sc.nextInt();

                        switch(z){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opción inválida, vuelva a ingresar");
                                break;
                        }
                    }while(z!=4);
                break;
                
                default:
                    System.out.println("\nCedula inválida, vuelva a ingresar");
                    b=false;
            }
        } 
    }
    
    public static int buscar(String cadena, Hospital h){
        int opcion=0;
        if(cadena.equals(h.getS().getCedula())){
            opcion=1;
        }
        for(int i=0;i<h.getM().size();i++){
            if(cadena.equals(h.getM().get(i).getCedula())){
                opcion=2;
            }
        }
        for(int i=0;i<h.getP().size();i++){
            if(cadena.equals(h.getP().get(i).getCedula())){
                opcion=3;
            }
        }
        
        return opcion;
    }
    public static int buscarPoscicion(String cadena,Hospital h){
        
        for(int i=0;i<h.getM().size();i++){
            if(cadena.equals(h.getM().get(i).getCedula())){
                return i;
            }
        }
        for(int i=0;i<h.getP().size();i++){
            if(cadena.equals(h.getP().get(i).getCedula())){
                return i;
            }
        }
        return 0;
    }
}
