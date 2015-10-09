package com.brian.ducca.lectorrss;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author  Brian Ducca
 * @version 1.0
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFecha;
    private TextView txtTitulo;
    private TextView txtDescripcion;
    private ImageView img;

    public MyViewHolder(View view){
        super(view);
        setTxtFecha((TextView) view.findViewById(R.id.txtfechaNoticia));
        setTxtTitulo((TextView) view.findViewById(R.id.txttituloNoticia));
        setTxtDescripcion((TextView) view.findViewById(R.id.txttextoNoticia));
        setImg((ImageView) view.findViewById(R.id.imgNoticia));

    }


    public TextView getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(TextView txtFecha) {
        this.txtFecha = txtFecha;
    }

    public TextView getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(TextView txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public TextView getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(TextView txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
}
