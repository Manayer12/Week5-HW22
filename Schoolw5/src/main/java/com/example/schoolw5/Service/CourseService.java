package com.example.schoolw5.Service;

import com.example.schoolw5.Api.ApiException;
import com.example.schoolw5.Model.Course;
import com.example.schoolw5.Model.Teacher;
import com.example.schoolw5.Repoository.CourseRepository;
import com.example.schoolw5.Repoository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseService {
    private final CourseRepository courseRepository;
   private final TeacherRepository teacherRepository;
    public List<Course> getAll(){

        return courseRepository.findAll();
    }

    public void addCourse(Course course ){
        courseRepository.save(course);

    }

    public String getTbyCourse(Integer teacher_id,Integer course_id){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course= courseRepository.findCourseById(course_id);
        if (teacher==null || course==null){
            throw  new ApiException("Can not find id");
        }

        if(teacher.getCourseset().contains(course)){
           return teacherRepository.findTeacherById(teacher_id).getName();
        }

        throw new ApiException("the Course id is wrong and not assigned to any other Teacher");
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("id not found");
        }
        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);

    }

    public void deleteCourse(Integer id){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("id not found");
        }

        courseRepository.deleteById(id);
    }

    public void assignTechertoCourse(Integer teacher_id,Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);

        if (course==null || teacher==null){

            throw  new ApiException("Can not Assign");
        }
        course.setTeacher(teacher);
        teacherRepository.save(teacher);
    }



}
