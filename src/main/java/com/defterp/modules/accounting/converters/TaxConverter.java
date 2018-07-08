package com.defterp.modules.accounting.converters;

import com.defterp.modules.accounting.entities.Tax;
import com.defterp.dataAccess.GenericDAO;
import com.defterp.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author MOHAMMED BOUNAGA
 *
 * github.com/medbounaga
 */

@FacesConverter(value = "taxConverter")
public class TaxConverter implements Converter {

    @Inject
    private GenericDAO dataAccess;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value) | !isNumeric(value)) {
            return null;
        }
        return dataAccess.findById(getKey(value), Tax.class);
    }

    private Integer getKey(String value) {
        Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    private String getStringKey(Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Tax) {
            Tax o = (Tax) object;
            return getStringKey(o.getId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tax.class.getName()});
            return null;
        }
    }

}
