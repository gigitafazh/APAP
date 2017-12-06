package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrasyaratMataKuliahModel {
	private int id;
	private String kode_matkul;
	private String kode_prasyarat_matkul;
}
