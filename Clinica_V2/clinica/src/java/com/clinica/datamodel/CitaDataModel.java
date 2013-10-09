
package com.clinica.datamodel;

import com.clinica.bean.Cita;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


public class CitaDataModel extends ListDataModel<Cita> implements SelectableDataModel<Cita> {
    public CitaDataModel(){}
    
    public CitaDataModel(List<Cita> c){
        super(c);
    }
    
    @Override
    public Object getRowKey(Cita c) {
        return c.getHorario();
    }

    @Override
    public Cita getRowData(String rowKey) {
        List<Cita> CitaList = (List<Cita>)getWrappedData();
        
        for(Cita c : CitaList){
            if(c.getHorario().compareTo(rowKey)==0){
                return c;
            }
        }
        return null;
    }   
    
}
