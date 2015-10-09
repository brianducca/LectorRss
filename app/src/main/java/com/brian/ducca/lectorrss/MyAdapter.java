package com.brian.ducca.lectorrss;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author  Brian Ducca
 * @version 1.0
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Noticia> myList;
    private Handler h;

    public MyAdapter(List<Noticia> myList, Handler h)
    {
        this.myList = myList;
        this.h = h;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View v = li.inflate(R.layout.noticias, null);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Noticia minoticia = myList.get(i);
        myViewHolder.getTxtFecha().setText(minoticia.getFecha().toString());
        myViewHolder.getTxtTitulo().setText(minoticia.getTitulo());
        myViewHolder.getTxtDescripcion().setText(minoticia.getDescripcion());
        /*
        if ( minoticia.getUrlImg() == null ) {


            ThreadImagenes thI = new ThreadImagenes(minoticia.getUrlImg(), h, i);
            Thread t = new Thread(thI);
            t.start();

        }
        */


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
