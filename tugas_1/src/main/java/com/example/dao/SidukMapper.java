package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KecamatanModel;
import com.example.model.KotaModel;

@Mapper
public interface SidukMapper {
	// Mapper Penduduk
	// select view penduduk
	@Select("select * from penduduk where nik = #{nik}")
	PendudukModel selectPenduduk(String nik);

	// select view penduduk get data di keluarga
	@Select("select * from keluarga where id = #{id_keluarga}")
	KeluargaModel selectKeluargaById(int id_keluarga);

	// select view penduduk get data di keluarga, kelurahan
	@Select("select * from kelurahan where id = #{id_kelurahan}")
	KelurahanModel selectKelurahanById(int id_kelurahan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan
	@Select("select * from kecamatan where id = #{id_kecamatan}")
	KecamatanModel selectKecamatanById(int id_kecamatan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan, kota
	@Select("select * from kota where id = #{id_kota}")
	KotaModel selectKotaById(int id_kota);

	// Mapper Keluarga
	// select view keluarga
	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	KeluargaModel selectKeluarga(String nomor_kk);

	// select view anggota keluarga penduduk di keluarga
	@Select("select * from penduduk where id_keluarga = #{id}")
	List<PendudukModel> selectPendudukById(int id_keluarga);
}
