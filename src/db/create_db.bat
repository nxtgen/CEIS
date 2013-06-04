@ECHO off

REM Modify the below line to match your MySql installation
cd D:\MySQL\MySQL Server 5.6\bin\

REM Modify the source location according to your local folder structure
mysql -u root -p < D:\User\Work\CEIS\CEIS-NB\db\create_db.sql

ECHO.
ECHO If no error message is shown, the databases named murach and music were created successfully.
ECHO.

:: Display 'press any key to continue' message
PAUSE

cd D:\User\Work\CEIS\CEIS-NB\db
