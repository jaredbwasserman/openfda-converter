package com.jaredbwasserman.openfda.download;

public class FileDownloadClientFactory {
    public static FileDownloadClient getFileDownloadClient() {
        return new NIOFileDownloadClient();
    }
}
