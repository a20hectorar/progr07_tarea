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
 * clase padre de las cuentas
 */
public abstract class CuentaBancaria implements Imprimible{
       /**
 * atributo titular de tipo objeto Persona con los datos personales
 * atributo saldo guarda el saldo de la cuenta
 * atributo iban es una cadena que guarda el código IBAN identificador de cada cuenta
 */
    private Persona titular;
    private double saldo;
    private String iban;
    
       /**
 * escribimos dos constructores de la clase para poder tener acceso a dos formas de instanciar CuentaBancaria
 */
       /**
 * Constructor con 3 parámetros
 * @param titular de la cuenta
 * @param saldo de la cuenta
 * @param iban de la cuenta
 */
    public CuentaBancaria(Persona titular, double saldo, String iban){
        this.titular=new Persona(titular.getNombre(),titular.getApellidos(),titular.getDni());
        this.saldo=saldo;
        this.iban=iban;
    }
       /**
 * constructor con 5 parámetros
 * @param nombre del titular
 * @param apellidos del titular
 * @param dni del titular
 * @param saldo de la cuenta
 * @param iban de la cuenta
 */
    public CuentaBancaria(String nombre, String apellidos, String dni, double saldo, String iban){
        this.titular=new Persona(nombre,apellidos,dni);
        this.saldo=saldo;
        this.iban=iban;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
       /**
 * sobreescribimos el metodo de la interfaz Imprimible devolverInfoString que nos devolverá los datos de las cuentas
 * @return info de la cuenta
 */
    @Override
    public String devolverInfoString() {
        return "Nombre: " + this.titular.getNombre() + " Apellidos: " + this.titular.getApellidos() + " DNI: " + 
                this.titular.getDni() + " IBAN: " + this.iban + " Saldo: " + this.saldo;
    }
    
  
}
