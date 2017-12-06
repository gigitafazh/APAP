package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	
	private int id;
	private String npm;
	private String nama;
	private int id_prodi;
	private int sks_wajib;
	private int sks_pilihan;
	private int status_lulus;
	private int id_angkatan;
}
