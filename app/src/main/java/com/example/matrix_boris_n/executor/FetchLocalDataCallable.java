package com.example.matrix_boris_n.executor;

import com.example.matrix_boris_n.json.CatalogJsonParser;
import com.example.matrix_boris_n.models.CatalogItem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FetchLocalDataCallable implements Callable<List<CatalogItem>> {
    private final InputStream stream;
    private ArrayList<CatalogItem> data = new ArrayList<>();

    public FetchLocalDataCallable(InputStream stream) {
        this.stream = stream;

    }

    @Override
    public List<CatalogItem> call() throws Exception {
        CatalogJsonParser parser = new CatalogJsonParser(stream);
        return parser.parse();
    }
}
