package com.mycompany.prog07_tarea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class Banco {
    
    CuentaBancaria listaCuentas[]=new CuentaBancaria[100];
    String infoCuenta[]=new String[100];
    
    boolean abrirCuenta(CuentaBancaria nuevaCuenta){
        for(int i=0;i<100;i++){
            if(listaCuentas[i]==null){
                listaCuentas[i]=nuevaCuenta;
                return true;
            }
        }
        return false;
    }
    
    String[] listadoCuentas(){
        for(int i=0;i<listaCuentas.length;i++){
            infoCuenta[i]=listaCuentas[i].getTitular().getNombre() + listaCuentas[i].getTitular().getApellidos() + listaCuentas[i].getTitular().getDni();
        }
        return infoCuenta;
    }
    
    String informacionCuenta(String iban){  
        listadoCuentas();
        for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                return infoCuenta[i];
            }
        }
        return null;
    }
    
    boolean ingresoCuenta(String iban,double cantidad){
        for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                listaCuentas[i].setSaldo(listaCuentas[i].getSaldo() + cantidad);
                return true;
            }
        }
        return false;
    }
    
    boolean retiradaCuenta(String iban,double cantidad){
        for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                if(listaCuentas[i].getSaldo()>=cantidad){
                    listaCuentas[i].setSaldo(listaCuentas[i].getSaldo() - cantidad);
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
    
    double obtenerSaldo(String iban){
         for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                return listaCuentas[i].getSaldo();
            }
        }
        System.out.println("No se encontró la cuenta.");
        return -1;
    }
}
