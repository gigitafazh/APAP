package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.KurikulumModel;

@Service
public interface KurikulumService {
	
	KurikulumModel selectKurikulum(int id);
	
	List<KurikulumModel> selectKurikulumProdi(int id_prodi);

	String addKurikulum(KurikulumModel kurikulum);

	String updateKurikulum(KurikulumModel kurikulum, int id);

	void deleteKurikulum(int id);
}
