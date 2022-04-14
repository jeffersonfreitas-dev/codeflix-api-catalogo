package com.fullcycle.CatalogoVideo.application.usecase.category.findById;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;

import java.util.UUID;

public interface IFindByIdCategoryUseCase {
    CategoryOutputData execute(UUID uuid);
}
