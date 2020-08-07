package com.example.proyecto;

import com.example.proyecto.Registrarse.Model.ModelRegistrarse;
import com.example.proyecto.Registrarse.Presenter.PresenterRegistrarseImp;
import com.example.proyecto.Registrarse.Presenter.PresenterViewRegistrarse;
import com.example.proyecto.Registrarse.View.ViewRegistrarse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class RegistrarUnitTest {
    @Mock
    private ViewRegistrarse view;
    @Mock
    private ModelRegistrarse model;
    private PresenterViewRegistrarse presenter;
    @Before
    public void setUp(){
        presenter = new PresenterRegistrarseImp(view, model);
    }

    /* PU-007*/
    @Test
    public void validarNombreCumpleFormato() {

        String nombre = "Kristian";
        String apellido = "Ccahui";
        String email = "test@hotmail.com";
        String password = "123456";

        presenter.registrarUsuario(nombre, apellido, email, password);

        Mockito.verify(view).mostrarProgressBar();
    }
    /* PU-008*/
    @Test
    public void validarNombreVacio() {
        String nombre = "";
        String apellido = "Ccahui";
        String email = "test@hotmail.com";
        String password = "123456";

        presenter.registrarUsuario(nombre, apellido, email, password);

        Mockito.verify(view).setNombreError("required");
    }
    /* PU-009*/
    @Test
    public void validarApellidoCumpleFormato() {

        String nombre = "Kristian";
        String apellido = "Ccahui Huaman";
        String email = "test@hotmail.com";
        String password = "123456";

        presenter.registrarUsuario(nombre, apellido, email, password);

        Mockito.verify(view).mostrarProgressBar();
    }
    /* PU-010*/
    @Test
    public void validarApellidoVacio() {
        String nombre = "Kristian";
        String apellido = "";
        String email = "test@hotmail.com";
        String password = "123456";

        presenter.registrarUsuario(nombre, apellido, email, password);

        Mockito.verify(view).setApellidoError("required");
    }

}