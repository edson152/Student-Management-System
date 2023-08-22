package StudentApp;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;


public  class SimpleTableModel<T> extends AbstractTableModel
{
   protected List<String> cols;
   protected List<T> rows;

    public SimpleTableModel(List<String> cols, List<T> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
      
 
    public int getRowCount() {
        return rows.size();
    }


    public int getColumnCount() {
        return  cols.size();
    }

 
    public String getColumnName(int column) {
        return cols.get(column);
    }
    
   
    public  Object getValueAt(int rowIndex, int columnIndex) {
       try {
           List<Method> getMethods=ClassRefect.getAllGetMethod(rows.get(rowIndex));          
           return getMethods.get(columnIndex).invoke(rows.get(rowIndex), null);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalArgumentException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InvocationTargetException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return "";
    }
    
}

