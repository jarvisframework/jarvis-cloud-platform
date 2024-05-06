package com.jarvis.platform.autoconfigure.license.util;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 11:07:59
 */
public class FileUtil {

    public static String readFileContent(String path) {
        String content = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            content = stringBuilder.toString();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return content;
    }

}
