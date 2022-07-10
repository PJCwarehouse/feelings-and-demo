#github内的仓库和本地仓库的关联
##本地仓库设置
1.本地创建一个文件夹，右键git bush here，输入git init（此时在文件夹中，打开隐藏文件显示，可以看到一个.git的文件）；
2.1添加文件一般使用git add .（注意add和·之间有一个空格）；
2.2添加文件进去是使用git add 文件名.文件类型（此方法一般使用于添加多个文件时，仅仅上传单一文件）；
2.3
git add -A     提交所有变化；
git add -u     提交被修改的文件和被删除的文件，不包括新文件；
git add .      提交新文件和被修改的文件，不包括被删除的文件；
3.1
提交文件，同步到云端，格式：
git commit -m  "修改注释"；
查看修改内容：git diff 文件名.文件类型；
查看所有文件内容：cat 文件名.文件类型；
3.2
git commit命令执行成功后会告诉你：
1 file changed：1个文件被改动（我们新添加的readme.txt文件）；
2 insertions：插入了两行内容（readme.txt有两行内容）；
##远端仓库的设置
1.创建一个仓库(一般是用空仓库)，得到仓库的位置，http或者ssh（ssh传输速度更快）
2.首先注意，git全局设置要上传email和name，注意在git confit --global user.name的""前面有一个空格；
git confit --global user.name "PJCwarehouse"
git confit --global user.email "2751607512@qq.com"
3.**要关联一个远程库，使用命令git remote add origin https://gitee.com/user name/project name.git**；
（关联一个远程库时必须给远程库指定一个名字，origin（feelings-and-demo）是默认习惯命名）；
关联后，使用命令**git push -u origin master**第一次推送master分支的所有内容；
此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送最新修改；
##远端仓库修改后同步本地仓库
1.克隆仓库：git clone SSH或者http地址；
2.取回远程文件（在github的web端修改了后，取回远程文件）：git pull 仓库名
3.git fetch:拉回远程的commit数据，将commit id更新为最新的，但是不会修改本地仓库
4.git merge:合并本地仓库
5.**push：add——commit——push(本地仓库修改同步到远程仓库);pull = fetch + merge（远程仓库修改同步到本地仓库）**


