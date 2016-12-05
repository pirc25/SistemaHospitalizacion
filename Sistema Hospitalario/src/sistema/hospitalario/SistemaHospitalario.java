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
        cargarDatos(hosp);
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
                    
                    int pos=buscarPoscicion(ci,hosp);
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
                    
                    int pos2=buscarPoscicion(ci,hosp);
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
                    System.out.println("\n\tCedula inválida!, vuelva a ingresar");
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
        return -1;
    }
    public static void cargarDatos(Hospital h){
        //Carga de Secretario
        h.getS().setNombre("Juan");
        h.getS().setApellido("Vasconez");
        h.getS().setCedula("33333");
        
        //Medicos
        for(int i=0;i<2;i++){
            Medico med=new Medico();
            h.getM().add(med);
        }
        h.getM().get(0).setNombre("Enrique");
        h.getM().get(0).setApellido("Vasconez");
        h.getM().get(0).setCedula("11111");
        h.getM().get(0).setEspecialidad("Cardiologo");
        h.getM().get(1).setNombre("Javier");
        h.getM().get(1).setApellido("Velazques");
        h.getM().get(1).setCedula("12222");
        h.getM().get(1).setEspecialidad("Pediatra");
        
        //Pacientes
        for(int i=0;i<6;i++){
            Paciente pac = new Paciente();
            h.getP().add(pac);
        }
        h.getP().get(0).setNombre("Enrique");
        h.getP().get(0).setApellido("Rivera");
        h.getP().get(0).setCedula("21111");
        h.getP().get(0).setSexo("Masculino");
        h.getP().get(0).setMedico(h.getM().get(0));
        h.getP().get(1).setNombre("Juan");
        h.getP().get(1).setApellido("Perez");
        h.getP().get(1).setCedula("22222");
        h.getP().get(1).setSexo("Masculino");
        h.getP().get(1).setMedico(h.getM().get(0));
        h.getP().get(2).setNombre("Sebastian");
        h.getP().get(2).setApellido("Hidalgo");
        h.getP().get(2).setCedula("23333");
        h.getP().get(2).setSexo("Masculino");
        h.getP().get(2).setMedico(h.getM().get(1));
        h.getP().get(3).setNombre("Jose");
        h.getP().get(3).setApellido("Rojas");
        h.getP().get(3).setCedula("24444");
        h.getP().get(3).setSexo("Masculino");
        h.getP().get(3).setMedico(h.getM().get(1));
        h.getP().get(4).setNombre("Maria");
        h.getP().get(4).setApellido("Gonzalez");
        h.getP().get(4).setCedula("25555");
        h.getP().get(4).setSexo("Femenino");
        h.getP().get(4).setMedico(h.getM().get(0));
        
    }
}

