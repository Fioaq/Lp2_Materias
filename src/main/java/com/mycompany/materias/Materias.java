/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.materias;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class Materias {
    private String id;
    private String codigo;
    private String nombre;
    private String docente;
    private String fechaInicio;
    private String fechaFin;
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getDocente(){
        return docente;
    }
    public void setDocente(String docente){
        this.docente=docente;
    }
    
    public String getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio){
        this.fechaInicio=fechaInicio;
    }
    
    public String getFechaFin(){
        return fechaFin;
    }
    public void setFechaFin(String fechaFin){
        this.fechaFin=fechaFin;
    }
    
    public void insertarMateria(JTextField paramCodigo, JTextField paramNombre, JTextField paramDocente, JTextField paramfechaInicio, JTextField paramfechaFin){
        setCodigo(paramCodigo.getText());
        setNombre(paramNombre.getText());
        setDocente(paramDocente.getText());
        setFechaInicio(paramfechaInicio.getText());
        setFechaFin(paramfechaFin.getText());
        conexion objetoConexion= new conexion();
        String Consulta=" INSERT INTO materias(codigo, nombre, docente, fechaInicio, fechaFin) VALUES(?,?,?,?,?);";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(Consulta);
            cs.setString(1, getCodigo());
            cs.setString(2, getNombre());
            cs.setString(3, getDocente());
            cs.setString(4, getFechaInicio());
            cs.setString(5, getFechaFin());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se creo correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hubo un error: "+e.toString());
        }
    }
    
    public void MostrarTabla(JTable paramTabla){
        conexion ObjetoConexion= new conexion();
        DefaultTableModel model= new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(model);
        paramTabla.setRowSorter(OrdenarTabla);
        String sql="";
        model.addColumn("ID");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Docente");
        model.addColumn("Inicio");
        model.addColumn("Fin");
        sql="SELECT * FROM `materias`";
        String [] datos= new String[6];
        Statement st;
        try{
            st= ObjetoConexion.establecerConexion().createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                model.addRow(datos);
            }
            paramTabla.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los registros: "+e.toString());
        }
    }
}
