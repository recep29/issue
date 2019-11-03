package com.gulrecep.issuemanegement.service;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.entity.Project;
import com.gulrecep.issuemanegement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id, ProjectDto project);
    ProjectDto getByProjectCodeAndIdNot(String projectCode, Long id);
}
