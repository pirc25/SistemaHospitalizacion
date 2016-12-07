/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Usuario {

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

    public Medico() {
        this.especialidad = "";
        this.consultorio = new Consultorio();
        this.nombre = "";
        this.apellido = "";
    }

    public Medico(String nombre, String apellido, String especialidad, Consultorio consultorio) {
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void toSting() {
        System.out.println("Nombre: " + this.getNombre() + " " + this.getApellido());
        System.out.println("Especialidad: " + this.getEspecialidad());
        System.out.println("Consultorio: " + this.consultorio.getNumero());
    }

    public void editarPaciente(Hospital h) {
        Scanner sc = new Scanner(System.in);
        int x=this.verPacientes(h.getP());
        if(x==0){
            System.out.print("Ingrese cedula del paciente que desea editar: ");
            String ci = sc.nextLine();

            int i = h.buscarPaciente(ci);

            if (i == -1) {
                System.out.println("Paciente no encontrado\n");
            } else {
                System.out.println("\nPaciente " + h.getP().get(i).getNombre() + " " + h.getP().get(i).getApellido());
                System.out.print("\nIngrese su tipo de sangre: ");
                h.getP().get(i).getHistoriaClinica().setTipoSangre(sc.nextLine());
                System.out.print("Ingrese alergias: ");
                h.getP().get(i).getHistoriaClinica().setAlergia(sc.nextLine());
                System.out.print("\n");
            }
        }    
    }

    public void atenderPaciente(Hospital h) {

        Scanner sc = new Scanner(System.in);
        int x=this.verPacientes(h.getP());
        if(x==0){
            System.out.print("Ingrese cedula del paciente que desea registrar: ");
            String ci = sc.nextLine();
            int i = h.buscarPaciente(ci);

            if (i == -1) {
                System.out.println("Paciente no encontrado\n");
            } else {
                if ("Enfermo".equals(h.getP().get(i).getHistoriaClinica().getEstado())) {
                    h.getP().get(i).getHistoriaClinica().setEstado(1);
                } else if ("En Tratamiento".equals(h.getP().get(i).getHistoriaClinica().getEstado())) {
                    h.getP().get(i).getHistoriaClinica().setEstado(2);
                }
                System.out.println("Registro finalizado con exito!\n");
            }
        }    
    }

    public int verPacientes(ArrayList<Paciente> p) {
        int cont=0;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getMedico().equals(this)) {
                cont++;
            }
            if(cont!=0){
                if (p.get(i).getMedico().equals(this)) {
                    System.out.printf("\n%-10s%-10s%-15s%-15s", p.get(i).getNombre(), p.get(i).getApellido(), p.get(i).getCedula(), p.get(i).getHistoriaClinica().getEstado());
                }
            }else{
                System.out.println("\n   Aún no tiene pacientes asignados\n");
                return 1;
            }    
        }
        System.out.println("\n");
        return 0;
    }
}
