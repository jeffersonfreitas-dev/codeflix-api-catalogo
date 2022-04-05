package com.fullcycle.CatalogoVideo.application.usercase.category.findById;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;

import java.util.UUID;

public interface IFindByIdCategoryUseCase {
    CategoryOutputData execute(UUID uuid);
}
