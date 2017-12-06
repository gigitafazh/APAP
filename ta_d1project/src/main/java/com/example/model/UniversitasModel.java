package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversitasModel
{
    private int id_univ;
    private String nama_univ;
    private List<FakultasModel> listFakultas;
}