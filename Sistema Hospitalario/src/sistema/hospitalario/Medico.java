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
                System.out.println("\n   Paciente no encontrado\n");
            } else {
                System.out.println("\nPaciente " + h.getP().get(i).getNombre() + " " + h.getP().get(i).getApellido());
                System.out.print("\nIngrese su tipo de sangre[A+/O-]: ");
                h.getP().get(i).getHistoriaClinica().setTipoSangre(sc.nextLine());
                System.out.print("Ingrese alergias: ");
                h.getP().get(i).getHistoriaClinica().setAlergia(sc.nextLine());
                System.out.println("\n   Registro finalizado con exito!\n");
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
                System.out.println("\n   Paciente no encontrado\n");
            } else {
                if ("Enfermo".equals(h.getP().get(i).getHistoriaClinica().getEstado())) {
                    h.getP().get(i).getHistoriaClinica().setEstado(1);
                } else if ("En Tratamiento".equals(h.getP().get(i).getHistoriaClinica().getEstado())) {
                    h.getP().get(i).getHistoriaClinica().setEstado(2);
                }
                System.out.println("\n   Registro finalizado con exito!\n");
            }
        }    
    }

    public int verPacientes(ArrayList<Paciente> p) {
        boolean b=false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getMedico().equals(this)) {
                b=true;
                break;
            }
        }
        if(b==true){
            System.out.printf("\n%-10s%-10s%-15s%-17s%s\n","Nombre","Apellido","Cedula","Estado","Turno");
            for (int i = 0; i < p.size(); i++) {    
                if (p.get(i).getMedico().equals(this)) {
                    System.out.printf("\n%-10s%-10s%-15s%-17s%s", p.get(i).getNombre(), p.get(i).getApellido(), p.get(i).getCedula(), p.get(i).getHistoriaClinica().getEstado(),p.get(i).getTurno());
                }
            }
            System.out.printf("\n\n");
        }else{
            System.out.println("\n   Aún no tiene pacientes asignados\n");
            return 1;
        }        
        return 0;
    }
    public void visualizarPacientes(Hospital h) {
        Scanner sc = new Scanner(System.in);
        int x=this.verPacientes(h.getP());
        if(x==0){
            System.out.print("Ingrese cedula de un paciente para tener más informacion: ");
            String ci = sc.nextLine();
            int i = h.buscarPaciente(ci);

            if (i == -1) {
                System.out.println("\n   Paciente no encontrado\n");
            } else {
                System.out.println("\nAlergias: "+h.getP().get(i).getHistoriaClinica().getAlergia());
                System.out.println("Tipo de Sangre: "+h.getP().get(i).getHistoriaClinica().getTipoSangre()+"\n");
            }
        }
    }
}
