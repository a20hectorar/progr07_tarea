package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    private String listaEntidadesAutorizadasCobro;
    
    public CuentaCorriente(){};

    public String getListaEntidadesAutorizadasCobro() {
        return listaEntidadesAutorizadasCobro;
    }

    public void setListaEntidadesAutorizadasCobro(String listaEntidadesAutorizadasCobro) {
        this.listaEntidadesAutorizadasCobro = listaEntidadesAutorizadasCobro;
    }
    
    
}
