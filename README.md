1.本文是在 http://www.jianshu.com/p/a3de51e9097d 这篇文章下实现的
2.代码中首先采用作者的做法，使用DemoApplication 存储所有的Activity,
  该做法会占用比较大的内存
3.使用EventBus通知所有的Activity关闭
4.博客中存在一个问题：在BaseActivity中使用Runnable弹出Dialog,会出现闪退
  在OnResume和onPause之间增加一个变量
