package com.jaredbwasserman.openfda.util;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void deleteFile(@NonNull File file) {
        try {
            if (file.delete()) {
                logger.info(
                        "Successfully deleted file {}",
                        file
                );
            }
        } catch (Exception exception) {
            logger.warn(
                    "Could not delete file {}",
                    file,
                    exception
            );
        }
    }

    public static void deleteFile(@NonNull String filePathString) {
        deleteFile(new File(filePathString));
    }
}
