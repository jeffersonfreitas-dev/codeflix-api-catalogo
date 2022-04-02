package com.fullcycle.CatalogoVideo.application.usercase.category.create;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;

public interface ICreateCategoryUseCase {
    CategoryOutputData execute(CreateCategoryInputData input);
}
