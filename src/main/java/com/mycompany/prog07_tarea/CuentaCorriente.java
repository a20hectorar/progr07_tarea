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
 * clase abstracta que hereda de CuentaBancaria
 */
public abstract class CuentaCorriente extends CuentaBancaria{
       /**
 * atributo listaEntidadesAutorizadasCobro que guardaría una lista con las entidades con permiso para retirar efectivo de una cuenta
 */
    private String listaEntidadesAutorizadasCobro;
       /**
 * constructor con 3 parámetros
 * @param titular de la cuenta
 * @param saldo de la cuenta
 * @param iban de la cuenta
 */
    public CuentaCorriente(Persona titular,double saldo,String iban){
        super(titular,saldo,iban);
    }

    public String getListaEntidadesAutorizadasCobro() {
        return listaEntidadesAutorizadasCobro;
    }

    public void setListaEntidadesAutorizadasCobro(String listaEntidadesAutorizadasCobro) {
        this.listaEntidadesAutorizadasCobro = listaEntidadesAutorizadasCobro;
    }
}
