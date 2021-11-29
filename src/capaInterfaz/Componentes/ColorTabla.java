package capaInterfaz.Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorTabla extends DefaultTableCellRenderer {

    private final JLabel firstLabel = new JLabel() {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(getBackground());
            float r = 8f;
            float x = 0f;
            float y = 0f;
            float w = getWidth();
            float h = getHeight();
            Path2D p = new Path2D.Float();
            p.moveTo(x, y + r);
            p.quadTo(x, y, x + r, y);
            p.lineTo(x + w, y);
            p.lineTo(x + w, y + h);
            p.lineTo(x + r, y + h);
            p.quadTo(x, y + h, x, y + h - r);
            p.closePath();
            g2.fill(p);
            g2.dispose();
            super.paintComponent(g);
        }
    };
    private final JLabel lastLabel = new JLabel() {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(getBackground());
            float r = 8f;
            float x = 0f;
            float y = 0f;
            float w = getWidth();
            float h = getHeight();
            Path2D p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(x + w - r, y);
            p.quadTo(x + w, y, x + w, y + r);
            p.lineTo(x + w, y + h - r);
            p.quadTo(x + w, y + h, x + w - r, y + h);
            p.lineTo(x, y + h);
            p.closePath();
            g2.fill(p);
            g2.dispose();
            super.paintComponent(g);
        }
    };

    public ColorTabla() {
        super();
        firstLabel.setOpaque(false);
        lastLabel.setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        firstLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        lastLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0) {
            l = firstLabel;
        } else if (column == table.getColumnCount() - 1) {
            l = lastLabel;
        }
        l.setFont(table.getFont());
        l.setText(value.toString());
        l.setForeground(Color.WHITE);
        l.setBackground(new Color(16, 171, 131));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Gadugi", Font.BOLD, 16));

        return l;
    }

}
