package com.example.app;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.stereotype.Component;

@Component
public class CommandLineArgumentResolver implements ArgumentResolver {

    @Override
    public Argument resolve(String... args) {

        //
        // usage: [command --type=<command type>]
        // -?, --help              [print this message.]
        // -a1, --arg1 <arg>       [arg1 description.]
        // -a2, --arg2 <arg>       [arg2 description.]
        //
        Options options = new Options();
        options.addOption("a1", "arg1", true, "[arg1 description.]");
        options.addOption("a2", "arg2", true, "[arg2 description.]");
        // options.addOption(
        //         Option.builder("t")
        //             .longOpt("type")
        //             .desc("[type description.]")
        //             .hasArg()
        //             .argName("[command type]").build());
        options.addOption("?", "help", false, "[print this message.]");

        try {
            CommandLine cl = new DefaultParser().parse(options, args);

            if (cl.hasOption("?")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("[command --type=<command type>]", options);
            }

            String arg1 = cl.getOptionValue("a1");
            String arg2 = cl.getOptionValue("a2");
            return new Argument(arg1, arg2);

        } catch (ParseException e) {
            e.printStackTrace();
            return new Argument("-", "-");
        }

    }

}
