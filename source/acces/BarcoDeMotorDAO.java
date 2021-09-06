/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.BarcoDeMotorModel;
import utils.ConnectionDB;

/**
 *
 * @author david
 */
public class BarcoDeMotorDAO {
    private Connection conn;
    
    /*
    Función para obtener en un array todos los barcos de motor registrados
    */
    public ArrayList<BarcoDeMotorModel> obtenerBarcos(){
        //instanciar el arreglo a retornar
        ArrayList<BarcoDeMotorModel> barcos=new ArrayList<>();
        
        try{
            if(conn==null){
                conn=ConnectionDB.getConnection();
                
                }
            
            //Query
            String  sql="SELECT mot_registro  as Registro,mot_marca as Marca,mot_cantidadMotores as \"N° de motores\","
                    + "barc_propietario as Propietario, mot_autonomia_horas as \"Autonomía (Horas)\" "
                    + "From de_motor,barco where de_motor.mot_registro=barco.registro ORDER BY  mot_registro ASC ;";
            
            //ejecuta query
            Statement statement=conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            // agrega los barcos obtenidos de la base de datos al arreglo a retornar
            while(result.next()){
                BarcoDeMotorModel barco=new BarcoDeMotorModel(result.getString(1),result.getString(2),result.getInt(3),
                        result.getString(4),result.getDouble(5));
                barcos.add(barco);
                
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return barcos;
    }
    
    /*
    Función para obtener un barco en especifico
    */
    
    public BarcoDeMotorModel obtenerBarco(String registro){
        
        BarcoDeMotorModel barco=null;
        
        try{
            if(conn==null){
                conn=ConnectionDB.getConnection();
            }
            //query
            String  sql="SELECT mot_registro  as Registro,mot_marca as Marca,mot_cantidadMotores as \"N° de motores\","
                    + "barc_propietario as Propietario, mot_autonomia_horas as \"Autonomía (Horas)\" "
                    + "from de_motor,barco where de_motor.mot_registro=barco.registro and  barco.registro=? ;";
            
            //preparacion del query
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1, registro);
            
            //ejecucion del query
            ResultSet result = statement.executeQuery();
            
            //obtiene el barco
            boolean items=false;
            while(result.next()){
                items=true;
                barco=new BarcoDeMotorModel(result.getString(1),result.getString(2),result.getInt(3),
                result.getString(4),result.getDouble(5));
                break;
            }
            
            //items es un flag que determina si se encontró el barco o no
            if(!items){
                JOptionPane.showMessageDialog(null,"No se encontró registro del barco");
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return barco;
    }
    
    /*
    Función para agregar un barco de motor
    */
    public int agregarBarco(BarcoDeMotorModel barco){
        try{
            if(conn==null){
                conn=ConnectionDB.getConnection();}
            
            /* Inserto primero en la tabla barco para poder insertar en la tabla barco de motor*/
            //preparo query para agregar en la tabla barco
            String  sql_barco="INSERT INTO barco(registro,barc_propietario)"+
                    "VALUES(?,?);";
            PreparedStatement statementBarco=conn.prepareStatement(sql_barco);
            statementBarco.setString(1,barco.getRegistro());
            statementBarco.setString(2,barco.getPropietario_fk());
            
            //ejecuto query
            statementBarco.executeUpdate();

            //preparo query para agregar en la tabla de_motor
            String  sql="insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)"+
                    "VALUES(?,?,?,?);";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,barco.getRegistro());
            statement.setString(2,barco.getMarca());
            statement.setInt(3,barco.getCantidadMotores());
            statement.setDouble(4,barco.getAutonomiaHoras());  
            
            //ejecuto query
            statement.executeUpdate();
            
        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Verifique que el registro del barco no exista aún o que el propietario esté registrado  ");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
     /*
    Función para actualizar atributos del barco
    */
    
    public int actualizarBarco(BarcoDeMotorModel barco){
        
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            //preparo query para actualizar propiedades del barco de motor seleccionado, primero actualizo en la tabla barco
            String sqlBarco = "UPDATE barco SET barc_propietario =? WHERE registro =?;";
            PreparedStatement statementBarco = conn.prepareStatement(sqlBarco);
            statementBarco.setString(2,barco.getRegistro());
            statementBarco.setString(1,barco.getPropietario_fk());
            
            //ejecuto query
            int rowsUpdated=statementBarco.executeUpdate();


            //preparo query para actualizar propiedades del barco en la tabla de_motor
            String sql = "UPDATE de_motor SET mot_marca =?,mot_cantidadMotores =?,"
                    + "mot_autonomia_horas =? WHERE mot_registro =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,barco.getMarca());
            statement.setInt(2,barco.getCantidadMotores());
            statement.setDouble(3,barco.getAutonomiaHoras());
            statement.setString(4,barco.getRegistro());
            
            //ejecuto query
            rowsUpdated += statement.executeUpdate();
            return rowsUpdated; // se actualizo
            
        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Verifique el registro del nuevo propietario");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return -1; // no se actualizo
    }
    
     /*
    Función para agregar un barco de motor
    */
    public int eliminarBarco(String registro){
        try{
            if(conn==null){
                conn=ConnectionDB.getConnection();
            }
            
            //preparo query para eliminar en la tabla prestamos
            String  sqlEliminar="DELETE FROM prestamos WHERE prest_barco=?;";
            PreparedStatement statementPrest=conn.prepareStatement(sqlEliminar);
            statementPrest.setString(1, registro);
            
            //ejecuto query
            statementPrest.executeUpdate(); 
            
            //preparo query para eliminar en la tabla de_motor
            String  sql="DELETE FROM de_motor WHERE mot_registro=?;";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1, registro);
            
            //ejecuto query
            statement.executeUpdate();
            
            //preparo query para eliminar en la tabla barco
            String  sqlBarco="DELETE FROM barco WHERE registro=?;";
            PreparedStatement statementBarco=conn.prepareStatement(sqlBarco);
            statementBarco.setString(1, registro);
            
            //ejecuto query
            int rowsDeleted= statementBarco.executeUpdate();
            
            //determino se se eliminó o no se elimino
            if (rowsDeleted > 0) {
                return 1; //se elimino
            }
            else{
                return 0; // no se elimino
            }
                
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }   
    
    
    
}
