package com.example.taskmanager.service.Impl;

import com.example.taskmanager.dto.IssueItemDto;
import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.dto.ProjectForm;
import com.example.taskmanager.dto.ProjectItemDto;
import com.example.taskmanager.entity.Project;
import com.example.taskmanager.entity.Project.ProjectBuilder;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.ProjectRepository;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.ProjectService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProjectServiceImpl implements ProjectService {

   private UserRepository userRepository;
   private ProjectRepository projectRepository;


    @Override
    public ProjectDto add(ProjectForm projectForm) {

               return ProjectDto.fromProject(projectRepository.save(fillProject(new Project(),projectForm))) ;
    }

    @Override
    public ProjectDto findOne(Long id) {
        return ProjectDto.fromProject((Project) projectRepository.getReferenceById(id));
    }

    @Override
    public ProjectDto update(Long id, ProjectForm projectform) {

              return ProjectDto.fromProject(projectRepository.save(fillProject(projectRepository.getReferenceById(id),projectform)));
    }


    @Override
    public List<ProjectItemDto> projects() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String email = auth.getName();
        User user = userRepository.findUserByEmail(email);
       Long id= user.getUserId();


        return projectRepository.findAllByUserId(id)
                .stream().map(ProjectItemDto::fromProject)
                .collect(Collectors.toList());
    }


    @Override
    public Boolean delete(Long id) {

        projectRepository.deleteById(id);
        Optional<Project> project=projectRepository.findById(id);

        if (project!=null)
            return  true;

        return false;
    }
  private  Project fillProject(Project project,ProjectForm  form){
        return project.builder().projectName(form.getProjectName()).
                description(form.getDescription()).build();


  }


}
