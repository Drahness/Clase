package com.example.clase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MyListActivity extends MainMenu {
    private String[] books;
    private String[] authors;
    private int[] images;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.list_view);

        authors = getResources().getStringArray(R.array.authors);
        books = getResources().getStringArray(R.array.books);

        images = new int[books.length];
        images[0] = R.drawable.cabre_senyoria;
        images[1] = R.drawable.grisman_rogue;
        images[2] = R.drawable.traicion_roma;
        images[3] = R.drawable.rrmartinsong;
        images[4] = R.drawable.rrtolkien_hobbit;

        adapter = new ArrayAdapter<String>(this,R.layout.item_list,R.id.textView,libros);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
                builder.setTitle(libros[(int)l]);
                builder.setMessage("Autor: " + autor);
                ImageView image = new ImageView(ListViewActivity.this);
                image.setImageResource(images[(int)l]);
                builder.setPositiveButton("OK",null);
                builder.setView(image);
                builder.create().show();
            }
        });
    }
}