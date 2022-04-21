package com.fullcycle.CatalogoVideo.api.category;

import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.UpdateCateogoryInputData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public interface ICategoryEndPoint {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryOutputData postMethodName(@RequestBody CreateCategoryInputData input);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryOutputData> findAll();

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryOutputData findById(@PathVariable UUID id);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id);

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id, UpdateCateogoryInputData input);
}
