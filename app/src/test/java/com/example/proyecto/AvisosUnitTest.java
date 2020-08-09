package com.example.proyecto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvisosUnitTest {
    @Test
    public void validar_nombre_isCorrect(){
        String nombre = "Raul";

        boolean valorObtenido = Util2.validarNombres(nombre);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_nombre_isIncorrect(){
        String nombre = "";

        boolean valorObtenido = Util2.validarIsCampoVacio(nombre);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_apellido_isCorrect(){
        String apellido = "esto es un apellido";

        boolean valorObtenido = Util2.validarApellidos(apellido);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_apellido_isIncorrect(){
        String apellido = "";

        boolean valorObtenido = Util2.validarIsCampoVacio(apellido);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_numeroCel_isCorrect(){
        int numeroCel = 938473811;

        boolean valorObtenido = Util2.validarNumeroDeCelular(numeroCel);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_numeroCel_isIncorrect(){
        String numeroCel = "";

        boolean valorObtenido = Util2.validarIsCampoVacio(numeroCel);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_descripcionA_isCorrect(){
        String descripcion = "Persona de estatura alta, contextura delgada.";

        boolean valorObtenido = Util2.validarDescripcionAvisos(descripcion);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_descripcionA_isIncorrect(){
        String descripcion = "";

        boolean valorObtenido = Util2.validarDescripcionAvisos(descripcion);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }
}
