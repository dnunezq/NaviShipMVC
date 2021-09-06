/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author david
 */
import acess.BarcoDeMotorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.BarcoDeMotorModel;
import view.ControlsPanel;

/*
Clase para manejar los distintos tipos de eventos
*/
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;//panel de control de la interfaz de usuario
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //try para manejar excepciones de tipo de dato incorrecto
        try{
            /*
            - Action a ejecutar si se oprime el boton agregar
            */
            if(actionEvent.getSource() == this.controlsPanel.getjButtonAgregar()) {
                //crea un DAO del barco
                BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();
                
                //obtiene el texto de los campos de texto
                String registro= this.controlsPanel.getjTextFieldRegistro().getText();
                String marca= this.controlsPanel.getjTextFieldMarca().getText();
                int n_motores= Integer.parseInt(this.controlsPanel.getjTextFieldMotores().getText());
                String propietario= this.controlsPanel.getjTextFieldPropietario().getText();
                double autonomia= Double.parseDouble(this.controlsPanel.getjTextFieldAutonomia().getText());

                //crea un barco
                BarcoDeMotorModel barco= new BarcoDeMotorModel(registro,marca,n_motores,propietario,autonomia);
                
                //agrega el barco
                barcoDAO.agregarBarco(barco);

                //actualiza los resultados
                this.controlsPanel.setTblResults(barcoDAO.obtenerBarcos());
            }
            
            /*
            - Action a ejecutar si se oprime el boton eliminar
            */
            else if(actionEvent.getSource() == this.controlsPanel.getjButtonEliminar()){
                //guarda si hay una fila seleccionada
                int row = controlsPanel.getTblResults().getSelectedRow();
                
                //crea un DAO del barco
                BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();
                
                //obtiene el registro del campo de texto
                String registro_delete= this.controlsPanel.getjTextFieldRegistro().getText();
                
                /*
                -determina que registro va a eliminar
                -se da prioridad al registro escrito en el campo de texto
                -si no hay registro pero esta seleccionada una fila, elimina la fila correspondiente
  
                */
                if (registro_delete.length()==0 && row!=-1){
                    registro_delete = controlsPanel.getTblResults().getModel().getValueAt(row, 0).toString();
                }
                //elimina barco
                int rowsDelete=barcoDAO.eliminarBarco(registro_delete);
                
                //si no se encontró registro, muestra mensaje en pantalla
                //si se pudo ejecutar, actualiza la ventana
                if (rowsDelete==0){
                    JOptionPane.showMessageDialog(null,"No se encontró el registro a eliminar");
                }
                else{
                    this.controlsPanel.setTblResults(barcoDAO.obtenerBarcos());
                }
                
            }
            
            /*
            - Action a ejecutar si se oprime el boton obtener barco
            */
            else if(actionEvent.getSource() == this.controlsPanel.getjButtonObtenerBarco()){
                //guarda si hay una fila seleccionada
                int row = controlsPanel.getTblResults().getSelectedRow();
                
                //crea un DAO del barco
                BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();
                
                //Obtiene el registro del campo de texto
                String registro= this.controlsPanel.getjTextFieldRegistro().getText();
                
                /*
                -Si hay una fila seleccionada y no hay registro en el campo de texto, obtiene los valores de esa fila y los pone en los campos de texto y 
                -obtiene el barco seleccionado
                */
                if(registro.length()==0 && row!=-1){
                        registro = controlsPanel.getTblResults().getModel().getValueAt(row, 0).toString();
                        String marca_tabla = controlsPanel.getTblResults().getModel().getValueAt(row, 1).toString();
                        String motores_tabla = controlsPanel.getTblResults().getModel().getValueAt(row, 2).toString();
                        String propietario_tabla = controlsPanel.getTblResults().getModel().getValueAt(row, 3).toString();
                        String autonomia_tabla = controlsPanel.getTblResults().getModel().getValueAt(row, 4).toString();
                        controlsPanel.getjTextFieldRegistro().setText(registro);
                        controlsPanel.getjTextFieldMarca().setText(marca_tabla);
                        controlsPanel.getjTextFieldMotores().setText(motores_tabla);
                        controlsPanel.getjTextFieldPropietario().setText(propietario_tabla);
                        controlsPanel.getjTextFieldAutonomia().setText(autonomia_tabla);
                    }
                //Obtiene el barco y actualiza ventana
                ArrayList<BarcoDeMotorModel> barcos= new ArrayList<>();
                barcos.add(barcoDAO.obtenerBarco(registro));

                /*
                si se encontraron registros del barco los muestro
                si no, no realizo nada
                */
                if (barcos.get(0)!=null){
                    this.controlsPanel.setTblResults(barcos);
                    
                        
                }

            }
            
            /*
            - Action a ejecutar si se oprime el boton obtener barcos
            */
            else if(actionEvent.getSource() == this.controlsPanel.getjButtonObtenerBarcos()){
                //crea un DAO del barco y obtiene todos los barcos
                BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();

                this.controlsPanel.setTblResults(barcoDAO.obtenerBarcos());
            }
            
            /*
            - Action a ejecutar si se oprime el boton actualizar
            */
            else if(actionEvent.getSource() == this.controlsPanel.getjButtonActualizar()){
                //crea un DAO del barco
                BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();
                
                //obtiene la informacion de los campos de texto
                String registro= this.controlsPanel.getjTextFieldRegistro().getText();
                String marca= this.controlsPanel.getjTextFieldMarca().getText();
                int n_motores= Integer.parseInt(this.controlsPanel.getjTextFieldMotores().getText());
                String propietario= this.controlsPanel.getjTextFieldPropietario().getText();
                double autonomia= Double.parseDouble(this.controlsPanel.getjTextFieldAutonomia().getText());
                
                //crea un modelo de barco con la informacion de los campos de texto
                BarcoDeMotorModel barco= new BarcoDeMotorModel(registro,marca,n_motores,propietario,autonomia);
                
                //actualiza barco
                int actualizacion=barcoDAO.actualizarBarco(barco);
                
                /*
                determina si se pudo actualizar o no
                */
                if (actualizacion==0){
                    JOptionPane.showMessageDialog(null,"No se encontró el registro del barco a actualizar");
                }
               
                else{
                    this.controlsPanel.setTblResults(barcoDAO.obtenerBarcos());
                }
                
            }
        }
        catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Verifique los tipos de datos y campos requeridos");
        }
    }
}