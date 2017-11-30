package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AngkatanModel
{
    private int id;
    private String nama;
    private int id_prodi;
    private int id_kurikulum;
}
