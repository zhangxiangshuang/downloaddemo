package com.jason;

import com.github.kevinsawicki.http.HttpRequest;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static int NO;
    static String URLHEAD;
    static String PATHHEAD;



    public static void main(String[] args) {

        while(true){
            Scanner sc = new Scanner(System.in);
            if(PATHHEAD == null){
                System.out.println("请输入文件保存地址地址：");
                PATHHEAD = sc.next();
            }
            System.out.println("请输入要下载的url地址：");
            String url = sc.next();
            getUrlfrom(url);
            System.out.println(URLHEAD);
            System.out.println(NO);
            //文件保存地址
            // final String PATHHEAD = "D:\\Download\\OneBuildVideo\\";
            int i = 0;
            System.out.println(getUrl(i, URLHEAD));
            System.out.println(getCode(getUrl(i, URLHEAD)));
            if (!getCode(getUrl(i, URLHEAD))) {
                System.out.println("获取下载失败");
            } else {
                while (getCode(getUrl(i, URLHEAD))) {
                    System.out.println("资源url：" + getUrl(i, URLHEAD));
                    System.out.println("获取资源：" + getCode(getUrl(i, URLHEAD)));
                    DownloadFile.downloadFiles(getUrl(i, URLHEAD), getPath(i, PATHHEAD, NO));
                    i++;
                }
                System.out.println("下载结束");
                System.out.println("-------------------------------------------");
                System.out.println("开始合并TS并转换为MP4");
                String tsFilePath = PATHHEAD + "\\" + NO + "\\";
                List<File> tsFiles = ConvertTsToMp4.getTSFiles(tsFilePath);
                String mp4FilePath = tsFilePath + "\\" + NO + ".mp4";
                File mp4File = ConvertTsToMp4.createMP4File(mp4FilePath);
                ConvertTsToMp4.mergeTSFiles(tsFiles, mp4File);
                ConvertTsToMp4.deleteTSFile(tsFiles);
            }
        }



    }

    public static String getUrl(int i, String URLHEAD) {
        // String url = URLHEAD + i + ".ts";
        //return url;
        return URLHEAD + i + ".ts";
    }

    public static String getPath(int i, String PATHHEAD, int NO) {
        String ii = null;
        if (i < 10) {
            ii = "00" + i;
        } else if (i > 9 && i < 100) {
            ii = "0" + i;
        } else {
            ii = String.valueOf(i);
        }
        String path = PATHHEAD + "\\" + NO + "\\" + ii + ".ts";
        return path;
    }

    public static boolean getCode(String url) {
        int body = HttpRequest.get(url).code();
        return body == 200;
    }

    public static void getUrlfrom(String url) {
        int index = url.indexOf("/index");
        int i = url.lastIndexOf("/", index - 1);
        int last = url.lastIndexOf("/");
        NO = Integer.parseInt(url.substring(i + 1, index));
        URLHEAD = url.substring(0, last + 1);
    }

}
