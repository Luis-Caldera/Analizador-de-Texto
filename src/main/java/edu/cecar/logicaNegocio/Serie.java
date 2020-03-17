/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logicaNegocio;

import edu.cecar.ConexionBaseDatos.ConexionBaseMysql;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.Resty;

/**
 *
 * @author luis caldera
 */
public class Serie {

    ConexionBaseMysql conectarMySQL;
    // infromacionPelicula variables = new infromacionPelicula();

    public Serie() throws Exception {
        //this.variables.getTitulo();
        conectarMySQL = new ConexionBaseMysql("127.0.0.1", "proyecto", "root", "");
    }

    public String getDatosSeries() throws IOException, JSONException {

        String texto = "";
        String ruta = "C:\\Users\\luis "
                + "caldera\\Downloads\\Analisis "
                + "y Diseño II\\Archivos del Programa "
                + "Analizador\\codigoSerie.txt";

        try {
            BufferedReader recorre = new BufferedReader(new FileReader(ruta));
            //  System.out.println(ruta);
            String temp = "";
            String bfRead;

            for (int i = 0; i < 50; i++) {
                bfRead = recorre.readLine();
                temp = bfRead;
                String url = "http://www.omdbapi.com/?i=" + temp + "&apikey=3e13ab2d";
                System.out.println(url);
                JSONObject jsonObjectRaiz = new Resty().json(url).object();
//                JSONArray jsonArray = jsonObjectRaiz.getJSONArray("Ratings");

                String titulo = jsonObjectRaiz.get("Title").toString();
                String año = jsonObjectRaiz.get("Year").toString();
                String calificado = jsonObjectRaiz.get("Rated").toString();
                String lanzado = jsonObjectRaiz.get("Released").toString();
                //String temporada = jsonObjectRaiz.get("Season").toString();
                // String episodio = jsonObjectRaiz.get("Episode").toString(); 
                String tiempoEjecucion = jsonObjectRaiz.get("Runtime").toString();
                String genero = jsonObjectRaiz.get("Genre").toString();
                String director = jsonObjectRaiz.get("Director").toString();
                String escritor = jsonObjectRaiz.get("Writer").toString();
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
                //String seriesID = jsonObjectRaiz.get("seriesID").toString();
                String tipo = jsonObjectRaiz.get("Type").toString();
                String respuesta = jsonObjectRaiz.get("Response").toString();

                try {

                    PreparedStatement preparedStatement = conectarMySQL.getConexion().prepareStatement("insert into seriepeliculas values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setString(1, titulo);
                    preparedStatement.setString(2, año);
                    preparedStatement.setString(3, calificado);
                    preparedStatement.setString(4, lanzado);
                    //preparedStatement.setString(4, temporada);
                    //  preparedStatement.setString(4, episodio);
                    preparedStatement.setString(5, tiempoEjecucion);
                    preparedStatement.setString(6, genero);
                    preparedStatement.setString(7, director);
                    preparedStatement.setString(8, escritor);
                    preparedStatement.setString(9, actores);
                    preparedStatement.setString(10, trama);
                    preparedStatement.setString(11, idioma);
                    preparedStatement.setString(12, pais);
                    preparedStatement.setString(13, premios);
                    preparedStatement.setString(14, cartel);
                    preparedStatement.setString(15, metascore);
                    preparedStatement.setString(16, imdbRating);
                    preparedStatement.setString(17, imdbVotes);
                    preparedStatement.setString(18, imdbID);
                    //preparedStatement.setString(19, seriesID);
                    preparedStatement.setString(19, tipo);
                    preparedStatement.setString(20, respuesta);

                    preparedStatement.execute();

                } catch (SQLException e) {

                }

            }

        } catch (IOException | JSONException e) {
            System.out.println("Error...  algo va mal.");
        }
        return texto;
    }

    public String crearArchivoSeries() throws IOException, JSONException {
        String archivoDatosSeries = "";

        ObjectOutputStream canal = null;
        ArrayList elementosArchivo = new ArrayList(100);

        String ruta = "C:\\Users\\luis "
                + "caldera\\Downloads\\Analisis "
                + "y Diseño II\\Archivos del Programa "
                + "Analizador\\codigoPelicula.txt";
        try {
            BufferedReader recorre = new BufferedReader(new FileReader(ruta));
            System.out.println(ruta);
            String id = "";
            String bfRead;

            for (int i = 0; i < 50; i++) {
                bfRead = recorre.readLine();
                id = bfRead;
                String url = "http://www.omdbapi.com/?i=" + id + "&apikey=3e13ab2d";
                System.out.println(url);
                JSONObject jsonObjectRaiz = new Resty().json(url).object();
//                JSONArray jsonArray = jsonObjectRaiz.getJSONArray("Ratings");

                String titulo = jsonObjectRaiz.get("Title").toString();
                String año = jsonObjectRaiz.get("Year").toString();
                String calificado = jsonObjectRaiz.get("Rated").toString();
                String lanzado = jsonObjectRaiz.get("Released").toString();
                String tiempoEjecucion = jsonObjectRaiz.get("Runtime").toString();
                String genero = jsonObjectRaiz.get("Genre").toString();
                String director = jsonObjectRaiz.get("Director").toString();
                String escritor = jsonObjectRaiz.get("Writer").toString();
                // String temporada = jsonObjectRaiz.get("Season").toString();
                // String episodio = jsonObjectRaiz.get("Episode").toString();                 
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
                // String seriesID = jsonObjectRaiz.get("seriesID").toString().toLowerCase(null);
                String tipo = jsonObjectRaiz.get("Type").toString();
                String respuesta = jsonObjectRaiz.get("Response").toString();

                // guardar en el archivo ========================================
                Archivo a = new Archivo(titulo, año, calificado, lanzado, tiempoEjecucion, genero, director, escritor, actores, trama, idioma, pais, premios, cartel, metascore, imdbRating, imdbVotes, imdbID, tipo, respuesta);
                elementosArchivo.add(a);
            }
            canal = new ObjectOutputStream(new FileOutputStream("E:JsonPelicula.scv"));
            canal.writeObject(elementosArchivo);
            canal.close();

        } catch (IOException | JSONException e) {
            System.out.println("Error al crear el archivo serie datos peliculas.");
        }

        return archivoDatosSeries;
    }
}
