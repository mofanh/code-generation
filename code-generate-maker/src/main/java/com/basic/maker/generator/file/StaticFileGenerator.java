package com.basic.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成器
 */
public class StaticFileGenerator {
//    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir");
//        File parentFile = new File(projectPath).getParentFile();
//        System.out.println(parentFile);
//        String src = parentFile + File.separator + "code-generate-demo-hub/acm-template" + File.separator + "acm-template";
//        String dest = projectPath;
//        copyFilesByHutool(src, dest);
//    }

    /**
     * 拷贝文件（hutool实现，将输入目录完整拷贝至目标目录下
     *
     * @param src  输入路径
     * @param dest 输出路径
     */
    public static void StaticFileGenerator(String src, String dest) {
        copyFilesByRecursive(src, dest);
    }

    /**
     * 拷贝文件（hutool实现，将输入目录完整拷贝至目标目录下
     *
     * @param src  输入路径
     * @param dest 输出路径
     */
    public static void copyFilesByHutool(String src, String dest) {
        FileUtil.copy(src, dest, false);
    }

    /**
     * 递归拷贝文件（递归实现，会将输入目录完整拷贝到输出目录下）
     *
     * @param src
     * @param dest
     */
    public static void copyFilesByRecursive(String src, String dest) {
        File inputFile = new File(src);
        File outputFile = new File(dest);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 核心思路：先创建目录，然后遍历目录内的文件，依次复制
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是文件还是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目标目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件，直接结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
