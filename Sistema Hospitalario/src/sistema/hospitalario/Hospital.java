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
        this.getM().get(0).setNombre("Enrique");
        this.getM().get(0).setApellido("Vasconez");
        this.getM().get(0).setCedula("1234567890");
        this.getM().get(0).setEspecialidad("Cardiologo");
        this.getM().get(1).setNombre("Javier");
        this.getM().get(1).setApellido("Velazques");
        this.getM().get(1).setCedula("0123456789");
        this.getM().get(1).setEspecialidad("Pediatra");
        for(int i=0;i<6;i++){
            Paciente pac = new Paciente();
            this.getP().add(pac);
        }
        this.getP().get(0).setNombre("Enrique");
        this.getP().get(0).setApellido("Rivera");
        this.getP().get(0).setCedula("1234567891");
        this.getP().get(0).setSexo("Masculino");
        this.getP().get(1).setNombre("Juan");
        this.getP().get(1).setApellido("Perez");
        this.getP().get(1).setCedula("0123456782");
        this.getP().get(1).setSexo("Masculino");
        this.getP().get(2).setNombre("Sebastian");
        this.getP().get(2).setApellido("Hidalgo");
        this.getP().get(2).setCedula("1234567893");
        this.getP().get(2).setSexo("Masculino");
        this.getP().get(3).setNombre("Jose");
        this.getP().get(3).setApellido("Rojas");
        this.getP().get(3).setCedula("0123456784");
        this.getP().get(3).setSexo("Masculino");
        this.getP().get(4).setNombre("Maria");
        this.getP().get(4).setApellido("Gonzalez");
        this.getP().get(4).setCedula("1234567895");
        this.getP().get(4).setSexo("Femenino");
        
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
