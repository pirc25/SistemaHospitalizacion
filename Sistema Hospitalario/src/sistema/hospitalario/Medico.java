/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;

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
    
    public void atenderPaciente(Paciente paciente){
        /*if(paciente.getHistoriaClinica().getEstado()=="Enfermo"){
            paciente.getHistoriaClinica().setEstado(2);
        }else if(paciente.getHistoriaClinica().getEstado()=="En tratamiento"){
            paciente.getHistoriaClinica().setEstado(3);
        }*/
    }
    public void verPacientes(ArrayList<Paciente> p){
        for(int i=0;i<p.size();i++){
            System.out.println("\n"+p.get(i).getNombre());
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
    
    
}
