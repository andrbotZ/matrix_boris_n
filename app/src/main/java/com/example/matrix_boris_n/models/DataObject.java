package com.example.matrix_boris_n.models;

import java.util.List;

public class DataObject {
    public final List<DataListCat> categories;
    public final List<DataListObject> elements;

    public DataObject(List<DataListObject> elements, List<DataListCat> categories) {
        this.elements = elements;
        this.categories = categories;
    }
}
