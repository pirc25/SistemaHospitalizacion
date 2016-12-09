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
public class Secretario extends Usuario {

    private Oficina oficina;

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public void registrarNuevoPaciente(ArrayList<Paciente> p, Paciente q,Hospital h) {
        
        Scanner sc = new Scanner(System.in);     
        System.out.print("\nIngrese cedula: ");
        String ci=sc.nextLine();        
        int i=this.buscarPoscicion(ci,h);
        if(i==-1){
            p.add(q);
            q.setCedula(ci);
            System.out.print("Ingrese nombre: ");
            q.setNombre(sc.nextLine());
            System.out.print("Ingrese apellido: ");
            q.setApellido(sc.nextLine());
            System.out.print("Ingrese sexo [M/F]: ");
            q.setSexo(sc.nextLine());
            System.out.print("Ingrese alergias: ");
            q.getHistoriaClinica().setAlergia(sc.nextLine());
            System.out.print("Ingrese tipo de sangre [A+/O-]: ");
            q.getHistoriaClinica().setTipoSangre(sc.nextLine());
            System.out.print("Ingrese numero de cuarto: ");
            q.getCuarto().setNum(sc.nextLine());
            System.out.printf("\n");
        }else{
            System.out.println("\n   Cedula ingresada ya existe, vuelva a ingresar\n");
        }
        
        
        
    }

    public void registrarNuevoMedico(ArrayList<Medico> m, Medico n,Hospital h) {
        
        Scanner sc = new Scanner(System.in);     
        System.out.print("\nIngrese cedula: ");
        String ci=sc.nextLine();        
        int i=this.buscarPoscicion(ci,h);
        if(i==-1){
            m.add(n);
            n.setCedula(ci);
            System.out.print("Ingrese nombre: ");
            n.setNombre(sc.nextLine());
            System.out.print("Ingrese apellido: ");
            n.setApellido(sc.nextLine());
            System.out.print("Ingrese especialidad: ");
            n.setEspecialidad(sc.nextLine());
            System.out.print("Ingrese el numero del consultorio: ");
            n.getConsultorio().setNumero(sc.nextLine());
            System.out.printf("\n");
        }else{
            System.out.println("\n   Cedula ingresada ya existe, vuelva a ingresar\n");
        }    
    }

    public void verListadePacientes(ArrayList<Paciente> p, Paciente q) {
        System.out.printf("\n");
        System.out.printf("%-12s%-15s%-15s%s\n","Nombre","Apellido","Cedula","Sexo","No de Cuarto");
        System.out.printf("\n");
        for (int i = 0; i < p.size(); i++) {
            System.out.printf("%-12s%-15s%-15s%s\n",p.get(i).getNombre(), p.get(i).getApellido(),p.get(i).getCedula(), p.get(i).getSexo());
        }
    }

    public void verListadeMedicos(ArrayList<Medico> m, Medico n) {
        System.out.printf("\n");
        System.out.printf("%-12s%-15s%-15s%s\n","Nombre","Apellido","Cedula","Especialidad","No de Consultorio");
        System.out.printf("\n");
        for (int i = 0; i < m.size(); i++) {
            System.out.printf("%-12s%-15s%-15s%s\n",m.get(i).getNombre(), m.get(i).getApellido(),m.get(i).getCedula(), m.get(i).getEspecialidad());
        }
        System.out.printf("\n");
    }
    public int buscarPoscicion(String cadena, Hospital h) {

        for (int i = 0; i < h.getM().size(); i++) {
            if (cadena.equals(h.getM().get(i).getCedula())) {
                return i;
            }
        }
        for (int i = 0; i < h.getP().size(); i++) {
            if (cadena.equals(h.getP().get(i).getCedula())) {
                return i;
            }
        }
        return -1;
    }
}
