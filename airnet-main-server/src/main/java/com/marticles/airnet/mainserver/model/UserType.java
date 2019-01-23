package com.marticles.airnet.mainserver.model;

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
     *
     * @author Marticles
     * @date 2019/1/21
     */
    public static Integer USER_ADMIN = 0;
    public static Integer USER_COMMON = 1;
}
