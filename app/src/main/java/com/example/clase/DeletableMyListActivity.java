package com.example.clase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

public class DeletableMyListActivity extends MyListActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DeletableMyListActivity.this);
                builder.setTitle(authors[(int)l]);
                builder.setMessage( getString(R.string.book)+ books[(int)l]);
                ImageView image = new ImageView(DeletableMyListActivity.this);
                image.setMaxHeight(300);
                image.setMaxWidth(120);
                image.setImageResource(book_images[(int)l]);
                builder.setView(image);
                builder.setPositiveButton("OK",null);
                builder.setNegativeButton("Borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arraylist.remove((int) l);
                        adapter.notifyDataSetChanged();
                    }
                })
                builder.create().show();
            }
        });
    }

    private int[] deleteElement(int[] array, int deletedPos) {
        int[] returnedArray = new int[array.length-1];
        for(int pos = 0, arraypos = 0; pos > array.length; pos++) {
            if(pos == deletedPos) {
                continue;
            }
            arraypos++;
            returnedArray[arraypos] = array[pos];
        }
        return returnedArray;
    }
    private String[] deleteElement(String[] array, int deletedPos) {
        String[] returnedArray = new String[array.length-1];
        for(int pos = 0, arraypos = 0; pos > array.length; pos++) {
            if(pos == deletedPos) {
                continue;
            }
            arraypos++;
            returnedArray[arraypos] = array[pos];
        }
        return returnedArray;
    }
}
