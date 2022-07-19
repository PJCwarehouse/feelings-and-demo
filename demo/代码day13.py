import os
import shutil

source = "C:\Users\GoJeonPa\Desktop\新建文件夹/源文件"
target = "C:\Users\GoJeonPa\Desktop\新建文件夹/新目录"

dirs = os.listdir(source)
source_path = os.path.abspath(r'C:\Users\GoJeonPa\Desktop\新建文件夹/源文件')
target_path = os.path.abspath(r'C:\Users\GoJeonPa\Desktop\新建文件夹/新目录')
if os.path.exists(source_path):
    for root, dirs, files in os.walk(source_path):#遍历整个源文件
        for file_name in dirs:
            if file_name.endswith("txt"):#查找目录中后缀为“txt”的文件
                if not os.path.exists("C:\Users\GoJeonPa\Desktop\新建文件夹/新目录"):#如果没有创建新目录就创建一个
                    os.makedirs("C:\Users\GoJeonPa\Desktop\新建文件夹/新目录")
                for file in files:#将源文件中的txt文件复制到新目录中
                    src_file = os.path.join(root, file)
                    shutil.copy(src_file, target_path)
                    with open("target_path","w") as f:#在新目录的的所有文件后添加“ok.”
                        f.write("ok.") 
                        f.close()