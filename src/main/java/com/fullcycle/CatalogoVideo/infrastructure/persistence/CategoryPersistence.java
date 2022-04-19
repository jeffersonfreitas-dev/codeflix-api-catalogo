package com.fullcycle.CatalogoVideo.infrastructure.persistence;

import com.fullcycle.CatalogoVideo.domain.entity.Category;
import com.fullcycle.CatalogoVideo.domain.exception.NotNullDomainException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARBINARY(16)")
    private UUID id;

    @Column
    @NotBlank(message = "name can not be blank")
    private String name;

    @Column
    private String description;

    @Column
    private Boolean isActive;

    public static CategoryPersistence from(Category category){
        if (category == null) throw new NotNullDomainException("Category is null");
        return new CategoryPersistence(category.getId(), category.getName(),
                category.getDescription(), category.getActive());
    }

    public Category fromThis(){
        return new Category(getId(), getName(), getDescription(), getIsActive());
    }
}
