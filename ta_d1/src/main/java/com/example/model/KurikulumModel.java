package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class KurikulumModel {
	private int id;
	private String kode_kurikulum;
	private String nama_kurikulum;
	private int jumlah_sks_wajib;
	private int jumlah_sks_pilihan;
	private int id_prodi;
	private int id_fakultas;
}
