package com.example.matrix_boris_n.json;

import android.util.JsonReader;
import android.util.Log;

import com.example.matrix_boris_n.models.DataListAddr;
import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.models.DataObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DataListObjectJsonParser {

    private JsonReader reader;


    public DataListObjectJsonParser(InputStreamReader stream) {
        reader = new JsonReader(stream);
    }

    public DataObject parse() throws IOException {
        List<DataListObject> dataListObjects = new ArrayList<>();
        List<DataListCat> listCat = new ArrayList<>();

        if(reader != null){
            reader.beginObject();
            if(reader.nextName().equalsIgnoreCase("DataObject")) {
                reader.beginObject();
                while (reader.hasNext()) {
                    String name = reader.nextName();
                    if (name.equalsIgnoreCase("DataListObject")) {
                        reader.beginArray();
                        while (reader.hasNext()) {
                            DataListObject item = parseItem(reader);
                            dataListObjects.add(item);
                        }
                        reader.endArray();
                    }
                    else if(name.equalsIgnoreCase("DataListCat")) {
                        reader.beginArray();
                        while (reader.hasNext()) {
                            DataListCat item = parseCatItem(reader);
                            listCat.add(item);
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
        return new DataObject(dataListObjects, listCat);
    }

    private DataListCat parseCatItem(JsonReader reader) throws IOException {

        long catId = 0;
        String cTitle = "";

        reader.beginObject();
        while (reader.hasNext()){
            String name = reader.nextName();
            switch (name){
                case "CatId":
                    catId = reader.nextLong();
                    break;
                case "CTitle":
                    cTitle = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new DataListCat(catId, cTitle);
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
