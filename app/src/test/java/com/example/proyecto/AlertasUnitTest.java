package com.example.proyecto;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class AlertasUnitTest {
    /*PU-011*/
    @Test
    public void validar_titulo_isCorrect(){
        String titulo = "esto es un título";

        boolean valorObtenido = Util2.validarTitulo(titulo);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }


    @Test
    public void validar_titulo_vacio_isIncorrect(){
        String titulo = "asd";

        boolean valorObtenido = Util2.validarIsCampoVacio(titulo);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    /*PU-012*/
    @Test
    public void validar_descripcion_isCorrect(){
        String descripcion = "alerta generada por un usuario";

        boolean valorObtenido = Util2.validarDescripcionAlerta(descripcion);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_descripcion_isIncorrect(){
        String descripcion = "";

        boolean valorObtenido = Util2.validarIsCampoVacio(descripcion);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

}
