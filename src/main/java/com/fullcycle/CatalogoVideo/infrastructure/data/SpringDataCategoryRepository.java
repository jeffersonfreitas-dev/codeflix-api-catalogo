package com.fullcycle.CatalogoVideo.infrastructure.data;

import com.fullcycle.CatalogoVideo.infrastructure.persistence.CategoryPersistence;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpringDataCategoryRepository extends CrudRepository<CategoryPersistence, UUID> {

}
