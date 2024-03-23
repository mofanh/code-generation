package com.basic.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.basic.generator.MainGenerator;
import com.basic.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable {
    /*
     * 1. 在代码开头增加作者
     * 2. 修改程序的可输出信息
     * 3. 将循环设置为可选*/

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true)
    private String author = "LBJ";
    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true)
    private String outputText = "end:";
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true)
    private boolean loop = true;

    @Override
    public Object call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println(author + ":" + outputText + ":" + loop);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
