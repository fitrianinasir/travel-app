package com.travel.payment.db.catalogdb.repository;

import com.travel.payment.db.catalogdb.model.CatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CatalogRepository extends JpaRepository<CatalogModel, Integer> {
    CatalogModel findByNameAndDate(String name, Date date);
}
