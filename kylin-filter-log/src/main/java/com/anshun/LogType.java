package com.anshun;

import lombok.Getter;

/**
 * @author mtasflash Created on 2023/3/16 20:41
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
public enum LogType {
    WAIN("WAIN"),
    ERROR("ERROR"),
    ;
    private final String type;

    LogType(String type) {
        this.type = type;
    }
}
