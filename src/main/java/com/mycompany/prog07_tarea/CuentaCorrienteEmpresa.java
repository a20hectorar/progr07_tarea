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
public class CuentaCorrienteEmpresa extends CuentaCorriente{
       /**
 * interesDescubierto guarda el valor del tipo de interes cargado sobre un descubierto
 * descubiertoMaximo guarda el valor de la cantidad máxima que puede estar en negativo
 * comisionFijaDescubierto guarda el valor de una comisión fija sobre el descubierto
 */
    private double interesDescubierto;
    private double descubiertoMaximo;
    private double comisionFijaDescubierto;
           /**
 * constructor con 6 parámetros
 * @param titular de la cuenta
 * @param saldo de la cuenta
 * @param iban de la cuenta
 * @param interesDescubierto propio de la clase
 * @param descubiertoMaximo propio de la clase
 * @param comisionFijaDescubierto propio de clase
 */
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, double interesDescubierto, double descubiertoMaximo, double comisionFijaDescubierto){
        super(titular,saldo,iban);
        this.interesDescubierto=interesDescubierto;
        this.descubiertoMaximo=descubiertoMaximo;
        this.comisionFijaDescubierto=comisionFijaDescubierto;
    }

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
