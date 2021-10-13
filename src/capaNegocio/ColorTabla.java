
package capaNegocio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorTabla extends DefaultTableCellRenderer {
    
    public ColorTabla() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
           setFont(new Font("Gadugi", Font.BOLD, 18));
           setBackground(new Color(84, 248, 147));
           setForeground(new Color(255, 255, 255));
           
            return this;
        }
   
    
    
}
