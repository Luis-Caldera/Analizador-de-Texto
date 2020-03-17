/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logicaNegocio;

import edu.cecar.ConexionBaseDatos.ConexionBaseMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luis caldera
 */
public class consulltaBaseDato {

    ConexionBaseMysql conectarMySQL;

    public consulltaBaseDato() throws Exception {
        //this.variables.getTitulo();
        conectarMySQL = new ConexionBaseMysql("127.0.0.1", "proyecto", "root", "");
    }

    public void getPeluculaTituloCodigo() throws SQLException {

        // ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
              //   PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("Select * from peliculas order by Año ");
PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("SELECT `Titulo`, `Año`, `Calificado`, `Lanzada`, `Idioma`, `Timepo De Ejecucion`, `Genero`, `Director`, `Escritor`, `Actores`, `Trama`, `Pais`, `Premio`, `Cartel`, `Metascore`, `imdbRating`, `ImdbVotes`, `mdbID`, `Tipo`, `Respuesta` FROM `codigopeliculas`");
      
// String nombre =  "'Othello'";
        //PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("SELECT * FROM `peliculas` WHERE `Titulo` = "+nombre);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            System.out.println("Titulo " + resultado.getString(1));
            System.out.println("Año " + resultado.getString(2));
            System.out.println("Calificada " + resultado.getString(3));
            System.out.println("Lanzado " + resultado.getString(4));
            System.out.println("Idioma " + resultado.getString(5));
            System.out.println("Tiempo De Ejecucion " + resultado.getString(6));
            System.out.println("Genero " + resultado.getString(7));
            System.out.println("Director " + resultado.getString(8));
            System.out.println("Escritor " + resultado.getString(9));
            System.out.println("Actores " + resultado.getString(10));
            System.out.println("Trama " + resultado.getString(11));
            System.out.println("Pais " + resultado.getString(12));
            System.out.println("Premio " + resultado.getString(13));
            System.out.println("Cartel " + resultado.getString(14));
         }
    }
    
    public void getPeluculaBuscarNombre() throws SQLException {

        // ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        // PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("Select * from peliculas order by Año ");
        String nombre =  "'"+Validar.getArgumentoComando_3_2()+"'";
        System.out.println("---------->>>>>>>>>>>>"+nombre);
        
        
        PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("SELECT * FROM `codigopeliculas` WHERE `Titulo` = " +nombre);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
          System.out.println("Titulo " + resultado.getString(1));
            System.out.println("Año " + resultado.getString(2));
            System.out.println("Calificada " + resultado.getString(3));
            System.out.println("Lanzado " + resultado.getString(4));
            System.out.println("Idioma " + resultado.getString(5));
            System.out.println("Tiempo De Ejecucion " + resultado.getString(6));
            System.out.println("Genero " + resultado.getString(7));
            System.out.println("Director " + resultado.getString(8));
            System.out.println("Escritor " + resultado.getString(9));
            System.out.println("Actores " + resultado.getString(10));
            System.out.println("Trama " + resultado.getString(11));
            System.out.println("Pais " + resultado.getString(12));
            System.out.println("Premio " + resultado.getString(13));
            System.out.println("Cartel " + resultado.getString(14));
            System.out.println("Metascore " + resultado.getString(15));
            System.out.println("imdbRating " + resultado.getString(16));
            System.out.println("imdbID" + resultado.getString(17));
            System.out.println("imdbVotes" + resultado.getString(18));
            System.out.println("Tipo" + resultado.getString(19));
            System.out.println("Respuesta" + resultado.getString(20));
            
            
            
         }
    }
    
     public void getPeluculaBuscarAño() throws SQLException {

        // ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        // PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("Select * from peliculas order by Año ");
        //String año =  "'1953'";
        
        PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("SELECT * FROM `codigopeliculas` WHERE `Año` = "+Validar.getArgumentoComando_3_1());
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
          System.out.println("Titulo " + resultado.getString(1));
            System.out.println("Año " + resultado.getString(2));
            System.out.println("Calificada " + resultado.getString(3));
            System.out.println("Lanzado " + resultado.getString(4));
            System.out.println("Idioma " + resultado.getString(5));
            System.out.println("Tiempo De Ejecucion " + resultado.getString(6));
            System.out.println("Genero " + resultado.getString(7));
            System.out.println("Director " + resultado.getString(8));
            System.out.println("Escritor " + resultado.getString(9));
            System.out.println("Actores " + resultado.getString(10));
            System.out.println("Trama " + resultado.getString(11));
            System.out.println("Pais " + resultado.getString(12));
            System.out.println("Premio " + resultado.getString(13));
            System.out.println("Cartel " + resultado.getString(14));
            System.out.println("Metascore " + resultado.getString(15));
            System.out.println("imdbRating " + resultado.getString(16));
            System.out.println("imdbID" + resultado.getString(17));
            System.out.println("imdbVotes" + resultado.getString(18));
            System.out.println("Tipo" + resultado.getString(19));
            System.out.println("Respuesta" + resultado.getString(20));
         }
    }

}
