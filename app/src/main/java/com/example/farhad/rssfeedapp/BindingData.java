package com.example.farhad.rssfeedapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BindingData extends BaseAdapter {
    ArrayList<String> title;
    ArrayList<String> link;
    ArrayList<String> description;
    ArrayList<String> pubDate;
    LayoutInflater inflater;

    public BindingData() {

    }

    public BindingData(Activity act, ArrayList<String> title,
                       ArrayList<String> link, ArrayList<String> description, ArrayList<String> pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;

        inflater = (LayoutInflater) act
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.activity_world_news, null);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.txtLink = (TextView) convertView.findViewById(R.id.link);
            holder.txtDescription = (TextView) convertView.findViewById(R.id.description);
            holder.txtpubDate = (TextView) convertView.findViewById(R.id.pubDate);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtTitle.setText(Html.fromHtml("<b>Title : </b>" + title.get(position)));
        holder.txtLink.setText(Html.fromHtml("<b>Link : </b>" + link.get(position)));
        holder.txtDescription.setText(Html.fromHtml("<b>Description : </b>" + description.get(position)));
        holder.txtpubDate.setText(Html.fromHtml("<b>PubDate : </b>" + pubDate.get(position)));

        return convertView;
    }

    private class Holder {
        TextView txtTitle, txtLink, txtDescription, txtpubDate;
    }
}