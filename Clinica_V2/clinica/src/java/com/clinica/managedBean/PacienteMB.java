package com.clinica.managedBean;

import com.clinica.bean.*;
import com.clinica.dao.PacienteDAO;
import com.clinica.dao.PersonaDAO;
import com.clinica.dao.UbigeoDAO;
import com.clinica.datamodel.PacienteDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "pacienteMB")
@ViewScoped
public class PacienteMB {

    private String dniPaci;
    private String nombPaci;
    private String apepatPaci;
    private String apematPaci;
    private String sexoPaci;
    private Date fecnacPaci;
    private String lugnacPaci;
    private Long depaPaci;
    private Long provPaci;
    private Long distPaci;
    private String direPaci;
    private String telefPaci;
    private String movilPaci;
    private Paciente pacienteSelected;
    private List<Paciente> listado_busquedaPaciente;
    private List<SelectItem> comboDepartamento;
    private List<SelectItem> comboProvincia;
    private List<SelectItem> comboDistrito;
    private PacienteDataModel PacienteDM;
    PacienteDAO pacienteDAO = new PacienteDAO();

    public PacienteMB() {
        pacienteDAO = new PacienteDAO();
        listado_busquedaPaciente = new ArrayList<Paciente>();
        PacienteDM = new PacienteDataModel(listado_busquedaPaciente);
    }

    public void busquedaPaciente() {
        listado_busquedaPaciente = new ArrayList<Paciente>();
        listado_busquedaPaciente = pacienteDAO.lista_busquedaPaciente(dniPaci, nombPaci);
        PacienteDM = new PacienteDataModel(listado_busquedaPaciente);
    }

    public void preRegistrarPaciente() {
        this.limpiar();
        RequestContext.getCurrentInstance().update("frmAgregarPaciente:dlgAgregarPaciente");
        RequestContext.getCurrentInstance().execute("frmAgregarPaciente:dlgAgregarPaciente.show()");
    }

    public void preEditarPaciente() {
        dniPaci = pacienteSelected.getPersona().getDni_psn();
        nombPaci = pacienteSelected.getPersona().getNomb_psn();
        apepatPaci = pacienteSelected.getPersona().getApepat_psn();
        apematPaci = pacienteSelected.getPersona().getApemat_psn();
        sexoPaci = pacienteSelected.getPersona().getSexo_psn();
        fecnacPaci = new Date();
        lugnacPaci = pacienteSelected.getPersona().getLugnac_psn();
        depaPaci = pacienteSelected.getPersona().getDepa_psn();
        provPaci = pacienteSelected.getPersona().getProv_psn();
        distPaci = pacienteSelected.getPersona().getDist_psn();
        direPaci = pacienteSelected.getPersona().getDire_psn();
        telefPaci = pacienteSelected.getPersona().getTelef_psn();
        movilPaci = pacienteSelected.getPersona().getMovil_psn();
        RequestContext.getCurrentInstance().update("frmEditarPaciente");
        RequestContext.getCurrentInstance().execute("frmEditarPaciente:dlgEditarPaciente.show()");
    }

    private void limpiar() {
        dniPaci = "";
        nombPaci = "";
        apepatPaci = "";
        apematPaci = "";
        sexoPaci = "";
        fecnacPaci = new Date();
        lugnacPaci = "";
        depaPaci = 0l;
        provPaci = 0l;
        distPaci = 0l;
        direPaci = "";
        telefPaci = "";
        movilPaci = "";
        pacienteSelected = null;
    }

    public PacienteDataModel getPacienteDM() {
        return PacienteDM;
    }

    public void setPacienteDM(PacienteDataModel PacienteDM) {
        this.PacienteDM = PacienteDM;
    }

    public String getDniPaci() {
        return dniPaci;
    }

    public void setDniPaci(String dniPaci) {
        this.dniPaci = dniPaci;
    }

    public String getApematPaci() {
        return apematPaci;
    }

    public void setApematPaci(String apematPaci) {
        this.apematPaci = apematPaci;
    }

    public String getApepatPaci() {
        return apepatPaci;
    }

    public void setApepatPaci(String apepatPaci) {
        this.apepatPaci = apepatPaci;
    }

    public Long getDepaPaci() {
        return depaPaci;
    }

    public void setDepaPaci(Long depaPaci) {
        this.depaPaci = depaPaci;
    }

    public String getDirePaci() {
        return direPaci;
    }

    public void setDirePaci(String direPaci) {
        this.direPaci = direPaci;
    }

    public Long getDistPaci() {
        return distPaci;
    }

    public void setDistPaci(Long distPaci) {
        this.distPaci = distPaci;
    }

    public Date getFecnacPaci() {
        return fecnacPaci;
    }

    public void setFecnacPaci(Date fecnacPaci) {
        this.fecnacPaci = fecnacPaci;
    }

    public String getLugnacPaci() {
        return lugnacPaci;
    }

    public void setLugnacPaci(String lugnacPaci) {
        this.lugnacPaci = lugnacPaci;
    }

    public String getMovilPaci() {
        return movilPaci;
    }

    public void setMovilPaci(String movilPaci) {
        this.movilPaci = movilPaci;
    }

    public Long getProvPaci() {
        return provPaci;
    }

    public void setProvPaci(Long provPaci) {
        this.provPaci = provPaci;
    }

    public String getSexoPaci() {
        return sexoPaci;
    }

    public void setSexoPaci(String sexoPaci) {
        this.sexoPaci = sexoPaci;
    }

    public String getTelefPaci() {
        return telefPaci;
    }

    public void setTelefPaci(String telefPaci) {
        this.telefPaci = telefPaci;
    }

