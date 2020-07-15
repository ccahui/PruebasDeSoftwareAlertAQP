package com.example.proyecto.Model;

public class Aviso {

    private String nombre;
    private String apellido;
    private String descripcion;
    private String telefono;
    private String mImageUrl;


    public Aviso(String mImageUrl, String nombre, String apellido, String descripcion, String telefono) {
        setmImageUrl(mImageUrl);
        setNombre(nombre);
        setApellido(apellido);
        setDescripcion(descripcion);
        setTelefono(telefono);
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
