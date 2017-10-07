package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SidukMapper;
import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KecamatanModel;
import com.example.model.KotaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SidukServiceDatabase implements SidukService {
	@Autowired
	private SidukMapper sidukMapper;
	
	// method view penduduk
	@Override
	public PendudukModel selectPenduduk(String nik) {
		log.info("select penduduk with nik {}", nik);
		return sidukMapper.selectPenduduk(nik);
	}
	
	// method view keluarga
	@Override
	public KeluargaModel selectKeluarga(String nomor_kk) {
		log.info("select keluarga with nomor_kk {}", nomor_kk);
		return sidukMapper.selectKeluarga(nomor_kk);
	}

}
