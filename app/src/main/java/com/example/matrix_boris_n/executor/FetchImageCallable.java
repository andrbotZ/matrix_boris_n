package com.example.matrix_boris_n.executor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

public class FetchImageCallable implements Callable<Bitmap> {
    private final String image;

    public FetchImageCallable(String image) {
     this.image = image;
    }

    @Override
    public Bitmap call() throws Exception {
        Bitmap bitmap = null;
        try {
            InputStream stream = new URL(image).openStream();
            bitmap = BitmapFactory.decodeStream(stream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return bitmap;
    }
}
