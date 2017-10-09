package com.example.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KecamatanModel;
import com.example.model.KotaModel;
import com.example.service.SidukService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class SidukController {
	@Autowired
	SidukService sidukDAO;

	// halaman home
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// halaman view penduduk
	@RequestMapping("/penduduk/view")
	public String viewPenduduk(Model model, @RequestParam(value = "nik") String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);
		KeluargaModel keluarga = sidukDAO.selectKeluargaById(penduduk.getId_keluarga());
		KelurahanModel kelurahan = sidukDAO.selectKelurahanById(keluarga.getId_kelurahan());
		KecamatanModel kecamatan = sidukDAO.selectKecamatanById(kelurahan.getId_kecamatan());
		KotaModel kota = sidukDAO.selectKotaById(kecamatan.getId_kota());
		
		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			model.addAttribute("keluarga", keluarga);
			model.addAttribute("kelurahan", kelurahan);
			model.addAttribute("kecamatan", kecamatan);
			model.addAttribute("kota", kota);
			return "view-penduduk";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// halaman view keluarga
	@RequestMapping("/keluarga/view")
	public String viewKeluarga(Model model, @RequestParam(value = "nomor_kk") String nomor_kk) {
		KeluargaModel keluarga = sidukDAO.selectKeluarga(nomor_kk);
		List<PendudukModel> penduduk = sidukDAO.selectPendudukById(keluarga.getId_kelurahan());

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "view-keluarga";
		} else {
			model.addAttribute("nomor_kk", nomor_kk);
			return "not-found";
		}
	}

	// halaman add penduduk
	@RequestMapping("/penduduk/add")
	public String addPenduduk(Model model) {
		model.addAttribute("penduduk", new PendudukModel());
		return "form-penduduk";
	}

	// halaman success add penduduk
	// @RequestMapping(value = "/penduduk/add", method = RequestMethod.POST)
	// public String addPendudukSubmit(Model model, @ModelAttribute PendudukModel
	// penduduk) {
	// KeluargaModel keluarga =
	// sidukDAO.selectKeluargaId(penduduk.getId_keluarga());
	//
	// return "success-penduduk";
	// }

	// halaman add keluarga

	// halaman success add keluarga, generate nik

	// halaman update penduduk

	// halaman success update penduduk, generate nkk

	// halaman update status kematian

	// halaman success update status kematian

	// find penduduk by kota
}
