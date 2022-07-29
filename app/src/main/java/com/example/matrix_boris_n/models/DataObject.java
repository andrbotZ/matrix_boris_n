package com.example.matrix_boris_n.models;

import java.util.List;

public class DataObject {
    private final List<DataListCat> listCat;
    private final List<DataListObject> listObject;

    public DataObject(List<DataListObject> listObject, List<DataListCat> listCat) {
        this.listObject = listObject;
        this.listCat = listCat;
    }
}
