package com.demo.userservice.departmentwrapper;

import com.demo.userservice.entity.CustomUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateUserDepartment {
    private CustomUser customUser;
    private Department department;
}
