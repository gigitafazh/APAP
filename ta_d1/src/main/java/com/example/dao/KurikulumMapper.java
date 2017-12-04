package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KurikulumModel;

@Mapper
public interface KurikulumMapper {
	// lihat hasil cari kurikulum
	@Select("select * from kurikulum where id_fakultas = #{id_prodi}, id_prodi = #{id_prodi}")
	List<KurikulumModel> selectKurikulumbyParam(int id_fakultas, int id_prodi);

	// lihat detail kurikulum
	@Select("select * from kurikulum where id = #{id}")
	KurikulumModel selectKurikulum(@Param("id") int id);

	// tambah kurikulum
	@Insert("insert into kurikulum (kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan, id_prodi, id_fakultas)"
			+ "values (#{kode_kurikulum}, #{nama_kurikulum}, #{jumlah_sks_wajib}, #{jumlah_sks_pilihan}, #{id_prodi}, #{id_fakultas}")
	void addKurikulum(KurikulumModel kurikulum);
}