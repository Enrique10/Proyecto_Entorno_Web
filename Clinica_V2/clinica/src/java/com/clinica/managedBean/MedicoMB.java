package com.clinica.managedBean;

import com.clinica.bean.Empleado;
import com.clinica.dao.EmpleadoDAO;
import com.clinica.datamodel.EmpleadoDataModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "medicoMB")
@ViewScoped
public class MedicoMB {

    private String pdniMedi;
    private String pnombMedi;
    
    public List<Empleado> listado_BusquedaMedico;
    
    public EmpleadoDataModel medicoDM;
    
    public Empleado medicoSelected;
           
    EmpleadoDAO empleadoDAO;

    public MedicoMB() {
        
        empleadoDAO = new EmpleadoDAO();
        
        listado_BusquedaMedico = new ArrayList<Empleado>();
        medicoDM = new EmpleadoDataModel(listado_BusquedaMedico);
    }

  
    
    public void preEditarMedico(){
//        RequestContext.getCurrentInstance().update("frmConsultaDoctor:dlgEditaDoctor");
//        RequestContext.getCurrentInstance().execute("frmConsultaDoctor:dlgEditaDoctor.show()");
    }
    
       public void preRegistrarMedico(){
//        RequestContext.getCurrentInstance().update("frmConsultaDoctor:dlgEditaDoctor");
        RequestContext.getCurrentInstance().execute("frmAgregarMedico:dlgAgregarMedico.show()");
    }

    public void busquedaMedico(){
        listado_BusquedaMedico = empleadoDAO.lista_busquedaEmpleado(pdniMedi, pnombMedi);
        medicoDM = new EmpleadoDataModel(listado_BusquedaMedico);
        
        RequestContext.getCurrentInstance().update("frmConsultaMedico:tblConsultaMedico");
    }
    
    public String getPdniMedi() {
        return pdniMedi;
    }

    public void setPdniMedi(String pdniMedi) {
        this.pdniMedi = pdniMedi;
    }

    public String getPnombMedi() {
        return pnombMedi;
    }

    public void setPnombMedi(String pnombMedi) {
        this.pnombMedi = pnombMedi;
    }
    
    public List<Empleado> getListado_BusquedaMedico() {
        return listado_BusquedaMedico;
    }

    public void setListado_BusquedaMedico(List<Empleado> listado_BusquedaMedico) {
        this.listado_BusquedaMedico = listado_BusquedaMedico;
    }

    public EmpleadoDataModel getMedicoDM() {
        return medicoDM;
    }

    public void setMedicoDM(EmpleadoDataModel medicoDM) {
        this.medicoDM = medicoDM;
    }

    public Empleado getMedicoSelected() {
        return medicoSelected;
    }

    public void setMedicoSelected(Empleado medicoSelected) {
        this.medicoSelected = medicoSelected;
    }
    
    
    
    
    
}
