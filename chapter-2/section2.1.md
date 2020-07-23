---
description: public，private，default，protected……这都啥玩意啊。
---

# 2.1 访问权限设计

## 2.1.1 当前访问权限设计存在的问题

你知道啥是public，private，protected，default都是啥对吧，我不觉得这边有必要再解释一遍。

protected在当前类，当前package和子类中可以使用，在其他package中不能使用。

default在当前类和当前package中可以使用，在子类和其他package中不能使用。

但是，经常的，我们需要的其实是在当前类和子类中可以使用，在当前package和其他package中不能使用。

经常的，我们也会需要某个类在某些package中（并不只是在当前package，而是一系列package，通常是一个父package下的所有子package）可以使用，而在其他package中不可以使用。（当然似乎jigsaw能一定程度上解决这个问题，但是我憎恶jigsaw——有关jigsaw的嘲讽放在更后面）。

此外，有时候我们会需要某个field读权限和写权限分别设置。例如，我们会需要一个field的写权限为protected，读权限为public，那么在当前的java中是无法做到的，我们只能创建两个函数分别进行读写该变量的操作，并分别设置这两个函数的访问权限，以间接达到此目的。

## 2.1.2 解决方案

上面提到的这些问题其实有很多的解决方法。在尝试构建新语言时，读者们可以试一试下面几个方法，或者想一个新的，但是请务必吸取Java的教训。

### 2.1.2.1 对于“在当前类和子类中可以使用，在其他package中不能使用”的需求

事实上，Java当前的访问权限可以分为四块，即当前类是否可用，当前package是否可用，子类是否可用，其他package是否可用。

那其实我们用每一位二进制数字代表一个权限是否允许，用总数字代表访问权限，不就完事了吗。

这个解决方案是可行的，至少很少有linux用户会抱怨linux的文件权限设置。

### 2.1.2.2 对于“某个类在某些package中”的需求

对于每个类，首先，维护一个允许使用它的package列表。

列表中的每一项包含：1.该package名称。2.一个boolean值，true代表允许这个package的所有子package使用这个类，false代表只允许该package使用这个类，而不允许其子package使用这个类。

当然，这个解决方案如果真的要施行的话，要做一些性能上的考量。

