package com.anshun.mtasweb.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mtasflash Created on 2022-04-29 15:15
 */
@Getter
@Setter
@NoArgsConstructor
public class ResultMsg {

    private boolean success = true;

    private String msg = "操作成功";

    private Integer code = 0;

    private Object data;

    public ResultMsg(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
        this.code = success ? 0 : 1;
    }

    public static ResultMsg ok() {
        return new ResultMsg();
    }

    public static ResultMsg ok(String msg) {
        return new ResultMsg(msg, true);
    }

    public static ResultMsg fail() {
        return new ResultMsg("操作失败", false);
    }

    public static ResultMsg fail(String msg) {
        return new ResultMsg(msg, false);
    }

}
