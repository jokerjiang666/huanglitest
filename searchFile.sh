#!/bin/bash

# 输入要搜索的内容和要搜索的文件名
read -p "请输入要搜索的内容: " search_content
read -p "请输入要搜索的文件名: " search_file

# 搜索并输出到控制台
echo "搜索结果如下:"
grep -n "$search_content" "$search_file"

# 将搜索结果保存到新的文件中
read -p "请输入保存结果的文件名: " result_file
grep -n "$search_content" "$search_file" > "$result_file"
echo "搜索结果已保存到文件 $result_file 中"