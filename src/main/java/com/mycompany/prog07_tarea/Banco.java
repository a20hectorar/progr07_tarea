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
    /**
 * MAXNUM es una constante que toma el valor límite del array de cuentas
 * lo metemos en una constante para poder cambiar su valor a la hora de hacer pruebas
 */
    final int MAXNUM=100;
        /**
 * creamos el array listaCuentas donde iremos guardando los objetos de tipo CuentaBancaria
 */
    CuentaBancaria listaCuentas[]=new CuentaBancaria[MAXNUM];
    String infoCuenta[]=new String[MAXNUM];
        /**
 * el método abrirCuenta toma como parámetro de entrada un objeto tipo CuentaBancaria y nos recorre el array de las cuentas
 * hasta encontrar un hueco, donde guardará el siguiente objeto
 * @param nuevaCuenta de tipo CuentaBancaria
 * @return true si guarda la cuenta
 * @return false si no puede guardar la cuenta
 */
    boolean abrirCuenta(CuentaBancaria nuevaCuenta){
        for(int i=0;i<MAXNUM;i++){
            if(listaCuentas[i]==null){
                listaCuentas[i]=nuevaCuenta;
                return true;
            }
        }
        return false;
    }
          /**
 * el método listadoCuentas mete en el array infoCuenta la información de cada cuenta del array listaCuentas
 * como cadena de caracteres. Las cuentas conservan el mismo orden en ambos arrays
 * @return array infoCuenta
 */
    String[] listadoCuentas(){
        for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i]!=null){ 
            infoCuenta[i]=listaCuentas[i].devolverInfoString();
            }
        }
        return infoCuenta;
    }
          /**
 * el método informacionCuenta toma como parámetro un IBAN y devuelve la informacion de la cuenta
 * con IBAN coincidente, si no la encuentra devuelve null
 * @param iban de la cuenta
 * @return la posicion de la cuenta en el array infoCuenta
 * @return null si no hay coincidencia en el iban
 */
    String informacionCuenta(String iban){  
        listadoCuentas();
        for(int i=0;i<listaCuentas.length && listaCuentas[i]!=null;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                return infoCuenta[i];
            }
        }
        return null;
    }
          /**
 * el método ingresoCuenta toma como parámetros un IBAN para buscar la cuenta coincidente en el array listaCuentas
 * y una cantidad que será sumada al saldo de la cuenta y devuelve true si se efectúa. Si no encuentra coincidencia en el IBAN devuelve false.
 * @param iban de la cuenta
 * @param cantidad a ingresar
 * @return true si hace el ingreso
 * @return false si no hace el ingreso
 */
    boolean ingresoCuenta(String iban,double cantidad){
        for(int i=0;i<listaCuentas.length;i++){
            if(listaCuentas[i]!=null){
                if(listaCuentas[i].getIban().equals(iban)){
                    listaCuentas[i].setSaldo(listaCuentas[i].getSaldo() + cantidad);
                    return true;
                }
            }
        }
        return false;
    }
          /**
 el método retiradaCuenta toma como parámetros un IBAN para buscar la cuenta coincidente en el array listaCuentas
 * y una cantidad que será restada al saldo de la cuenta y devuelve true si se efectúa. Si no encuentra coincidencia en el IBAN devuelve false.
 * Igualmente si no se puede efectuar la retirada por falta de fondos devuelve false.
 * @param iban de la cuenta
 * @param cantidad a retirar de la cuenta
 * @return true si hace la retirada
 * @return false si no hace la retirada
 */
    boolean retiradaCuenta(String iban,double cantidad){
        for(int i=0;i<listaCuentas.length && listaCuentas[i]!=null;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                //comprobamos que la cantidad a restar del saldo es por lo menos igual al saldo de la cuenta
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
    /**
 * obtenerSaldo toma como parámetro un IBAN para buscar la cuenta coincidente y muestra el atributo saldo
 * @param iban de la cuenta
 * @return el saldo guardado en el array listaCuentas
 * @return -1 si no encuentra la cuenta
 */
    double obtenerSaldo(String iban){
         for(int i=0;i<listaCuentas.length && listaCuentas[i]!=null;i++){
            if(listaCuentas[i].getIban().equals(iban)){
                return listaCuentas[i].getSaldo();
            }
        }
        return -1;
    }
}
