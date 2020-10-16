package com.example.clase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListActivity extends MainMenu {
    private static final String PICTURE_TAG = "pic";
    private static final String AUTHOR_TAG = "name";
    private String[] books;
    private String[] authors;
    private int[] book_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        if(getActionBar() == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        ListView list = (ListView) findViewById(R.id.list_view);
        // Get the resources
        authors = getResources().getStringArray(R.array.authors);
        books = getResources().getStringArray(R.array.books);
        // Get the images from R.
        book_images = new int[books.length];
        book_images[0] = R.drawable.cabre_senyoria;
        book_images[1] = R.drawable.grisman_rogue;
        book_images[2] = R.drawable.traicion_roma;
        book_images[3] = R.drawable.rrmartinsong;
        book_images[4] = R.drawable.rrtolkien_hobbit;


        int[] author_images = new int[authors.length];
        author_images[0] = R.drawable.jaume;
        author_images[1] = R.drawable.joegris;
        author_images[2] = R.drawable.posteguillo;
        author_images[3] = R.drawable.rrmartin;
        author_images[4] = R.drawable.rrtolkien;

        List<Map<String,Object>> arraylist = new ArrayList<>();

        for (int i = 0 ;i < books.length ; i++) {
            Map<String,Object> map = new HashMap<>();

            map.put("pic", author_images[i]);
            map.put("name",authors[i]);
            arraylist.add(map);
        }


        SimpleAdapter adapter = new SimpleAdapter(
                MyListActivity.this,
                arraylist,
                R.layout.item_list,
                new String[]{PICTURE_TAG, AUTHOR_TAG},
                new int[]{R.id.item_image, R.id.item_text});
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyListActivity.this);
                builder.setTitle(authors[(int)l]);
                builder.setMessage( getString(R.string.book)+ books[(int)l]);
                ImageView image = new ImageView(MyListActivity.this);
                image.setMaxHeight(300);
                image.setMaxWidth(120);
                image.setImageResource(book_images[(int)l]);
                builder.setPositiveButton("OK",null);
                builder.setView(image);
                builder.create().show();
            }
        });
    }
}