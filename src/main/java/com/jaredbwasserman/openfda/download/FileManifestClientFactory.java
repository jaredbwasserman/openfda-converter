package com.jaredbwasserman.openfda.download;

public class FileManifestClientFactory {
    private static SimpleFileManifestClient simpleFileManifestClient = null;

    public static FileManifestClient getFileManifestClient() {
        if (null == simpleFileManifestClient) {
            simpleFileManifestClient = new SimpleFileManifestClient(
                    FileDownloadClientFactory.getFileDownloadClient()
            );
        }
        return simpleFileManifestClient;
    }
}
