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
	// select view penduduk
	@Select("select * from penduduk where nik = #{nik}")
	PendudukModel selectPenduduk(String nik);
	
	// select view keluarga
	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	KeluargaModel selectKeluarga(String nomor_kk);

}
