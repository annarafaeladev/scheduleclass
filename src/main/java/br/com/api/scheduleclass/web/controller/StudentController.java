package br.com.api.scheduleclass.web.controller;

import br.com.api.scheduleclass.application.dto.student.StudentCommand;
import br.com.api.scheduleclass.application.dto.student.StudentResume;
import br.com.api.scheduleclass.application.usecase.student.CreateStudentUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentFullDetailsFindByIdUseCase;
import br.com.api.scheduleclass.application.usecase.student.StudentResumeFindByIdUseCase;
import br.com.api.scheduleclass.domain.model.Student;
import br.com.api.scheduleclass.web.dto.errors.ErrorResponseDTO;
import br.com.api.scheduleclass.web.dto.student.CreateStudentRequest;
import br.com.api.scheduleclass.web.dto.student.CreateStudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentFullDetailsFindByIdUseCase studentFindByIdUseCase;
    private final StudentResumeFindByIdUseCase studentResumeFindByIdUseCase;
    private final CreateStudentUseCase createStudentUseCase;

    @Operation(summary = "Buscar dados completo estudante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
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
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}/resume")
    public ResponseEntity<StudentResume> resume(@PathVariable Long id) {
        StudentResume resume = studentResumeFindByIdUseCase.execute(id);
        return ResponseEntity.ok(resume);
    }

    @Operation(summary = "Cadastrar um estudante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = CreateStudentResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping
    public ResponseEntity<CreateStudentResponse> create(@RequestHeader("X-Academy-ID") Long academiaId, @RequestBody @Valid CreateStudentRequest request) {

        StudentCommand command = new StudentCommand(
                request.name(),
                request.email(),
                request.phone(),
                request.belt(),
                request.beltDegree()
        );

        Long id = createStudentUseCase.execute(academiaId, command);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateStudentResponse(id));
    }


}

