package com.fullcycle.CatalogoVideo.application.category;

import com.fullcycle.CatalogoVideo.application.usercase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usercase.category.findAll.FindAllCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class FindAllCategoryUseCaseTest {

    @InjectMocks
    private FindAllCategoryUseCase useCase;

    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new FindAllCategoryUseCase(repository);
    }

    @Test
    public void shouldReturnAllCategories(){
        List<Category> categories = Arrays.asList(
                new Category("Horror", "So bad", true),
                new Category("Comedy", "So fun", true),
                new Category("Police", "So exiting", true)
        );

        when(repository.findAll()).thenReturn(categories);
        List<CategoryOutputData> result = useCase.execute();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(3);
        verify(repository, times(1)).findAll();

    }

}
