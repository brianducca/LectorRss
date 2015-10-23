package com.brian.ducca.lectorrss;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.http.io.HttpMessageParser;

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

        String html=minoticia.getDescripcion().toString();
        //patrones de string
        html = html.replaceAll("<(.*?)\\>"," ");//Removes all items in brackets
        html = html.replaceAll("<(.*?)\\\n", " ");//Must be undeneath
        html = html.replaceFirst("(.*?)\\>", " ");//Removes any connected item to the last bracket
        html = html.replaceAll("&nbsp;"," ");
        html = html.replaceAll("&amp;"," ");

        myViewHolder.getTxtDescripcion().setText(android.text.Html.fromHtml(html));

        if ( minoticia.getImagenarray() == null ) {
            Log.d("urlimg", minoticia.getUrlImg());
            ThreadImagenes thI = new ThreadImagenes(minoticia.getUrlImg(), h, i);
            Thread t = new Thread(thI);
            t.start();

        }
        else
        {
            Log.d("urlimg","entre al else");
            Log.d("urlimg",Integer.valueOf(minoticia.getImagenarray().getByteCount()).toString());
           myViewHolder.getImg().setImageBitmap(minoticia.getImagenarray());
        }



    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
