package com.gulrecep.issuemanegement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    // @ApiModelProperty(value = "Project ID")
    private Long id;
    @NotNull
    @Column (nullable = false)
    //  @ApiModelProperty(required = true,value = "Code Of Project")
    private String projectCode;
    @NotNull
    // @ApiModelProperty(required = true,value = "NAme Of Project")
    private String projectName;

}
