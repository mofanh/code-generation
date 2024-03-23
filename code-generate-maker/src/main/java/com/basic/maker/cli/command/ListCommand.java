package com.basic.maker.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", description = "查看待生成文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        File parentPath = new File(projectPath).getParentFile();
        String inputPath = new File(parentPath, "code-generate-demo-hub/acm-template/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for(File file : files) {
            System.out.println(file);
        }
    }
}
