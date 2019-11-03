package com.gulrecep.issuemanegement.api;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.service.imp.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path="/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        // SOLİD prensipleri her metot tek başına sedece yüklenici olduğu işi gerçekleştirmesi gerekir.
        // birden fazla metodu yuklememesi gerekiyor.
        return ResponseEntity.ok(projectServiceImpl.update(id, project));

    }
@DeleteMapping("/{id}")
   public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return  ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
