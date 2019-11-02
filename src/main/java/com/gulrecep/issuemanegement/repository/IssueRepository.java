package com.gulrecep.issuemanegement.repository;

import com.gulrecep.issuemanegement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {

}
