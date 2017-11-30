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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TAD1Controller {
	@Autowired
	//ProductService productDAO;

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
	public String resultKurikulum() {
		return "kurikulum-result";
	}
	
	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view")
	public String viewKurikulum() {
		return "kurikulum-view";
	}
	
	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view/{id}")
	public String viewPathKurikulum() {
		return "kurikulum-view";
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
		return "redirect:/kurikulum/view/"; //+ kurikulum.getId();
	}
	
	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulum() {
		return "kurikulum-delete";
	}
}

//	// viewall
//	@RequestMapping("/product/viewall")
//	public String view(Model model) {
//		List<ProductModel> products = productDAO.selectAllProducts();
//		model.addAttribute("product", products);
//
//		return "viewall";
//	}
//
//	// view
//	@RequestMapping("/product/view")
//	public String view(Model model, @RequestParam(value = "id", required = false) int id) {
//		ProductModel product = productDAO.selectProduct(id);
//
//		if (product != null) {
//			model.addAttribute("product", product);
//			return "view";
//		} else {
//			model.addAttribute("id", id);
//			return "not-found";
//		}
//	}
//
//	// view
//	@RequestMapping("/product/view/{id}")
//	public String viewPath(Model model, @PathVariable(value = "id") int id) {
//		ProductModel product = productDAO.selectProduct(id);
//
//		if (product != null) {
//			model.addAttribute("product", product);
//			return "view";
//		} else {
//			model.addAttribute("id", id);
//			return "not-found";
//		}
//	}
//
//	// update product
//	@RequestMapping("/product/update/{id}")
//	public String update(Model model, @PathVariable(value = "id") int id) {
//		ProductModel product = productDAO.selectProduct(id);
//		if (product != null) {
//			model.addAttribute("product", product);
//			return "form-update";
//		} else {
//			model.addAttribute("id", id);
//			return "not-found";
//		}
//	}
//
//	// submit update product
//	@RequestMapping(value = "/product/update/submit", method = RequestMethod.POST)
//	public String updateForm(@ModelAttribute ProductModel product) {
//		productDAO.updateProduct(product);
//
//		return "redirect:/product/view/" + product.getId();
//	}
//
//	// add product
//	@RequestMapping("/product/add")
//	public String add() {
//		return "form-add";
//	}
//
//	// submit add product
//	@RequestMapping("/product/add/submit")
//	public String addSubmit(@RequestParam(value = "nama", required = false) String nama,
//			@RequestParam(value = "deskripsi", required = false) String deskripsi,
//			@RequestParam(value = "kategori", required = false) String kategori,
//			@RequestParam(value = "pabrikan", required = false) String pabrikan,
//			@RequestParam(value = "berat", required = false) double berat,
//			@RequestParam(value = "harga", required = false) int harga,
//			@RequestParam(value = "tahun_produksi", required = false) int tahun_produksi,
//			@RequestParam(value = "jumlah_stok", required = false) int jumlah_stok,
//			@RequestParam(value = "kondisi", required = false) String kondisi) {
//
//		ProductModel product = new ProductModel(0, nama, deskripsi, kategori, pabrikan, berat, harga, tahun_produksi,
//				jumlah_stok, kondisi);
//		productDAO.addProduct(product);
//
//		return "redirect:/product/viewall";
//	}
//
//	// submit add product
//	// @RequestMapping(value = "/product/add/submit", method = RequestMethod.POST)
//	// public String addSubmit(Model model, @ModelAttribute ProductModel product) {
//	//
//	// productDAO.addProduct(product);
//	// return "redirect:/product/viewall";
//	// }

//		@RequestMapping(value = { "/student/delete/{npm}", "/student/delete" })
//		public String deletePath(@PathVariable Optional<String> npm, Model model) {
//			if (npm.isPresent()) {
//				StudentModel student = studentService.deleteStudent(npm.get());
//				if (student == null) {
//					model.addAttribute("error", "Sorry, NPM not found!");
//					return "error";
//				} else {
//					model.addAttribute("student", student);
//					return "delete";
//				}
//			} else {
//				model.addAttribute("error", "Sorry, NPM is Empty!");
//				return "error";
//			}
//		}