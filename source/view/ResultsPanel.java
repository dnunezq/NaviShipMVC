/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author david
 * clase para la tabla de resultados
 */
public class ResultsPanel extends JScrollPane{
    
    private JTable tblResults;
    public ResultsPanel(){
        initComponents();
    }
    
    private void initComponents(){
        //nueva tabla
        tblResults = new JTable();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        //añade scrollbar
        setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblResults.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblResults.setFont(new java.awt.Font("Segoe UI", 0, 14)); // fuente de letra
        
        
        tblResults.setGridColor(new java.awt.Color(255, 255, 255));
       
        setViewportView(tblResults);
        if (tblResults.getColumnModel().getColumnCount() > 0) {
            tblResults.getColumnModel().getColumn(0).setResizable(false);
            tblResults.getColumnModel().getColumn(1).setResizable(false);
            tblResults.getColumnModel().getColumn(2).setResizable(false);
            tblResults.getColumnModel().getColumn(3).setResizable(false);
            tblResults.getColumnModel().getColumn(4).setResizable(false);
        }
        
    
    }
    /*
    metodo para obtener los resultados de la tabla
    */
    public JTable getTblResults() {
        return tblResults;
    }

    
}
