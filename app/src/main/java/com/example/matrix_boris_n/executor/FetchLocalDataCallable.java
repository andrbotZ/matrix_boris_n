package com.example.matrix_boris_n.executor;

import com.example.matrix_boris_n.json.DataListObjectJsonParser;
import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.models.DataObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;

public class FetchLocalDataCallable implements Callable<DataObject> {
    private final InputStream stream;

    public FetchLocalDataCallable(InputStream stream) {
        this.stream = stream;

    }

    @Override
    public DataObject call() throws Exception {
        DataListObjectJsonParser parserObject = new DataListObjectJsonParser(new InputStreamReader(stream, "UTF-8"));
        return parserObject.parse();
    }
}
