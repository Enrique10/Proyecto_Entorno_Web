
package com.clinica.datamodel;

import com.clinica.bean.Empleado;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


public class EmpleadoDataModel extends ListDataModel<Empleado> implements SelectableDataModel<Empleado> {
    public EmpleadoDataModel(){}
    
    public EmpleadoDataModel(List<Empleado> e){
        super(e);
    }
    
    @Override
    public Object getRowKey(Empleado e) {
        return e.getId_emp().intValue()+"";
    }

    @Override
    public Empleado getRowData(String rowKey) {
        List<Empleado> EmpleadoList = (List<Empleado>)getWrappedData();
        
        for(Empleado e : EmpleadoList){
            if(e.getId_emp().compareTo(Long.parseLong(rowKey))==0){
                return e;
            }
        }
        return null;
    }   
    
}
