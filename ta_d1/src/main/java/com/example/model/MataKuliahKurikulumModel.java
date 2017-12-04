package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MataKuliahKurikulumModel {
	private int id;
	private int id_kurikulum;
	private int id_matkul;
	private String status_matkul;
	private int term;
	private List<MataKuliahKurikulumModel> listMatkul;
}
