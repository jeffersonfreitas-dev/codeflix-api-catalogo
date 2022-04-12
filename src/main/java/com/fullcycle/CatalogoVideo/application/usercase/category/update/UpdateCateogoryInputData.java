package com.fullcycle.CatalogoVideo.application.usercase.category.update;

import lombok.Data;

@Data
public class UpdateCateogoryInputData {

    private String name;
    private String description;
    private Boolean isActive;
}
