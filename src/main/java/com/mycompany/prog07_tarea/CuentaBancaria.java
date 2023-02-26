package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public abstract class CuentaBancaria implements Imprimible{
    private Persona titular;
    private double saldo;
    private String iban;
    
    public CuentaBancaria(Persona titular, double saldo, String iban){
        this.titular=new Persona(titular.getNombre(),titular.getApellidos(),titular.getDni());
        this.saldo=saldo;
        this.iban=iban;
    }
        
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

    @Override
    public String devolverInfoString() {
        return "Nombre: " + this.titular.getNombre() + " Apellidos: " + this.titular.getApellidos() + " DNI: " + 
                this.titular.getDni() + " IBAN: " + this.iban + " Saldo: " + this.saldo;
    }
    
  
}
