package com.basic.maker.model;

import lombok.Data;

@Data
public class DataModel {
    /*
     * 1. 在代码开头增加作者
     * 2. 修改程序的可输出信息
     * 3. 将循环设置为可选*/
    private String author = "LBJ";
    private String outputText = "end:";
    private boolean loop = true;
}
