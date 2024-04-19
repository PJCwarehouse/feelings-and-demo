# 本地新建仓库的作用
如果你是在团队项目中工作，并且远程仓库是共享的，则最好的做法是创建一个分支，然后在该分支上进行修改。然后，你可以通过向远程仓库创建合并请求（pull request）来请求将你的修改合并到远程分支中。

## 设置本地git的用户和密码
git的操作，不是github，而是本地git
git config --global user.name "用户名"
git config --global user.email "用户邮箱"
**是全局的，github和gitee通用**

## 连接远程仓库
1. 首先创建一个本地文件夹
2. 在该文件目录下打开Git Bash
3. 输入**git init**,进行初始化（初次连接时）
4. 连接远程仓库（初次连接是下一次进入该文件夹就不用了）
输入下列命令
    git remote add origin git(ssh连接)
    git remote add origin https(http连接)

git remote rm origin(删除仓库)
查看仓库配置
git remote -v

5. 设置本地分支与远程分支的连接
# 分支理解
一般是本地的分支跟踪远程的分支，然后远程的更新可以pull到本地分支，本地的更新也可以push到远程分支上

    主分支（Main Branch）：主分支是代码库的主要开发线，通常是 master 分支或者 main 分支。这是项目的默认分支，通常用于稳定的生产版本。

    远程分支（Remote Branch）：远程分支是存在于远程仓库中的分支。它们跟踪着远程仓库中的分支状态，并允许你与团队成员协作、共享代码。

    跟踪分支（Tracking Branch）：跟踪分支是与远程分支相关联的本地分支。它们允许你在本地进行修改并将这些修改推送到远程仓库中。

分支的创建有两种：
**一种是在git上创建一个分支，然后在本地环境创建分支跟踪这个新创建的分支**
流程：
git init仓库化
git remote add origin url连接
git fetch获取所有分支
git branch -a 获取远程和本地分支（这里刚刚初始化仓库，还没有本地分支）
git checkout name 切换到目的分支

checkout后 本地会创建对应 目的分支 的 本地分支
例如目的分支为origin/pjc ，那么checkout后当前就会处于本地新创建的分支 "pjc"
<!-- 注意：如果本地是没有分支，直接使用的远程的git上的分支的话，这样是不推荐的（如何辨别？如果使用git branch -a，发现只有远程分支，没有本地分支，那么说明直接使用的是远程的分支）
    在这种情况下，如果你执行 git push 命令，Git 将会尝试将本地分支的修改推送到对应的远程分支，但通常会失败并报错。因为远程分支是不可编辑的，只能通过合并请求（pull request）或者其他权限管理方式来更新。
    所以，直接切换到远程分支并修改是一个不推荐的做法。如果你需要在远程分支上进行修改，应该先创建一个本地分支来跟踪远程分支，并在本地分支上进行修改，然后通过合并请求等方式将修改推送到远程分支。 -->

<!-- **此时我们可以创建一个本地分支，将本地分支连接到远程分支**
    git checkout -b name
    git branch --set-upstream-to=origin/<branch> name 
    虽然连接了，但是push的时候还是需要设置推送的远程分支
和下面的方法相似，唯一的区别是创建新的分支连接到git中已有的分支；而下面的方法是创建git中没有的分支，推送到git中使出现新的分支
    如果git不认识set-upstream，可以试试下面的方法
    git push -u origin master_pjc:pjc -->

**一种是直接在本地创建新的分支，然后将这个新分支连接到git上面的仓库，然后git上面就会显示这个新的分支（本来git是没有这个新分支的）**
在本地已经存在分支的情况下，git branch name 创建一个新的分支，切换到新分支后
git push --set-upstream origin name

这样就可以把新的分支推送的到仓库中，同时也关联了当前这个分支

## 本地创建分支
git branch <name>

## 本地切换分支
git checkout xxx

## 创建后直接切换分支
git checkout -b <branch_name>

## 查看本地分支列表
git branch -a 获取远端和近端分支
git branch
输出将会显示当前所在的分支前有一个星号*
**如果是一个新仓库，没有任何已经和远端连接的分支，那么使用git branch/git checkout -b <branch_name> 创建分支是没有用的，因为git branch是在当前的提交位置创建一个新分支**
1. 如果目前没有任何已经连接的分支，那么你就无法根据当前位置创建一个新分支
2. 使用 git branch 创建新分支后，不会直接切换分支，会依旧在当前分支上

