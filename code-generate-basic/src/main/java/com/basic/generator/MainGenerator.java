package com.basic.generator;

import com.basic.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("LBJ112");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("LBJ`s output");

        doGenerate(mainTemplateConfig);
    }

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile().getParentFile();
        System.out.println(parentFile);

        String inputStaticDirPath = new File(parentFile, "code-generate-demo-hub\\acm-template" + File.separator + "acm-template").getAbsolutePath();
        String outputStaticDirPath = projectPath;

//        静态文件生成
        StaticGenerator.copyFilesByRecursive(inputStaticDirPath, outputStaticDirPath);

//        动态文件生成
        File projectPathD = new File(projectPath).getParentFile(); // 由于jar包的位置变换所以打的补丁
        String inputDynamicFilePath = projectPathD + File.separator + "src\\main\\resources\\templete\\MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPathD + File.separator + "acm-template\\src\\com\\yupi\\acm\\MainTemplate.java";
        System.out.println("in:" + inputDynamicFilePath);
        System.out.println("out:" + outputDynamicFilePath);
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
