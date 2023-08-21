package com.example.schoolw5.Controller;
import com.example.schoolw5.Api.ApiResponse;
import com.example.schoolw5.Model.Course;
import com.example.schoolw5.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(courseService.getAll());
    }
    @GetMapping("/getname/{teacher_id}/{course_id}")
    public ResponseEntity getnameofteacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){

        return ResponseEntity.status(200).body(courseService.getTbyCourse(teacher_id,course_id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("course added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Course course ){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted"));
    }

    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeachertoCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignTechertoCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned to Teacher"));



}}
