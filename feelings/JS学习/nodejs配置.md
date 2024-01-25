下载nodejs前，先下载管理nodejs版本的nvm，这样之后就可以达到版本的随意交换，如果先下载了nodejs，要想使用nvm，就需要卸载nodejs后再下载nvm方可正常使用
在nvm中安装好了nodejs，还需要配置nodejs的环境
分别找一个下载nvm和配置nodejs的博客来学习配置
nvm安装倒没什么难的，注意后续nodejs的配置需要新建文件夹以及环境变量配置

nvm下载：https://blog.csdn.net/Trista_1999/article/details/96998638
nodejs环境配置：https://zhuanlan.zhihu.com/p/542932711
新建的node_global和node_cache文件夹直接放在nvm文件夹下就好

error：express没反应

默认下载位置C：program files/nodejs
npm全局模块默认的存放的路径
使用“npm get prefix”查看
npm config set prefix="E:\Environment\nvm\node_global"

npm默认缓存存放的路径
使用“npm get cache”查看
npm config set cache="E:\Environment\nvm\node_cache"