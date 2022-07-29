package com.example.matrix_boris_n.interfaces;

import java.util.List;
import java.util.concurrent.Future;

public interface Repository<T> {
    void addListener(OnDataChangeListener<T> listener);
    void removeListener(OnDataChangeListener<T> listener);
    void fetchData(String name);
}
