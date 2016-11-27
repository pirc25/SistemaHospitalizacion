/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;

public class Medico extends Usuario{
    private String especialidad;
    private String consultorio;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    
    public void atenderPaciente(Paciente paciente){
        if(paciente.getEstado()=="Enfermo"){
            paciente.setEstado(2);
        }else if(paciente.getEstado()=="En tratamiento"){
            paciente.setEstado(3);
        }
    }
    //ArrayList <Paciente> ap=new ArrayList();
    public void verPacientes(ArrayList<Paciente> ap){
        for(int i=0;i<ap.size;i++){
            System.out.println("\n"+ap[i].getNombre()+" "+ap[i].getApellido()+"    "ap[i].getEstado());
        }
    }

    public Medico() {
    }
    
    public Medico(String nombre,String apellido,String especialidad, String consultorio) {
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.setNombre(nombre);
        this.setApellido(apellido);
    }
    
}
