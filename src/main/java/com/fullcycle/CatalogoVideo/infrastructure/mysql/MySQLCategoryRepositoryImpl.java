package com.fullcycle.CatalogoVideo.infrastructure.mysql;

import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import com.fullcycle.CatalogoVideo.infrastructure.data.SpringDataCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class MySQLCategoryRepositoryImpl implements ICategoryRepository {

    private SpringDataCategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public void update(Category category) {

    }
}
