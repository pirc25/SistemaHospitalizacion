/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Usuario{
    private String especialidad;
    private Consultorio consultorio;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }   
    public void verPacientes(ArrayList<Paciente> p){
        for(int i=0;i<p.size();i++){
            if(p.get(i).getMedico()==this){
                System.out.printf("\n%-10s%-10s%-10s",p.get(i).getNombre(),p.get(i).getApellido(),p.get(i).getHistoriaClinica().getEstado());
            }
        }
        System.out.println();
    }
    public void atenderPaciente(Hospital h){
        Scanner sc=new Scanner(System.in);
        
        for(int i=0;i<h.getP().size();i++){
            if(h.getP().get(i).getMedico()==this){
                System.out.printf("\n%s %10s%10s",h.getP().get(i).getNombre(),h.getP().get(i).getApellido(),h.getP().get(i).getHistoriaClinica().getEstado());
            }
        }
        System.out.println("\n\nIngrese cedula del paciente que desea registrar: ");
        String ci=sc.nextLine();
        int i=h.buscarPaciente(cedula);
        
        if("Enfermo".equals(h.getP().get(i).getHistoriaClinica().getEstado())){
            h.getP().get(i).getHistoriaClinica().setEstado(1);
        }else if("En tratamiento".equals(h.getP().get(i).getHistoriaClinica().getEstado())){
           h.getP().get(i).getHistoriaClinica().setEstado(2);
        }
    }

    public Medico() {
        this.especialidad ="";
        this.consultorio =new Consultorio();
        this.nombre="";
        this.apellido="";
    }
    
    public Medico(String nombre,String apellido,String especialidad, Consultorio consultorio) {
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public void toSting(){
        System.out.println("Nombre: "+this.getNombre()+" "+this.getApellido());
        System.out.println("Especialidad: "+this.getEspecialidad());
        System.out.println("Consultorio: "+this.consultorio.getNumero());
    }
    public void editarPaciente(Hospital h){        
        Scanner sc=new Scanner(System.in);
        
        for(int i=0;i<h.getP().size();i++){
            if(h.getP().get(i).getMedico()==this){
                System.out.printf("\n%s %10s%10s",h.getP().get(i).getNombre(),h.getP().get(i).getApellido(),h.getP().get(i).getHistoriaClinica().getEstado());
            }
        }
        
        System.out.println("\n\nIngrese cedula del paciente que desea editar: ");
        String ci=sc.nextLine();
        
        int i=h.buscarPaciente(cedula);
        
        System.out.println("\nPaciente "+h.getP().get(i).getNombre()+" "+h.getP().get(i).getApellido());       
        System.out.print("\nIngrese su tipo de sangre: ");
        h.getP().get(i).getHistoriaClinica().setTipoSangre(sc.nextLine());        
        System.out.print("\nIngrese alergias: ");
        h.getP().get(i).getHistoriaClinica().setAlergia(sc.nextLine());
    }
    
}
