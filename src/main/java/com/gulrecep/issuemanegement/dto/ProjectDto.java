package com.gulrecep.issuemanegement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long id;
    @NotNull
    @Column (nullable = false)
    private String projectCode;
    @NotNull
    private String projectName;

}
