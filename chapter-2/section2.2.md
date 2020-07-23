---
description: '不多说了，看着C#，眼泪流了出来。'
---

# 2.2 jni设计

## 2.1.1 jni好麻烦

java的jni是真的难用。

或许写惯了的人会说这有啥难用的，但是我举个例子给你，去看看这个项目：

{% embed url="https://github.com/nxrighthere/ValveSockets-CSharp" %}

这个项目做的事情是给valve（对，就是steam那个valve）出的一个通讯协议dll/so做一个c\#封装。

看完自己想想如果让你用Java做一下类似的工作，会是个什么代码量。

请考虑你输出的jar至少需要支持windows，windows64，Linux（debian），macos。

## 2.2.1 解决方法

### 2.2.1.1 Java下一步可以怎么做/你做一个新语言的时候可以怎么做

这方面真的不能去学学C\#吗，秋梨膏！

本来想讲点啥的，后来转念一想，听我搁着叨逼叨，真不如让你们自己对着C\#好好看，好好学（抄），所以干脆不讲了！

### 2.2.1.2 对于使用Java的人现在可以怎么做

可以考虑看看这个库：

{% embed url="https://github.com/libgdx/gdx-jnigen" caption="https://github.com/libgdx/gdx-jnigen" %}

相关视频：

{% embed url="https://www.youtube.com/watch?v=N2EE\_jlDfrM" caption="https://www.youtube.com/watch?v=N2EE\_jlDfrM" %}

当然也可以选择用类似的思想自己做一套。

作为一个凑合方案来说已经至少可用了。

