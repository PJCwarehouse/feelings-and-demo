import os
import shutil

source = "C:\Users\GoJeonPa\Desktop\新建文件夹/源文件"
target = "C:\Users\GoJeonPa\Desktop\新建文件夹/新目录"
dirs = os.listdir(source)
source_path = os.path.abspath(r'source')
if not os.path.exists("target"):#如果没有创建新目录就创建一个
    os.makedirs("target")
target_path = os.path.abspath(r'target')
if os.path.exists(source):
    for file in dirs:
        file_path = os.path.join(source, file)
        dst_path = os.path.join(target, file)
        if file.endswith("txt"):#查找目录中后缀为“txt”的文件
            for root, dirs, files in os.walk(source_path):
                src_file = os.path.join(root, file)
                shutil.copy(src_file, target_path)
for file in target:
    f = open("file","w")
    f.write("ok.")
    f.close