---
description: public的，final的，并且可修改的。每天都用的。简直糟透了。
---

# 1.2 final变量问题

从你第一天学习Java，我的朋友，从你的第一本入门书籍的正文的前20行，某个语句就像鬼上身了一样缠绕着你，在很久以后或许你会通过一些Log库（比如log4j或者slf4j）来试图摆脱他，但是这条语句依旧会出现在你的每一天的每一小时中。

这条该死的语句就是System.out.println\(\)。

很明显out是一个public变量。并且我们也很容易知道out也是一个final变量。

那么问题来了：为什么System类中存在下图这个函数：

```text
public static void setOut(PrintStream out) {
```

？

## 1.2.1 第一个问题：他们是怎么做到的？

答案很简单：是native！他们加了native！

setOut函数内部调用了一个名为setOut0的内部函数，该函数为一个native函数，用native代码强行草下来了System类的final变量out。

事实上这次他们没有太过分，至少，普通用户如果想要实现类似效果，是可以做到的。

## 1.2.2 第二个问题：这个做法有什么问题？

这个做法的问题在于native实际上是挺沉的。

另外，这也太丑了点吧。

## 1.2.3 第三个问题：为什么要这么做？

我也想知道这个问题的答案，因为这个设计使得out的final像脱了裤子放屁一样毫无意义可言。

如果哪位读者知道答案，请发来让我长长见识。

## 1.2.4 解决方法

### 1.2.4.1 暴躁老哥的做法：去你妈的final

不管是从定义上还是从常识上来说，一个可以被修改的变量都不应该有final修饰符。

那么，我们只要把System.out的final给他摘了不就完事了。

这个解决方法很明显是可行的。

这个方法的唯一问题大概是，可能会被写Effective Java的那个老哥喷一顿。

### 1.2.4.1 正常人的做法：使用正常人都会使用的面向对象编程模式

```text
    private static PrintStream out = null;

    public static PrintStream getOut() {
        return out;
    }

    public static void setOut(PrintStream printStream) {
        out = printStream;
    }
```

当然这边只是讲讲思路，想要加点花活啥的请便，比如要加同步的话，或者要加checkPermission setIO啥的，我觉得也不用我啰嗦怎么加，在座的各位都会，自己加上就是。

这样带来的一个问题就是，原本的System.out.println\(\)会变成System.getOut\(\).println\(\).

奇怪的语句变正常了但是变长了!

### 1.2.4.1 肝不错的正常人的做法

既然你又要面向对象，又要简洁，那想来想去我们只能多搞些short-cut了。

JOJO！我不做人了！

把PrintStream的所有常用的public方法都创建一个代理函数如下：

```text
    private static PrintStream out = null;

    public static PrintStream getOut() {
        return out;
    }

    public static void setOut(PrintStream printStream) {
        out = printStream;
    }

    public static void println(long x) {
        out.println(x);
    }
```

当然不止这一个当然这是个挺烦躁的过程，但是写库不就是这样吗。

最终结果的话，既能实现之前的所有功能，又不违背final的语义，并且还会使print语句变得更短。（从System.out.println变成System.println\(\)）

唯一的问题是，System中并不只有out一个PrintStream。所以对于err，我们也可以相应的做一套代理，函数名改为errPrintln\(\)就行了。

当然，为了一致性与公平性，我们也可以把上面的代理函数名字统统改为outPrintln\(\)。



