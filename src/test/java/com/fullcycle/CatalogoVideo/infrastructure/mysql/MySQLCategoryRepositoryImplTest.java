package com.fullcycle.CatalogoVideo.infrastructure.mysql;

import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.infrastructure.data.SpringDataCategoryRepository;
import com.fullcycle.CatalogoVideo.infrastructure.persistence.CategoryPersistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class MySQLCategoryRepositoryImplTest {

    @InjectMocks
    private MySQLCategoryRepositoryImpl service;

    @Mock
    private SpringDataCategoryRepository repository;

    public void saveCategory(){
        Category expected = new Category("Action", "Action Description", true);
        Category input = new Category("Action", "Action Description", true);

        doReturn(CategoryPersistence.from(expected))
                .when(repository).save(Mockito.any(CategoryPersistence.class));
        
        Category actual = service.create(input);

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual).hasFieldOrPropertyWithValue("name", "Action");
        assertTrue(actual.getActive());
    }

    @Test
    public void findAllCategories(){
        Category entity1 = new Category("Action", "Action Description", true);
        Category entity2 = new Category("Action2", "Action Description2", true);
        List<CategoryPersistence> expected = new ArrayList<>();
        expected.add(CategoryPersistence.from(entity1));
        expected.add(CategoryPersistence.from(entity2));

        doReturn(expected).when(repository).findAll();

        List<Category> actual = service.findAll();

        assertThat(actual).isNotNull();
     }

    @Test
    public void findByIdCategory(){
        Category entity = new Category("Action", "Action Description", true);
        CategoryPersistence input = CategoryPersistence.from(entity);

        doReturn(Optional.of(input)).when(repository).findById(entity.getId());

        Optional<Category> actual = service.findById(entity.getId());

        assertThat(actual.isPresent()).isTrue();
        assertThat(actual).isNotNull();
     }

    @Test
    public void deleteCategory(){
        Category entity = new Category("Action", "Action Description", true);
        doNothing().when(repository).deleteById(entity.getId());
        service.remove(entity.getId());
        verify(repository, times(1)).deleteById(entity.getId());
     }

    @Test
    public void updateCategory(){
        Category expected = new Category("Action", "Action Description", true);
        Category input = new Category("Action", "Action Description", true);

        doReturn(CategoryPersistence.from(expected))
                .when(repository).save(Mockito.any(CategoryPersistence.class));
        Category toUpdate = service.create(input);

        toUpdate.update("Action Updated", toUpdate.getDescription(), false);
        doReturn(CategoryPersistence.from(toUpdate))
                .when(repository).save((Mockito.any(CategoryPersistence.class)));
        service.update(toUpdate);

        assertThat(toUpdate).isNotNull();
        assertThat(toUpdate).hasFieldOrPropertyWithValue("name", "Action Updated");
        assertFalse(toUpdate.getActive());
    }

}
