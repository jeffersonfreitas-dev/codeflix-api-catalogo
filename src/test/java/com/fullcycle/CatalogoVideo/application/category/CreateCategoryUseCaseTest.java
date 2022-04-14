package com.fullcycle.CatalogoVideo.application.category;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CreateCategoryUseCaseTest {

    @InjectMocks
    private CreateCategoryUseCase useCase;
    @Mock
    private ICategoryRepository repository;

    @BeforeEach
    void initUseCase(){
        useCase = new CreateCategoryUseCase(repository);
    }

    @Test
    public void executeReturnsCreatedCategory(){
        Category entity = new Category("NameTest", "DescriptionTest");

        when(repository.create(any(Category.class))).thenReturn(entity);

        CreateCategoryInputData input = new CreateCategoryInputData();
        input.setName(entity.getName());
        input.setDescription(entity.getDescription());
        input.setIsActive(entity.getActive());

        CategoryOutputData output = useCase.execute(input);
        repository.create(entity);

    }
}
