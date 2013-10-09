
package com.clinica.bean;


public class Cita {
    
    private String horario;
    private Long id_cta;
    private String fec_cta;
    private String horaCita;
    private String id_paci;
    private Paciente paciente;
    private Especialidad especialidad;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Long getId_cta() {
        return id_cta;
    }

    public void setId_cta(Long id_cta) {
        this.id_cta = id_cta;
    } 

    public String getFec_cta() {
        return fec_cta;
    }

    public void setFec_cta(String fec_cta) {
        this.fec_cta = fec_cta;
    }
    
    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getId_paci() {
        return id_paci;
    }

    public void setId_paci(String id_paci) {
        this.id_paci = id_paci;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }     
    
    
}
