package com.basic.maker.cli;

import com.basic.maker.cli.command.ConfigCommand;
import com.basic.maker.cli.command.GenerateCommand;
import com.basic.maker.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "CE", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this).
                addSubcommand(new ConfigCommand()).
                addSubcommand(new GenerateCommand()).
                addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入命令");
    }

    /*
    * 执行命令
    *
    * @param args*/
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
