package com.booksstore.booksstore.controller.docs;

import com.booksstore.booksstore.dto.manager.ManagerCreateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Managers management")

public interface ManagerControllerDocs {
    @ApiOperation("Manager creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success manager creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    void create(ManagerCreateRequest managerCreateRequest);
}
