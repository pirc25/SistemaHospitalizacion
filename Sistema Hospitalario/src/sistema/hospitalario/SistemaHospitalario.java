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
                    System.out.println("1)Ingresar Nuevo Medico\n2)Ingresar Nuevo Paciente\n3)Ver Listas\n4)Salir\n\nEscoja una opcion: ");
                    int x=sc.nextInt();

                    switch(x){
                        case 1:
                        case 2:
                        case 3:
                        default: 
                            break;
                    }

                    break;
                case 2://medico
                    int pos=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Dr."+hosp.getM().get(pos).getNombre()+" "+hosp.getM().get(pos).getApellido()+"\n");
                    System.out.println("1)Ver Pacientes\n2)Atender Paciente\n3)Salir\n\nEscoja una opcion: ");
                    int y=sc.nextInt();

                    switch(y){
                        case 1:
                        case 2:
                        case 3:
                        default: 
                            break;
                    }
                    break;
                case 3://paciente
                    int pos2=hosp.buscarPoscicion(ci);
                    System.out.println("Bienvenido Sr."+hosp.getP().get(pos2).getNombre()+" "+hosp.getP().get(pos2).getApellido()+"\n");
                    System.out.println("\n1)Ver Citas\n2)Ver Historia Clinica\n3)Elegir Medico\n4)Salir\n\nEscoja una opcion: ");
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
