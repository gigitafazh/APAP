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
		KelurahanModel kelurahan = sidukDAO.selectKelurahanById(keluarga.getId_kelurahan());
		KecamatanModel kecamatan = sidukDAO.selectKecamatanById(kelurahan.getId_kecamatan());
		KotaModel kota = sidukDAO.selectKotaById(kecamatan.getId_kota());
		List<PendudukModel> penduduk = sidukDAO.selectPendudukById(keluarga.getId());

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			model.addAttribute("kelurahan", kelurahan);
			model.addAttribute("kecamatan", kecamatan);
			model.addAttribute("kota", kota);
			model.addAttribute("penduduk", penduduk);
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

	// halaman success add penduduk tanpa generate nik
	@RequestMapping(value = "/penduduk/add/submit", method = RequestMethod.GET)
	public String addPendudukSubmit(Model model, @ModelAttribute PendudukModel penduduk) {
		sidukDAO.addPenduduk(penduduk);
		return "success-penduduk";
	}

	// halaman add keluarga
	@RequestMapping("/keluarga/add")
	public String add() {
		return "form-keluarga";
	}

	// halaman success add keluarga tanpa generate nkk dan nambah data kelurahan
	@RequestMapping(value = "/keluarga/add/submit", method = RequestMethod.GET)
	public String addKeluargaSubmit(Model model, @ModelAttribute KeluargaModel keluarga) {
		// KeluargaModel keluarga =
		// sidukDAO.selectKeluargaId(penduduk.getId_keluarga());
		sidukDAO.addKeluarga(keluarga);
		return "success-keluarga";
	}

	// halaman update penduduk
	@RequestMapping("/penduduk/update/{nik}")
	public String updatePendudukSubmit(Model model, @PathVariable(value = "nik") String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);
		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "form-update-penduduk";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// halaman success update penduduk, tanpa generate nik
	@RequestMapping(value = "/penduduk/update/submit", method = RequestMethod.POST)
	public String updateForm(Model model, @ModelAttribute PendudukModel penduduk) {
		String nik = penduduk.getNik();
		PendudukModel pendudukUpdate = sidukDAO.selectPenduduk(nik);

		if (penduduk.getJenis_kelamin() == null) {
			penduduk.setJenis_kelamin(pendudukUpdate.getJenis_kelamin());
		}
		if (penduduk.getGolongan_darah() == null) {
			penduduk.setGolongan_darah(pendudukUpdate.getGolongan_darah());
		}
		if (penduduk.getStatus_perkawinan() == null) {
			penduduk.setStatus_perkawinan(pendudukUpdate.getStatus_perkawinan());
		}
		if (penduduk.getStatus_dalam_keluarga() == null) {
			penduduk.setStatus_dalam_keluarga(pendudukUpdate.getStatus_dalam_keluarga());
		}
		sidukDAO.updatePenduduk(penduduk);
		model.addAttribute("nik", pendudukUpdate.getNik());

		return "success-update-penduduk";
	}

	// halaman update status kematian

	// halaman success update status kematian

	// find penduduk by kota
}
