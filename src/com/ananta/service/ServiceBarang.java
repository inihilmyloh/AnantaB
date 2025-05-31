package com.ananta.service;

import com.ananta.model.ModelBarang;
import java.util.List;

public interface ServiceBarang {
    void tambahData     (ModelBarang model);
    void perbaruiData   (ModelBarang model);
    void hapusData      (ModelBarang model);
    
    List<ModelBarang> tampilData();
    List<ModelBarang> pencarianData(String id);
}
