package com.jaredbwasserman.openfda.process;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.excel.ExcelWriter;
import com.jaredbwasserman.openfda.excel.ExcelWriterFactory;
import com.jaredbwasserman.openfda.ui.MainFrame;
import com.jaredbwasserman.openfda.util.FileUtil;

import java.util.List;

class OpenFDARunnable implements Runnable {
    private final MainFrame mainFrame;
    private final Endpoint endpoint;
    private final List<String> inputFilePathStrings;
    private final String destinationDirectoryPathString;
    private final List<String> selectedFields;
    private final List<String> splitFields;

    private final EndpointDownloadClient endpointDownloadClient;
    private final ExcelWriter excelWriter;

    private int progress;

    public OpenFDARunnable(MainFrame mainFrame,
                           Endpoint endpoint,
                           List<String> inputFilePathStrings,
                           String destinationDirectoryPathString,
                           List<String> selectedFields,
                           List<String> splitFields) {
        this.mainFrame = mainFrame;
        this.endpoint = endpoint;
        this.inputFilePathStrings = inputFilePathStrings;
        this.destinationDirectoryPathString = destinationDirectoryPathString;
        this.selectedFields = selectedFields;
        this.splitFields = splitFields;
        endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        excelWriter = ExcelWriterFactory.getExcelWriter();
        progress = 0;
    }

    @Override
    public void run() {
        mainFrame.setProcessingLabelText("Starting");
        sleep();
        completeStep();

        // Get input files
        List<String> filePathStrings;
        boolean isDownload;
        if (!inputFilePathStrings.isEmpty()) {
            mainFrame.setProcessingLabelText("Checking files...");
            sleep();
            filePathStrings = inputFilePathStrings;
            isDownload = false;
        } else {
            mainFrame.setProcessingLabelText("Downloading files...");
            filePathStrings = endpointDownloadClient.downloadAndUnzipEndpointFiles(
                    endpoint,
                    destinationDirectoryPathString
            );
            isDownload = true;
        }
        completeStep();

        // Write to Excel
        mainFrame.setProcessingLabelText("Writing to Excel...");
        final List<String> workbookPath = excelWriter.writeWorkbooks(
                selectedFields,
                splitFields,
                filePathStrings,
                destinationDirectoryPathString,
                endpoint.getCamelCaseName()
        );
        completeStep();

        // Clean up
        mainFrame.setProcessingLabelText("Cleaning up...");
        if (isDownload) {
            filePathStrings.forEach(FileUtil::deleteFile);
        }
        sleep();
        completeStep();

        // Done
        mainFrame.setProcessingLabelText("Done");
        sleep();

        // Reset
        mainFrame.setProcessingLabelText(String.format("Output file(s): %s", workbookPath.get(0))); // TODO: Fix when more than one workbook can be returned
        sleep();
        sleep();
        sleep();
        mainFrame.updateProcessingProgress(0, 1);
        mainFrame.setProcessingLabelText("");
        mainFrame.setProcessingEnabled(true);
    }

    private void completeStep() {
        mainFrame.updateProcessingProgress(++progress, 4);
    }

    private void sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignored) {
        }
    }
}
