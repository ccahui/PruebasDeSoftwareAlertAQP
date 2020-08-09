package com.example.proyecto;

public class Util2 {

    public static boolean validarTitulo(String titulo) {
        boolean valido = true;
        if (validarIsCampoVacio(titulo)) {
            return false;
        }
        return valido;
    }
    public static boolean validarDescripcionAlerta(String descripcion) {
        boolean valido = true;
        if (validarIsCampoVacio(descripcion)) {
            return false;
        }
        return valido;
    }
    /***********************************************/
    public static boolean validarNombres(String nombres) {
        boolean valido = true;
        if (validarIsCampoVacio(nombres)) {
            return false;
        }
        return valido;
    }
    public static boolean validarApellidos(String apellidos) {
        boolean valido = true;
        if (validarIsCampoVacio(apellidos)) {
            return false;
        }
        return valido;
    }
    public static boolean validarNumeroDeCelular(int numero) {
        boolean valido = true;
        String numeroo = Integer.toString(numero);
        if (validarIsCampoVacio(numeroo)) {
            return false;
        }else if(validarIsNumeroCelular(numeroo)){
            return false;
        }
        return valido;
    }
    public static boolean validarDescripcionAvisos(String descripcion) {
        boolean valido = true;
        if (validarIsCampoVacio(descripcion)) {
            return false;
        }
        return valido;
    }
    /***********************************************/
    public static boolean validarIsCampoVacio(String cadena) {
        return ("".equals(cadena));
    }
    public static boolean validarIsNumeroCelular(String cadena) {
        return (cadena.length()==9);
    }

}
