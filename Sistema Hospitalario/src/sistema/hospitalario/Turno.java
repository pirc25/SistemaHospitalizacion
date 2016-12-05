/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

/**
 *
 * @author USRKAP
 */
public class Turno {

    private int hora;
    private int minuto;
    private int dia;
    private int mes;
    private int año;

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public void imprimeHora() {
        System.out.print(this.getHora() + ":" + this.getMinuto());
    }

    public void imprimeFecha() {
        System.out.print(this.getDia() + "/" + this.getMes() + "/" + this.getAño());
    }

    public void setHora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public void setFecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
}