6. 分支连接好后，就可以进行代码的pull和push了
   1.   git add .
   2.   git commit -m "备注信息"
   3. 连接远程仓库下的分支（**第一次push**）

**推送之前必须要将本地分支和远程分支关联**
    git push --set-upstream origin master
**拉取时，如果不设置拉取的分支名，默认拉取master分支**
    git push -u origin "分支名"
//push之前最好先pull一下远程仓库，防止冲突

 查看状态(可以不用)
    git status
 提交更改，添加备注信息

## 设置本地分支与远程分支的关联
git branch -u origin/XXX XXX

如果报错：
error: pathspec 'XXX' did not match any file(s) known to git

解决方法：
1.查看本地的所有的分支中是否有同事新创建的分支：
    git branch -a
**2.如果没看到，那么执行以下操作，这步是获取所有分支：**
    git fetch
3.切换到远程同事分支:
    git checkout origin/XXX
4.现在可以看到自己的分支是一串数字字母，这时新建并切换到同事的分支：
    git checkout -b XXX
5.现在需要跟远程的同事分支进行关联：
    git branch -u origin/XXX XXX


## 将github的代码拉到本地仓库中
git pull
git pull --rebase origin master
使用git pull 根据远程仓库和本地仓库的状态不同，主要分为以下四种情况:https://www.jianshu.com/p/06a1c7f0fac0


在 Git 中，远程分支的 origin 是指代远程仓库的别名或者标识符。通常情况下，origin 是默认用于指代克隆或者添加远程仓库时的远程仓库地址。

···················································

1. 首先打开cmd 然后 cd + 仓库地址(C:\Users\GoJeonPa\Desktop\我的仓库\feelings-and-demo)

git status 就可以看你当前和远端仓库的差别

现在可以看到有一个文件 will be commited

2. git add . 就是自动把修改添加到 commit 列表

现在看git status 就可以看到他识别到 ：新增了一个文件

3. git commit -m"提交信息" 提交（本地仓库）这一步执行完会提交到本地仓库并产生一条记录
git commit -m"[feat]"==feature 功能新增的意思
git commit -m"[fix]"==fix bug 修复 bug 的意思

4. 推送到远端仓库：git push



## bug
**fatal: refusing to merge unrelated histories**
这个错误通常发生在尝试合并两个不相关的历史时，例如，当在本地创建了一个新的仓库并且尝试拉取远程仓库时。

解决这个问题的一种方法是使用--allow-unrelated-histories选项来允许合并不相关的历史。执行以下命令：
    git pull origin master --allow-unrelated-histories
执行后会进入到一个vim文档中，使用vim操作，输入：wq 保存并退出（这里是让你写拉取仓库的理由）
···················································
## git gui的提交方式

1.修改文档
2.stage changed
3.commit
4.push

## git代理的设置
git设置和取消代理的作用
当我们访问GitHub的时候一般都会使用梯子，所以往上推代码的时候也是需要梯子，没有梯子推送成功概率很低，一般都会报错超时，所以设置梯子提高访问成功率文章来源地址

取消代理是因为，访问Gitee的时候不需要梯子，所以要取消代理文章地址
http和https的代理是分开设置的，还可以设置socks5的代理

1.设置代理
git config --global http.proxy  http://127.0.0.1:7890
git config --global https.proxy http://127.0.0.1:7890
2.取消代理
git config --global --unset http.proxy
git config --global --unset https.proxy
3.查看代理
git config --global --get http.proxy
git config --global --get https.proxy
4.拓展知识
git helper -a // 查看全部git子命令

关于git 和 clash的关系
当clash打开时，代理会自动开始，无论是否开启系统代理，git clone都会默认使用已有的代理
当clash关闭后，代理会自动取消

## gitee SSH连接方法
下载git
获取公钥，配置到gitee上

测试是否连接到远程自己的账号。
 ssh -T git@gitee.com

远程连接 fork的数据库
git remote add origin + 网址

设置分支