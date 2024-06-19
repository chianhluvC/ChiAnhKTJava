package com.example.KT.model;

import com.example.KT.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Size(max = 3, min = 1, message = "Ma Nhan Vien khong vuot qua 3 ky tu va toi thieu 1 ky tu")
    private String Ma_NV;
    @Column(name = "Ten_NV")
    @NotEmpty(message = "Ten nhan vien khong duoc de trong")
    @Size(max = 100, min = 1, message = "Title khong vuot qua 100 ky tu va toi thieu 1 ky tu")
    private String Ten_NV;
    @Column(name = "Phai")
    @Size(max = 3, min = 1, message = "Phai khong vuot qua 3 ky tu va toi thieu 1 ky tu")
    private String Phai;
    @Column(name = "NoiSinh")
    @Size(max = 200, min = 1, message = "Noi sinh khong vuot qua 200 ky tu va toi thieu 1 ky tu")
    private String NoiSinh;
    @Column(name = "Luong")
    private int Luong;
    @ManyToOne
    @JoinColumn(name = "PHONGBAN_MaPhong")
    private PhongBan PHONGBAN;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
