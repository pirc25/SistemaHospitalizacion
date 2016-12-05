/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalario;

import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Hospital {
    private String nombre;
    private String dirección;
    private ArrayList<Paciente>p;
    private ArrayList<Medico>m;
    private Secretario s;

    public Secretario getS() {
        return s;
    }

    public void setS(Secretario s) {
        this.s = s;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public ArrayList<Paciente> getP() {
        return p;
    }

    public void setP(ArrayList<Paciente> p) {
        this.p = p;
    }

    public ArrayList<Medico> getM() {
        return m;
    }

    public void setM(ArrayList<Medico> m) {
        this.m = m;
    }

    public Hospital() {
        this.nombre ="";
        this.dirección ="";
        this.p=new ArrayList();
        this.m=new ArrayList();
        this.s=new Secretario();
    }

    public Hospital(String nombre, String dirección) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.p=new ArrayList();
        this.m=new ArrayList();
        this.s=new Secretario();
    }
    
    public int buscarMedico(String cadena){
        
        for(int i=0;i<this.m.size();i++){
            if(cadena.equals(this.m.get(i).cedula)){
                return i;
            }
        }
        return -1;
    }
    public int buscarPaciente(String cadena){
        
        for(int i=0;i<this.getP().size();i++){
            if(cadena.equals(this.getP().get(i).getCedula())){
                return i;
            }
        }
        return -1;
    }    
}
