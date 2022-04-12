package com.fullcycle.CatalogoVideo.application.category;

import com.fullcycle.CatalogoVideo.application.usercase.category.remove.RemoveCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class RemoveCategoryUseCaseTest {

    @InjectMocks
    RemoveCategoryUseCase useCase;

    @Mock
    ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        this.useCase = new RemoveCategoryUseCase(repository);
    };

    @Test
    public void executeReturnsRemove() {
        UUID id = UUID.randomUUID();
        Category entity = new Category(id,"Comedy", "So fun", true);

        doNothing().when(repository).remove(entity.getId());

        useCase.execute(id);

        Assertions.assertThat(entity).isNotNull();
        verify(repository).remove(id);
    }
}
