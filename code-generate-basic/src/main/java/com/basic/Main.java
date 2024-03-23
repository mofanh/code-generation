package com.basic;

import com.basic.cli.CommandExecutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-o", "-a"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}