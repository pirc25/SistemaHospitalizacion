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
    public void cargarDatos(){
        for(int i=0;i<2;i++){
            Medico med=new Medico();
            this.getM().add(med);
        }
        this.getM().get(0).setNombre("Juan");
        this.getM().get(0).setApellido("Velazques");
        this.getM().get(0).setCedula("0215545554");
        this.getM().get(0).setEspecialidad("Cardiologo");
    }
    public int buscar(String cadena){
        if("cadena".equals(this.s.getCedula())){
            return 1;
        }
        for(int i=0;i<this.m.size();i++){
            if("cadena".equals(this.m.get(i).cedula)){
                return 2;
            }
        }
        for(int i=0;i<this.p.size();i++){
            if("cadena".equals(this.p.get(i).cedula)){
                return 3;
            }
        }
        return 0;    
    }
    
}
