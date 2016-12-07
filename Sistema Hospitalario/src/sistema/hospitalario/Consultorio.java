/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

/**
 *
 * @author fabio
 */
public class Consultorio {
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Consultorio() {
        numero="n/a";
    }

    public Consultorio(String numero) {
        this.numero = numero;
    }
    
}
