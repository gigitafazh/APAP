package com.example.service;

import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.ProdiModel;;

public interface UniversitasService {
	FakultasModel selectFakultas(int id_univ, int id_fakultas);
	ProdiModel selectProdi (int id_univ, int id_fakultas, int id_prodi);
}
