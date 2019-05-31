package br.barretuino.integrador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Main {

    public static void main(String[] args) {
             Connection conn = null;

        try {

            conn = Conexao.getConnection();
            Map<String, Object> map =
                    new HashMap<String, Object>();
            //transmite o trecho da sintaxe SQL que completarão o relatório
            map.put("PAR_SQL", "WHERE pedidos.PedidoID=10397");

            //pega o caminho físico até o arquivo .jasper
            String arquivo = System.getProperty("user.dir") +
                    "/src/br/barretuino/integrator/RelatorioComParametroContendoTrechoSQL.jasper";

            //chama fillReport
            JasperPrint jp = JasperFillManager.fillReport(arquivo, map, conn);

            //exibe o relatório com viewReport
            JasperViewer.viewReport(jp, false);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

}
