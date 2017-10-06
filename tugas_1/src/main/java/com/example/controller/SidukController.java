package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.service.SidukService;

@Controller
public class SidukController {
	@Autowired
	SidukService sidukDAO;

	// menampilkan halaman index
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// view data penduduk
	@RequestMapping("/penduduk/view")
	public String viewPenduduk(Model model, @RequestParam(value = "nik", required = false) String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);

		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "view";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// view data penduduk
	@RequestMapping("/penduduk/view/{nik}")
	public String viewPendudukPath(Model model, @PathVariable(value = "nik") String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);

		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "view";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// view data keluarga
	@RequestMapping("/keluarga/view")
	public String viewKeluarga(Model model, @RequestParam(value = "nkk", required = false) String nkk) {
		KeluargaModel keluarga = sidukDAO.selectKeluarga(nkk);

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "view2";
		} else {
			model.addAttribute("nkk", nkk);
			return "not-found";
		}
	}

	// view data keluarga
	@RequestMapping("/keluarga/view/{nomor_kk}")
	public String viewKeluargaPath(Model model, @PathVariable(value = "nomor_kk") String nomor_kk) {
		KeluargaModel keluarga = sidukDAO.selectKeluarga(nomor_kk);

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "view2";
		} else {
			model.addAttribute("nomor_kk", nomor_kk);
			return "not-found";
		}
	}

	// add data penduduk
	@RequestMapping("/penduduk/add")
	public String add() {
		return "form-add";
	}

	// submit add data penduduk
	@RequestMapping("/penduduk/add/submit")
	public String addSubmit(@RequestParam(value = "nik", required = false) String nik,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "jenis_kelamin", required = false) String jenis_kelamin,
			@RequestParam(value = "agama", required = false) String agama,
			@RequestParam(value = "agama", required = false) String pekerjaan,
			@RequestParam(value = "status_perkawinan", required = false) String status_perkawinan,
			@RequestParam(value = "status_dalam_keluarga", required = false) String status_dalam_keluarga,
			@RequestParam(value = "golongan_darah", required = false) String golongan_darah,
			@RequestParam(value = "is_wni", required = false) Boolean is_wni,
			@RequestParam(value = "is_wafat", required = false) Boolean is_wafat,
			@RequestParam(value = "id_keluarga", required = false) Integer id_keluarga) {
		PendudukModel penduduk = new PendudukModel(nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin,
				golongan_darah, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, is_wni, is_wafat,
				id_keluarga);
		sidukDAO.addPenduduk(penduduk);

		return "success-add";
	}

	// update data penduduk
	@RequestMapping("/penduduk/update/{npm}")
	public String updatePenduduk(Model model, @PathVariable(value = "nik") String nik) {
		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);
		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "form-update";
		} else {
			model.addAttribute("nik", nik);
			return "not-found";
		}
	}

	// submit update data penduduk
	@RequestMapping(value = "/penduduk/update/submit", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute PendudukModel penduduk) {
		sidukDAO.updatePenduduk(penduduk);

		return "success-update";
	}
}
