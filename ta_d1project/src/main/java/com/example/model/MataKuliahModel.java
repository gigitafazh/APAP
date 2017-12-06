package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private int id;
	private int id_univ;
	private int id_fakultas;
	private int id_prodi;
	private String kode_matkul;
	private String nama_matkul;
	private Integer jumlah_sks;
	private Integer prasyarat_sks;
	private List<MataKuliahModel> listPrasyarat;
}
