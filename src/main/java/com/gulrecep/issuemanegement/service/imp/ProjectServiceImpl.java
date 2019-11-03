package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.entity.Project;
import com.gulrecep.issuemanegement.repository.ProjectRepository;
import com.gulrecep.issuemanegement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
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
    public ProjectDto getById(Long id) {

     Project project =projectRepository.getOne(id);
     return modelMapper.map(project,ProjectDto.class);

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
