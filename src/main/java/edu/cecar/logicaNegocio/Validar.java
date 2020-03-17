package edu.cecar.logicaNegocio;

/**
* Empresiones a validar
* 1 -> "getDatosPeliculas [–d basededatos]"
* 2 -> "getDatosSeries [–d basededatos]"
* 3 -> "getPelicula [-n nombre|-a año]"
*/

import java.util.regex.*;

public class Validar {
    
    private static String argumentoComando_1;
    private static String argumentoComando_2;
    private static int argumentoComando_3_1;
    private static String argumentoComando_3_2;
    
    public static int procesarExpresion(String[] args){
        int estado_validacion = -1;
        boolean bandera = true;
        String argumento = ""; 
        
       
        // conctena los string de que escribieron
        for(int i=0; i<args.length; i++){
            argumento = argumento + args[i];       
        }
       
        if(args[0].equals("getDatosPeliculas") || args[0].equals("getDatosSeries") || args[0].equals("getPelicula")){
           
            if(args.length>1){
                
               if(args[1].equals("-d") || args[1].equals("-a") || args[1].equals("-n")){
                   
                    Pattern modelo_1 = Pattern.compile("^getDatosPeliculas{1}");
                    Pattern modelo_1_1 = Pattern.compile("^getDatosPeliculas{1}-d[a-zA-Z0-9._-]*");        
                    Matcher r_modelo_1 = modelo_1.matcher(argumento);
                    Matcher r_modelo_1_1 = modelo_1_1.matcher(argumento);

                    Pattern modelo_2 = Pattern.compile("^getDatosSeries{1}");
                    Pattern modelo_2_1 = Pattern.compile("^getDatosSeries{1}-d[a-zA-Z0-9._-]*");
                    Matcher r_modelo_2 = modelo_2.matcher(argumento);
                    Matcher r_modelo_2_1 = modelo_2_1.matcher(argumento);

                    Pattern modelo_3 = Pattern.compile("^getPelicula{1}");
                    Pattern modelo_3_1 = Pattern.compile("^getPelicula{1}-n[a-zA-Z0-9]*");
                    Pattern modelo_3_2 = Pattern.compile("^getPelicula{1}-a[0-9]*");
                    Matcher r_modelo_3 = modelo_3.matcher(argumento);
                    Matcher r_modelo_3_1 = modelo_3_1.matcher(argumento);
                    Matcher r_modelo_3_2 = modelo_3_2.matcher(argumento);

                    estado_validacion = 0;

                    if(r_modelo_1.matches()){   estado_validacion = 1;}  
                    if(r_modelo_1_1.matches()){ estado_validacion = 2; argumentoComando_1 = args[2];}
                    if(r_modelo_2.matches())    estado_validacion = 3;
                    if(r_modelo_2_1.matches()){ estado_validacion = 4; argumentoComando_2 = args[2]; }
                    if(r_modelo_3.matches())    estado_validacion = 5;
                    if(r_modelo_3_1.matches()){ estado_validacion = 6; argumentoComando_3_2 = args[2]; }
                    if(r_modelo_3_2.matches()){ estado_validacion = 7; argumentoComando_3_1 = Integer.parseInt(args[2]);}
               }
               
        }else{
              if(args[0].equals("getDatosPeliculas")){
                 estado_validacion = 1;
              }else if(args[0].equals("getDatosSeries")){
                  estado_validacion = 3;
              }else if(args[0].equals("getPelicula")){
                  estado_validacion = 0;
              }                 
           }
           
       }
        
        return estado_validacion;
    }

    public static String getArgumentoComando_1() {
        return argumentoComando_1;
    }

    public static void setArgumentoComando_1(String argumentoComando_1) {
        Validar.argumentoComando_1 = argumentoComando_1;
    }

    public static String getArgumentoComando_2() {
        return argumentoComando_2;
    }

    public static void setArgumentoComando_2(String argumentoComando_2) {
        Validar.argumentoComando_2 = argumentoComando_2;
    }

    public static int getArgumentoComando_3_1() {
        return argumentoComando_3_1;
    }

    public static void setArgumentoComando_3_1(int argumentoComando_3_1) {
        Validar.argumentoComando_3_1 = argumentoComando_3_1;
    }

    public static String getArgumentoComando_3_2() {
        return argumentoComando_3_2;
    }

    public static void setArgumentoComando_3_2(String argumentoComando_3_2) {
        Validar.argumentoComando_3_2 = argumentoComando_3_2;
    }
    
}