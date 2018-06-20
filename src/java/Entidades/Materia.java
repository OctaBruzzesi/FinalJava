/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Augusto
 */
public class Materia {
    int codMateria, ano;
    String nombre;
    boolean habilitado;

    public Materia(int codMateria, String nombre, int ano, boolean habilitado) {
        this.codMateria = codMateria;
        this.ano = ano;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

    public int getCodMteria() {
        return codMateria;
    }

    public void setCodMteria(int codMteria) {
        this.codMateria = codMteria;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
