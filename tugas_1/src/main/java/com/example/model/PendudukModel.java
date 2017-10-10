package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendudukModel {
	private String nik;
	private String nama;
	private String tempat_lahir;
	private String tanggal_lahir;
	private String jenis_kelamin;
	private int is_wni;
	private int id_keluarga;
	private String agama;
	private String pekerjaan;
	private String status_perkawinan;
	private String status_dalam_keluarga;
	private String golongan_darah;
	private int is_wafat;

	public PendudukModel(String nama, String tempat_lahir, String tanggal_lahir, String jenis_kelamin, int is_wni,
			int id_keluarga, String agama, String pekerjaan, String status_perkawinan, String status_dalam_keluarga,
			String golongan_darah, int is_wafat) {
		this.nama = nama;
		this.tempat_lahir = tempat_lahir;
		this.tanggal_lahir = tanggal_lahir;
		this.jenis_kelamin = jenis_kelamin;
		this.is_wni = is_wni;
		this.id_keluarga = id_keluarga;
		this.agama = agama;
		this.pekerjaan = pekerjaan;
		this.status_perkawinan = status_perkawinan;
		this.status_dalam_keluarga = status_dalam_keluarga;
		this.golongan_darah = golongan_darah;
		this.is_wafat = is_wafat;
	}
	
	PendudukModel penduduk;
}
