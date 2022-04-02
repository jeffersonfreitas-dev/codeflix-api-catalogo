package com.fullcycle.CatalogoVideo.domain.entity;

import com.fullcycle.CatalogoVideo.domain.exception.DomainException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTest {

    @Test
    public void createCategoryWithName() {
        final Category category = new Category("NameTest", "DescriptionTest");

        assertNotNull(category);
        assertNotNull(category.getId());
        assertEquals(category.getName(), "NameTest");
        assertEquals(category.getDescription(), "DescriptionTest");
        assertTrue(category.getActive());
    }

    @Test
    public void createCategoryWithNameAndDeactivate() {
        final Category category = new Category("NameTest", "DescriptionTest");
        category.deactivate();

        assertNotNull(category);
        assertNotNull(category.getId());
        assertEquals(category.getName(), "NameTest");
        assertEquals(category.getDescription(), "DescriptionTest");
        assertFalse(category.getActive());
    }

    @Test
    public void createCategoryAndUpdate() {
        final Category category = new Category("NameTest", "DescriptionTest");

        assertNotNull(category);
        assertNotNull(category.getId());
        assertEquals(category.getName(), "NameTest");
        assertEquals(category.getDescription(), "DescriptionTest");
        assertTrue(category.getActive());

        category.update("Name2", "Description2", false);
        assertNotNull(category);
        assertNotNull(category.getId());
        assertEquals(category.getName(), "Name2");
        assertEquals(category.getDescription(), "Description2");
        assertFalse(category.getActive());
    }

    @Test
    public void throwDomainExceptionWhenNameIsNull(){
        assertThrows(DomainException.class, ()-> new Category(null, "Description"));
    }

    @Test
    public void throwDomainExceptionWhenNameIsBlank(){
        assertThrows(DomainException.class, ()-> new Category("", "Description"));
    }
}
