package com.example.service;

import java.util.List;

import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;

public interface SidukService {
	// view penduduk
	PendudukModel selectPenduduk(String nik);
	
	// add penduduk
	void addPenduduk(PendudukModel penduduk);

	// update penduduk
	void updatePenduduk(PendudukModel penduduk);
	
	// view keluarga
	KeluargaModel selectKeluarga(String nomor_kk);
}
