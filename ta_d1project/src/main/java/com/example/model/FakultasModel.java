package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakultasModel
{
    private int id_fakultas;
    private int id_univ;
    private String nama_fakultas;
    private List<ProdiModel> listProdi;
}
