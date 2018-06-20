/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;


/**
 *
 * @author Augusto
 */
public class Consulta {
    int codConsulta, legajoAlumno, legajoProfesor;
    String estado, titulo, cuerpo, respuesta, imagen;
    Date fecha;

    public Consulta(int codConsulta, String estado, String titulo, String cuerpo, String respuesta, String imagen, Date fecha, int legajoAlumno, int legajoProfesor) {
        this.codConsulta = codConsulta;
        this.estado = estado;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.respuesta = respuesta;
        this.imagen = imagen;
        this.fecha = fecha;
        this.legajoAlumno = legajoAlumno;
        this.legajoProfesor = legajoProfesor;
        
    }

    
    public int getLegajoAlumno() {
        return legajoAlumno;
    }

    public void setLegajoAlumno(int legajoAlumno) {
        this.legajoAlumno = legajoAlumno;
    }

    public int getLegajoProfesor() {
        return legajoProfesor;
    }

    public void setLegajoProfesor(int legajoProfesor) {
        this.legajoProfesor = legajoProfesor;
    }
    
    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}

