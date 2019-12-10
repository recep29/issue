package com.gulrecep.issuemanegement.api;


import com.gulrecep.issuemanegement.dto.IssueDto;
import com.gulrecep.issuemanegement.dto.UserDto;
import com.gulrecep.issuemanegement.service.imp.IssueServiceImpl;
import com.gulrecep.issuemanegement.service.imp.UserServiceImpl;
import com.gulrecep.issuemanegement.util.ApiPaths;
import com.gulrecep.issuemanegement.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * http metotları
 * GET
 * PUT
 * POST
 * DELETE
 */
@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
public class UserController {

    //dışarıya DTO lar üzerinden iletişimde bulunuyoruz

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true) Long id) {
        UserDto userDto = userServiceImpl.getById(id);
        return ResponseEntity.ok(userDto);

    }

    @GetMapping("/pagination")
    //  @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable) {
        TPage<UserDto> data = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);

    }

    @PostMapping
    public ResponseEntity<UserDto> createIssue(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }
/*
    //@RequestMapping(path="/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody UserDto user) {
        // SOLİD prensipleri her metot tek başına sedece yüklenici olduğu işi gerçekleştirmesi gerekir.
        // birden fazla metodu yuklememesi gerekiyor.
        return ResponseEntity.ok(userServiceImpl.update(id, issue));

    }


@DeleteMapping("/{id}")
   public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
        return  ResponseEntity.ok(userServiceImpl.delete(id));
    }

 */
}
