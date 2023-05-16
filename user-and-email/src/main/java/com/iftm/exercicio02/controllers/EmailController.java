package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.EmailVO;
import com.iftm.exercicio02.services.EmailService;
import com.iftm.exercicio02.utils.MediaType;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/email")
@Tag(name = "Email", description = "Endpoint for managing emails.")
public class EmailController {
    @Autowired
    private EmailService service;

    @GetMapping
    @Operation (
        summary = "Find all emails.", description = "Find all emails.", tags = {"Email"},
        responses = {
            @ApiResponse (description = "Sucess.", responseCode = "200",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON,
                        array = @ArraySchema(schema = @Schema(implementation = EmailVO.class)))
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
        }
    )
    public List<EmailVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Find a email by ID.", description = "Find a email by ID.", tags = {"Email"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = EmailVO.class)
                    )
                }
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public EmailVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(
        summary = "Create a email.", description = "Create a email.", tags = {"Email"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = EmailVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public EmailVO save(@RequestBody EmailVO emailVO) {
        return service.save(emailVO);
    }

    @PutMapping
    @Operation(
        summary = "Update a email.", description = "Update a email.", tags = {"Email"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = @Content(
                        schema = @Schema(implementation = EmailVO.class)
                )
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public EmailVO update(@RequestBody EmailVO emailVO) {
        return service.update(emailVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Deletes a email by ID.", description = "Deletes a email by ID.", tags = {"Email"},
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