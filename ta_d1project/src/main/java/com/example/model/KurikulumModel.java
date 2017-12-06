package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurikulumModel {
	private int id;
	private int id_univ;
	private int id_fakultas;
	private int id_prodi;
	private String kode_kurikulum;
	private String nama_kurikulum;
	private int jumlah_sks_wajib;
	private int jumlah_sks_pilihan;
	private List<MataKuliahModel> listMataKuliah;
	private List<MataKuliahKurikulumModel> listMataKuliahKurikulum;
}