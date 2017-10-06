package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KeluargaModel {
	private String nomor_kk;
	private String alamat;
	private String RT;
	private String RW;
	private Boolean id_kelurahan;
	private Boolean is_tidak_berlaku;
}
