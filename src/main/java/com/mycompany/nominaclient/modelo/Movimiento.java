/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nominaclient.modelo;

import com.mycompany.nominaclient.MovimientoVista;

/**
 *
 * @author Admin
 */
public class Movimiento {
    private int cantidad;
    private int mes;
    private int numero;
    private int year;
    
    public Movimiento(){
    }
   public Movimiento(MovimientoVista movimientoVista){
       this.cantidad=Integer.parseInt(movimientoVista.getEntrega().getText());
       this.mes=Integer.parseInt(movimientoVista.getMes().getText());
       this.numero=Integer.parseInt(movimientoVista.getNumeroPersonal().getText());
       this.year=2020;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
