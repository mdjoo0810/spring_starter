package kr.jmd.spring_starter.interfaces.resource;

import lombok.Data;

@Data
public class CommonResult {

    private boolean success;

    private int code;

    private String msg;

}
