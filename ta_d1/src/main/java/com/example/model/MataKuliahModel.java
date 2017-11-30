package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private Integer id;
	private String kode_matkul;
	private String nama_matkul;
	private Integer jumlah_sks;
	private Integer prasyarat_sks;
	private Integer id_prodi;
	private Integer id_kurikulum;
	private List<MataKuliahModel> listPrasyarat;
}
