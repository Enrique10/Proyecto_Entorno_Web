
package com.clinica.datamodel;

import com.clinica.bean.Empleado;
import com.clinica.bean.Paciente;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


public class PacienteDataModel extends ListDataModel<Paciente> implements SelectableDataModel<Paciente> {
    public PacienteDataModel(){}
    
    public PacienteDataModel(List<Paciente> p){
        super(p);
    }
    
    @Override
    public Object getRowKey(Paciente p) {
        return p.getId_paci();
    }

    @Override
    public Paciente getRowData(String rowKey) {
        List<Paciente> PacienteList = (List<Paciente>)getWrappedData();
        
        for(Paciente p : PacienteList){
            if(p.getId_paci().compareTo(Long.parseLong(rowKey))==0){
                return p;
            }
        }
        return null;
    }   
    
}
