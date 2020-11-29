/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import modelo.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AxelHOOLIC
 */
public class ProductoDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarId(int id){
        String sql="select * from producto where idProducto="+id;
        Producto p=new Producto();
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setImg(rs.getString(6));
                
            }
        } catch (Exception e) {
        }return p;
    }
    
    public List listar(){
        List<Producto>productos=new ArrayList();
        String sql="select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setImg(rs.getString(6));
                productos.add(p);
                
            }
        } catch (Exception e) {           
        }return productos;

    }
    
            
    public int updatecantidad(int id, int cantidad){
        String sql = "UPDATE producto SET Stock="+cantidad+"WHERE idProducto="+id;
        int resultado = 0;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("registro correcto");
            }
        } catch (Exception e) {
            System.out.println("error:" + e);
        }return resultado;
    }
}
