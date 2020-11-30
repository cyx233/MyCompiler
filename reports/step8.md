# 实验报告
#### 计81 陈雨翔 2018011295
## 任务概述
1. 改进语法
2. LabelManager实现对break与continue的支持。需要记录IRVisitor目前解析节点的外层循环的状态，在IRVisitor调用break，continue时给出正确的Label。
3. 由于Statment的形式变得多样，用if-else显得非常臃肿。重构Minidecaf.g4，大部分选择支都进行命名，同时修改IRVisitor。
## 遇到的困难
和if的那一步很像，实验指导同样非常的详细。虽然比较复杂，但是照着实验指导做，思考难度显著降低。主要的时间在重构上。
## 思考题
### 第一题
从我生成汇编的方法统计

|IR标记|汇编指令|汇编指令条数|
|-----|-------|----------|
|Beqz|lw t1,0(sp); addi sp,sp,4; beqz t1,LABEL| 3|
|Goto|j LABEL(等价于beqz x0,LABEL,|1|

可以看到，第一种方法Beqz一次，Goto一次，共4条指令。
第二种方法Beqz一次，Bnez（虽然没有实现，但是应该指令条数和Beqz相同）一次，共6条指令。

显然第一种方法比较好。
