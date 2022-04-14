package com.fullcycle.CatalogoVideo.application.category;

import com.fullcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.findById.FindByIdCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class FindByIdCategoryUseCaseTest {

    @InjectMocks
    private FindByIdCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new FindByIdCategoryUseCase(repository);
    }

    @Test
    public void shouldReturnCategoryById (){
        UUID id = UUID.randomUUID();
        Category entity = new Category(id,"Comedy", "So fun", true);

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        CategoryOutputData result = useCase.execute(id);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    public void shouldReturnErrorWhenIdNotFound(){
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());
        Throwable result = catchThrowable(() -> useCase.execute(id));
        assertThat(result).isInstanceOf(NotFoundException.class)
                .hasMessage("Category %s not found", id);
        verify(repository, times(1)).findById(id);
    }

}
