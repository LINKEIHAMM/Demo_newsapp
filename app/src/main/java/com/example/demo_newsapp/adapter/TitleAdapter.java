package com.example.demo_newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.demo_newsapp.R;
import com.example.demo_newsapp.entity.Title;

import java.util.List;

public class TitleAdapter extends ArrayAdapter<Title> {
    private int resourceId;

    public TitleAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Title> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Title title = getItem(position);
        View view;
        ViewHolder viewHolder;
        /**
         * Memorize the layout and instances, improve listView
         */
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.titleText = (TextView)view.findViewById(R.id.tvId);
            viewHolder.titlePic = (ImageView) view.findViewById(R.id.image1);
            viewHolder.titleDescr = (TextView)view.findViewById(R.id.tvSource);
//            viewHolder.tvDate=(itemView)view.findViewById(R.id.tvDate);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(getContext()).load(title.getImageUrl()).into(viewHolder.titlePic);
        viewHolder.titleText.setText(title.getTitle());
        viewHolder.titleDescr.setText(title.getDescr());

        return view;

    }

    public class ViewHolder{
        TextView titleText;
        TextView titleDescr;
        ImageView titlePic;
    }
}