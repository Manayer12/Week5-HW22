package com.example.schoolw5.Service;

import com.example.schoolw5.Api.ApiException;
import com.example.schoolw5.Dto.TeacherDTO;
import com.example.schoolw5.Model.Address;
import com.example.schoolw5.Model.Teacher;
import com.example.schoolw5.Repoository.AddressRepostory;
import com.example.schoolw5.Repoository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepostory addressRepostory;
    private final TeacherRepository teacherRepository;

    public void addAddress(TeacherDTO teacherDTO){
        Teacher teacher=teacherRepository.findTeacherById(teacherDTO.getTeacher_id());

        if (teacher == null){
            throw new ApiException("id is null");
        }
        Address address=new Address(null,teacherDTO.getArea(),teacherDTO.getStreet(),teacherDTO.getBuildingNumber(),teacher);
        addressRepostory.save(address);
    }


    public void updateAddess(Integer id,TeacherDTO teacherDTO){
        Address address=addressRepostory.findAddressById(id);
        if(address==null){
            throw new ApiException("id not found");
        }
        address.setArea(teacherDTO.getArea());
        address.setStreet(teacherDTO.getStreet());
        address.setBuildingNumber(teacherDTO.getBuildingNumber());
        addressRepostory.save(address);

    }

    public void deleteAddress(Integer id){
        Address address=addressRepostory.findAddressById(id);
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(address == null || teacher == null){
            throw new ApiException("id not found");
        }

        addressRepostory.deleteAllByIdInBatch(Collections.singleton(id));
    }
}
