package com.example.martin.expancess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static com.example.martin.expancess.R.id.expanceAmmount;

public class EnvisionAdaptor extends ArrayAdapter {
    LayoutInflater inflater;
ArrayList<expance> item;
    public EnvisionAdaptor(@NonNull Context context, ArrayList<expance> items) {
        super( context, 0,items);
        inflater=(LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.item=items;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View output=inflater.inflate( R.layout.expance_row_layout,parent,false );
        TextView nameTextView=output.findViewById( R.id.expanceName );
        TextView ammountTextView=output.findViewById( R.id.expanceAmmount );
        expance exp=item.get(position);
        nameTextView.setText( exp.getName() );
        ammountTextView.setText( exp.getPrice()+"" );

        return  output;


    }
}
