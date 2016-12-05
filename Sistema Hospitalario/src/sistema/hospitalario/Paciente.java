/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

/**
 *
 * @author Richard
 */
public class Paciente extends Usuario {

    private Medico medico;
    private HistoriaClinica historiaClinica;
    private Cuarto cuarto;

    public Medico getMedico() {
        return medico;
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
    }

    public Paciente(Medico medico, HistoriaClinica historiaClinica, Cuarto cuarto) {
        this.medico = medico;
        this.historiaClinica = historiaClinica;
        this.cuarto = cuarto;
    }

    public void verHistoriaClinica() {
        System.out.println(this.getHistoriaClinica().getEstado());
        System.out.println(this.getHistoriaClinica().getAlergia());
        System.out.println(this.getHistoriaClinica().getTipoSangre());
    }
}
