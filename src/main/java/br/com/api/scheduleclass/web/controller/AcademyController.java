package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.web.dto.errors.ErrorResponseDTO;
import br.com.api.scheduleclass.application.dto.academy.CreateAcademyCommand;
import br.com.api.scheduleclass.application.usecase.academy.AcademyFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.academy.CreateAcademyUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import br.com.api.scheduleclass.web.dto.academy.CreateAcademyRequest;
import br.com.api.scheduleclass.web.dto.academy.CreateAcademyResponse;
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

@RestController
@RequestMapping("/v1/academies")
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyFindByIdUseCase academyFindByIdUseCase;
    private final CreateAcademyUseCase createAcademyUseCase;

    @Operation(summary = "Buscar academia por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Academia encontrada",
                    content = @Content(schema = @Schema(implementation = Academy.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma academia encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Academy> get(@PathVariable Long id) {
        Academy academy = academyFindByIdUseCase.execute(id);
        return ResponseEntity.ok(academy);
    }

    @Operation(summary = "Cadastrar uma nova academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created",
                    content = @Content(schema = @Schema(implementation = Academy.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping
    public ResponseEntity<CreateAcademyResponse> create(@RequestBody @Valid CreateAcademyRequest request) {

        CreateAcademyCommand command = new CreateAcademyCommand(
                request.name(),
                request.address(),
                request.phone(),
                request.email()
        );

        Long id = createAcademyUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAcademyResponse(id));
    }
}

