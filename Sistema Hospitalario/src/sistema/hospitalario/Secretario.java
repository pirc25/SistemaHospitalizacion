/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admini
 */
public class Secretario extends Usuario{
    private Oficina oficina;

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public void  registrarNuevoPaciente (ArrayList<Paciente>p,Paciente q){
    p.add(q);
    Scanner sc=new Scanner(System.in);
    System.out.println("Ingrese nombre del paciente");
    q.setNombre(sc.nextLine());
    System.out.println("Ingrese apellido del paciente");
    q.setApellido(sc.nextLine());
    System.out.println("Ingrese cedula del paciente");
    q.setCedula(sc.nextLine());
    System.out.println("Ingrese sexo del pacietne");
    q.setSexo(sc.nextLine());
    
   }
    public void registrarNuevoMedico (ArrayList<Medico>m,Medico n){
        
        m.add(n);
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese nombre del medico");
        n.setNombre(sc.nextLine());
        System.out.println("Ingrese apellido del medico");
        n.setApellido(sc.nextLine());
        System.out.println("Ingrese cedula del medico");
        n.setCedula(sc.nextLine());
        System.out.println("Ingrese especialidad del medico");
        n.setEspecialidad(sc.nextLine());
        System.out.println("Ingrese el numero del consultorio");
        n.getConsultorio().setNumero(sc.nextInt());
                   
    }
     
     public void  verListadePacientes (ArrayList<Paciente>p,Paciente q){
         for(int i=0;i<p.size();i++){
             System.out.println(p.get(i).getNombre()+" "+p.get(i).getApellido()+" "+p.get(i).getCedula()+" "+p.get(i).getSexo()+"\n");
         }
     }
    
    
    public void verListadeMedicos (ArrayList<Medico>m,Medico n){
         for(int i=0; i<m.size();i++){
             System.out.println(m.get(i).getNombre()+" "+m.get(i).getApellido()+" "+m.get(i).getEspecialidad()+"\n");
         }
     }
}
