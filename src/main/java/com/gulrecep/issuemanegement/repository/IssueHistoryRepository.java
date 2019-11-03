package com.gulrecep.issuemanegement.repository;

import com.gulrecep.issuemanegement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
