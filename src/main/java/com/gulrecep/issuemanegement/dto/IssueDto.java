package com.gulrecep.issuemanegement.dto;

import com.gulrecep.issuemanegement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
//DTO = Data Transfer Object

@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
