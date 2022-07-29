package com.example.matrix_boris_n.models;

import java.util.List;

public class DataListObject {
    private final long catId;
    private final String title;
    private final String sTitle;
    private final String image;
    private final long id;
    private final List<DataListAddr> dataListAddrList;

    public DataListObject(long catId, String title, String sTitle, String image, long id, List<DataListAddr> dataListAddrList) {
        this.catId = catId;
        this.title = title;
        this.sTitle = sTitle;
        this.image = image;
        this.id = id;
        this.dataListAddrList = dataListAddrList;
    }

    @Override
    public String toString() {
        return "DataListObject{" +
                "catId=" + catId +
                ", title='" + title + '\'' +
                ", sTitle='" + sTitle + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                ", dataListAddrList=" + dataListAddrList +
                '}';
    }
}
