/**
 *
 Copyright (C) <2015>  <Brian Ducca>

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.brian.ducca.lectorrss;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Brian Ducca
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements Handler.Callback,Clickeable,View.OnClickListener {

    private Handler h;
    private RecyclerView recycler;
    private List<Noticia> milista;
    private MyAdapter adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = new Handler(this);
        Button botonleer= (Button) findViewById(R.id.btnLeer);
        botonleer.setOnClickListener(this);


        recycler= (RecyclerView)findViewById(R.id.list);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void seHizoClick() {

    }

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.arg1==1)
        {
            Noticia n= milista.get(msg.arg2);
            n.setImagenarray((Bitmap) msg.obj);
            adap.notifyDataSetChanged();
        }

        if (msg.arg2==1)
        {
            if (msg.obj instanceof List) {
                milista = (ArrayList) msg.obj;

                adap= new MyAdapter(milista, h);
                recycler.setAdapter(adap);
                adap.notifyDataSetChanged();

                return true;

            }

        }
        return false;
    }

    @Override
    public void onClick(View v) {

        EditText texto= (EditText) findViewById(R.id.urlWeb);
        String web="";
        web= texto.getText().toString();
        ThreadConexion tc = new ThreadConexion(web,h);
        Thread t= new Thread(tc);
        t.start();
    }
}
