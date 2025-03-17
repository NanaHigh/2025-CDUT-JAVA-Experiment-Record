#!/bin/bash
# build.sh

# 清理旧编译文件
rm -rf bin/

# 编译
mkdir -p bin
javac -d bin src/*.java


# 打包Server
cd bin
jar cvfe Server.jar Server *
mv Server.jar ../
cd ../

# 打包Client
cd bin
jar cvfe Client.jar Client *
mv Client.jar ../
cd ../
