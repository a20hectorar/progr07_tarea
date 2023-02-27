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
 * clase que hereda de CuentaCorriente que a su vez hereda de CuentaBancaria
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
       /**
 * comisionMantenimiento guarda el valor de la comision de mantenimiento de la cuenta
 */
    private double comisionMantenimiento;
       /**
 * constructor con 4 parámetros
 * @param titular de la cuenta
 * @param saldo de la cuenta
 * @param iban de la cuenta
 * @param comisionMantenimiento propio de la clase
 */
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
