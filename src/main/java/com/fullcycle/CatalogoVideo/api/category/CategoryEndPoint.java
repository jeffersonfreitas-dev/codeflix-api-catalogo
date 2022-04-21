package com.fullcycle.CatalogoVideo.api.category;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.ICreateCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.findAll.IFindAllCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.findById.IFindByIdCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.remove.IRemoveCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.IUpdateCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCateogoryInputData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CategoryEndPoint implements ICategoryEndPoint{

    private final ICreateCategoryUseCase createCategoryUseCase;
    private final IFindAllCategoryUseCase findAllCategoryUseCase;
    private final IFindByIdCategoryUseCase findByIdCategoryUseCase;
    private final IRemoveCategoryUseCase removeCategoryUseCase;
    private final IUpdateCategoryUseCase updateCategoryUseCase;

    @Override
    public CategoryOutputData postMethodName(CreateCategoryInputData input) {
        CategoryOutputData category = createCategoryUseCase.execute(input);
        return category;
    }

    @Override
    public List<CategoryOutputData> findAll() {
        return findAllCategoryUseCase.execute();
    }

    @Override
    public CategoryOutputData findById(UUID id) {
        return findByIdCategoryUseCase.execute(id);
    }

    @Override
    public void deleteById(UUID id) {
        removeCategoryUseCase.execute(id);
    }

    @Override
    public void update(UUID id, UpdateCateogoryInputData input) {
        updateCategoryUseCase.execute(id, input);
    }
}
