package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultModel {
	private int id_univ;
	private List<FakultasModel> fakultasList;
	private FakultasModel fakultas;
	private List<ProdiModel> prodiList;
	private ProdiModel prodi;
	private MataKuliahModel matkul;	
}
