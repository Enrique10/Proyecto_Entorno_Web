package com.clinica.managedBean;

import com.clinica.bean.Usuario;
import com.clinica.dao.PersonalDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author GERARDO
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginMB {

    private Usuario usuario; 
    private String user;
    private String clave;

    public LoginMB() {

        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
            } else {
                usuario = new Usuario();
            }
        } catch (Exception e) {
        }

    }

    public String validarUsuario() {

        String ir = "";

        PersonalDAO personal = new PersonalDAO();
        Usuario usu = personal.validarUsuario(user, clave);

        if (usu != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usu);
            ir = "gestionar_cita";
        } else {
            String msj = "Usuario o Contraseña Incorrecta";
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            RequestContext.getCurrentInstance().update("frmlogin:msglogin");
            ir = "";
        }
        return ir;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }       

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
