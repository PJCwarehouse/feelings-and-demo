## linux运行新项目
切记要到服务器的防火墙中打开使用的端口，否则浏览器访问不到

## Linux切换用户
su - root
root 用户密码：123456
ubuntu 用户密码：whitenight...123456
先切换到root用户，再切换到ubuntu用户
使用 "ubuntu" 用户： 如果您有 "ubuntu" 用户的密码，您可以直接切换到 "ubuntu" 用户。
su - ubuntu
cd ubuntu


## 运行mysql
常用命令：
连接服务器mysql -u root -p
密码就是数据库密码:12345678
之后操作后面加“;”，不然系统不知道命令已经完成
常用命令：https://www.dbs724.com/391589.html

## 在云服务器上后台运行进程
如果在云服务器上运行了一个Java项目的JAR文件，并且希望在后台持续运行而不受终端会话的影响，可以使用一些工具来实现这一目标。以下是一种常见的做法：

使用 nohup 命令：
nohup 命令允许在后台运行进程，即使终端会话结束，该进程仍将继续运行。下面是一个使用 nohup 的示例：

nohup java -jar your_project.jar --server.port=8081 &
            这里替换为需要运行的jar包
nohup: 启动命令，使其在后台运行。
java -jar your_project.jar: 启动Java项目的命令。
--server.port=8081 设置启动的端口（这里因为xshell调试的时候使用的是8080端口，所以在云服务器就使用8081，使得在同一个电脑上运行不会冲突）
&: 将进程放入后台运行。

此命令将Java项目作为一个后台进程运行，关闭终端后该进程仍然会继续运行。nohup 将输出写入当前目录下的 nohup.out 文件，可以通过查看该文件来了解项目的输出。

## 关闭在后台运行的 Java 项目

`jps` 是 Java Virtual Machine Process Status Tool 的缩写，用于显示当前系统上所有正在运行的 Java 进程。
在命令行中使用 `jps -m` 可以显示 Java 进程的主类（Main Class）的名称，这对于确定正在运行的 Java 应用程序很有用。
具体而言，`jps -m` 命令的输出将包括 Java 进程的进程ID（PID）以及其对应的主类名称。这样的输出可以帮助你迅速了解在系统上运行的 Java 进程及其主要功能。
例如：

jps -m
1234 MainClass1
5678 MainClass2

在这个示例中，`1234` 和 `5678` 是两个 Java 进程的PID，分别对应 `MainClass1` 和 `MainClass2`。

要关闭在后台运行的 Java 项目，您需要找到相应的 Java 进程，并终止它。首先，您可以使用 `ps` 命令查看正在运行的 Java 进程的详细信息：


ps aux | grep java
或者
jps -l | grep 项目.jar


上述命令列出了所有包含 "java" 的进程。找到与您的项目相关的进程，并记下其进程ID（PID）。
然后，使用 `kill` 命令终止该进程。假设您找到的进程ID是 `28090`，您可以执行：

kill -15 28090

或者使用 `-9` 选项强制终止：

kill -9 28090

在上述命令中，`-15` 选项表示发送 `SIGTERM` 信号，是一个优雅的终止信号，允许程序完成正在进行的工作。如果这不奏效，您可以尝试使用 `-9` 选项，发送 `SIGKILL` 信号，将进程立即终止，但请注意这可能导致未完成的操作。

请确保将进程ID替换为您找到的实际PID。执行上述命令后，Java 项目应该会终止。如果需要，您可以检查 `nohup.out` 文件查看终止的输出信息。

如果您不确定要终止哪个进程，请提供 `ps aux | grep java` 命令的输出，我可以帮助您识别正确的进程。