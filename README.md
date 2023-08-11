# downloaddemo
下载争学网视频软件使用介绍
1、打开相应的视频然后按F12打开开发者工具，点击网络-Fetch/XHR/找到后缀为ts的记录，
![image](https://github.com/zhangxiangshuang/downloaddemo/assets/49675605/50dbf476-1f21-4a15-a8f2-fa3d9e863929)
2、点击后查看请求URL，记录标记的数据，左边框选的是集数 ，此图中是第1集，右边框选的是此集对应的代码，如图所示第1集 对应的是 1224375649
注意：每集的数值都不一样，需要挨个进行抓包
![抓包截图](https://github.com/zhangxiangshuang/downloaddemo/assets/49675605/d3f21907-cd59-4540-be82-243b65fdbc99)

3、点击startdown.bat 打开下载程序，依次输入第二步中的 集数和对应的代码
![image](https://github.com/zhangxiangshuang/downloaddemo/assets/49675605/d6c6e963-f8cb-4218-9958-a332aa26e7ef)

4、视频默认下载的路径是D:\Download\OneBuildVideo ，下载路径目前无法修改！
![image](https://github.com/zhangxiangshuang/downloaddemo/assets/49675605/0bcbd2a9-cf8e-418f-936a-b66ca6f8fe6a)
