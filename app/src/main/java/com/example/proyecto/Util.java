package com.example.proyecto;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean validarEmail(String email) {
        boolean valido = true;
        if (validarIsCampoVacio(email)) {
            return false;
        } else if (!isEmailValid(email)) {
            return false;
        }
        return valido;
    }

    public static boolean validarPassword(String password) {
        boolean valido = true;
        if (validarIsCampoVacio(password)) {
            valido = false;
        } else if (password.length() < 6) {
            valido = false;
        }
        return valido;
    }

    public static boolean validarIsCampoVacio(String cadena) {
        return ("".equals(cadena));
    }

    public static boolean isEmailValid(String email) {
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}