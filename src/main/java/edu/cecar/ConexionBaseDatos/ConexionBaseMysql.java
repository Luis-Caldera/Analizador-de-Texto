/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author luis caldera
 */
public class ConexionBaseMysql {

    private Connection conexion;

    /**
     * Constructor general que se conecta a la base de datos
     * @param ip
     * @param nombreBaseDatos
     * @param usuario
     * @param contraseña
     * @throws java.lang.Exception
     */
    public ConexionBaseMysql(String ip, String nombreBaseDatos, String usuario, String contraseña) throws Exception {

        if (conexion == null) {
            //** Se carga el driver para conectarse a la base de datos
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Se conecta a la base de datos
            // Se crea un URL hacia la maquina y la base de datos
            String url = "jdbc:mysql://" + ip + ":3306/" + nombreBaseDatos;

            //se crea la conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            //conexion.setAutoCommit(false);
        }
    }

    /**
     * Devuelve el objeto que permite la conexion a la base de datos
     *
     * @return Connection Conexion a la base de datos
     *
     */
    public Connection getConexion() {
        return conexion;
    }

}
