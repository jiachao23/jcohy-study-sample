package com.jcohy.study.common;

import org.apache.commons.lang3.StringUtils;

public final class AvatarUtil {

    public static String randomAvatar(String prefix, String seed){
        if (StringUtils.isBlank(seed)){
            return null;
        } else {
            return prefix + "t_" + (Math.abs(seed.hashCode()) % 16 + 1) + ".png";
        }
    }
}
