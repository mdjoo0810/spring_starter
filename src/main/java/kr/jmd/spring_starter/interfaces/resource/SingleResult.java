package kr.jmd.spring_starter.interfaces.resource;

import lombok.Data;

@Data
public class SingleResult<T> extends CommonResult {

    private T data;

}
