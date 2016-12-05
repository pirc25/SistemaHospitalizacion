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
public class HistoriaClinica {

    private String estado;
    private String alergia;
    private String tipoSangre;

    public String getEstado() {
        return estado;
    }

    public String getAlergia() {
        return alergia;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setEstado(int x) {
        switch (x) {
            case 0:
                this.estado = "Enfermo";
                break;
            case 1:
                this.estado = "En Tratamiento";
                break;
            case 2:
                this.estado = "Sano";
                break;
            default:
                this.estado = "Enfermo";
                break;
        }
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public HistoriaClinica(String estado, String alergia, String tipoSangre) {
        this.estado = estado;
        this.alergia = alergia;
        this.tipoSangre = tipoSangre;
    }

    public HistoriaClinica() {
        this.estado = "Enfermo";
        this.alergia = "";
        this.tipoSangre = "";
    }

    @Override
    public String toString() {
        String str;
        str = "Estado: " + getEstado() + "\n";
        str += "Alergia: " + getAlergia() + "\n";
        str += "Tipo de sangre: " + getTipoSangre();
        return str;
    }

}
