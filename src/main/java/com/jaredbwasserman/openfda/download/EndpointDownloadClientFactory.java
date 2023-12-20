package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.zip.FileZipperFactory;

public class EndpointDownloadClientFactory {
    private static ForkJoinEndpointDownloadClient forkJoinEndpointDownloadClient = null;

    public static EndpointDownloadClient getEndpointDownloadClient() {
        if (null == forkJoinEndpointDownloadClient) {
            forkJoinEndpointDownloadClient = new ForkJoinEndpointDownloadClient(
                    FileManifestClientFactory.getFileManifestClient(),
                    FileDownloadClientFactory.getFileDownloadClient(),
                    FileZipperFactory.getFileZipper()
            );
        }
        return forkJoinEndpointDownloadClient;
    }
}
