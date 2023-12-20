package com.jaredbwasserman.openfda.download;

public class EndpointDownloadClientFactory {
    private static ForkJoinEndpointDownloadClient forkJoinEndpointDownloadClient = null;

    public static EndpointDownloadClient getEndpointDownloadClient() {
        if (null == forkJoinEndpointDownloadClient) {
            forkJoinEndpointDownloadClient = new ForkJoinEndpointDownloadClient(
                    FileManifestClientFactory.getFileManifestClient(),
                    FileDownloadClientFactory.getFileDownloadClient()
            );
        }
        return forkJoinEndpointDownloadClient;
    }
}
