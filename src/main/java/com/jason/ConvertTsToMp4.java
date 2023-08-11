package com.jason;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertTsToMp4 {

 /*   public static void main(String[] args) {
        List<File> fileList = getTSFiles("D:\\Download\\OneBuildVideo\\1\\");
        System.out.println(fileList);
        File mp4File = createMP4File("D:\\Download\\OneBuildVideo\\1\\1.mp4");
        mergeTSFiles(fileList,mp4File);
    }*/

    public static List<File> getTSFiles(String folderPath) {
        List<File> tsFiles = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".ts")) {
                tsFiles.add(file);
            }
        }
        return tsFiles;
    }

    public static File createMP4File(String filePath) {
        File mp4File = new File(filePath);
        try {
            mp4File.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mp4File;
    }
    public static void mergeTSFiles(List<File> tsFiles, File mp4File) {
        try (
                FileOutputStream outputStream = new FileOutputStream(mp4File)
        ) {
            for (File tsFile : tsFiles) {
                byte[] buffer = new byte[1024];
                try (FileInputStream inputStream = new FileInputStream(tsFile)) {
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
public static void deleteTSFile(List<File> tsFiles){
    boolean delete =false;
        for (File tsFile : tsFiles){
             delete = tsFile.delete();
        }
if (delete){
    System.out.println("删除TS文件成功");
}
}


}
