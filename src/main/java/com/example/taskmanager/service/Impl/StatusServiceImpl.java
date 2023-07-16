package com.example.taskmanager.service.Impl;

import com.example.taskmanager.entity.Status;
import com.example.taskmanager.repository.StatusRepository;
import com.example.taskmanager.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    @Override
    public Status add(Status status) {
        return statusRepository.save(status);
    }
}
