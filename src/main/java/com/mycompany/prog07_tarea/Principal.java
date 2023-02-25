package com.mycompany.prog07_tarea;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class Principal {
    int tipoCuenta;
    double saldoInicial=0;
    
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
            case 1:
                System.out.println("Nombre del titular: ");
                Persona.nombre=sc.nextLine();
                System.out.println("Apellidos del titular: ");
                Persona.apellidos=sc.nextLine();
                System.out.println("Dni del titular: ");
                Persona.dni=sc.nextLine();

                Persona nuevoTitular = new Persona(Persona.nombre,Persona.apellidos,Persona.dni);
                CuentaBancaria.titular=nuevoTitular;

                System.out.println("Tipo de cuenta: ");
                System.out.println("Opción 1: cuenta de ahorro.");
                System.out.println("Opcion 2: cuenta corriente personal.");
                System.out.println("Opcion 3: cuenta corriente de empresa.");
                tipoCuenta=sc.nextInt();

                System.out.println("Saldo inicial. Introduzca el importe con el que se abrirá la cuenta:");
                saldoInicial=sc.nextDouble();
                CuentaBancaria.saldo=saldoInicial;

                System.out.println("Número de IBAN: ");
                nuevoIban=sc.nextLine();

                Pattern pattern=Pattern.compile("[ES][0-9]{22}");
                Matcher matcher=pattern.matcher(nuevoIban);
                    if(matcher.find() == true){
                        System.out.println("IBAN válido.");
                    }else{
                        while(matcher.find() == false){
                         System.out.println("Introduzca un IBAN válido: ");
                         nuevoIban=sc.nextLine();
                        }
                    }

                switch (tipoCuenta){
                    case 1:
                        System.out.println("Introduzca el tipo de interés de remuneración: ");
                        CuentaAhorro.interes=sc.nextDouble();
                        CuentaAhorro nuevaCuentaAhorro=new CuentaAhorro(nuevoTitular,saldoInicial,nuevoIban,interes);

                    case 2:
                        System.out.println("Introduzca comisión de mantenimiento: ");
                        CuentaCorrientePersonal.comisionMantenimiento=sc.nextDouble();
                        CuentaCorrientePersonal nuevaCuentaCorrientePersonal=new CuentaCorrientePersonal(nuevoTitular,saldoInicial,nuevoIban,comisionMantenimiento);

                    case 3:
                        System.out.println("Introduzca el máximo cubierto permitido: ");
                        CuentaCorrienteEmpresa.descubiertoMaximo=sc.nextDouble();

                        System.out.println("Introduzca el tipo de interés por descubierto: ");
                        CuentaCorrienteEmpresa.interesDescubierto=sc.nextDouble();

                        System.out.println("Introduzca la comisión fija por descubierto: ");
                        CuentaCorrienteEmpresa.comisionFijaDescubierto=sc.nextDouble();
                        
                        CuentaCorrienteEmpresa nuevaCuentaCorrienteEmpresa=new CuentaCorrienteEmpresa(nuevoTitular,saldoInicial,nuevoIban,descubiertoMaximo,interesDescubierto,comisionFijaDescubierto);
                        
                }
        Banco.abrirCuenta(CuentaBancaria);
        }
}
