package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    private double interesDescubierto;
    private double descubiertoMaximo;
    private double comisionFijaDescubierto;
    
    public CuentaCorrienteEmpresa(){}

    public double getInteresDescubierto() {
        return interesDescubierto;
    }

    public void setInteresDescubierto(double interesDescubierto) {
        this.interesDescubierto = interesDescubierto;
    }

    public double getDescubiertoMaximo() {
        return descubiertoMaximo;
    }

    public void setDescubiertoMaximo(double descubiertoMaximo) {
        this.descubiertoMaximo = descubiertoMaximo;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }
    
    
}
