package com.fullcycle.CatalogoVideo.application.usercase.category.findAll;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FindAllCategoryUseCase extends IFindAllCategoryUseCase {

    private final ICategoryRepository repository;

    @Override
    public List<CategoryOutputData> execute() {
        return null;
    }
}
