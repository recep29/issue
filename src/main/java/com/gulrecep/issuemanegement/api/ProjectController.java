package com.gulrecep.issuemanegement.api;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.service.imp.ProjectServiceImpl;
import com.gulrecep.issuemanegement.util.ApiPaths;
import com.gulrecep.issuemanegement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * http metotları
 * GET
 * PUT
 * POST
 * DELETE
 */
//@Api(value = "Project APİs")
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Slf4j
@CrossOrigin
public class ProjectController {

    //dışarıya DTO lar üzerinden iletişimde bulunuyoruz

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/pagination")
    //  @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);

    }


    @GetMapping("/{id}")
    //  @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("ProjectController  -> GetById -> Param");
        log.debug("ProjectController  -> GetById -> Param" + id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }

    @PostMapping
    // @ApiOperation(value = "Insert Project  Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path="/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    // @ApiOperation(value = "Update Project Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        // SOLİD prensipleri her metot tek başına sedece yüklenici olduğu işi gerçekleştirmesi gerekir.
        // birden fazla metodu yuklememesi gerekiyor.
        return ResponseEntity.ok(projectServiceImpl.update(id, project));

    }

    @DeleteMapping("/{id}")
// @ApiOperation(value = "Delete Project Operation",response =Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
