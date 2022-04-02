package com.fullcycle.CatalogoVideo.application.usercase.category.create;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCategoryUseCase implements ICreateCategoryUseCase{

    private final ICategoryRepository repository;

    @Override
    public CategoryOutputData execute(CreateCategoryInputData input) {
        Category created = repository.create(toDomain(input));
        return CategoryOutputData.fromDomain(created);
    }

    private Category toDomain(CreateCategoryInputData input) {
        return new Category(
          input.getName(),
          input.getDescription(),
          input.getIsActive()
        );
    }
}
