//www.jianshu.com-p-3dfcbdaf6412
@echo.
@echo   ����׼�������ѹ���������Android Studio��Ŀ 
@echo   �뽫���ļ�����Ҫ������Ŀ�ĸ�Ŀ¼�¼��� 
@echo.        
@Echo Off
Echo ��ѡ�� Y. ȷ��            N. �˳�
Echo.
Set /p var=��ѡ��:
If /i %var%==N (Exit) 
 
@echo ɾ��Gradle���룬�ڵ���ʱ�������
rmdir .gradle /s /q
@echo.
@echo ɾ��IDE�ļ�
rmdir .idea /s /q
del *.iml /f /s
del local.properties
@echo.
@echo ɾ�������ļ��У������´���
rmdir build /s /q
rmdir app\build /s /q
@echo.
@echo ɾ��Gradle Wrapper�����������
rmdir gradle /s /q
@echo.
@echo ɾ��Git�����ļ� 
//del .gitignore /f /s 
@echo.
@echo ɾ������Gradle�ļ�
//del gradle.properties
del gradle?.*
@echo.
@echo ɾ��libs�ļ���
//rmdir app\libs /s /q
@echo.
@echo ɾ��ProGuard����
//del app\proguard-rules.pro /f
@echo.
@echo ɾ�����Դ���
rmdir app\src\androidTest /s /q
rmdir app\src\test /s /q
@echo.
@echo ���ֻ������
attrib -R *.* /s
@echo ���ֻ������
