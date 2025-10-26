package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.application.dto.ErrorResponseDTO;
import br.com.api.scheduleclass.application.usecase.academy.AcademyFindByIdUseCase;
import br.com.api.scheduleclass.domain.model.Academy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academies")
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyFindByIdUseCase getAcademyUseCase;

    @Operation(summary = "Buscar academia por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Academia encontrada",
                    content = @Content(schema = @Schema(implementation = Academy.class))),
            @ApiResponse(responseCode = "404", description = "Nenhuma academia encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Academy> get(@PathVariable Long id) {
        Academy academy = getAcademyUseCase.execute(id);
        return ResponseEntity.ok(academy);
    }
}

