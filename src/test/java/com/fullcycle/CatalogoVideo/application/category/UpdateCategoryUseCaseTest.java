package com.fullcycle.CatalogoVideo.application.category;

import com.fullcycle.CatalogoVideo.application.exception.NotFoundException;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCateogoryInputData;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryUseCaseTest {

    @InjectMocks
    private UpdateCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new UpdateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsUpdatedById (){
        UUID id = UUID.randomUUID();
        Category entity = new Category(id,"Comedy", "So fun", true);
        Category expected = new Category(id,"Comedy2", "So fun2", true);

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        UpdateCateogoryInputData input = new UpdateCateogoryInputData();
        input.setName("Comedy2");
        input.setDescription("So fun2");
        input.setIsActive(true);

        entity.update(input.getName(), input.getDescription(), input.getIsActive());

        doNothing().when(repository).update(entity);

        useCase.execute(id, input);

        assertThat(entity).isNotNull();
        assertThat(expected).isNotNull();
        assertThat(expected.getName()).isEqualTo(entity.getName());
    }

    @Test
    public void shouldReturnErrorWhenIdNotFound(){
        UUID id = UUID.randomUUID();
        UpdateCateogoryInputData input = new UpdateCateogoryInputData();
        input.setName("Comedy2");
        input.setDescription("So fun2");
        input.setIsActive(true);

        when(repository.findById(id)).thenReturn(Optional.empty());
        Throwable result = catchThrowable(() -> useCase.execute(id, input));
        assertThat(result).isInstanceOf(NotFoundException.class)
                .hasMessage("Category %s not found", id);
        verify(repository, times(1)).findById(id);
    }

}
