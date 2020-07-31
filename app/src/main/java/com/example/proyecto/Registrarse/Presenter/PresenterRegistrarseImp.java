package com.example.proyecto.Registrarse.Presenter;

import android.util.Patterns;
import com.example.proyecto.Registrarse.Model.ModelRegistrarse;
import com.example.proyecto.Registrarse.Model.ModeloRegistrarseImp;
import com.example.proyecto.Registrarse.View.ViewRegistrarse;
import com.example.proyecto.Util;

public class PresenterRegistrarseImp implements PresenterRegistrarse, ListenerRegistrarse {

    private final String REQUIRED = "required";

    private final ViewRegistrarse vista;
    private final ModelRegistrarse modelo;

    public PresenterRegistrarseImp(ViewRegistrarse vista) {
        this.vista = vista;
        modelo = new ModeloRegistrarseImp(this);
    }

    @Override
    public void registrarUsuario(String nombre, String apellido, String email, String password) {
        if(validarDatosDeUsuario(nombre, apellido, email, password)){
            vista.mostrarProgressBar();
            modelo.registrarUsuario(nombre, apellido, email, password);
        }
    }

    @Override
    public void onSuccess() {
        vista.ocultarProgressBar();
        vista.redirecToHome();
    }

    @Override
    public void onError(String error) {
        vista.ocultarProgressBar();
        vista.onErrorRegistrarse(error);
    }

    private boolean validarDatosDeUsuario(String nombre, String apellido, String email, String password) {
        return validarEmailVista(email) & validarPasswordVista(password) & validarNombreVista(nombre) & validarApellidoVista(apellido);
    }

    private boolean validarNombreVista(String nombre){
       if(Util.validarIsCampoVacio(nombre)){
            vista.setNombreError(REQUIRED);
            return false;
        }
        return true;
    }

    private boolean validarApellidoVista(String apellido){
        if(Util.validarIsCampoVacio(apellido)){
            vista.setApellidoError(REQUIRED);
            return false;
        }
        return true;
    }

    private boolean validarEmailVista(String email) {

        boolean valido = true;

        if (Util.validarIsCampoVacio(email)) {
            vista.setEmailError(REQUIRED);
            valido = false;
        }
        else if (! Util.isEmailValid(email)) {
            vista.setEmailError("email no valido");
            valido = false;
        }
        return valido;

    }

    private boolean validarPasswordVista(String password) {
        boolean valido = true;
        if (Util.validarIsCampoVacio(password)) {
            vista.setPassworError(REQUIRED);
            valido = false;
        }
        else if (password.length()< 6) {
            vista.setPassworError("Minimo 6 caracteres");
            valido = false;
        }
        return valido;
    }


}
