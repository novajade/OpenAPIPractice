package com.example.zzong.openapipractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        TextView year = (TextView) row.findViewById(R.id.movie_year);
        TextView director = (TextView) row.findViewById(R.id.movie_director);
        TextView actor = (TextView) row.findViewById(R.id.movie_actor);
        RatingBar rate = (RatingBar) row.findViewById(R.id.movie_rate);
        ImageView image = (ImageView) row.findViewById(R.id.movie_image);

        items list = values.get(position);

        //Runtime error 원인 - placeholder와 error 없이 하면 이미지가 로드가 완료되지 않은 상태에서 imageview에 넣으려 하는거 같아서..
        //img url이 비어있는 - 이미지 준비중 영화는 X표시 이미지로 바꿈
        try{
            Picasso.get()
                    .load(list.getImage().toString())
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image);
        }
        catch (Exception e){
            e.printStackTrace();
            Picasso.get()
                    .load(R.drawable.no_image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(image);
        }

        String text_title = list.getTitle();
        title.setText(text_title);
        String text_year = list.getPubdate();
        year.setText(text_year);
        String text_director = list.getDirector();
        director.setText(text_director);
        String text_actor = list.getActor();
        actor.setText(text_actor);
        rate.setRating(list.getUserrating());

        return row;
    }
}
