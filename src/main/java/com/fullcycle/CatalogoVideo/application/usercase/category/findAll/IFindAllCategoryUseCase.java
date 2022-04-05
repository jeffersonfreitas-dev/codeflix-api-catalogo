package com.fullcycle.CatalogoVideo.application.usercase.category.findAll;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;

import java.util.List;

public interface IFindAllCategoryUseCase {
    List<CategoryOutputData> execute();
}
