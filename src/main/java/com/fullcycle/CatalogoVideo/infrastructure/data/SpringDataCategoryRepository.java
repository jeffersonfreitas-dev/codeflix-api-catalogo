package com.fullcycle.CatalogoVideo.infrastructure.data;

import com.fullcycle.CatalogoVideo.infrastructure.persistence.CategoryPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryPersistence, UUID> {

}
