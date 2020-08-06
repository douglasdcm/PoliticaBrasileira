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
public class ConsultarPoliticoBD {
    
    public ResultSet consultarPoliticoBanco ()throws SQLException, ClassNotFoundException { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/menagerie", "root","admin");
        System.out.println("Conectado!");
                        
        PreparedStatement stmt = conexao.prepareStatement("select * from politico");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            System.out.println
            (rs.getString("nome") + " :: " + rs.getString("partido"));
        }
        
        conexao.close();
        return rs;
    }
    
}
