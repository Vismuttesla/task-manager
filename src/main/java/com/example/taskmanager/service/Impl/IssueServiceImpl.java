package com.example.taskmanager.service.Impl;

import com.example.taskmanager.dto.IssueDto;
import com.example.taskmanager.dto.IssueForm;
import com.example.taskmanager.dto.IssueItemDto;
import com.example.taskmanager.entity.Issue;
import com.example.taskmanager.repository.IssueRepository;
import com.example.taskmanager.repository.ProjectRepository;
import com.example.taskmanager.repository.StatusRepository;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private IssueRepository issueRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    private StatusRepository statusRepository;

    @Override
    public IssueDto add(IssueForm form) {
        return IssueDto.fromIssue(issueRepository.save(fillIssue(new Issue(), form)));
    }

    @Override
    public IssueDto findOne(Long id) {
        return IssueDto.fromIssue(issueRepository.getReferenceById(id));
    }

    @Override
    public IssueDto update(Long id, IssueForm issueForm) {
        return IssueDto.fromIssue(issueRepository.save(fillIssue(issueRepository.getReferenceById(id), issueForm)));
    }

    @Override
    public List<IssueItemDto> issues(Long projectId) {
        return issueRepository.findAllByProjectId(projectId).
                stream().map(IssueItemDto::fromIssue).collect(Collectors.toList());
    }


    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        Optional<Issue> issue = issueRepository.findById(id);

        if (issue != null)
            return true;

        return false;

    }

    private Issue fillIssue(Issue issue, IssueForm form) {
        issue.builder().project(projectRepository.getReferenceById(form.getProjectId())).
                assignee(userRepository.findUserByName((form.getAssigneeName()))).
                title(form.getTitle()).
                description(form.getDescription()).
                issueType(form.getIssueType()).
                status(statusRepository.findStatusByName(form.getStatus())).build();
        return issue;
    }


}
