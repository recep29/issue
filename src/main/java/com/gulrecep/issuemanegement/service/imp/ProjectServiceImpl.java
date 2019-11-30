package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.dto.ProjectDto;
import com.gulrecep.issuemanegement.entity.Project;
import com.gulrecep.issuemanegement.repository.ProjectRepository;
import com.gulrecep.issuemanegement.service.ProjectService;
import com.gulrecep.issuemanegement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        /*
          ProjectDto da @notnull eklediğimiz için burda kontrole gerek kalmadı.
          spring bizim yerimize kontrolü sağlıyor olacak.

          if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project Codecan not be null");
        }

         */

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null)
            throw new IllegalArgumentException("Project code Alredy Exist");
        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);


        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {

        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);

    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        // veritabanından entity yardımı ile tüm verileri cektik. ancak frontente modelmapper yardımı ile map edip dtosu üzerinden kendi page miz ile set ettik.
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }

    public Boolean delete(Long id){
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        //validation
        if (projectDb == null)
            throw new IllegalArgumentException("project dos not exist ID:" + id);
        //iş kuralı aynı proje kodundan birdden fazla olamaz
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck !=  null)
            throw new IllegalArgumentException("Project code Alredy Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);


        return modelMapper.map(projectDb, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCodeAndIdNot(String projectCode, Long id) {
        return null;
    }
}
