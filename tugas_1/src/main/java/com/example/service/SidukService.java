package com.example.service;

import java.util.List;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

public interface SidukService {
	// view penduduk
	PendudukModel selectPenduduk(String nik);
	
	// view keluarga
	KeluargaModel selectKeluarga(String nomor_kk);

}
