package com.example.schoolw5.Repoository;

import com.example.schoolw5.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepostory extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);


//    @Query("delete  from Address a where a.id in (1,2,3,4,5,6,7,8,9)")
//    Address deleteadd(Integer id);
}
