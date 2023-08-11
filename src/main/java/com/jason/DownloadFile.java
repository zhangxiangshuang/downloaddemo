package com.jason;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.*;

/**
 * @author Jason
 * @version 1.0
 * @ClassName DownloadFile
 * @Description TODO
 * @createTime 2023年08月10日 23:06:00
 */
public class DownloadFile {

    public static  void downloadFiles(String fileUrl,String filePath){
       // String fileUrl = "https://example.com/file.zip";
        // 定义要保存的文件的路径
       // String filePath = "D:\\Download\\OneBuildVideo/file.zip";
        // 创建URL对象
        {
            try {
                URL url = new URL(fileUrl);
                File file = new File(filePath);
                copyURLToFile(url, file);
                System.out.println("下载成功");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}