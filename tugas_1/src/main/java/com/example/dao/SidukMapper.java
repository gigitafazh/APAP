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

	// add penduduk
	@Insert("insert into penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga,"
			+ "agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat)"
			+ "values ('${nik}', '${nama}', '${tempat_lahir}', '${tanggal_lahir}', ${jenis_kelamin},"
			+ "${is_wni}, ${id_keluarga}, '${agama}', '${pekerjaan}', '${status_perkawinan}',"
			+ "'${status_dalam_keluarga}', '${golongan_darah}', ${is_wafat})")
	void addPenduduk(PendudukModel penduduk);

	// update penduduk
	// @Select("update penduduk set nik = #{nik}, nama = #{nama},"
	// + "tempat_lahir = #{tempat_lahir},tanggal_lahir = #{tanggal_lahir},"
	// + "jenis_kelamin = #{jenis_kelamin}, is_wni = #{is_wni},"
	// + "id_keluarga = #{id_keluarga}, agama = #{agama}, pekerjaan = #{pekerjaan},"
	// + "status_perkawinan = #{status_perkawinan}, status_dalam_keluarga =
	// #{status_dalam_keluarga},"
	// + "golongan_darah = #{golongan_darah} where nik = #{nik}")
	// void updatePenduduk(@Param("penduduk") PendudukModel penduduk, @Param("id")
	// int id);
	@Update("update penduduk set nik = '${penduduk.nik}', nama = '${penduduk.nama}',"
			+ "tempat_lahir = '${penduduk.tempat_lahir}', tanggal_lahir = '${penduduk.tanggal_lahir}',"
			+ "jenis_kelamin = '${penduduk.jenis_kelamin}', is_wni = ${penduduk.is_wni},"
			+ "id_keluarga = ${penduduk.id_keluarga}, agama = '${penduduk.agama}',"
			+ "pekerjaan = '${penduduk.pekerjaan}', status_perkawinan = '${penduduk.status_perkawinan}',"
			+ "status_dalam_keluarga = '${penduduk.status_dalam_keluarga}', golongan_darah = '${penduduk.golongan_darah}',"
			+ "is_wafat = ${is_wafat}  where nik = #{nik}")
	void updatePenduduk(PendudukModel penduduk);

	// Mapper Keluarga
	// select view keluarga
	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	KeluargaModel selectKeluarga(String nomor_kk);

	// select view anggota keluarga penduduk di keluarga
	@Select("select * from penduduk where id_keluarga = #{id}")
	List<PendudukModel> selectPendudukById(int id_keluarga);

	// add keluarga
	@Insert("insert into keluarga (nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku) values"
			+ "('${nomor_kk}', '${alamat}', '${RT}', '${RW}', ${id_kelurahan}, ${is_tidak_berlaku})")
	void addKeluarga(KeluargaModel keluarga);
}
