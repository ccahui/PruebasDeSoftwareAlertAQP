package com.example.proyecto;

import com.example.proyecto.Login.Presenter.PresenterLoginImp;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class AqpUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validar_email_isCorrect(){
        String email = "test@example.com";

        boolean valorObtenido = Util.validarEmail(email);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_email_isIncorrect(){
        String email = "test@";

        boolean valorObtenido = Util.validarEmail(email);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_email_vacio_isIncorrect(){
        String email = "";

        boolean valorObtenido = Util.validarEmail(email);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }


    @Test
    public void validar_contrasenia_isCorrect(){
        String contrasenia = "test123";

        boolean valorObtenido = Util.validarPassword(contrasenia);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_contrasenia_isIncorrect(){
        String contrasenia = "test1";

        boolean valorObtenido = Util.validarPassword(contrasenia);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_nombre_isCorrect(){
        String nombre = "Kristian";

        boolean valorObtenido = Util.validarIsCampoVacio(nombre);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_nombre_isIncorrect(){
        String email = "";

        boolean valorObtenido = Util.validarIsCampoVacio(email);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_apellido_isCorrect(){
        String nombre = "Ccahui Huaman";

        boolean valorObtenido = Util.validarIsCampoVacio(nombre);
        boolean valorEsperado = false;

        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    public void validar_apellido_isIncorrect(){
        String email = "";

        boolean valorObtenido = Util.validarIsCampoVacio(email);
        boolean valorEsperado = true;

        assertEquals(valorObtenido, valorEsperado);
    }








}
