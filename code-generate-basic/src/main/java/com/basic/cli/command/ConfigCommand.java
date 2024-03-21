package com.basic.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.basic.model.MainTemplateConfig;
import picocli.CommandLine;

import java.io.File;
import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        for(Field field : fields){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }
}
