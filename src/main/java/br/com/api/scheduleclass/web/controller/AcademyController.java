package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.application.usecase.academy.StatusAcademyByIdUseCase;
import br.com.api.scheduleclass.application.usecase.academy.UpdateAcademyByIdUseCase;
import br.com.api.scheduleclass.web.dto.academy.*;
import br.com.api.scheduleclass.web.dto.errors.ErrorResponseDTO;
import br.com.api.scheduleclass.application.dto.academy.AcademyCommand;
import br.com.api.scheduleclass.application.usecase.academy.AcademyFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.academy.CreateAcademyUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/academies")
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyFindByIdUseCase academyFindByIdUseCase;
    private final CreateAcademyUseCase createAcademyUseCase;
    private final UpdateAcademyByIdUseCase updateAcademyByIdUseCase;
    private final StatusAcademyByIdUseCase statusAcademyyService;

    @Operation(summary = "Buscar academia por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Academia encontrada",
                    content = @Content(schema = @Schema(implementation = Academy.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma academia encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<Academy> all(@PathVariable Long id) {
        Academy academy = academyFindByIdUseCase.execute(id);
        return ResponseEntity.ok(academy);
    }

    @Operation(summary = "Cadastrar uma nova academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = CreateAcademyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping
    public ResponseEntity<CreateAcademyResponse> create(@RequestBody @Valid CreateAcademyRequest request) {

        AcademyCommand command = new AcademyCommand(
                request.name(),
                request.address(),
                request.phone(),
                request.email()
        );

        Long id = createAcademyUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAcademyResponse(id));
    }


    @Operation(summary = "Atualizar academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated",
                    content = @Content(schema = @Schema(implementation = UpdateAcademyResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<UpdateAcademyResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateAcademyRequest request) {

        AcademyCommand command = new AcademyCommand(
                request.name(),
                request.address(),
                request.phone(),
                request.email()
        );

        Academy academy = updateAcademyByIdUseCase.execute(id, command);

        UpdateAcademyResponse response = new UpdateAcademyResponse(
                academy.getId(),
                request.name(),
                request.address(),
                request.phone(),
                request.email(),
                academy.getUpdatedAt()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Operation(summary = "Atualizar status da academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PatchMapping("/{id}/status")
    public ResponseEntity<StatusAcademyResponse> status(@PathVariable Long id) {

        Academy academy = statusAcademyyService.execute(id);

        return ResponseEntity.status(HttpStatus.OK).body(new StatusAcademyResponse(academy.getId(), academy.getActive(), academy.getUpdatedAt()));
    }
}

