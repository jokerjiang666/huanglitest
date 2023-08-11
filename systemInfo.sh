#!/bin/bash

# 显示硬盘使用情况
df -h

# 显示内存使用情况
free -m

# 显示CPU使用情况
top -bn1 | grep "Cpu(s)" | \
    sed "s/.*, *\([0-9.]*\)%* id.*/\1/" | \
    awk '{print "CPU使用率: " 100 - $1"%"}'