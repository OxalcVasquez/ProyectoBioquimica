/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJDBCConexion;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 * @author Jordan Oxalc Vásquez Fernández
 */
public class clsReporte {

    public String RUTA_REPORTES = "src\\Reportes\\";

    public JRViewer reporteInterno(String archivoReporte,Map<String,Object> parametros) throws Exception {
        try {
            clsJDBCConexion objConexion = new clsJDBCConexion();
            objConexion.conectarBD();
            JasperPrint miReporte = JasperFillManager.fillReport(RUTA_REPORTES + archivoReporte, parametros, objConexion.getCon());
            JRViewer visorReporte = new JRViewer(miReporte);
            return visorReporte;
        } catch (Exception e) {
//            throw new Exception("Error al cargar el reporte...");
            throw new Exception(e);
        }
    }
}
