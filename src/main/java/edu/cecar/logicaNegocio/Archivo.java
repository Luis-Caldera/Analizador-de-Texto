/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logicaNegocio;

import java.io.Serializable;

/**
 *
 * @author luis caldera
 */
public class Archivo implements Serializable {

    String titulo;
    String año;
    String calificado;
    String lanzado;
    String tiempoEjecucion;
    String genero;
    String director;
    String escritor;
    String actores;
    String trama;
    String idioma;
    String pais;
    String premios;
    String cartel;
    String metascore;
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String tipo;
    String respuesta;

    public Archivo(String titulo, String año, String calificado, String lanzado, String tiempoEjecucion, String genero, String director, String escritor, String actores, String trama, String idioma, String pais, String premios, String cartel, String metascore, String imdbRating, String imdbVotes, String imdbID, String tipo, String respuesta) {
        this.titulo = titulo;
        this.año = año;
        this.calificado = calificado;
        this.lanzado = lanzado;
        this.tiempoEjecucion = tiempoEjecucion;
        this.genero = genero;
        this.director = director;
        this.escritor = escritor;
        this.actores = actores;
        this.trama = trama;
        this.idioma = idioma;
        this.pais = pais;
        this.premios = premios;
        this.cartel = cartel;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.tipo = tipo;
        this.respuesta = respuesta;
    }

}
