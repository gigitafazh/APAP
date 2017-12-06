package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.MataKuliahModel;

@Mapper
public interface KurikulumMapper {
	@Select("select id, id_univ, id_fakultas, id_prodi, kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan "
			+ "from kurikulum where id = #{id}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "kode_kurikulum", column = "kode_kurikulum"),
			@Result(property = "nama_kurikulum", column = "nama_kurikulum"),
			@Result(property = "jumlah_sks_wajib", column = "jumlah_sks_wajib"),
			@Result(property = "jumlah_sks_pilihan", column = "jumlah_sks_pilihan"),
			@Result(property = "id_univ", column = "id_univ"), @Result(property = "id_prodi", column = "id_prodi"),
			@Result(property = "id_fakultas", column = "id_fakultas"),
			@Result(property = "listMataKuliah", column = "id", javaType = List.class, many = @Many(select = "selectMataKuliah")),
			@Result(property = "listMataKuliahKurikulum", column = "id", javaType = List.class, many = @Many(select = "selectMataKuliahKurikulumR")) })
	KurikulumModel selectKurikulumR(@Param(value = "id") int id);
	
	@Select("select id, id_univ, id_fakultas, id_prodi, kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan "
			+ "from kurikulum where id = #{id}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "kode_kurikulum", column = "kode_kurikulum"),
			@Result(property = "nama_kurikulum", column = "nama_kurikulum"),
			@Result(property = "jumlah_sks_wajib", column = "jumlah_sks_wajib"),
			@Result(property = "jumlah_sks_pilihan", column = "jumlah_sks_pilihan"),
			@Result(property = "id_univ", column = "id_univ"), @Result(property = "id_prodi", column = "id_prodi"),
			@Result(property = "id_fakultas", column = "id_fakultas"),
			@Result(property = "listMataKuliah", column = "id", javaType = List.class, many = @Many(select = "selectMataKuliah")) })
	KurikulumModel selectKurikulumAPI(@Param(value = "id") int id);
	
	// ubah kurikulum
	@Update("UPDATE kurikulum SET id_fakultas = #{kurikulum.id_fakultas}, id_prodi = #{kurikulum.id_prodi},"
			+ " kode_kurikulum = #{kurikulum.kode_kurikulum}, nama_kurikulum = #{kurikulum.nama_kurikulum}, "
			+ "jumlah_sks_wajib = #{kurikulum.jumlah_sks_wajib}, jumlah_sks_pilihan = #{kurikulum.jumlah_sks_pilihan} "
			+ "where id = #{id_kurikulum}")
	void updateKurikulum(@Param("kurikulum") KurikulumModel kurikulum, @Param(value = "id_kurikulum") int id_kurikulum);

	// hapus kurikulum
	@Delete("DELETE FROM kurikulum where id = #{id}")
	void deleteKurikulum(@Param("id") int id);

	//
	@Select("select mata_kuliah_kurikulum.id, mata_kuliah_kurikulum.id_kurikulum, mata_kuliah_kurikulum.id_matkul, "
			+ "mata_kuliah_kurikulum.status_matkul, mata_kuliah_kurikulum.term from mata_kuliah_kurikulum join kurikulum"
			+ " on mata_kuliah_kurikulum.id_kurikulum = kurikulum.id where kurikulum.id = #{id}")
	List<MataKuliahKurikulumModel> selectMataKuliahKurikulumR(@Param(value = "id") int id);

	//
	@Select("SELECT mata_kuliah.id, mata_kuliah.id_univ, mata_kuliah.id_fakultas, mata_kuliah.id_prodi,"
			+ "mata_kuliah.kode_matkul, mata_kuliah.nama_matkul, mata_kuliah.jumlah_sks, "
			+ "mata_kuliah.prasyarat_sks from mata_kuliah join mata_kuliah_kurikulum on "
			+ "mata_kuliah.id = mata_kuliah_kurikulum.id_matkul JOIN kurikulum on kurikulum.id = "
			+ "mata_kuliah_kurikulum.id_kurikulum WHERE kurikulum.id = #{id}")
	List<MataKuliahModel> selectMataKuliah(@Param(value = "id") int id);

	// lihat hasil cari kurikulum milih prodi tertentu dengan fakultas tertentu di
	// universitas tertentu
	@Select("select id, kode_kurikulum, nama_kurikulum from kurikulum "
			+ "where id_prodi = #{id_prodi} and id_fakultas = #{id_fakultas} and id_univ = #{id_univ}")
	List<KurikulumModel> selectKurikulumbyParam(@Param(value = "id_univ") int id_univ,
			@Param(value = "id_fakultas") int id_fakultas, @Param(value = "id_prodi") int id_prodi);

	// lihat detail kurikulum
	@Select("select distinct k.kode_kurikulum, k.nama_kurikulum, k.jumlah_sks_wajib, k.jumlah_sks_pilihan"
			+ "from kurikulum k, mata_kuliah_kurikulum mk where k.id=mk.id_kurikulum" + "and mk.id_kurikulum=#{id}")
	KurikulumModel selectKurikulum(@Param(value = "id") int id);

	// lihat list mata kuliah dalam kurikulum tertentu
	@Select("select m.kode_matkul, m.nama_matkul, m.jumlah_sks, mk.status_matkul, mk.term from mata_kuliah m,"
			+ "mata_kuliah_kurikulum mk, kurikulum k where mk.id_matkul=m.id and mk.id_kurikulum=k.id"
			+ "and mk.id_kurikulum=#{id}")
	List<MataKuliahKurikulumModel> selectMataKuliahKurikulum(@Param(value = "id") int id);

	// tambah kurikulum
	@Insert("insert into kurikulum (id_univ, id_fakultas, id_prodi, kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan)"
			+ "values (#{kurikulum.id_univ}, #{kurikulum.id_fakultas}, #{kurikulum.id_prodi}, #{kurikulum.kode_kurikulum}, #{kurikulum.nama_kurikulum}, #{kurikulum.jumlah_sks_wajib}, #{kurikulum.jumlah_sks_pilihan})")
	void addKurikulum(@Param(value = "kurikulum") KurikulumModel kurikulum);

	// select fakultas
	@Select("select f.nama_fakultas from fakultas f, kurikulum k where f.id_fakultas=k.id_fakultas "
			+ "and f.id_fakultas=#{id_fakultas}")
	FakultasModel selectFakultasbyId(@Param(value = "id_fakultas") int id_fakultas,
			@Param(value = "id_univ") int id_univ);
}
