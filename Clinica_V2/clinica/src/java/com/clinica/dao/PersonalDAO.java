
package com.clinica.dao;

import com.clinica.bean.Usuario;


public class PersonalDAO {
    
    public Usuario validarUsuario(String user, String password){
        Usuario personal = null;
        try{
            if(user.equals("admin123") && password.equals("123456")){
                personal = new Usuario();
                personal.setUsr_psn(user);
                personal.setClav_psn(password);
            }
        }catch(Exception e){
            e.getMessage();
        }        
        return personal;
    }
    
    
}
