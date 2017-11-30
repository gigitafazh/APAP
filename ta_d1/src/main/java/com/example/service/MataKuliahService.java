package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;

public interface MataKuliahService
{
    MataKuliahModel selectMataKuliah (int id);
    
    List<MataKuliahModel> selectMataKuliahProdi (int id_prodi);

    String addMataKuliah (MataKuliahModel mata_kuliah);

    String updateMataKuliah (MataKuliahModel mata_kuliah, int id);

    void deleteMataKuliah (int id);
}
