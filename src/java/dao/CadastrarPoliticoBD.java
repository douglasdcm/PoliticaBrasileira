/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
//import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;

/**
 *
 * @author Douglas
 */
public class CadastrarPoliticoBD {
    
    public static void cadastrarPoliticoBanco (String nome, String partido)throws SQLException, ClassNotFoundException { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/menagerie", "root","admin");
        System.out.println("Conectado!");
        
        String sql = "insert into politico (nome,partido) values (?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        Date d = new Date();
        //stmt.setString(1,"Douglas");
        //stmt.setString(2,"PSDB");
        
        stmt.execute();
        stmt.close();
        System.out.println("Gravado!");
        
        //ler
        stmt = conexao.prepareStatement("select * from politico");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            System.out.println
            (rs.getString("nome") + " :: " + rs.getString("partido"));
        }
        
        conexao.close();
    }
    
}
