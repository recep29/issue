package com.gulrecep.issuemanegement.api;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.service.imp.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http metotları
 * GET
 * PUT
 * POST
 * DELETE
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    //dışarıya DTO lar üzerinden iletişimde bulunuyoruz

    private final ProjectServiceImpl projectServiceImpl;
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto>  getById(@PathVariable("id") Long id){
      ProjectDto projectDto=projectServiceImpl.getById(id);
      return ResponseEntity.ok(projectDto);

  }
}
