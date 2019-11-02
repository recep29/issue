package com.gulrecep.issuemanegement.service.imp;

import com.gulrecep.issuemanegement.dto.IssueDto;
import com.gulrecep.issuemanegement.entity.Issue;
import com.gulrecep.issuemanegement.repository.IssueRepository;
import com.gulrecep.issuemanegement.service.IssueService;
import com.gulrecep.issuemanegement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

public class IssueServiceImpl implements IssueService {
    /* setter injection
    -- ancak spring Constructor injectionu tavsiye eder
    @Autowired
    private IssueRepository issueRepository;
    */

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

   // @Autowired    yazmasakta kendisi inject ediyor.
   public IssueServiceImpl( IssueRepository issueRepository, ModelMapper modelMapper){
       this.issueRepository=issueRepository;
       this.modelMapper =modelMapper;
   }


    @Override
    public IssueDto save(IssueDto issue) {
       if (issue.getDate()==null){
           throw new IllegalArgumentException("can not be null");
       }
       //kayıt metodu dto tipinde nesneyi alıyor. Issue tipinde veritabanına kayıt ediyor
        // ve daha sonra DTO tipine cevirip geri donderiyor;

        Issue issueEntity= modelMapper.map(issue,Issue.class);
        issueEntity =issueRepository.save(issueEntity);
        IssueDto parseDto=modelMapper.map(issueEntity,IssueDto.class);
        return parseDto;
}

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
       //controller ve rest apiler dıs dünyaya dto lar üzerinden haberleşecekler
       // veritabanından entity yardımı ile tüm verileri cektik. ancak frontente modelmapper yardımı ile map edip dtosu üzerinden kendi page miz ile set ettik.
      Page<Issue> data =issueRepository.findAll(pageable);
      TPage page= new TPage<IssueDto>();
      IssueDto[] dtos= modelMapper.map(data.getContent(),IssueDto[].class);
      page.setStat(data, Arrays.asList(dtos));
      return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
