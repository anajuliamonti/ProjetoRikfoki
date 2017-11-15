package model;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class MyTable extends JTable
{
    public MyTable(Object[][] data, Object[] columnNames) 
    {
        super(data, columnNames);
        super.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
        super.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        super.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        super.setColumnSelectionAllowed(false);
        super.setRowSelectionAllowed(true);
    }
    
    public void setTableColumns(int[] sizes) throws NullPointerException
    {
        for (int i = 0; i < sizes.length; i++) 
        {
            try {
                super.getColumnModel().getColumn(i).setPreferredWidth(sizes[i]);
            } catch (ArrayIndexOutOfBoundsException e1) {
                break;
            }
        }
    }
}