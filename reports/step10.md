# 实验报告
#### 计81 陈雨翔 2018011295
## 任务概述
1. 改进语法
2. 加入GloaInfo，记录全局变量的信息，在汇编的开头旧直接完成对全局变量的内存分配
## 遇到的问题
GlobalDecl一样会被递归到declaration，尝试通过nameInfo获得Variable。但是全局变量不属于任何一个函数的栈帧，不在nameInfo._v中，所以不能通过nameInfo._v进行查找，这里出了KeyError。解决方法也很简单。因为全局变量所有的信息都在Namer生成nameInfo时保存在了nameInfo.globs中了，所以不需要第二遍解析GlobalDecl，让visitGlobalDecl直接pass即可解决问题。
## 思考题
非常简短，比局部变量方便
```mips
    la t0,a
```