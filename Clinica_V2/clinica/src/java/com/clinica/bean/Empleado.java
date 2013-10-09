
package com.clinica.bean;


public class Empleado {
    
    private Long id_emp;
    private Perfil Perfil;
    private Persona Persona;
    private Especialidad Especialidad;

    public Long getId_emp() {
        return id_emp;
    }

    public void setId_emp(Long id_emp) {
        this.id_emp = id_emp;
    }

    public Perfil getPerfil() {
        return Perfil;
    }

    public void setPerfil(Perfil Perfil) {
        this.Perfil = Perfil;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    public Especialidad getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(Especialidad Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    
}
