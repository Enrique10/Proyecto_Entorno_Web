/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinica.managedBean;

import com.clinica.bean.Cita;
import com.clinica.dao.CitaDAO;
import com.clinica.datamodel.CitaDataModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "citaMB")
@ViewScoped
public class CitaMB {

    private List<Cita> listado_busquedaCita;
    private CitaDAO citaDAO = new CitaDAO();
    private String lunes;
    private String martes;
    private CitaDataModel CitaDM;
    private Cita citaSelected;
    

    public CitaMB() {
        citaDAO = new CitaDAO();
        listado_busquedaCita = new ArrayList<Cita>();
        CitaDM = new CitaDataModel(listado_busquedaCita);
        lunes = "2013-09-04";
        martes = "2013-09-05";
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }  
    

    public List<Cita> getListado_busquedaCita() {       
        return listado_busquedaCita;
    }

    public void setListado_busquedaCita(List<Cita> listado_busquedaCita) {
        this.listado_busquedaCita = listado_busquedaCita;
    }

    public void busquedaCita() {
        List<Cita> listado_busquedaCita_clone = new ArrayList<Cita>();
        Cita cita = new Cita();
        for (int i = 8; i < 22; i++) {
            cita = new Cita();
            cita.setHoraCita(null);
            cita.setId_paci(null);
            cita.setHorario(String.valueOf(i) + ":00");
            listado_busquedaCita_clone.add(cita);
//            for (int m = 15; m < 60; m = m + 15) {
//                cita = new Cita();
//                cita.setHorario(i + ":" + m);
//                listado_busquedaCita_clone.add(cita);
//            }
        }           
        
        List<Cita> lista = new ArrayList<Cita>();
        lista = citaDAO.lista_busquedaCita();        
        
        for(Cita ci : listado_busquedaCita_clone){
            String horario = ci.getHorario().trim();               
            cita = new Cita();
            cita.setHorario(horario);
            for(Cita c: lista){
                String hora_cita = c.getHoraCita().trim();
                if(horario.equals(hora_cita)){        
                    cita.setId_cta(c.getId_cta());
                    cita.setId_paci(c.getId_paci());  
                    cita.setHoraCita(c.getHoraCita());
                    cita.setFec_cta(c.getFec_cta());
                } 
            }
            listado_busquedaCita.add(cita); 
            CitaDM = new CitaDataModel(listado_busquedaCita);
        }       
        
    }
        
    public CitaDataModel getCitaDM() {
        return CitaDM;
    }

    public void setCitaDM(CitaDataModel CitaDM) {
        this.CitaDM = CitaDM;
    }

    public Cita getCitaSelected() {
        return citaSelected;
    }

    public void setCitaSelected(Cita citaSelected) {
        this.citaSelected = citaSelected;
    }   
    
    public void preRegistrarEditar(){
        if(citaSelected != null){
            RequestContext.getCurrentInstance().update("frmAgregarCita:dlgAgregarCita");
            RequestContext.getCurrentInstance().execute("dlgAgregarCita.show()");
        }       
        
    }
    
    
}
