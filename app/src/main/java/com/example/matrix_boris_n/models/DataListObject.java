package com.example.matrix_boris_n.models;

import java.util.List;

public class DataListObject {
    public final long catId;
    public final String title;
    public final String sTitle;
    public final String image;
    public final long id;
    public final List<DataListAddr> dataListAddrList;

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
