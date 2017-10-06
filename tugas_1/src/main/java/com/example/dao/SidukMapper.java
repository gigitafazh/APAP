package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;

@Mapper
public interface SidukMapper {
	// select view penduduk
	@Select("select * from penduduk where nik = #{nik}")
	PendudukModel selectPenduduk(String nik);

	// insert add penduduk
	@Insert("INSERT INTO penduduk (nik, nama, tanggal_lahir) VALUES (#{nik}, #{nama}, #{tanggal_lahir})")
	void addPenduduk(PendudukModel penduduk);

	// insert update penduduk
	@Select("update penduduk set nama = #{nama}, tanggal_lahir = #{tanggal_lahir} where nik = #{nik}")
	void updatePenduduk(PendudukModel penduduk);

	// select view keluarga
	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	KeluargaModel selectKeluarga(String nomor_kk);
}