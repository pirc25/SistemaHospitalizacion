/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Richard
 */
public class Paciente extends Usuario {

    private Medico medico;
    private HistoriaClinica historiaClinica;
    private Cuarto cuarto;
    private Date turno;

    public Medico getMedico() {
        return medico;
    }

    public void setTurno(Date turno) {
        this.turno = turno;
    }

    public Date getTurno() {
        return turno;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public Cuarto getCuarto() {
        return cuarto;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public void setCuarto(Cuarto cuarto) {
        this.cuarto = cuarto;
    }

    public Paciente() {
        this.medico = new Medico();
        this.historiaClinica = new HistoriaClinica();
        this.cuarto = new Cuarto();
        this.turno = new Date();
    }

    public Paciente(Medico medico, HistoriaClinica historiaClinica, Cuarto cuarto, Date turno) {
        this.medico = medico;
        this.historiaClinica = historiaClinica;
        this.cuarto = cuarto;
        this.turno = turno;
    }

    public void agendarTurno() {
        boolean b = true;

        System.out.println("Introduzca la fecha con formato dd/MM/yyyy hh:mm");
        Scanner sc = new Scanner(System.in);

        while (b == true) {
            String fecha = sc.nextLine();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String date = fecha;
            try {
                turno = df.parse(date);
                System.out.println("Su turno es para: " + turno);
                if (!df.format(turno).equals(date)) {
                    System.out.println("Ingrese");
                } else {
                    System.out.println("Gracias");
                }
                b = false;
            } catch (ParseException e) {
                System.out.println("formato invalido");
            }
        }
    }

    public void seleccionarMedico(ArrayList<Medico> p) {
        Scanner sc = new Scanner(System.in);
        int x;
        for (int i = 0; i < p.size(); i++) {
            System.out.printf("\n%-4d%-15s%-15s%-15s", i + 1, p.get(i).getNombre(), p.get(i).getApellido(), p.get(i).getEspecialidad());
        }
        System.out.println("\n");
        System.out.println("Ingrese el numero del medico para agender la cita");
        x = sc.nextInt();
        this.setMedico(p.get(x - 1));
        System.out.println("Usted ha escogido al Doctor/a: " + this.getMedico());

    }
}
