package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.MataKuliahKurikulumModel;

@Service
public interface MataKuliahKurikulumService {
	
	MataKuliahKurikulumModel selectMataKuliahKurikulum(int id);
	
	void updateMataKuliahKurikulum (MataKuliahKurikulumModel mataKuliahKurikulum, int id);
	
	void deleteMataKuliahKurikulum (int id);


	void addMataKuliahKurikulum(MataKuliahKurikulumModel matkul_kurikulum);

	
	List<MataKuliahKurikulumModel> selectMatkulTerm(int term);

}
