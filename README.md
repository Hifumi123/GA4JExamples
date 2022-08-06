# GA4J Examples

[GA4J](https://github.com/Hifumi123/GA4J) 的示例工程。

## 示例列表

### De Jong 函数 F1 的最小值

f1(x1, x2, x3) = x1^2 + x2^2 + x3^3

-5.12 <= xi <= 5.12 (i = 1, 2, 3)

### De Jong 函数 F2（Rosenbrock 函数）的最大值

f(x1, x2) = 100 * (x1^2-x2)^2 + (1 - x1)^2

-2.048 <= xi <= 2.048 (i = 1, 2)

## 开发环境

* Java 8
* Eclipse 2020-06 (4.16.0)
* Maven 3.6.3

## 依赖

依赖 [GA4J](https://github.com/Hifumi123/GA4J) 和 [Apache Commons CSV](https://commons.apache.org/proper/commons-csv)，见 POM 文件。

## 更新记录

### 0.1.0

第一版，包含两个对应 GA4J 0.1.0 版本的示例。