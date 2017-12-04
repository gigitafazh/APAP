package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.KurikulumModel;

@Service
public interface KurikulumService {
	// lihat hasil cari kurikulum
	List<KurikulumModel> selectKurikulumbyParam(int id_fakultas, int id_prodi);
	
	// lihat detail kurikulum
	KurikulumModel selectKurikulum(int id);
	
	// tambah kurikulum
	String addKurikulum(KurikulumModel kurikulum);

	// ubah kurikulum
	String updateKurikulum(KurikulumModel kurikulum, int id);

	// hapus kurikulum
	void deleteKurikulum(int id);
}
