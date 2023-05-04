/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.materias;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conexion {
        Connection conectar=null;
        String usuario="root";
        String contrasenia= "";
        String bd ="lp2_materias";
        String ip ="localhost";
        String puerto ="3306";
        String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
         public Connection establecerConexion(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conectar =DriverManager.getConnection(cadena,usuario,contrasenia);
          JOptionPane.showMessageDialog(null,"Conexion exitosa!"); 
     }catch(Exception e) {
         JOptionPane.showMessageDialog(null,"Error en la conexion,error:"+e.toString()); 
     }
         return conectar;

     }
}
