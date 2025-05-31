package com.ananta.service;

import com.ananta.model.ModelKaryawan;
import java.util.List;

public interface ServiceKaryawan {
    void tambahData     (ModelKaryawan model);
    void perbaruiData   (ModelKaryawan model);
    void hapusData      (ModelKaryawan model);
    
    List<ModelKaryawan> tampilData();
    List<ModelKaryawan> pencarianData(String id);
}
