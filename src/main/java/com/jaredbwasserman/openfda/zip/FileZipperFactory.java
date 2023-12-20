package com.jaredbwasserman.openfda.zip;

public class FileZipperFactory {
    private static SimpleFileZipper simpleFileZipper = null;

    public static FileZipper getFileZipper() {
        if (null == simpleFileZipper) {
            simpleFileZipper = new SimpleFileZipper();
        }
        return simpleFileZipper;
    }
}
