package com.example.farhad.rssfeedapp;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsingClass extends DefaultHandler {

    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> link = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<String> pubDate = new ArrayList<String>();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equalsIgnoreCase("title")) {
            tempStore = "";
        } else if (localName.equalsIgnoreCase("link")) {
            tempStore = "";
        } else if (localName.equalsIgnoreCase("description")) {
            tempStore = "";
        }else if (localName.equalsIgnoreCase("pubDate")) {
            tempStore = "";
        }else{
            tempStore = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equalsIgnoreCase("title")) {
            title.add(tempStore);
        } else if (localName.equalsIgnoreCase("link")) {
            link.add(tempStore);
        } else if (localName.equalsIgnoreCase("description")) {
            description.add(tempStore);
        } else if (localName.equalsIgnoreCase("pubDate")) {
            pubDate.add(tempStore);
        }

        tempStore = "";
    }

    private String tempStore = "";

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        tempStore += new String(ch, start, length);
    }
}