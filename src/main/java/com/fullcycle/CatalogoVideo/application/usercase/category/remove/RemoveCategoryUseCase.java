package com.fullcycle.CatalogoVideo.application.usercase.category.remove;

import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class RemoveCategoryUseCase implements IRemoveCategoryUseCase{

    private final ICategoryRepository repository;

    @Override
    public void execute(UUID uuid) {
        repository.remove(uuid);
    }
}
