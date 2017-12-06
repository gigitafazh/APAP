package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.ProdiModel;

@Service
public class UnivesitasDAOImpl implements UniversitasDAO {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ApiModel<Map <String, FakultasModel>> selectFakultas(int id_univ, int id_fakultas) {
		ApiModel<Map <String, FakultasModel>> fakultas = restTemplate.exchange("https://apap2017-univ-apps.herokuapp.com/getFakultas/1/" + id_fakultas, HttpMethod.GET, null,
						new ParameterizedTypeReference<ApiModel<Map<String, FakultasModel>>>() {}).getBody();
		
		return fakultas;
	}

	@Override
	public ApiModel<Map <String, ProdiModel>> selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		ApiModel<Map <String, ProdiModel>> prodi = restTemplate.exchange("https://apap2017-univ-apps.herokuapp.com/getProdi/1/" + id_fakultas + "/" + id_prodi, HttpMethod.GET, null,
				new ParameterizedTypeReference<ApiModel<Map<String, ProdiModel>>>() {}).getBody();
		return prodi;
	}

}
