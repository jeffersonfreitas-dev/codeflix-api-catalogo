package com.fullcycle.CatalogoVideo.api.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullcycle.CatalogoVideo.api.configuration.GlobalExceptionHandler;
import com.fullcycle.CatalogoVideo.application.usecase.category.common.CategoryOutputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.CreateCategoryInputData;
import com.fullcycle.CatalogoVideo.application.usecase.category.create.ICreateCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.findAll.IFindAllCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.findById.IFindByIdCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.remove.IRemoveCategoryUseCase;
import com.fullcycle.CatalogoVideo.application.usecase.category.update.IUpdateCategoryUseCase;
import com.fullcycle.CatalogoVideo.domain.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryEndPointTest {

    @InjectMocks
    private CategoryEndPoint endPoint;

    @Mock private ICreateCategoryUseCase createUseCase;
    @Mock private IFindByIdCategoryUseCase findByIdUseCase;
    @Mock private IFindAllCategoryUseCase findAllUseCase;
    @Mock private IRemoveCategoryUseCase removeUseCase;
    @Mock private IUpdateCategoryUseCase updateUseCase;

    private MockMvc mvc;
    private JacksonTester<CreateCategoryInputData> createJson;

    @BeforeEach
    public void init(){
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(endPoint)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    public void createCategory() throws Exception {
        CreateCategoryInputData input = new CreateCategoryInputData();
        input.setName("Action");

        String payload = createJson.write(input).getJson();
        Category entity = new Category("Action", "", true);
        CategoryOutputData output = new CategoryOutputData(entity.getId(), entity.getName(),
                entity.getDescription(), entity.getActive());

        doReturn(output).when(createUseCase).execute(any(CreateCategoryInputData.class));

        mvc.perform(post("/categories")
                .contentType(APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON));
    }


}
