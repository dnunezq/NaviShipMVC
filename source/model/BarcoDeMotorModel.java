/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author david
 */
public class BarcoDeMotorModel {
    /*
    atributos del barco de motor
    */
    private String registro;
    private String marca;
    private int cantidadMotores;
    private String propietario_fk;
    private double autonomiaHoras;
    
    /**
     * Constructor manejo interno de la tabla
     * @param registro
     * @param marca
     * @param cantidadMotores
     * @param propietario_fk
     * @param autonomiaHoras 
     */
    public BarcoDeMotorModel(String registro, String marca, int cantidadMotores, String propietario_fk, double autonomiaHoras) {
        this.registro = registro;
        this.marca = marca;
        this.cantidadMotores = cantidadMotores;
        this.propietario_fk = propietario_fk;
        this.autonomiaHoras = autonomiaHoras;
    }

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }


    /**
     * @return the cantidadMotores
     */
    public int getCantidadMotores() {
        return cantidadMotores;
    }

    /**
     * @return the propietario_fk
     */
    public String getPropietario_fk() {
        return propietario_fk;
    }

    /**
     * @return the autonomiaHoras
     */
    public double getAutonomiaHoras() {
        return autonomiaHoras;
    }

    
    
    public Object[] toArray(){
        Object[] data={registro,marca,cantidadMotores,propietario_fk,autonomiaHoras};
        return data;
    }
    
}
