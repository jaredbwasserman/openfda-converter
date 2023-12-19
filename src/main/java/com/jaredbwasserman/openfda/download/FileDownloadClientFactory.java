package com.jaredbwasserman.openfda.download;

public class FileDownloadClientFactory {
    private static NIOFileDownloadClient nioFileDownloadClient = null;

    public static FileDownloadClient getFileDownloadClient() {
        if (null == nioFileDownloadClient) {
            nioFileDownloadClient = new NIOFileDownloadClient();
        }
        return nioFileDownloadClient;
    }
}
