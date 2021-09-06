/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controllers.ClickEvent;
import controllers.InitialData;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.BarcoDeMotorModel;
/**
 *
 * @author david
 * clase para manejar la interfaz del panel de control
 */
public class ControlsPanel extends JPanel{
    
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonObtenerBarco;
    private javax.swing.JButton jButtonObtenerBarcos;
    private javax.swing.JLabel jLabelAutonomia;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelMotores;
    private javax.swing.JLabel jLabelNameRegistro;
    private javax.swing.JLabel jLabelPropietario;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAutonomia;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMotores;
    private javax.swing.JTextField jTextFieldPropietario;
    private javax.swing.JTextField jTextFieldRegistro;
    private javax.swing.JTable tblResults;
    
     public ControlsPanel(ResultsPanel resultsPanel){
         //obtiene la tabla de resultados
        this.tblResults = resultsPanel.getTblResults();

        initComponents();
    }
     private void initComponents(){
        //color de fondo
        setBackground(new java.awt.Color(29, 53, 87));
        setToolTipText("");
        
        //intancia los eventos de los botones
        ClickEvent clickEvent = new ClickEvent(this);
        
        //muestra la informacion inicial de la base de datos
        InitialData initialData = new InitialData();
        
        //campos de texto
        jLabeltitle = new JLabel();
        jLabelNameRegistro = new JLabel();
        jSeparator1 = new JSeparator();
        jLabelMotores = new JLabel();
        jLabelAutonomia = new JLabel();
        jLabelMarca = new JLabel();
        jLabelPropietario = new JLabel();
        jTextFieldMotores = new JTextField();
        jTextFieldRegistro = new JTextField();
        jTextFieldPropietario = new JTextField();
        jTextFieldAutonomia = new JTextField();
        jTextFieldMarca = new JTextField();
        jButtonObtenerBarcos = new JButton();
        jButtonObtenerBarco = new JButton();
        jButtonAgregar = new JButton();
        jButtonEliminar = new JButton();
        jButtonActualizar = new JButton();
        
        //diseño campos de txto y titulo
        jLabeltitle.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabeltitle.setForeground(new Color(241, 250, 238));
        jLabeltitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLabeltitle.setText("NaviShip");
        jLabeltitle.setVerticalAlignment(SwingConstants.BOTTOM);

        jLabelNameRegistro.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNameRegistro.setForeground(new Color(241, 250, 238));
        jLabelNameRegistro.setText("Registro del barco:");

        jLabelMotores.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabelMotores.setForeground(new Color(241, 250, 238));
        jLabelMotores.setText("N° de motores:");

        jLabelAutonomia.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAutonomia.setForeground(new Color(241, 250, 238));
        jLabelAutonomia.setText("Autonomía:");

        jLabelMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelMarca.setForeground(new Color(241, 250, 238));
        jLabelMarca.setText("Marca:");

        jLabelPropietario.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPropietario.setForeground(new Color(241, 250, 238));
        jLabelPropietario.setText("Propietario:");

        
        /*
        Agrego los botones y les agrego un action listener del evento clickEvent
        */

        jButtonObtenerBarcos.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jButtonObtenerBarcos.setText("Obtener todos");
        jButtonObtenerBarcos.addActionListener(clickEvent);

        jButtonObtenerBarco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonObtenerBarco.setText("Obtener ");
        jButtonObtenerBarco.addActionListener(clickEvent);

        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(clickEvent);

        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(clickEvent);

        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(clickEvent);
        
        
        //Distribucion del panel y sus componentes
        javax.swing.GroupLayout ControlsPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(ControlsPanelLayout);
        ControlsPanelLayout.setHorizontalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonObtenerBarcos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonObtenerBarco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ControlsPanelLayout.createSequentialGroup()
                        .addComponent(jLabelAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ControlsPanelLayout.createSequentialGroup()
                                .addComponent(jLabelPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ControlsPanelLayout.createSequentialGroup()
                                    .addComponent(jLabelNameRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ControlsPanelLayout.createSequentialGroup()
                                    .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelMotores, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldMarca)
                                        .addComponent(jTextFieldMotores))))
                            .addComponent(jTextFieldAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(ControlsPanelLayout.createSequentialGroup()
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ControlsPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ControlsPanelLayout.setVerticalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlsPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNameRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMotores, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMotores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonObtenerBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonObtenerBarco, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        
        this.setTblResults(initialData.getBarcos());
     }

     /* 
     getters y setters para los campos de texto y los botones
     */
    public JButton getjButtonAgregar() {
        return jButtonAgregar;
    }

    public JButton getjButtonEliminar() {
        return jButtonEliminar;
    }

    public JButton getjButtonObtenerBarco() {
        return jButtonObtenerBarco;
    }

    public JButton getjButtonObtenerBarcos() {
        return jButtonObtenerBarcos;
    }

    public JButton getjButtonActualizar() {
        return jButtonActualizar;
    }
     

    public JTextField getjTextFieldAutonomia() {
        return jTextFieldAutonomia;
    }

    public JTextField getjTextFieldMarca() {
        return jTextFieldMarca;
    }

    public JTextField getjTextFieldMotores() {
        return jTextFieldMotores;
    }

    public JTextField getjTextFieldPropietario() {
        return jTextFieldPropietario;
    }

    public JTextField getjTextFieldRegistro() {
        return jTextFieldRegistro;
    }

    public JTable getTblResults() {
        return tblResults;
    }
    
    //metodo para obtener los resultados de la tabla
    public void setTblResults(ArrayList<BarcoDeMotorModel> barcos) {
        System.out.println(barcos);
        String[] headers = {"Registro", "Marca", "Cantidad de Motores", "Propietario", "Autonomía (horas)"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel(){
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<barcos.size(); i++){
            tableModel.addRow(barcos.get(i).toArray() );
        }
    }

}
