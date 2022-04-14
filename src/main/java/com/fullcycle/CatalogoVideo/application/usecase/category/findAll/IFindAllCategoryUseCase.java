package com.fullcycle.CatalogoVideo.application.usecase.category.findAll;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

import java.util.List;

public interface IFindAllCategoryUseCase {
    List<CategoryOutputData> execute();
}
