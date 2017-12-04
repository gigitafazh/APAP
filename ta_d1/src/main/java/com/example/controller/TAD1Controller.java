package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.MataKuliahModel;
import com.example.service.KurikulumService;
import com.example.service.MataKuliahService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TAD1Controller {
	@Autowired
	KurikulumService kurikulumDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// akses halaman cari kurikulum
	@RequestMapping("/kurikulum")
	public String kurikulum() {
		return "kurikulum";
	}

	// akses halaman hasil cari kurikulum
	@RequestMapping("/kurikulum/result")
	public String resultKurikulum(Model model, @RequestParam(value = "id_fakultas") int id_fakultas,
			@RequestParam(value = "id_prodi") int id_prodi) {
		List<KurikulumModel> kurikulum = kurikulumDAO.selectKurikulumbyParam(id_fakultas, id_prodi);

		if (kurikulum != null) {
			model.addAttribute("kurkulum", kurikulum);
			return "kurikulum-result";
		} else {
			model.addAttribute("id_fakultas", id_fakultas);
			model.addAttribute("id_prodi", id_prodi);
			return "not-found";
		}

	}

	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view")
	public String viewKurikulum(Model model, @RequestParam(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);
		MataKuliahKurikulumModel matkulKurikulum = kurikulumDAO.selectMatkulbyId(kurikulum.getId_kurikulum());
		List<MataKuliahKurikulumModel> listMatkul = kurikulumDAO.selectListMatkul(matkul.getId_kurikulum());
		
		if (kurikulum != null) {
			model.addAttribute("kurikulum", kurikulum);
			model.addAttribute("matkulKurikulum", matkulKurikulum);
			model.addAttribute("matkul", matkul);
			return "kurikulum-view";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	// halaman tambah kurikulum
	@RequestMapping("/kurikulum/add")
	public String addKurikulum() {
		return "kurikulum-add";
	}

	// halaman ubah kurikulum
	@RequestMapping("/kurikulum/update/{id}")
	public String updateKurikulum() {
		return "kurikulum-update";
	}

	// akses halaman submit ubah kurikulum
	@RequestMapping("/kurikulum/update/submit")
	public String updateSubmitKurikulum() {
		return "redirect:/kurikulum/view/"; // + kurikulum.getId();
	}

	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulum() {
		return "kurikulum-delete";
	}
}