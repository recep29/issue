package com.gulrecep.issuemanegement.api;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.service.imp.ProjectServiceImpl;
import com.gulrecep.issuemanegement.util.ApiPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
public class ProjectVersionedApi {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;


    @GetMapping(value = "/{id}", params = "versiyon=1")
    //  @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }


    @GetMapping(value = "/{id}", params = "versiyon=2")
    //  @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById2(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }

}


//api versiyonu yaptık . parametre olark versiyon numarası alıp ona göre fonksiyon çalışmaktadır.