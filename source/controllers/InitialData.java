/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import acess.BarcoDeMotorDAO;
import java.util.ArrayList;
import model.BarcoDeMotorModel;



/**
Clase para inicializar la informacion que se mostrará en la interfaz en un principio
 */
public class InitialData {
    private ArrayList<BarcoDeMotorModel>  barcos   = null;
    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        BarcoDeMotorDAO barcoDAO = new BarcoDeMotorDAO();
        this.barcos = barcoDAO.obtenerBarcos();//obtiene los barcos
        
    }

    /**
     * @return the museums
     */
    public ArrayList<BarcoDeMotorModel> getBarcos() {
        return barcos;
    }

    
}