package com.demo.userservice.service;

import com.demo.userservice.departmentwrapper.Department;
import com.demo.userservice.departmentwrapper.ResponseTemplateUserDepartment;
import com.demo.userservice.repository.UserRepository;
import com.demo.userservice.entity.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private RestTemplate restTemplate;

    public CustomUser addUser(CustomUser CustomUser) {
        log.info("In addUser");
        return UserRepository.save(CustomUser);
    }

    public CustomUser getUser(Long id){
        log.info("In getUser by Id: " + id);
        return UserRepository.findUserByUserId(id);
    }

    public ResponseTemplateUserDepartment getUserWithDepartment(Long id) {
        ResponseTemplateUserDepartment retVal  = new ResponseTemplateUserDepartment();
        CustomUser lCustomUser = UserRepository.findUserByUserId(id);
        log.info("Found User: " + lCustomUser);
        Department ldepartment = restTemplate.getForObject( "http://DEPARTMENT-SERVICE/departments/getDept/"+ lCustomUser.getDepartmentId(), Department.class);
        log.info("Found Department: "+"With DepartmentId" + lCustomUser.getDepartmentId() + " " +ldepartment);
        retVal.setCustomUser(lCustomUser);
        retVal.setDepartment(ldepartment);
        return retVal;

    }

    public List<CustomUser> getAllUsers() {
        log.info("In getAllUsers");
        return UserRepository.findAll();
    }
}
