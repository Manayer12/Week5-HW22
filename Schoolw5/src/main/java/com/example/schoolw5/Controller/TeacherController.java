package com.example.schoolw5.Controller;

import com.example.schoolw5.Api.ApiResponse;
import com.example.schoolw5.Model.Teacher;
import com.example.schoolw5.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @GetMapping("/getteacher/{id}")
    public ResponseEntity getteacher(@PathVariable Integer id){

        return ResponseEntity.status(200).body(teacherService.getteacher(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }
}
