package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.entity.Project;
import com.gulrecep.issuemanegement.repository.ProjectRepository;
import com.gulrecep.issuemanegement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository=projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode()==null){
            throw new IllegalArgumentException("Project Code Boş Olamaz");
        }

        project = projectRepository.save(project);
        return project;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
