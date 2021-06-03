//www.jianshu.com-p-3dfcbdaf6412
@echo.
@echo   清理准备导入和压缩纯代码的Android Studio项目 
@echo   请将此文件拖入要清理项目的根目录下即可 
@echo.        
@Echo Off
Echo 请选择 Y. 确认            N. 退出
Echo.
Set /p var=请选择:
If /i %var%==N (Exit) 
 
@echo 删除Gradle代码，在导入时重新添加
rmdir .gradle /s /q
@echo.
@echo 删除IDE文件
rmdir .idea /s /q
del *.iml /f /s
del local.properties
@echo.
@echo 删除构建文件夹，将重新创建
rmdir build /s /q
rmdir app\build /s /q
@echo.
@echo 删除Gradle Wrapper，将重新添加
rmdir gradle /s /q
@echo.
@echo 删除Git忽略文件 
//del .gitignore /f /s 
@echo.
@echo 删除其他Gradle文件
//del gradle.properties
del gradle?.*
@echo.
@echo 删除libs文件夹
//rmdir app\libs /s /q
@echo.
@echo 删除ProGuard规则
//del app\proguard-rules.pro /f
@echo.
@echo 删除测试代码
rmdir app\src\androidTest /s /q
rmdir app\src\test /s /q
@echo.
@echo 清除只读属性
attrib -R *.* /s
@echo 清除只读属性
