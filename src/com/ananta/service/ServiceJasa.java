package com.ananta.service;

import com.ananta.model.ModelJasa;
import java.util.List;

public interface ServiceJasa {
    void tambahData     (ModelJasa model);
    void perbaruiData   (ModelJasa model);
    void hapusData      (ModelJasa model);
    
    List<ModelJasa> tampilData();
    List<ModelJasa> pencarianData(String id);
}
