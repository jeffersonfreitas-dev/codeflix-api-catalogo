package com.fullcycle.CatalogoVideo.application.usercase.category.findById;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class FindByIdCategoryUseCase implements IFindByIdCategoryUseCase{

    private final ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(UUID uuid) {
        return repository.findById(uuid)
                .map(CategoryOutputData::fromDomain)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }
}
