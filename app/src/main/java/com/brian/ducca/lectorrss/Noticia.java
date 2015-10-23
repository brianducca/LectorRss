package com.brian.ducca.lectorrss;


import android.graphics.Bitmap;

import java.util.Date;

/**
 * @autor Brian Ducca
 * @version 1.0
 */
public class Noticia {

    private String titulo;
    private String descripcion;
    private Date fecha;
    private String link;
    private String urlImg;
    private Bitmap imagenarray;


    /**
     * Constructor por defecto
     */
    public Noticia(){

    }

    /**
     * Contructor con parmetros
     * @param tit Ttulo de la noticia
     * @param desc Descripcin de la noticia
     * @param fechaNot Fecha de la noticia
     * @param link Link de la noticia
     * @param img Link de la imagen de la noticia
     */
    public Noticia (String tit, String desc, Date fechaNot, String link, String img){

        this.titulo = tit;
        this.descripcion = desc;
        this.fecha = fechaNot;
        this.link = link;
        this.urlImg = img;

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String imagen) {
        this.urlImg = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImagenarray(Bitmap imagenarray) {
        this.imagenarray = imagenarray;
    }

    public Bitmap getImagenarray() {
        return imagenarray;
    }
}
