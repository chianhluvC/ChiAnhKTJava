package com.example.KT.services;


import com.example.KT.model.NhanVien;
import com.example.KT.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired

    private INhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanViens(){
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanById(String id){
        return nhanVienRepository.findById(id).orElse(null);
    }

    public void addNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String id){
        nhanVienRepository.deleteById(id);
    }

    public void updateNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

}