    public List<Paciente> getListado_busquedaPaciente() {
        return listado_busquedaPaciente;
    }

    public void setListado_busquedaPaciente(List<Paciente> listado_busquedaPaciente) {
        this.listado_busquedaPaciente = listado_busquedaPaciente;
    }

    public String getNombPaci() {
        return nombPaci;
    }

    public void setNombPaci(String nombPaci) {
        this.nombPaci = nombPaci;
    }

    public Paciente getPacienteSelected() {
        return pacienteSelected;
    }

    public void setPacienteSelected(Paciente pacienteSelected) {
        this.pacienteSelected = pacienteSelected;
    }

    public List<SelectItem> getComboDepartamento() {
        comboDepartamento = new ArrayList();
        UbigeoDAO ubigeo = new UbigeoDAO();
        List<Departamento> listado = ubigeo.lista_departamento();
        for (Departamento depa : listado) {
            SelectItem opt = new SelectItem();
            opt.setLabel(depa.getDesc_depa());
            opt.setValue(depa.getId_depa());
            comboDepartamento.add(opt);
        }
        return comboDepartamento;
    }

    public void setComboDepartamento(List<SelectItem> comboDepartamento) {
        this.comboDepartamento = comboDepartamento;
    }

    public List<SelectItem> getComboDistrito() {
        if (depaPaci != null && provPaci != null) {
            comboDistrito = new ArrayList();
            UbigeoDAO ubigeo = new UbigeoDAO();
            List<Distrito> listado = ubigeo.lista_distrito(depaPaci, provPaci);
            for (Distrito dist : listado) {
                SelectItem opt = new SelectItem();
                opt.setLabel(dist.getDesc_dist());
                opt.setValue(dist.getId_dist());
                comboDistrito.add(opt);
            }
        }
        return comboDistrito;
    }

    public void setComboDistrito(List<SelectItem> comboDistrito) {
        this.comboDistrito = comboDistrito;
    }

    public List<SelectItem> getComboProvincia() {
        if (depaPaci != null) {
            comboProvincia = new ArrayList();
            UbigeoDAO ubigeo = new UbigeoDAO();
            List<Provincia> listado = ubigeo.lista_provincia(depaPaci);
            for (Provincia prov : listado) {
                SelectItem opt = new SelectItem();
                opt.setLabel(prov.getDesc_prov());
                opt.setValue(prov.getId_prov());
                comboProvincia.add(opt);
            }
        }

        return comboProvincia;
    }

    public void setComboProvincia(List<SelectItem> comboProvincia) {
        this.comboProvincia = comboProvincia;
    }

    public String registrarPaciente() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Persona persona = new Persona();

        persona.setDni_psn(dniPaci);
        persona.setNomb_psn(nombPaci);
        persona.setApepat_psn(apepatPaci);
        persona.setApemat_psn(apematPaci);
        persona.setSexo_psn(sexoPaci);
        persona.setFecnac_psn(sdf.format(fecnacPaci));
        persona.setLugnac_psn(lugnacPaci);
        persona.setDepa_psn(depaPaci);
        persona.setProv_psn(provPaci);
        persona.setDist_psn(distPaci);
        persona.setDire_psn(direPaci);
        persona.setTelef_psn(telefPaci);
        persona.setMovil_psn(movilPaci);

        pacienteDAO = new PacienteDAO();
        int i = pacienteDAO.registraPaciente(persona);

        if (i > 0) {
            String msj = "Paciente Registrado con Exito";
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            listado_busquedaPaciente = pacienteDAO.lista_busquedaPaciente(dniPaci, nombPaci);
            PacienteDM = new PacienteDataModel(listado_busquedaPaciente);

        } else {
            String msj = "Error. Paciente no Ingresado";
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }

        this.limpiar();
        RequestContext.getCurrentInstance().update("frmGestionarPaciente:tblPaciente");
        RequestContext.getCurrentInstance().update("frmGestionarPaciente:msgBandejaPaciente");
        RequestContext.getCurrentInstance().execute("frmAgregarPaciente:dlgAgregarPaciente.hide()");

        return "";

    }

    public String editarPaciente() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Persona persona = new Persona();

        persona.setId_psn(pacienteSelected.getPersona().getId_psn());
        persona.setDni_psn(dniPaci);
        persona.setNomb_psn(nombPaci);
        persona.setApepat_psn(apepatPaci);
        persona.setApemat_psn(apematPaci);
        persona.setSexo_psn(sexoPaci);
        persona.setFecnac_psn(sdf.format(fecnacPaci));
        persona.setLugnac_psn(lugnacPaci);
        persona.setDepa_psn(depaPaci);
        persona.setProv_psn(provPaci);
        persona.setDist_psn(distPaci);
        persona.setDire_psn(direPaci);
        persona.setTelef_psn(telefPaci);
        persona.setMovil_psn(movilPaci);

        pacienteDAO = new PacienteDAO();
        int i = pacienteDAO.editaPaciente(persona);

        if (i > 0) {
            String msj = "Informacion de Paciente se Actualizado Satisfactoriamente";
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            listado_busquedaPaciente = pacienteDAO.lista_busquedaPaciente(dniPaci, nombPaci);
            PacienteDM = new PacienteDataModel(listado_busquedaPaciente);

        } else {
            String msj = "Informacion de Paciente no Actualizada";
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }
        this.limpiar();
        RequestContext.getCurrentInstance().update("frmGestionarPaciente:tblPaciente");
        RequestContext.getCurrentInstance().update("frmGestionarPaciente:msgBandejaPaciente");
        RequestContext.getCurrentInstance().execute("frmEditarPaciente:dlgEditarPaciente.hide()");

        return "";

    }
}
