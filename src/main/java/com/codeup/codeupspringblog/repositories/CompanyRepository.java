package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Long> {



}
