package com.example.matrix_boris_n.executor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.models.DataObject;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

public class FetchImagesCallable implements Callable<DataObject> {
    private final DataObject data;

    public FetchImagesCallable(DataObject data) {
     this.data = data;
    }

    @Override
    public DataObject call() throws Exception {

        for (DataListObject element : data.elements) {
            Bitmap bitmap = null;
            try {
                InputStream stream = new URL(element.image).openStream();
                element.bitmap = BitmapFactory.decodeStream(stream);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        return data;
    }
}
