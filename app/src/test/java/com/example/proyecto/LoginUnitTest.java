package com.example.proyecto;

import com.example.proyecto.Login.Model.ModelLogin;
import com.example.proyecto.Login.Presenter.PresenterViewLogin;
import com.example.proyecto.Login.Presenter.PresenterLoginImp;
import com.example.proyecto.Login.View.ViewLogin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {
    @Mock
    private ViewLogin view;
    @Mock
    private ModelLogin model;
    private PresenterViewLogin presenter;
    @Before
    public void setUp(){
        presenter = new PresenterLoginImp(view, model);
    }

    /* PU-001*/
    @Test
    public void validarEmailCumpleConElFormato() {
        String email = "test@hotmail.com";
        String password = "123456";
        presenter.login(email, password);
        Mockito.verify(view).mostrarProgressBar();
    }
    /* PU-002*/
    @Test
    public void validarEmailNoCumpleConElFormato() {
        String email = "test@";
        String password = "123456";
        presenter.login(email, password);

        Mockito.verify(view).setEmailError("email no valido");
    }
    /* PU-003*/
    @Test
    public void validarEmailVacio() {
        String email = "";
        String password = "Kristian";
        presenter.login(email, password);

        Mockito.verify(view).setEmailError("required");
    }
    /* PU-004*/
    @Test
    public void validarPasswordCumpleConElFormato() {
        String email = "test@example.com";
        String password = "test123";
        presenter.login(email, password);

        Mockito.verify(view).mostrarProgressBar();
    }
    /*PU-005*/
    @Test
    public void validarPasswordPresentaMenosDe5Caracteres() {
        String email = "test@example.com";
        String password = "12345";
        presenter.login(email, password);

        Mockito.verify(view).setPassworError("Minimo 6 caracteres");
    }
    /*PU-006*/
    @Test
    public void validarPasswordVacio() {
        String email = "test@example.com";
        String password = "";
        presenter.login(email, password);

        Mockito.verify(view).setPassworError("required");
    }
}