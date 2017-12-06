package com.example.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiModel;
import com.example.model.KurikulumModel;
import com.example.service.KurikulumService;

@RestController
@RequestMapping("/api")
public class KurikulumRestController {
	@Autowired
	KurikulumService kurikulumService;
	
	@RequestMapping("/getKurikulum/{id}")
	public ApiModel<Map <String, KurikulumModel>> getKurikulum (@PathVariable (value= "id") String id) {
		int id_kurikulum = 0;
		boolean tes = true;
		ApiModel<Map <String, KurikulumModel>> api = new ApiModel<Map <String, KurikulumModel>>();
		
		try {
			id_kurikulum = Integer.parseInt(id);
		} 
		catch(NumberFormatException e){
	        tes = false;
	    }
		if (tes) {
			KurikulumModel kurikulum = kurikulumService.selectKurikulumAPI(id_kurikulum);
			Map <String, KurikulumModel> map = new HashMap<>();
			map.put("kurikulum", kurikulum);
			
			if(kurikulum != null) {
				api.setResult(map);
				api.setMsg("success");
				api.setStatus(200);
			} else {
				tes = false;
			}
		}
		 if (!tes) {
				api.setMsg("Kurikulum tidak ditemukan");
				api.setStatus(404);
			}
		return api;
	}
}
