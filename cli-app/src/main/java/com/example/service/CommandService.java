package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;

public abstract class CommandService implements CommandLineRunner {

    @Autowired
    ArgumentResolver argumentResolver;

    Argument argument;

    @Override
    public final void run(String... args) {
        init(args);
    }

    private void init(final String... args) {

        // @ConditionalOnPropertyにて指定している"type"を除去してから
        // コマンド引数解析を実施
        List<String> argList = new ArrayList<String>();
        for (String arg : args) {
            if (!arg.startsWith("--type=")) {
                argList.add(arg);
            }
        }

        argument = argumentResolver.resolve(argList.toArray(new String[argList.size()]));
    }

    public abstract void execute();
}
