package com.fullcycle.CatalogoVideo.application.usercase.category.update;

import java.util.UUID;

public interface IUpdateCategoryUseCase {
    void execute(UUID uuid, UpdateCateogoryInputData input);
}
