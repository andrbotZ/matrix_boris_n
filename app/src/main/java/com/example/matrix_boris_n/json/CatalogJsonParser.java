package com.example.matrix_boris_n.json;

import android.util.JsonReader;

import com.example.matrix_boris_n.models.CatalogItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CatalogJsonParser {

    private JsonReader reader;

    public CatalogJsonParser(InputStream stream) {

        try {
            reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public List<CatalogItem> parse() throws IOException {
        List<CatalogItem> items = new ArrayList<>();
        if(reader != null){
            reader.beginObject();
            reader.beginArray();
            while (reader.hasNext()){
                items.add(parseItem(reader));
            }
            reader.close();
        }
        return null;
    }

    private CatalogItem parseItem(JsonReader reader) {

        return null;
    }
}
