package com.example.schoolw5.Service;

import com.example.schoolw5.Api.ApiException;
import com.example.schoolw5.Model.Course;
import com.example.schoolw5.Model.Teacher;
import com.example.schoolw5.Repoository.CourseRepository;
import com.example.schoolw5.Repoository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){

        return teacherRepository.findAll();
    }

    public Teacher getteacher(Integer id){

        return teacherRepository.findTeacherById(id);
    }




    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }



    public void updateTeacher(Integer id, Teacher teacher){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("id not found");
        }

        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());

        teacherRepository.save(teacher1);

    }
    public void deleteTeacher(Integer id){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("id not found");
        }
        teacherRepository.deleteById(id);
    }
}
