package com.example.farhad.rssfeedapp;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;



public class WorldNews extends Activity {

    Button btn;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_news);
        btn = (Button) findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorldNews.this, MainActivity.class));
            }
        });


        setContentView(R.layout.activity_world_news);
        listView = (ListView) findViewById(R.id.listview);
        bindDataToListing();
    }

    private void bindDataToListing() {
        try {
            SAXParserFactory saxparser = SAXParserFactory.newInstance();
            SAXParser parser = saxparser.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();
            ParsingClass pc = new ParsingClass();
            xmlReader.setContentHandler(pc);
            InputStream is = getAssets().open("world_news.xml");
            xmlReader.parse(new InputSource(is));
            BindingData bindingData = new BindingData(this, pc.title,
                    pc.link, pc.description, pc.pubDate);
            listView.setAdapter(bindingData);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
