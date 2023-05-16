package com.iftm.exercicio02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.services.GroupService;
import com.iftm.exercicio02.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/group")
@Tag(name = "Group", description = "Endpoint for managing groups.")
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping
    @Operation(
        summary = "Find all groups.", description = "Find all groups.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "Sucess.", responseCode = "200",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON,
                            array =  @ArraySchema(schema = @Schema(implementation = GroupVO.class)))
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    public List<GroupVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Find a group by ID.", description = "Find a group by ID.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON,
                        schema = @Schema(implementation = GroupVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public GroupVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

 
    @PostMapping
    @Operation(
        summary = "Create a group.", description = "Create a group.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = GroupVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public GroupVO save(@RequestBody GroupVO groupVO) {
        return service.save(groupVO);
    }

    @PostMapping("insert-users")
    @Operation(
        summary = "Insert a user in group.", description = "Insert a user in group.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = GroupVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public GroupVO insertUsers(@RequestBody GroupVO groupVO) {
        return service.insertUsers(groupVO);
    }

    @PutMapping
    @Operation(
        summary = "Update a group.", description = "Update a group.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = GroupVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public GroupVO update(@RequestBody GroupVO groupVO) {
        return service.update(groupVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Deletes a Group by ID.", description = "Deletes a Group by ID.", tags = {"Group"},
        responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}