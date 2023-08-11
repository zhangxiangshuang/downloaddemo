package com.jason;

import com.github.kevinsawicki.http.HttpRequest;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
 /*   //集数
    public static final int NO=4;
    public static final String NOS="1224375653";
    public static String urlhead1="https://v3.kjjl100.com/kz/2023/jg/1j/gcjjwsn/jcjj/";
    //抓包的url地址
    public static final String URLHEAD = urlhead1+NO+"/index/hls/"+NOS+"/112089/";
    //文件保存地址
    public static final String PATHHEAD = "D:\\Download\\OneBuildVideo\\";*/


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入第几集：");
        int NO = sc.nextInt();
        System.out.println("你输入的是："+NO);
        System.out.println("--------------------------------------------");
        System.out.println("请输入第"+NO+"集对应的代码：");
        long NOS = sc.nextLong();
        System.out.println("你输入的代码是："+NOS);

        //public static final int NO=4;
        //public static final String NOS="1224375653";
        String urlhead1="https://v3.kjjl100.com/kz/2023/jg/1j/gcjjwsn/jcjj/";
        //抓包的url地址
         final String URLHEAD = urlhead1+NO+"/index/hls/"+NOS+"/112089/";
        //文件保存地址
         final String PATHHEAD = "D:\\Download\\OneBuildVideo\\";

        int i = 1;
        System.out.println(getUrl(i,URLHEAD));
        System.out.println(getCode(getUrl(i,URLHEAD)));
        while (getCode(getUrl(i,URLHEAD))) {
            System.out.println(getUrl(i,URLHEAD));
            System.out.println(getCode(getUrl(i,URLHEAD)));
            DownloadFile.downloadFiles(getUrl(i,URLHEAD), getPath(i,PATHHEAD,NO));
            i++;
        }
        System.out.println("下载完成");
    }

    //  String url="https://v3.kjjl100.com/kz/2023/jg/1j/gcjjwsn/jcjj/1/index/hls/1224375649/112089/210.ts";
    //  String path="D:\\Download\\OneBuildVideo\\210.ts";


    //int body = HttpRequest.get("https://v3.kjjl100.com/kz/2023/jg/1j/gcjjwsn/jcjj/1/index/hls/1224375649/112089/212.ts").code();
    // System.out.println(body);
    // System.out.println( "Hello World!" );

    public static String getUrl(int i,String URLHEAD) {
        String url = URLHEAD + i + ".ts";
        return url;
    }

    public static String getPath(int i,String PATHHEAD,int NO) {
        String ii = null;
        if(i<10)
        {
             ii="00"+i;
        } else if (i>9 && i<100){
             ii="0"+i;
        }else {
            ii=String.valueOf(i);
        }
        String path = PATHHEAD +"\\"+NO+"\\"+ ii + ".ts";
        return path;
    }

    public static boolean getCode(String url) {
        int body = HttpRequest.get(url).code();

        if (body == 200) {
            return true;
        } else {
            return false;
        }
    }
}
