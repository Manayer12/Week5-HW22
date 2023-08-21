package com.example.schoolw5.Controller;

import com.example.schoolw5.Api.ApiResponse;
import com.example.schoolw5.Dto.TeacherDTO;
import com.example.schoolw5.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid TeacherDTO teacherDTO){
       addressService.addAddress(teacherDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable  Integer id,@RequestBody @Valid TeacherDTO teacherDTO){
        addressService.updateAddess(id,teacherDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted"));
    }



}
