## 镜像操作

删除单个镜像：
docker rmi <镜像ID或镜像名称>
或者通过镜像ID：
docker rmi abcdef123456

删除多个镜像：
docker rmi <镜像1> <镜像2> <镜像3>

## 容器操作

查看所有正在运行的容器：
docker ps

查看所有容器，包括已停止的：
docker ps -a

按容器名称停止容器：
docker stop <容器名称>

按容器ID停止容器：
docker stop <容器ID>

删除单个容器：
docker rm <容器ID或容器名称>
或者通过容器ID：
docker rm abcdef123456

删除多个容器：
docker rm <容器1> <容器2> <容器3>
