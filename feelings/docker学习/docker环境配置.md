## 安装docker
家庭版的Windows操作系统在默认情况下不支持Docker Desktop，因为Docker Desktop需要Hyper-V虚拟化功能，而Hyper-V在家庭版中是不可用的。
需要注意的是，在Windows中运行docker，实际上是在Windows下先安装了一个Linux环境，然后在这个系统中运行的docker，所以“本机”指的是Linux的地址
通过 docker-machine ip default 查看Docker主机IP，default为主机名称，一般为 192.168.99.100

1. 使用虚拟机

2. **升级到专业版

3. **启用WSL 2：** Windows Subsystem for Linux 2（WSL 2）是一种轻量级的虚拟化技术，可以在Windows上运行Linux内核。你可以尝试启用WSL 2，并在WSL 2中运行Docker。确保你的Windows版本支持WSL 2，然后按照Docker官方文档中的说明配置Docker CLI来与WSL 2一起使用。


### 1.下载客户端：
"https://docs.docker.com/desktop/install/windows-install/" 或者 "https://hub.docker.com/"
2.在家庭版windows下载docker需要启用wsl,首先，确保你的windows版本满足 Windows 10 version 2004 and higher (Build 19041 and higher) or Windows 11
如果电脑windows版本不满足条件，只能手动安装wsl
"https://learn.microsoft.com/en-us/windows/wsl/install"
### 3.以下所有命令都是用管理员权限打开PowerShell，然后输入

**wsl --install**
**这里我用的是wsl --install -d Ubuntu**
**同时也直接下载了ubuntu，然后需要再Ubuntu内配置**
windows内Ubuntu账户和密码：pjc/123456

**为 Linux 启用 Windows 子系统**
**dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart**


这个命令是用于启用 Windows Subsystem for Linux (WSL) 功能的。具体来说，它的各个部分含义如下：

- `dism.exe`: 运行部署映像服务管理工具。
- `/online`: 表示对当前运行的操作系统进行操作。
- `/enable-feature`: 启用指定的功能。
- `/featurename:Microsoft-Windows-Subsystem-Linux`: 指定要启用的功能的名称，即 Windows Subsystem for Linux。
- `/all`: 表示对所有用户启用指定的功能。
- `/norestart`: 在安装完成后不要重新启动系统。

这个命令的目的是启用 WSL，这是在 Windows 上运行 Linux 子系统的功能。启用 WSL 后，你可以在 Windows 上运行 Linux 应用程序和命令行工具，并与 Windows 应用程序进行集成。

通常，启用 WSL 是在安装 Docker Desktop 之前执行的一部分操作，因为 Docker Desktop 使用 WSL 2 作为默认的后端。在 Docker Desktop 中，WSL 2 提供了更好的性能和更好的集成。

**启用虚拟机功能**
**dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart**

这是一个在 Windows 上启用虚拟机平台特性的命令。这个命令使用了 `dism.exe` 工具，该工具是 Windows 上用于部署和管理操作系统的工具。

具体而言，这个命令的含义如下：

- `dism.exe`: 运行部署映像服务管理工具。
- `/online`: 表示对当前运行的操作系统进行操作。
- `/enable-feature`: 启用指定的功能。
- `/featurename:VirtualMachinePlatform`: 指定要启用的功能的名称，这里是虚拟机平台。
- `/all`: 表示对所有用户启用指定的功能。
- `/norestart`: 在安装完成后不要重新启动系统。

这个命令的目的是启用 Windows Subsystem for Linux 2 (WSL 2) 所需的虚拟机平台功能。WSL 2 使用 Hyper-V 技术作为虚拟化平台，因此需要启用此功能。

如果你正在使用 Docker Desktop，并且要使用 WSL 2 作为 Docker 的后端，这个命令可能是在安装 Docker Desktop 之前执行的一部分操作，以确保系统满足 Docker Desktop 的要求。

**将 WSL 2 设置为默认版本**
**wsl --set-default-version 2**

**4.最后打开Docker Desktop**
docker账号
email：2751607512@qq.com
username：whitenight007
password：LZZX2banPJC
