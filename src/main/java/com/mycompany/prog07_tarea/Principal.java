package com.mycompany.prog07_tarea;
import static java.lang.System.exit;
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
        Scanner sc=new Scanner(System.in);
        mostrarMenu(sc,banco);
    }
    
        static void mostrarMenu(Scanner sc,Banco banco){
            System.out.println("Escoja una operación a realizar: ");
            System.out.println("1. Abrir una cuenta nueva.");
            System.out.println("2. Ver listado de cuentas disponibles.");
            System.out.println("3. Obtener los datos de una cuenta concreta. Realizar un ingreso en cuenta");
            System.out.println("4. Retirar efectivo de una cuenta.");
            System.out.println("5. Consultar el saldo actual de una cuenta.");
            System.out.println("6. Salir de la aplicación");
            System.out.println("Escoja una opción del menú: ");
            int opcion= sc.nextInt();
            //consumimos el siguiente salto de línea
            sc.nextLine();
            switch (opcion){
            case 1 : 
                menuAbrirCuenta(sc,banco);
                break;
            
            case 2:
                mostrarListadoCuentas(sc,banco);
                break;
                
            case 3:
                menuIngreso(sc,banco);
                break;
                
            case 4:
                menuRetirada(sc,banco);
                break;
                
            case 5:
                consultaSaldo(sc,banco);
                break;
            case 6:
                exit(0);
                break;
        }
        }
        
        static void mostrarListadoCuentas(Scanner sc,Banco banco){
            String listaArray[]=banco.listadoCuentas();
            for(String fila:listaArray){
                if(fila!=null){
                System.out.println(fila);
                }
            }
            volverInicio(sc,banco);
        }
        
        static void menuIngreso(Scanner sc,Banco banco){
            System.out.println("Introduzca el IBAN de la cuenta a mostrar: ");
            String iban=sc.nextLine();
            String infoCuenta=banco.informacionCuenta(iban);
            if(infoCuenta==null){
                System.out.println("El IBAN introducido no pertenece a ninguna cuenta.");
            }else{
                System.out.println(infoCuenta);
                System.out.println("Introduzca la cantidad a ingresar: ");
                double cantidad=sc.nextDouble();
                //consumimos el siguiente salto de línea
                sc.nextLine();
                    if(cantidad<=0){
                        System.out.println("La cantidad ha de ser mayor de cero");
                    }else{
                        if(banco.ingresoCuenta(iban, cantidad)){
                            System.out.println("Ingreso efectuado");
                        }else{
                            System.out.println("No se ha podido efectuar el ingreso");
                            }
                    }
            }
            volverInicio(sc,banco);
        }
        
        static void menuRetirada(Scanner sc,Banco banco){
            System.out.println("Introduzca el IBAN de la cuenta: ");
            String iban=sc.nextLine();
            System.out.println("Introduzca la cantidad a retirar");
            double cantidad=sc.nextDouble();
            //consumimos el siguiente salto de línea
                sc.nextLine();
            if(cantidad<=0){
                System.out.println("La cantidad ha de ser mayor de cero");
            }else{
                if(banco.retiradaCuenta(iban,cantidad)){
                    System.out.println("Retirada efectuada.");
                }else{
                    System.out.println("No se ha podido efectuar la retirada");
                }
            }    
            volverInicio(sc,banco);
        }
        
        static void consultaSaldo(Scanner sc,Banco banco){
            System.out.println("Introduzca el IBAN de la cuenta a consultar: ");
            String iban=sc.nextLine();
            double obtenerSaldo=banco.obtenerSaldo(iban);
            if(obtenerSaldo==-1){
                System.out.println("No se encontró la cuenta.");
            }else{
                System.out.println("Su saldo es de: " + obtenerSaldo + " €.");
            }
            volverInicio(sc,banco);
        }
        
        static void volverInicio(Scanner sc,Banco banco){
            System.out.println("Escriba \"s\" para volver al menú de inicio");
            char volverInicio=sc.nextLine().charAt(0);
            if(volverInicio=='s'){
                mostrarMenu(sc,banco);
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
                //consumimos el siguiente salto de línea
                sc.nextLine();
              
                System.out.println("Número de IBAN: ");
                String nuevoIban=sc.nextLine();
                
              /*  while(esIbanValido(nuevoIban)==false){
                    System.out.println("IBAN incorrecto");
                    nuevoIban=sc.nextLine();
                }*/
                               
                System.out.println("Tipo de cuenta: ");
                System.out.println("Opción 1: cuenta de ahorro.");
                System.out.println("Opcion 2: cuenta corriente personal.");
                System.out.println("Opcion 3: cuenta corriente de empresa.");
                int tipoCuenta=sc.nextInt();
                //consumimos el siguiente salto de línea
                sc.nextLine();
                boolean seGrabo=false;
                switch (tipoCuenta){
                    case 1:
                        double interes=0;
                        System.out.println("Introduzca el tipo de interés de remuneración: ");
                        interes=sc.nextDouble();
                        //consumimos el siguiente salto de línea
                        sc.nextLine();
                        nuevaCuenta=new CuentaAhorro(cliente,saldo,nuevoIban,interes);
                        seGrabo=banco.abrirCuenta(nuevaCuenta);
                            if(seGrabo){
                                System.out.println("Cuenta creada correctamente");
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
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
                                System.out.println("Cuenta creada correctamente");
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
                            }
                        break;
                        
                    case 3:
                        double maxDescubierto=0;
                        double interesDescubierto=0;
                        double comisionFijaDescubierto=0;
                        System.out.println("Introduzca el máximo descubierto permitido: ");
                        maxDescubierto=sc.nextDouble();
                        //consumimos el siguiente salto de línea
                        sc.nextLine();
                        System.out.println("Introduzca el tipo de interés por descubierto: ");
                        interesDescubierto=sc.nextDouble();
                        //consumimos el siguiente salto de línea
                        sc.nextLine();
                        System.out.println("Introduzca la comisión fija por descubierto: ");
                        comisionFijaDescubierto=sc.nextDouble();
                        //consumimos el siguiente salto de línea
                        sc.nextLine();
                        nuevaCuenta = new CuentaCorrienteEmpresa(cliente,saldo,nuevoIban,maxDescubierto,interesDescubierto,comisionFijaDescubierto);
                        banco.abrirCuenta(nuevaCuenta);
                        seGrabo=banco.abrirCuenta(nuevaCuenta);
                            if(seGrabo){
                                System.out.println("Cuenta creada correctamente");
                            }else{
                                System.out.println("La cuenta no se grabó correctamente.");
                            }
                        break;
                                        }
                volverInicio(sc,banco);
        }
}