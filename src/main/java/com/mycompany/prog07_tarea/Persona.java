package com.mycompany.prog07_tarea;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
public class Persona {
       /**
 * atributos de datos personales de una persona
 */
    private String nombre;
    private String apellidos;
    private String dni;
    
    public Persona(){}
       /**
 * constructor con 3 parámetros
 * @param nombre de la persona
 * @param apellidos de la persona
 * @param dni de la persona
 */
    public Persona(String nombre, String apellidos,String dni){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
