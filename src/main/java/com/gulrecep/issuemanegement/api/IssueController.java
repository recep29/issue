package com.gulrecep.issuemanegement.api;


import com.gulrecep.issuemanegement.dto.IssueDto;
import com.gulrecep.issuemanegement.service.imp.IssueServiceImpl;
import com.gulrecep.issuemanegement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * http metotları
 * GET
 * PUT
 * POST
 * DELETE
 */
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    //dışarıya DTO lar üzerinden iletişimde bulunuyoruz

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);

    }

    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    //@RequestMapping(path="/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        // SOLİD prensipleri her metot tek başına sedece yüklenici olduğu işi gerçekleştirmesi gerekir.
        // birden fazla metodu yuklememesi gerekiyor.
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));

    }
@DeleteMapping("/{id}")
   public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return  ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
