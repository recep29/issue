package com.gulrecep.issuemanegement.service;

import com.gulrecep.issuemanegement.dto.IssueDto;
import com.gulrecep.issuemanegement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

}
