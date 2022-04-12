package com.fullcycle.CatalogoVideo.application.usercase.category.update;

import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase{

    private final ICategoryRepository repository;

    @Override
    public void execute(UUID uuid, UpdateCateogoryInputData input) {
        Category category = repository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
        category.update(input.getName(), input.getDescription(), input.getIsActive());
        repository.update(category);
    }
}
