/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinica.bean;

/**
 *
 * @author GERARDO
 */
public class Paciente {

    private Long id_paci;
    private String fecing_paci;
    private Persona persona;

    public String getFecing_paci() {
        return fecing_paci;
    }

    public void setFecing_paci(String fecing_paci) {
        this.fecing_paci = fecing_paci;
    }

    public Long getId_paci() {
        return id_paci;
    }

    public void setId_paci(Long id_paci) {
        this.id_paci = id_paci;
    }        

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }    
    
}
