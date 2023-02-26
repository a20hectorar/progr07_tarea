package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    private double comisionMantenimiento;
    
    public CuentaCorrientePersonal(Persona titular,double saldo,String iban, double comisionMantenimiento){
        super(titular,saldo,iban);
        this.comisionMantenimiento=comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    
}
