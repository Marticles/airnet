package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description UserType
 * @date 2019/1/21
 */
@Data
public class UserType {
    /**
     * 0 管理员
     * 1 普通用户
     * 2 高级用户
     * 3 游客
     *
     * @author Marticles
     * @date 2019/1/21
     */
    public static Integer USER_ADMIN = 0;
    public static Integer USER_COMMON = 1;
    public static Integer USER_SENIOR = 2;
    public static Integer USER_VISITOR = 3;
}
