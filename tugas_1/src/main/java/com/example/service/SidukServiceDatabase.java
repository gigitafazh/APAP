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

	// penduduk service database
	// method view penduduk
	@Override
	public PendudukModel selectPenduduk(String nik) {
		log.info("select penduduk with nik {}", nik);
		return sidukMapper.selectPenduduk(nik);
	}

	// method select view penduduk get data keluarga
	@Override
	public KeluargaModel selectKeluargaById(int id_keluarga) {
		log.info("select keluarga with id {}", id_keluarga);
		return sidukMapper.selectKeluargaById(id_keluarga);
	}

	// method select view penduduk get data keluarga, kelurahan
	@Override
	public KelurahanModel selectKelurahanById(int id_kelurahan) {
		log.info("select kelurahan with id {}", id_kelurahan);
		return sidukMapper.selectKelurahanById(id_kelurahan);
	}

	// method select view penduduk get data keluarga, kelurahan, kecamatan
	@Override
	public KecamatanModel selectKecamatanById(int id_kecamatan) {
		log.info("select kecamatan with id {}", id_kecamatan);
		return sidukMapper.selectKecamatanById(id_kecamatan);
	}

	// method select view penduduk get data keluarga, kelurahan, kecamatan, kota
	@Override
	public KotaModel selectKotaById(int id_kota) {
		log.info("select kota with id {}", id_kota);
		return sidukMapper.selectKotaById(id_kota);
	}
	
	// method add penduduk
	@Override
	public void addPenduduk(PendudukModel penduduk) {
		sidukMapper.addPenduduk(penduduk);
	}

	// method update penduduk
	// @Override
	// public void updatePenduduk(PendudukModel penduduk, int id) {
	// log.info("update penduduk with id {}", id);
	// sidukMapper.updatePenduduk(penduduk, id);
	// }
	public void updatePenduduk(PendudukModel penduduk) {
		sidukMapper.updatePenduduk(penduduk);
		System.out.println("sdafabdghmjhgbvcdfghgnb vcxdfg");
	}

	// keluarga service database
	// method view keluarga
	@Override
	public KeluargaModel selectKeluarga(String nomor_kk) {
		log.info("select keluarga with nomor_kk {}", nomor_kk);
		return sidukMapper.selectKeluarga(nomor_kk);
	}

	// method select view anggota keluarga penduduk di keluarga
	@Override
	public List<PendudukModel> selectPendudukById(int id_keluarga) {
		log.info("select penduduk with id_keluarga {}", id_keluarga);
		return sidukMapper.selectPendudukById(id_keluarga);
	}
	
	// method add keluarga
	@Override
	public void addKeluarga(KeluargaModel keluarga) {
		sidukMapper.addKeluarga(keluarga);
	}
}
