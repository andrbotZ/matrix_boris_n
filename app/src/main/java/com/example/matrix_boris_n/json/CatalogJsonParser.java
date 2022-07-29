package com.example.matrix_boris_n.json;

import android.util.JsonReader;
import android.util.Log;

import com.example.matrix_boris_n.models.DataListAddr;
import com.example.matrix_boris_n.models.DataListObject;

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

    public List<DataListObject> parse() throws IOException {
        List<DataListObject> items = new ArrayList<>();
        if(reader != null){
            reader.beginObject();
            if(reader.nextName().equalsIgnoreCase("DataObject")) {
                reader.beginObject();
                while (reader.hasNext()) {

                    if (reader.nextName().equalsIgnoreCase("DataListObject")) {
                        reader.beginArray();
                        while (reader.hasNext()) {
                            DataListObject item = parseItem(reader);
                            items.add(item);
                        }
                        reader.endArray();
                    }
                   else reader.skipValue();

                }
                reader.endObject();
            }
            reader.endObject();
            reader.close();
        }
        return items;
    }

    private DataListObject parseItem(JsonReader reader) throws IOException {

        long catId = 0;
        String title = "";
        String sTitle = "";
        String image = "";
        long id = 0;
        List<DataListAddr> dataListAddrList = new ArrayList<>();

        reader.beginObject();
        while (reader.hasNext()){

            String name = reader.nextName();

            switch (name){
                case "CatId":
                    catId = reader.nextLong();
                    break;
                case "Title":
                    title = reader.nextString();
                    break;
                case "STitle":
                    sTitle = reader.nextString();
                    break;
                case "Imag":
                    image = reader.nextString();
                    break;
                case "Id":
                    id = reader.nextLong();
                    break;
                case "DataListAddr":
                    reader.beginArray();
                    while (reader.hasNext()) {
                        reader.beginObject();
                        String Addr = "";
                        String DAd = "";

                        while (reader.hasNext()) {
                            String nameAddr = reader.nextName();
                            if(nameAddr.contains("Addr")){
                                Addr = reader.nextString();
                            }
                            else if(nameAddr.contains("DAd")){
                                DAd = reader.nextString();
                            }
                            else reader.skipValue();
                        }
                        dataListAddrList.add(new DataListAddr(Addr, DAd));
                        reader.endObject();
                    }
                    reader.endArray();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new DataListObject(catId, title, sTitle, image, id, dataListAddrList);
    }
}
