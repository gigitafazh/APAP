package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.MataKuliahModel;

@Service
public interface KurikulumService {
	List<KurikulumModel> selectKurikulumProdi(int id_prodi);

	KurikulumModel selectKurikulumR(int id);

	List<MataKuliahModel> selectMataKuliah(int id_kurikulum);

	String updateKurikulum(KurikulumModel kurikulum, int id);

	void deleteKurikulum(int id);

	// lihat hasil cari kurikulum
	List<KurikulumModel> selectKurikulumbyParam(int id_univ, int id_fakultas, int id_prodi);

	// lihat detail kurikulum
	KurikulumModel selectKurikulum(int id);


	// tambah kurikulum
	void addKurikulum(KurikulumModel kurikulum, int id_univ, int id_fakultas, int id_prodi);

	// select fakultas
	FakultasModel selectFakultasbyId(int id_fakultas, int id_univ);
	
	List<MataKuliahModel> getMataKuliahByTerm(KurikulumModel kurikulum, int term);
	
	List<MataKuliahKurikulumModel> getMatkulKurikulumByTerm(KurikulumModel kurikulum, int term);

	
	
	KurikulumModel selectKurikulumAPI(int id);
}
