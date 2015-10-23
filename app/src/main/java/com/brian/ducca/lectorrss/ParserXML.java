package com.brian.ducca.lectorrss;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author  Brian Ducca
 * @version 1.0
 */
public class ParserXML
{
    private Noticia miNoticia;
    private List<Noticia> miLista;
    private String dato;

    public ParserXML(String dato)
    {
        this.dato=dato;
    }

    public List<Noticia> devolverListaNoticias() throws XmlPullParserException, IOException
    {
        String tag;
        XmlPullParser parser = Xml.newPullParser();
        try {

            parser.setInput(new StringReader(dato));
            int event = parser.getEventType();


            while (event != XmlPullParser.END_DOCUMENT){

                switch (event){

                    case XmlPullParser.START_DOCUMENT:

                        miLista = new ArrayList<Noticia>();

                        break;

                    case XmlPullParser.START_TAG:

                        tag = parser.getName();
                        Log.d("parserxml", "inicio tag:" + tag);
                        if (tag.equals("item"))
                        {
                            miNoticia = new Noticia();
                        }
                        else if (miNoticia != null){
                            if (tag.equals("title"))
                            {
                                miNoticia.setTitulo(parser.nextText().replaceAll("\n",""));
                            }
                            else if(tag.equals("link"))
                            {
                                miNoticia.setLink(parser.nextText());
                            }
                            else if(tag.equals("description"))
                            {
                                miNoticia.setDescripcion(parser.nextText().replaceAll("\n",""));
                            }
                            else if(tag.equals("pubDate"))
                            {
                                Date date = null;
                                DateFormat formatter;
                                String fec = parser.nextText();
                                fec = fec.substring(5,24);
                                formatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
                                date = formatter.parse(fec);
                                miNoticia.setFecha(date);
                            }

                            else if (tag.equals("thumbnail"))
                            {
                                String att= parser.getAttributeValue(null,"url");
                                miNoticia.setUrlImg(att);
                            }


                        }

                        break;

                    case XmlPullParser.END_TAG:

                        tag = parser.getName();
                        Log.d("xmlparser","fin tag:"+tag);
                        if (tag.equals("item") && miNoticia != null){

                            miLista.add(miNoticia);
                            miNoticia = null;
                        }

                        break;

                }

                event = parser.next();

            }



        }catch (Exception e){
            Log.d("log", e.toString());
        }


        return miLista;

    }

}
