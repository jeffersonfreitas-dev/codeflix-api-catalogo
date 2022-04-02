package com.fullcycle.CatalogoVideo.application.usercase.category.common;

import com.fullcycle.CatalogoVideo.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryOutputData {

    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;

    public static CategoryOutputData fromDomain(Category domain) {
        return new CategoryOutputData(domain.getId(), domain.getName(), domain.getDescription(), domain.getActive());
    }
}
