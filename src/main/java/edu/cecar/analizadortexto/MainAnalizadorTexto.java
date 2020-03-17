/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.analizadortexto;

import edu.cecar.logicaNegocio.Pelicula;
import edu.cecar.logicaNegocio.Serie;
import edu.cecar.logicaNegocio.Validar;
import edu.cecar.logicaNegocio.consulltaBaseDato;

/**
 *
 * @author luis caldera
 */
public class MainAnalizadorTexto {

    public static void main(String[] args) throws Exception {
       
        Pelicula almacenarP = new Pelicula();

        Serie almacenarS = new Serie();
        Serie archivoS = new Serie();
        consulltaBaseDato a = new consulltaBaseDato();
        consulltaBaseDato d = new consulltaBaseDato();
        String nombre = "'Othello'";

       
        switch (Validar.procesarExpresion(args)) {
            case -1:
                System.out.println("Error: El Comando No Existe");
                break;
            case 0:
                System.out.println("Error: Argumentos Invalidos");
                break;
            case 1:
                
                
                    System.out.println("Comando 1 -SinArgumento- La Informacion de las Peliculas Se Almacenara En Un Archivo");
                      almacenarP.crearArchivoPelicula();
               
                break;
            case 2:
                
                if (Validar.getArgumentoComando_1().equals("proyecto")) {
                    System.out.println("Comando 1 -ConArgumento- La Informacion de las Peliculas Se Almacenara en la BD Especificada");
                    almacenarP.getDatosPeliculas();
                } else {
                    System.out.println("el argumento no coincide con el nombre de la base datos.");
                }

                break;
            case 3:
                
                
                     System.out.println("Comando 2 -SinArgumento- La Informacion de las Series Se Almacenara En Un Archivo");
                     archivoS.crearArchivoSeries();
                
               
                break;
            case 4:
                if (Validar.getArgumentoComando_1().equals("proyecto")) {
                    System.out.println("Comando 2 -ConArgumento- La Informacion de la Series Se Almacenara en la BD especificada");
                    
                } else {
                    System.out.println("el argumento no coincide con el nombre de la base datos.");
                }
                
                break;
            case 5:
                
                    System.out.println("Comando 3 -SinArgumento- Busqueda en la BD por nombre y fecha");
                    d.getPeluculaBuscarNombre();
                     
               
                
                break;
            case 6:
                
                 
                     System.out.println("Comando 3 -ConArgumento- Busqueda en la BD por nombre");
                     d.getPeluculaBuscarNombre();

                break;
            case 7:
               
                System.out.println("Comando 3 -ConArgumento- Busqueda en la BD por año");
                d.getPeluculaBuscarAño();
                
                break;

            default:
                System.out.println("EL comando no existe.");
                break;
        }
    
//       
//                      //  Pelicula objeBD = new Pelicula();
//                        //objeBD.getDatosPeliculas();
//                        //objeBD.crearArchivo();
//                        Pelicula objBD = new Pelicula();
//                        
////                       objBD.getDatosPeliculas();
////                       objBD.crearArchivoPelicula();
//       
    }

}
