package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahKurikulumModel {
	private int id;
	private int id_kurikulum;
	private int id_matkul;
	private String status_matkul;
	private int term;
}
