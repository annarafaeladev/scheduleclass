package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.application.dto.student.StudentResume;
import br.com.api.scheduleclass.application.usecase.student.StudentFullDetailsFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentResumeFindByIdUseCase;
import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.web.dto.errors.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentFullDetailsFindByIdUseCase studentFindByIdUseCase;
    private final StudentResumeFindByIdUseCase studentResumeFindByIdUseCase;

    @Operation(summary = "Buscar dados completo estudante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        Student student = studentFindByIdUseCase.execute(id);
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Buscar resumo estudante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = StudentResume.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}/resume")
    public ResponseEntity<StudentResume> resume(@PathVariable Long id) {
        StudentResume resume = studentResumeFindByIdUseCase.execute(id);
        return ResponseEntity.ok(resume);
    }

//    @Operation(summary = "Cadastrar uma nova academia")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Created",
//                    content = @Content(schema = @Schema(implementation = CreateAcademyResponse.class))),
//            @ApiResponse(responseCode = "400", description = "Bad request",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
//            @ApiResponse(responseCode = "500", description = "Erro interno",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
//    })
//    @PostMapping
//    public ResponseEntity<CreateAcademyResponse> create(@RequestBody @Valid CreateAcademyRequest request) {
//
//        AcademyCommand command = new AcademyCommand(
//                request.name(),
//                request.address(),
//                request.phone(),
//                request.email()
//        );
//
//        Long id = createAcademyUseCase.execute(command);
//        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAcademyResponse(id));
//    }
//
//
//    @Operation(summary = "Atualizar academia")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Updated",
//                    content = @Content(schema = @Schema(implementation = UpdateAcademyResponse.class))),
//            @ApiResponse(responseCode = "404", description = "Not Found",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
//            @ApiResponse(responseCode = "400", description = "Bad request",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
//            @ApiResponse(responseCode = "500", description = "Erro interno",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
//    })
//    @PatchMapping("/{id}")
//    public ResponseEntity<UpdateAcademyResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateAcademyRequest request) {
//
//        AcademyCommand command = new AcademyCommand(
//                request.name(),
//                request.address(),
//                request.phone(),
//                request.email()
//        );
//
//        Academy academy = updateAcademyByIdUseCase.execute(id, command);
//
//        UpdateAcademyResponse response = new UpdateAcademyResponse(
//                academy.getId(),
//                request.name(),
//                request.address(),
//                request.phone(),
//                request.email(),
//                academy.getUpdatedAt()
//        );
//
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//
//    @Operation(summary = "Atualizar status da academia")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Updated"),
//            @ApiResponse(responseCode = "404", description = "Not Found",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
//            @ApiResponse(responseCode = "400", description = "Bad request",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
//            @ApiResponse(responseCode = "500", description = "Erro interno",
//                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
//    })
//    @PatchMapping("/{id}/status")
//    public ResponseEntity<StatusAcademyResponse> status(@PathVariable Long id) {
//
//        Academy academy = statusAcademyyService.execute(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body(new StatusAcademyResponse(academy.getId(), academy.getActive(), academy.getUpdatedAt()));
//    }
}

