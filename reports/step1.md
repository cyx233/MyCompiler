# 实验报告
#### 计81 陈雨翔 2018011295
## 任务概述
1. 编写语法词法分析。我选择了使用ANTLR工具。
2. IR的生成，IR标记仅需Const与Ret，Commend用作输出注释
3. ASM汇编代码的生成，仅需Ret与Const两个标识

## 遇到的困难
读示例代码花了很多时间才捋顺不同对象的关系
### main
主函数
1. 读入文件
2. 通过Lexer生成lex
3. 通过Parser，传入lex，生成语法分析树cst
4. 通过Namer，传入cst，生成名称解析信息nameInfo
5. 通过Typer，传入cst，nameInfo，生成类型解析信息typeInfo
6. 通过IRGen，传入cst，nameInfo，typeInfo，生成中间码IR
7. 通过AsmGen，传入IR，生成最终汇编代码

由于本步仅需实现return，所以只需要1,2,3,6,7步。

### IRGen
StackGen是逻辑部分，visitor设计模式，解析语法树。这里只需要解析Integer与Ret节点即可。
Integer节点解析为Const命令，Ret节点解析为Ret命令。

IREmitter负责整理IR栈，现在只需要整理func，同时判断是否名称是main即可。也就是直接生成
main函数对应的IR指令队列。

### AsmGen
visitor设计模式，依次翻译各个函数，依次翻译IR指令。在进入函数前，设置栈帧，退出函数后，回收栈帧。其实现在不需要栈帧，但还是先借鉴放着了。

## 思考题
### 第一题
修改 minilexer 的输入（lexer.setInput 的参数），使得 lex 报错，给出一个简短的例子。

答：
在任意位置加入中文字符。例如
```c++
int main() { 
     return 123;
     报错
}         
```
得到输出
```
token kind   text                
-----------  ------------------- 
Int          int                 
Identifier   main                
Lparen       (                   
Rparen       )                   
Lbrace       {                   
Return       return              
Integer      123                 
Semicolon    ;                   
Traceback (most recent call last):
  File "minilexer.py", line 95, in <module>
    dumpLexerTokens(default())
  File "minilexer.py", line 90, in dumpLexerTokens
    for tok in lexer.lex():
  File "minilexer.py", line 45, in lex
    raise Exception(f"lex error at input position {self.pos}")
Exception: lex error at input position 45
```
### 第二题
修改 minilexer 的输入，使得 lex 不报错但 parser 报错，给出一个简短的例子。

答：
只要词法不错误，但是不符合语法的产生式即可。如下
```c++
int int main() {    
  return 123;
}               
```
得到lexer输出
```
token kind   text                
-----------  ------------------- 
Int          int                 
Int          int                 
Identifier   main                
Lparen       (                   
Rparen       )                   
Lbrace       {                   
Return       return              
Integer      123                 
Semicolon    ;                   
Rbrace       }       
```
以及parser报错
```
Traceback (most recent call last):
  File "miniparser.py", line 71, in <module>
    print(default().parse("program"))
  File "miniparser.py", line 45, in parse
    children.append(self.parse(child))
  File "miniparser.py", line 42, in parse
    raise Exception(f"syntax error, {child} expected but {tok.kind.name} found")
Exception: syntax error, Identifier expected but Int found
```

### 第三题
在 riscv 中，哪个寄存器是用来存储函数返回值的？

答：
a0

## 代码复用
- 参考实现的makefile
- 参考实现中的框架结构,包括visitor,IR generator和ams generator的部分内容
- 祖传CommonLex.g4
