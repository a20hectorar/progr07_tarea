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
        Banco banco=new Banco();
        mostrarMenu();
        
        Scanner sc=new Scanner(System.in);

        int opcion= sc.nextInt();
        switch (opcion){
            case 1 : 
                menuAbrirCuenta(sc,banco);
                break;
            
            case 2:
                mostrarListadoCuentas(sc,banco);
                break;
        }
    }
    
        static void mostrarMenu(){
            System.out.println("Escoja una operación a realizar: ");
            System.out.println("1. Abrir una cuenta nueva.");
            System.out.println("2. Ver listado de cuentas disponibles.");
            System.out.println("3. Obtener los datos de una cuenta concreta. Realizar un ingreso en cuenta");
            System.out.println("4. Retirar efectivo de una cuenta.");
            System.out.println("5. Consultar el saldo actual de una cuenta.");
            System.out.println("6. Salir de la aplicación");
        }
        
        static void mostrarListadoCuentas(Scanner sc,Banco banco){
            String listaArray[]=banco.listadoCuentas();
            for(String fila:listaArray){
                System.out.println(fila);
            }
            
            System.out.println("Escriba \"s\" para volver al menú de inicio");
            char volverInicio=sc.next().charAt(0);
            if(volverInicio=='s'){
                mostrarMenu();
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
        
        static void menuAbrirCuenta(Scanner sc,Banco banco){
            System.out.println("Nombre del titular: ");
                Persona cliente=new Persona();
                cliente.setNombre(sc.nextLine());
                System.out.println("Apellidos del titular: ");
                cliente.setApellidos(sc.nextLine());
                System.out.println("Dni del titular: ");
                cliente.setDni(sc.nextLine());

                CuentaBancaria nuevaCuenta;
                System.out.println("Saldo inicial. Introduzca el importe con el que se abrirá la cuenta:");
                Double saldo=sc.nextDouble();
              
                System.out.println("Número de IBAN: ");
                String nuevoIban=sc.nextLine();
                
                while(esIbanValido(nuevoIban)==false){
                    System.out.println("IBAN incorrecto");
                    nuevoIban=sc.nextLine();
                }
                               
                System.out.println("Tipo de cuenta: ");
                System.out.println("Opción 1: cuenta de ahorro.");
                System.out.println("Opcion 2: cuenta corriente personal.");
                System.out.println("Opcion 3: cuenta corriente de empresa.");
                int tipoCuenta=sc.nextInt();
                boolean seGrabo=false;
                switch (tipoCuenta){
                    case 1:
                        double interes=0;
                        System.out.println("Introduzca el tipo de interés de remuneración: ");
                        interes=sc.nextDouble();
                        nuevaCuenta=new CuentaAhorro(cliente,saldo,nuevoIban,interes);
                        seGrabo=banco.abrirCuenta(nuevaCuenta);
                            if(seGrabo){
                                mostrarMenu();
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
                                mostrarMenu();
                            }
                        break;
                    case 2:
                        double comisionMantenimiento=0;
                        System.out.println("Introduzca el tipo de comisión de mantenimiento: ");
                        comisionMantenimiento=sc.nextDouble();
                        nuevaCuenta=new CuentaCorrientePersonal(cliente,saldo,nuevoIban,comisionMantenimiento);
                        banco.abrirCuenta(nuevaCuenta);
                        seGrabo=banco.abrirCuenta(nuevaCuenta);
                            if(seGrabo){
                                mostrarMenu();
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
                                mostrarMenu();
                            }
                        break;
                        
                    case 3:
                        double maxDescubierto=0;
                        double interesDescubierto=0;
                        double comisionFijaDescubierto=0;
                        System.out.println("Introduzca el máximo descubierto permitido: ");
                        maxDescubierto=sc.nextDouble();
                        System.out.println("Introduzca el tipo de interés por descubierto: ");
                        interesDescubierto=sc.nextDouble();
                        System.out.println("Introduzca la comisión fija por descubierto: ");
                        comisionFijaDescubierto=sc.nextDouble();
                        nuevaCuenta = new CuentaCorrienteEmpresa(cliente,saldo,nuevoIban,maxDescubierto,interesDescubierto,comisionFijaDescubierto);
                        banco.abrirCuenta(nuevaCuenta);
                        seGrabo=banco.abrirCuenta(nuevaCuenta);
                            if(seGrabo){
                                mostrarMenu();
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
                                mostrarMenu();
                            }
                        break;
                                        }
        }
}