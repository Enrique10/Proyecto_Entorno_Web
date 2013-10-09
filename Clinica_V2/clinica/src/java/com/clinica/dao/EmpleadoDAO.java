
package com.clinica.dao;

import com.clinica.bean.Empleado;
import com.clinica.bean.Especialidad;
import com.clinica.bean.Perfil;
import com.clinica.bean.Persona;
import com.clinica.util.DBconex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
    
    private Connection cn = DBconex.getConexion();
    private PreparedStatement pt;
    private ResultSet rs;
    
    public List<Empleado> lista_busquedaEmpleado(String pdni_psn, String pnomb_psn){
        List<Empleado> lista = null;
        try{
          lista = new ArrayList<Empleado>();
            String cadena = "select e.*, psn.*, pf.*, espe.* from empleado e, " +
            "persona psn, perfil pf, especialidad espe " + 
            "where e.id_pf = pf.id_pf and e.id_psn = psn.id_psn and " +  
            "e.id_espe = espe.id_espe and pf.id_pf = 2 and psn.dni_psn like '%" + pdni_psn + "%' and " +  
            "psn.nomb_psn like '%" + pnomb_psn + "%' ";
            System.out.println(cadena);
            pt = cn.prepareStatement(cadena);
            rs = pt.executeQuery();
            Empleado empleado = new Empleado(); 
            Persona persona = new Persona();
            Perfil perfil = new Perfil();
            Especialidad especialidad = new Especialidad();
            while(rs.next()){
                
                perfil = new Perfil();
                perfil.setId_pf(Long.valueOf(rs.getString("id_pf")));
                perfil.setNomb_pf(rs.getString("nomb_pf"));
                
                persona = new Persona();
                persona.setId_psn(Integer.parseInt(rs.getString("id_psn")));
                persona.setDni_psn(rs.getString("dni_psn"));
                persona.setNomb_psn(rs.getString("nomb_psn"));
                persona.setApepat_psn(rs.getString("apepat_psn"));
                persona.setApemat_psn(rs.getString("apemat_psn"));
                persona.setSexo_psn(rs.getString("sexo_psn"));
                persona.setFecnac_psn(rs.getString("fecnac_psn"));
                persona.setLugnac_psn(rs.getString("lugnac_psn"));
                persona.setDepa_psn(Long.valueOf(rs.getString("depa_psn")));
                persona.setProv_psn(Long.valueOf(rs.getString("prov_psn")));
                persona.setDist_psn(Long.valueOf(rs.getString("dist_psn")));
                persona.setDire_psn(rs.getString("dire_psn"));
                persona.setTelef_psn(rs.getString("telef_psn"));
                persona.setMovil_psn(rs.getString("movil_psn"));
                
                especialidad = new Especialidad();
                especialidad.setId_espe(Long.valueOf(rs.getString("id_espe")));
                especialidad.setNomb_espe(rs.getString("nomb_espe"));
                
                empleado = new Empleado();
                empleado.setId_emp(Long.valueOf(rs.getString("id_emp")));
                empleado.setPerfil(perfil);
                empleado.setPersona(persona);
                empleado.setEspecialidad(especialidad);
                
                lista.add(empleado);
            }
        }catch(Exception e){
            
        }
        return lista;
    }
    
    
}
