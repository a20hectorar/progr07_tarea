package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */

   /**
 * clase que hereda de CuentaBancaria
 */
public class CuentaAhorro extends CuentaBancaria{
       /**
 * interes es un atributo propio de CuentaAhorro que guarda el valor de los intereses sobre el saldo
 */
    private double interes;
       /**
 * constructor con 4 parámetros
 * @param titular de la cuenta:objeto tipo Persona
 * @param saldo de la cuenta
 * @param iban de la cuenta
 * @param interes de la cuenta, parámetro propio de la clase
 */
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
