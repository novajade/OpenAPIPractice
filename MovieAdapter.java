package com.example.zzong.openapipractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<items> {
    private Context context;
    private List<items> values;


    public MovieAdapter(@NonNull Context context, List<items> values) {
        super(context, R.layout.item_list, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_list, parent, false);
        }

        TextView title = (TextView) row.findViewById(R.id.movie_title);

        items list = values.get(position);
        String text = list.getTitle();
        title.setText(text);

        return row;
    }
}
