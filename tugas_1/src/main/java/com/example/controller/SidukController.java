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

	// akses halaman home
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// view penduduk
	@RequestMapping("/penduduk/view")
	public String viewPenduduk(Model model, @RequestParam(value = "nik") String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);

		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "view-penduduk";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// view keluarga
	@RequestMapping("/keluarga/view")
	public String viewKeluarga(Model model, @RequestParam(value = "nomor_kk") String nomor_kk) {
		KeluargaModel keluarga = sidukDAO.selectKeluarga(nomor_kk);

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "view-keluarga";
		} else {
			model.addAttribute("nomor_kk", nomor_kk);
			return "not-found";
		}
	}

	// add penduduk
	@RequestMapping("/penduduk/add")
	public String addPenduduk(Model model) {
		model.addAttribute("penduduk", new PendudukModel());
		return "form-penduduk";
	}

	// submit add penduduk
	@RequestMapping(value = "/penduduk/add", method = RequestMethod.POST)
	public String addPendudukSubmit(Model model, @ModelAttribute PendudukModel penduduk) {
		KeluargaModel keluarga = sidukDAO.selectKeluargaId(penduduk.getId_keluarga());
		
		return "success-add-penduduk";
	}
}
