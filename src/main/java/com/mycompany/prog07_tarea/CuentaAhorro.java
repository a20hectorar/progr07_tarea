package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class CuentaAhorro extends CuentaBancaria{
    private double interes;
    
    public CuentaAhorro(){
        super();
    }
    
    public CuentaAhorro(Persona titular,double saldo, String iban, double interes){
        super(titular,saldo,iban);
        this.interes=interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
    
    
}
