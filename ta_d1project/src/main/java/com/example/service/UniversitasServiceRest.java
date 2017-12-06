package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UniversitasDAO;
import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.ProdiModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UniversitasServiceRest implements UniversitasService {
	@Autowired
	private UniversitasDAO universitasDAO;

	@Override
	public FakultasModel selectFakultas(int id_univ, int id_fakultas) {
		FakultasModel fakultas = ((Map<String, FakultasModel>) universitasDAO.selectFakultas(id_univ, id_fakultas).getResult()).get("fakultas");
		return fakultas;
	}

	@Override
	public ProdiModel selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		ProdiModel prodi = ((Map<String, ProdiModel>) universitasDAO.selectProdi(id_univ, id_fakultas, id_prodi).getResult()).get("prodi");
		
		return prodi;
	}
	

}
