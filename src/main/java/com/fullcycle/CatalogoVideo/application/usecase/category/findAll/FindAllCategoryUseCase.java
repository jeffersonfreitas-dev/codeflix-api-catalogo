package com.fullcycle.CatalogoVideo.application.usecase.category.findAll;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FindAllCategoryUseCase implements IFindAllCategoryUseCase {

    private final ICategoryRepository repository;

    @Override
    public List<CategoryOutputData> execute() {
        List<Category> list = repository.findAll();
        return list.stream().map(CategoryOutputData::fromDomain)
                .collect(Collectors.toList());
    }
}
