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
       //hosp.cargarDatos();
       System.out.println("\t\t\tSistema Hospitalario");
       System.out.print("\nIngrese su cedula: ");
       String ci=sc.nextLine();
       
       int opc;
       opc=hosp.buscar(ci);
       
       if(opc==0){
           System.out.println("\nNo se ha encontrado usuario\n");
       }
    }
    
}
