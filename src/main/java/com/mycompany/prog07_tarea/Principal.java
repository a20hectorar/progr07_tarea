package com.mycompany.prog07_tarea;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class Principal {
    public static void main(String[] args){
        System.out.println("Escoja una operación a realizar: ");
        System.out.println("1. Abrir una cuenta nueva.");
        System.out.println("2. Ver listado de cuentas disponibles.");
        System.out.println("3. Obtener los datos de una cuenta concreta. Realizar un ingreso en cuenta");
        System.out.println("4. Retirar efectivo de una cuenta.");
        System.out.println("5. Consultar el saldo actual de una cuenta.");
        System.out.println("6. Salir de la aplicación");

        Scanner sc=new Scanner(System.in);

        int opcion= sc.nextInt();

        switch (opcion){
            case 1 -> {
                System.out.println("Nombre del titular: ");
                Persona cliente=new Persona();
                cliente.setNombre(sc.nextLine());
                System.out.println("Apellidos del titular: ");
                cliente.setApellidos(sc.nextLine());
                System.out.println("Dni del titular: ");
                cliente.setDni(sc.nextLine());

                CuentaBancaria nuevaCuenta=new CuentaBancaria();
                nuevaCuenta.setTitular(cliente);
                
                System.out.println("Saldo inicial. Introduzca el importe con el que se abrirá la cuenta:");
                nuevaCuenta.setSaldo(sc.nextDouble());
               
                System.out.println("Número de IBAN: ");
                String nuevoIban=sc.nextLine();
                
                while(esIbanValido(nuevoIban)==false){
                    System.out.println("IBAN incorrecto");
                    nuevoIban=sc.nextLine();
                }
                
                nuevaCuenta.setIban(nuevoIban);

                System.out.println("Tipo de cuenta: ");
                System.out.println("Opción 1: cuenta de ahorro.");
                System.out.println("Opcion 2: cuenta corriente personal.");
                System.out.println("Opcion 3: cuenta corriente de empresa.");
                int tipoCuenta=sc.nextInt();
                    
                switch (tipoCuenta){
                    case 1:
                        CuentaAhorro nuevaCuentaAhorro=new CuentaAhorro();
                        nuevaCuentaAhorro=(CuentaAhorro) nuevaCuenta;
                        System.out.println("Introduzca el tipo de interés de remuneración: ");
                        nuevaCuentaAhorro.setInteres(sc.nextDouble());
                        break;
                    case 2:
                        nuevaCuenta = new CuentaCorrientePersonal();
                        System.out.println("Introduzca comisión de mantenimiento: ");
                        nuevaCuenta.setComisionMantenimiento(sc.nextDouble());
                        break;
                        
                    case 3:
                        nuevaCuenta = new CuentaCorrienteEmpresa;
                        System.out.println("Introduzca el máximo cubierto permitido: ");
                        nuevaCuenta.set
                        
                        System.out.println("Introduzca el tipo de interés por descubierto: ");
                        
                        
                        System.out.println("Introduzca la comisión fija por descubierto: ");
                        break;
                        
                }
            }
        }
    }
        static boolean esIbanValido(String iban){
            Pattern pattern=Pattern.compile("ES[0-9]{22}");
                    Matcher matcher=pattern.matcher(iban);
                        if(matcher.find() == true){
                            System.out.println("IBAN válido.");
                            return true;
                        }else{
                           return false;
                            }
        }
}

