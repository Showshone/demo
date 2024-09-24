package com.nermali.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nermali.demo.model.ProductionInstallation;

@Repository
public interface ProductionInstallationRepositoryImpl extends JpaRepository<ProductionInstallation, Long>, ProductionInstallationRepositoryCustom {

}
