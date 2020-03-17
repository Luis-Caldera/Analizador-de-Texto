/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logicaNegocio;

import edu.cecar.ConexionBaseDatos.ConexionBaseMysql;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.Resty;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author luis caldera
 * @author osneyder Melendez
 *
 */
public class Pelicula {

    // private Builder builder;
    ConexionBaseMysql conectarMySQL;
    // infromacionPelicula variables = new infromacionPelicula();

    public Pelicula() throws Exception {
        //this.variables.getTitulo();
        conectarMySQL = new ConexionBaseMysql("127.0.0.1", "proyecto", "root", "");
    }

    public String getDatosPeliculas() throws IOException, JSONException {

        String datosPelicula = "";
        String ruta = "C:\\Users\\luis "
                + "caldera\\Downloads\\Analisis "
                + "y Diseño II\\Archivos del Programa "
                + "Analizador\\codigoPelicula.txt";

        try {
            BufferedReader recorre = new BufferedReader(new FileReader(ruta));
            String temp = "";
            String bfRead;

            for (int i = 0; i < 50; i++) {
                bfRead = recorre.readLine();
                temp = bfRead;
                String url = "http://www.omdbapi.com/?i=" + temp + "&apikey=3e13ab2d";
                JSONObject jsonObjectRaiz = new Resty().json(url).object();

                String titulo = jsonObjectRaiz.get("Title").toString();
                String año = jsonObjectRaiz.get("Year").toString();
                String calificado = jsonObjectRaiz.get("Rated").toString();
                String lanzado = jsonObjectRaiz.get("Released").toString();
                String tiempoEjecucion = jsonObjectRaiz.get("Runtime").toString();
                String genero = jsonObjectRaiz.get("Genre").toString();
                String director = jsonObjectRaiz.get("Director").toString();
                String escritor = jsonObjectRaiz.get("Writer").toString();
                // String temporada = ObjetoJson.get("Season").toString();
                // String episodio = ObjetoJson.get("Episode").toString();                 
                String actores = jsonObjectRaiz.get("Actors").toString();
                String trama = jsonObjectRaiz.get("Plot").toString();
                String idioma = jsonObjectRaiz.get("Language").toString();
                String pais = jsonObjectRaiz.get("Country").toString();
                String premios = jsonObjectRaiz.get("Awards").toString();
                String cartel = jsonObjectRaiz.get("Poster").toString();
                String metascore = jsonObjectRaiz.get("Metascore").toString();
                String imdbRating = jsonObjectRaiz.get("imdbRating").toString();
                String imdbVotes = jsonObjectRaiz.get("imdbVotes").toString();
                String imdbID = jsonObjectRaiz.get("imdbID").toString();
                // String seriesID = ObjetoJson.get("seriesID").toString().toLowerCase(null);
                String tipo = jsonObjectRaiz.get("Type").toString();
                String respuesta = jsonObjectRaiz.get("Response").toString();

                try {

                    PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("insert into codigopeliculas values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setString(1, titulo);
                    preparedStatement.setString(2, año);
                    preparedStatement.setString(3, calificado);
                    preparedStatement.setString(4, lanzado);
                    preparedStatement.setString(5, idioma);
                    preparedStatement.setString(6, tiempoEjecucion);
                    preparedStatement.setString(7, genero);
                    preparedStatement.setString(8, director);
                    preparedStatement.setString(9, escritor);
                    preparedStatement.setString(10, actores);
                    preparedStatement.setString(11, trama);
                    preparedStatement.setString(12, pais);
                    preparedStatement.setString(13, premios);
                    preparedStatement.setString(14, cartel);
                    preparedStatement.setString(15, metascore);
                    preparedStatement.setString(16, imdbRating);
                    preparedStatement.setString(17, imdbVotes);
                    preparedStatement.setString(18, imdbID);
                    //               preparedStatement.setString(19, seriesID);
                    preparedStatement.setString(19, tipo);
                    preparedStatement.setString(20, respuesta);
                    preparedStatement.execute();

                } catch (SQLException e) {

                }

            }

        } catch (IOException | JSONException e) {
            System.out.println("No se encontro el archivo con esa direcion.");
        }

        return datosPelicula;
    }

    public String crearArchivoPelicula() throws IOException, JSONException {

        String archiVosdatoPelicula = "";
        ObjectOutputStream oos = null;
        ArrayList al = new ArrayList(100);

        String ruta = "C:\\Users\\luis "
                + "caldera\\Downloads\\Analisis "
                + "y Diseño II\\Archivos del Programa "
                + "Analizador\\codigoPelicula.txt";
        try {
            BufferedReader recorre = new BufferedReader(new FileReader(ruta));
            System.out.println(ruta);
            String temp = "";
            String bfRead;

            for (int i = 0; i < 50; i++) {
                bfRead = recorre.readLine();
                temp = bfRead;
                String url = "http://www.omdbapi.com/?i=" + temp + "&apikey=3e13ab2d";
                System.out.println(url);

                JSONObject ObjetoJson = new Resty().json(url).object();
//                JSONArray jsonArray = ObjetoJson.getJSONArray("Ratings");

                
                String titulo = ObjetoJson.get("Title").toString();
                String año = ObjetoJson.get("Year").toString();
                String calificado = ObjetoJson.get("Rated").toString();
                String lanzado = ObjetoJson.get("Released").toString();
                String tiempoEjecucion = ObjetoJson.get("Runtime").toString();
                String genero = ObjetoJson.get("Genre").toString();
                String director = ObjetoJson.get("Director").toString();
                String escritor = ObjetoJson.get("Writer").toString();
                // String temporada = ObjetoJson.get("Season").toString();
                // String episodio = ObjetoJson.get("Episode").toString();                 
                String actores = ObjetoJson.get("Actors").toString();
                String trama = ObjetoJson.get("Plot").toString();
                String idioma = ObjetoJson.get("Language").toString();
                String pais = ObjetoJson.get("Country").toString();
                String premios = ObjetoJson.get("Awards").toString();
                String cartel = ObjetoJson.get("Poster").toString();
                String metascore = ObjetoJson.get("Metascore").toString();
                String imdbRating = ObjetoJson.get("imdbRating").toString();
                String imdbVotes = ObjetoJson.get("imdbVotes").toString();
                String imdbID = ObjetoJson.get("imdbID").toString();
                // String seriesID = ObjetoJson.get("seriesID").toString().toLowerCase(null);
                String tipo = ObjetoJson.get("Type").toString();
                String respuesta = ObjetoJson.get("Response").toString();

                // guardar en el archivo ========================================
                Archivo a = new Archivo(titulo, año, calificado, lanzado, tiempoEjecucion, genero, director, escritor, actores, trama, idioma, pais, premios, cartel, metascore, imdbRating, imdbVotes, imdbID, tipo, respuesta);
                al.add(a);
            }
            
            oos = new ObjectOutputStream(new FileOutputStream("E:JsonPelicula.scv"));
            oos.writeObject(al);
            oos.close();

        } catch (Exception e) {
            System.out.println("Error...  Algo va mal.");
        }

        return archiVosdatoPelicula;
    }

}
