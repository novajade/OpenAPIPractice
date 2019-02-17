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

import java.util.Arrays;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieData> {
    private Context context;
    private List<MovieData> values;

    public MovieAdapter(@NonNull Context context, List<MovieData> values) {
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

        TextView textView = (TextView) row.findViewById(R.id.item_list_text);

        MovieData movieData = values.get(position);
        List<MovieData.items> message = movieData.items;
        Log.d("Open Api", message.toString());
        textView.setText(message.toString());
        return row;
    }
}
