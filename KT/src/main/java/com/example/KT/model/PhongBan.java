package com.example.KT.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @NotNull
    @Size(max = 2, min = 1, message = "Ma Phong khong vuot qua 2 ky tu va toi thieu 1 ky tu")
    private String MaPhong;
    @Column(name = "TenPhong")
    @NotNull
    @Size(max = 30, min = 1, message = "Ten Phong khong vuot qua 30 ky tu va toi thieu 1 ky tu")
    private String TenPhong;
    @OneToMany(mappedBy = "PHONGBAN", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
