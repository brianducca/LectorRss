package com.brian.ducca.lectorrss;

import android.os.Handler;
import android.os.Message;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

/**
 * @author  Brian Ducca
 * @version 1.0
 */
public class ThreadConexion implements Runnable {

    private String url;
    private Handler h;

    public ThreadConexion(String url, Handler h)
    {
        this.url = url;
        this.h = h;
    }
    @Override
    public void run() {
        HttpManager http =  new HttpManager(url);

        try {
            String resultado = http.getStrDataByGET();
            ParserXML miParser = new ParserXML(resultado);
            List<Noticia> noticias = miParser.devolverListaNoticias();

            Message msg= new Message();
            msg.obj = noticias;
            msg.arg2=1;
            h.sendMessage(msg);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
