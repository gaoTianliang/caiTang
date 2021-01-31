package com.code.core.base.file;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserParent implements Serializable {
    private String parent;

    private void readObjectNoData() {
        System.out.println("============readObjectNoData:UserParent=============");
        this.parent = "parent";
    }
}
