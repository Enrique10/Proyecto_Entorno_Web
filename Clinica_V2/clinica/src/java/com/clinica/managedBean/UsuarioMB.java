
package com.clinica.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;


@ManagedBean(name="usuarioMB")
@ViewScoped

public class UsuarioMB {
    
    public UsuarioMB(){
        
    }
    
    public void preEditarUsuario(){
        RequestContext.getCurrentInstance().update("");
        RequestContext.getCurrentInstance().execute("");
    } 
    
    public void preRegistrarUsuario(){
        RequestContext.getCurrentInstance().update("frmNuevoUsuario:dlgNuevoUsuario");
        RequestContext.getCurrentInstance().execute("dlgNuevoUsuario.show()");
    } 
    
}
