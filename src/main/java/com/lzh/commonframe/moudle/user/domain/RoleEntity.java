package com.lzh.commonframe.moudle.user.domain;

import lombok.Data;

import java.security.Permission;
import java.util.List;

@Data
public class RoleEntity {

    private String id;

    private String roleName;

    private String userId;

}
