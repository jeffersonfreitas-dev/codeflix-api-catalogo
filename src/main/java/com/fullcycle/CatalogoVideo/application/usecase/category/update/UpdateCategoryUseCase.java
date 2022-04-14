package com.fullcycle.CatalogoVideo.application.usecase.category.update;

import com.fullcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UpdateCategoryUseCase implements IUpdateCategoryUseCase{

    private final ICategoryRepository repository;

    @Override
    public void execute(UUID uuid, UpdateCateogoryInputData input) {
        Category category = repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Category %s not found", uuid));
        category.update(input.getName(), input.getDescription(), input.getIsActive());
        repository.update(category);
    }
}
