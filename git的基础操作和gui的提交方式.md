# 连接远程仓库
1.首先创建一个本地文件夹，将其命名为远程仓库的相同名字
2.在该文件目录下打开Git Bash
3.输入git init,进行初始化（初次连接时）
4.连接远程仓库（初次连接是下一次进入该文件夹就不用了）
输入下列命令
git remote add origin git(ssh连接)
git remote add origin https(http连接)
5.从远程仓库拉取文件
git pull origin "分支名"
6.查看状态(可以不用)
git status
7.提交更改，添加备注信息
git add .
git commit -m "备注信息"
8.将本地文件push到远程仓库
git push -u origin "分支名"
//push之前最好先pull一下远程仓库，防止冲突
查看仓库配置
git remote -v


# 切换远程仓库
git remote rm origin(删除仓库)
git remote add origin url(添加新仓库)

# 在本地分支切换到新创建的分支：

git checkout xxx
报错：
error: pathspec 'XXX' did not match any file(s) known to git

解决方法：
1.查看本地的所有的分支中是否有同事新创建的分支：
git branch -a

**2.如果没看到，那么执行以下操作，这步是获取所有分支：
git fetch**

3.切换到远程同事分支:

git checkout origin/XXX


4.现在可以看到自己的分支是一串数字字母，这时新建并切换到同事的分支：
git checkout -b XXX

5.现在需要跟远程的同事分支进行关联：
git branch -u origin/XXX XXX


# 将github的代码拉到本地仓库中
git pull
git pull --rebase origin master
使用git pull 根据远程仓库和本地仓库的状态不同，主要分为以下四种情况:https://www.jianshu.com/p/06a1c7f0fac0


···················································

1.首先打开cmd 然后 cd + 仓库地址(C:\Users\GoJeonPa\Desktop\我的仓库\feelings-and-demo)

git status 就可以看你当前和远端仓库的差别

现在可以看到有一个文件 will be commited

2.git add . 就是自动把修改添加到 commit 列表

现在看git status 就可以看到他识别到 ：新增了一个文件

3.git commit -m"提交信息" 提交（本地仓库）这一步执行完会提交到本地仓库并产生一条记录
git commit -m"[feat]"==feature 功能新增的意思
git commit -m"[fix]"==fix bug 修复 bug 的意思

4.同步到远端仓库：git push


···················································
# gui的提交方式

1.修改文档
2.stage changed
3.commit
4.push

# git代理的设置
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

