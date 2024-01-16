package com.jaredbwasserman.openfda.process;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.ui.MainFrame;

import java.util.List;

public class OpenFDAProcessor {
    public static void process(MainFrame mainFrame,
                               Endpoint endpoint,
                               List<String> inputFilePathStrings,
                               String destinationDirectoryPathString,
                               List<String> selectedFields,
                               List<String> splitFields) {
        final Thread processorThread = new Thread(new OpenFDARunnable(
                mainFrame,
                endpoint,
                inputFilePathStrings,
                destinationDirectoryPathString,
                selectedFields,
                splitFields)
        );
        processorThread.start();
    }
}
