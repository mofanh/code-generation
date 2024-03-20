package com.basic.generator;

import com.basic.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("LBJ");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("LBJ`s output");

        doGenerate(mainTemplateConfig);
    }

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        System.out.println(parentFile);

        String inputStaticDirPath = new File(parentFile, "code-generate-demo-hub\\acm-template" + File.separator + "acm-template").getAbsolutePath();
        String outputStaticDirPath = projectPath;

//        静态文件生成
        StaticGenerator.copyFilesByRecursive(inputStaticDirPath, outputStaticDirPath);

//        动态文件生成
        String inputDynamicFilePath = projectPath + File.separator + "src\\main\\resources\\templete\\MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template\\src\\com\\yupi\\acm\\MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
