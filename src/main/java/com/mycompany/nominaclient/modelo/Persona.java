/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nominaclient.modelo;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.nominaclient.Main;
import com.mycompany.nominaclient.personal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Admin
 */
public class Persona {
    
private Integer numero;
private int idrol;
private String nombre;
private String apellidos;
private Integer salario;
private int vales;

public Persona(){
}
public Persona(personal personal){
    this.numero=Integer.parseInt(personal.getNumero().getText());
   
    if(personal.getAuxiliar().isSelected())  
        this.idrol=3;
    if(personal.getAuxiliar().isSelected())  
        this.idrol=1;
    if(personal.getAuxiliar().isSelected())  
        this.idrol=2;
    this.nombre=personal.getNombre().getText();
    this.apellidos="";
    this.salario=Integer.parseInt(personal.getSalario().getText());
    this.vales=4;

}

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
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

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public int getVales() {
        return vales;
    }

    public void setVales(int vales) {
        this.vales = vales;
    }

    
    public static void main(String args[]){
         CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/personal"); 
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        Persona persona=new Persona(); 
         ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            String parser=null;
        try {
             parser = mapper.writeValueAsString(persona);
             System.out.println("persoanl "+ parser);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(personal.class.getName()).log(Level.SEVERE, null, ex);
        }
         StringEntity entity =null;
       try {
            entity = new StringEntity(parser);  
            StringBuilder json = new StringBuilder();
            json.append("{");
            json.append("\"numero\":111113,");
            json.append("\"idrol\":2,");
            json.append("\"nombre\":\"ricardo\",");
            json.append("\"apellidos\":\"perez\",");
            json.append("\"salario\":3000,");
            json.append("\"vales\":4");
            json.append("}");
            post.setEntity(new StringEntity(json.toString()));
          //  post.setEntity(json.toString());
            CloseableHttpResponse response=null;
        
            response = httpClient.execute(post);
             System.out.println("fff");
            System.out.println("sss "+response.getStatusLine().getStatusCode());

        } catch (Exception  ex) {
            
            Logger.getLogger(personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
