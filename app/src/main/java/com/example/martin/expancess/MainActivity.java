package com.example.martin.expancess;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
ListView listView;
    ArrayList<expance> a;
    EnvisionAdaptor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        listView=findViewById( R.id.list );
       a=new ArrayList<>(  );
        for(int i=0;i<20;i++){
           expance e=new expance( "expance",i*1000 );
           e.setName( "expance"+i);
           e.setPrice( i*1000 );
           a.add( e );
        }
      //  ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,a );
        ed=new EnvisionAdaptor( this,a );
        listView.setAdapter( ed );
        listView.setOnItemClickListener( this );
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

      expance ex =a.get(i);
      final int position=i;
//
//
      // creating alert dialog----


        AlertDialog.Builder builder=new AlertDialog.Builder( this );
        //this builder creates setup for data
        builder.setTitle( "confirm delete" );
        builder.setPositiveButton( "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText( MainActivity.this,"ok press",Toast.LENGTH_SHORT ).show();
                a.remove( position );
                ed.notifyDataSetChanged();
            }
        } );
         builder.setNegativeButton( "cancel", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {

             }
         } );
        AlertDialog dialog=builder.create();

        // then you have to show the dialog

        dialog.show();


        switch(i){
            case 1:

                Intent i1=new Intent( this,item1.class );
                startActivity( i1 );
                break;
        }
    }
}
