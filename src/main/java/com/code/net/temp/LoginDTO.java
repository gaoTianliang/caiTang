package com.code.net.temp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {
    @ApiModelProperty("js_code")
    private String code;
    @ApiModelProperty("username")
    private String username;
    @ApiModelProperty("password")
    private String password;
}
