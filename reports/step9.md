# 实验报告
#### 计81 陈雨翔 2018011295
## 任务概述
1. 改进语法
2. Namer实现函数名称的解析，即加入FuncNameInfo。在之前分析过Namer完整的结构。
## 遇到的困难
整体上不算复杂，只是在获取Variable前，多一层获得具体函数FuncNameInfo即可。

但是failcases出了挺多问题。因为示例代码关于函数的检查一部分在Typer中，比如关于参数列表的检查。而我还没有实现Typer。所以暂时位于Namer中检测语义错误，将来步骤实现Typer后再重构。
## 思考题
```c++
int add(int a,int b){
    return a+b;
}

int main(){
    int a=0;
    int b=0;
    return add(b=a+1,a=1+2);
}
``` 
根据我写打代码，返回值为7

```c++
int add(int a,int b){
    return a+b;
}

int main(){
    int a=0;
    int b=0;
    return add(a=1+2,b=a+1);
}
```
根据我写的代码，返回值为4

由此可见，如果参数的表达式有副作用，参数的求值顺序是未定义行为。