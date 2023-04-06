package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Company;
import com.codeup.codeupspringblog.repositories.CompanyRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {


    private final CompanyRepository companyDao;

    private final PasswordEncoder passwordEncoder;

    public CompanyController(CompanyRepository companyDao, PasswordEncoder passwordEncoder ){
        this.companyDao = companyDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/company/sign-up")
    public String showCompanySignUp(Model model){
        model.addAttribute("company", new Company());
        return "/companies/companySignUp";
    }


    @PostMapping("/company/sign-up")
    public String saveCompany(@ModelAttribute Company company){
        String hash = passwordEncoder.encode(company.getCompanyPassword());
        company.setCompanyPassword(hash);
        companyDao.save(company);
        return "redirect:/login";
    }

    @GetMapping("/company/companyOrUser")
    public String companyOrUser(){
        return "/companyOrUser";
    }


    @GetMapping("/company/companySignUp")
    public String pickCompanySignUp(Model model){
        model.addAttribute("company", new Company());
        return "/companies/companyLogin";
    }
}
