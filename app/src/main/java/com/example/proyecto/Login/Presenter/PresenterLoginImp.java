package com.example.proyecto.Login.Presenter;

import com.example.proyecto.Login.Model.ModelLogin;
import com.example.proyecto.Login.Model.ModelLoginImp;
import com.example.proyecto.Login.View.ViewLogin;
import com.example.proyecto.Util;

public class PresenterLoginImp implements PresenterViewLogin, PresenterModelLogin {

    private final String REQUIRED = "required";

    private final ModelLogin modelo;
    private final ViewLogin vista;


    public PresenterLoginImp(ViewLogin vista) {
        this.vista = vista;
        modelo = new ModelLoginImp(this);
    }

    public PresenterLoginImp(ViewLogin vista, ModelLogin model) {
        this.vista = vista;
        this.modelo = model;
    }

    @Override
    public void onSuccess() {
        vista.ocultarProgressBar();
        vista.redirecToHome();
    }

    @Override
    public void onError(String error) {
        vista.ocultarProgressBar();
        vista.onErrorLogin(error);
    }

    @Override
    public void login(String email, String password) {
        if (validarEmailAndPassword(email, password)) {
            vista.mostrarProgressBar();
            modelo.login(email, password);
        }
    }


    public boolean validarEmailAndPassword(String email, String password) {
        return validarEmailVista(email) & validarPasswordVista(password);
    }

    public boolean validarEmailVista(String email) {
        boolean valido = true;
        if (!Util.validarEmail(email)) {
            if (Util.validarIsCampoVacio(email)) {
               vista.setEmailError(REQUIRED);
                valido = false;
            } else if (!Util.isEmailValid(email)) {
                vista.setEmailError("email no valido");
                valido = false;
            }
        }
        return valido;

    }

    public boolean validarEmail(String email) {
        boolean valido = true;
        if (!Util.validarEmail(email)) {
            if (Util.validarIsCampoVacio(email)) {
                valido = false;
            } else if (!Util.isEmailValid(email)) {
                valido = false;
            }
        }
        return valido;

    }
    public boolean validarPasswordVista(String password) {
        boolean valido = true;
        if (!Util.validarPassword(password)) {
            if (Util.validarIsCampoVacio(password)) {
                vista.setPassworError(REQUIRED);
                valido = false;
            } else if (password.length() < 6) {
                vista.setPassworError("Minimo 6 caracteres");
                valido = false;
            }
        }
        return valido;
    }



}

