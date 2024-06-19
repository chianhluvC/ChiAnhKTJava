package com.example.KT.controller;



import com.example.KT.model.NhanVien;
import com.example.KT.services.NhanVienService;
import com.example.KT.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanViens(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanviens", nhanViens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans", phongBanService.getAllPhongBans());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult result, Model model){
        if(result.hasErrors()){
            return "nhanvien/add";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id){
        if(nhanVienService.getNhanById(id)==null)
            return "not-found";
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable String id, Model model ){
        NhanVien editNhanVien = nhanVienService.getNhanById(id);
        if(editNhanVien!=null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("phongbans", phongBanService.getAllPhongBans());
            return "nhanvien/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editNhanVien(@PathVariable String id, @Valid NhanVien updateNhanVien, BindingResult result){
        if(nhanVienService.getNhanById(updateNhanVien.getMa_NV())==null)
            return "not-found";
        if(result.hasErrors()){
            updateNhanVien.setMa_NV(id);
            return "nhanvien/edit";
        }
        nhanVienService.updateNhanVien(updateNhanVien);
        return "redirect:/nhanviens";
    }

}
