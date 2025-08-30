/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.uniplan.infrastructure.repository.integration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class MysqlClient {

    private static final String url = "jdbc:mysql://localhost:3306/cadastrousuario";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection getConnection(){
        try {
            return DriveManager.getConnection(url, user, password);
        }catch (final SQLException ex){
            System.out.println("Erro ao conectar com o banco de dados"+ ex.getMessage());
            throw ex;
        }
    }

}
