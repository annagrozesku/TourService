# Процедура запуска автотестов

1. Установить IntelliJ IDEA версию Community Edition для своей ОС с официальной страницы https://www.jetbrains.com/ru-ru/idea/download/#section=windows
2. Скачать JDK: corretto-11
3. Установить Docker Desktop по инструкии: https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md
4. Установить плагин "Docker" в IDEA
5. Установить плагин "Lombook" в IDEA
6. Установить плагин "Database Navigator" в IDEA
7. Открыть код проекта в IDEA
8. Запустить docker-контейнеры командой docker-compose up --build 
9. Запустить SUT командой java -jar aqa-shop.jar
10. Запустить автотесты командой ./gradlew test "-Durl.database=jdbc:postgresql://localhost:5432/app" "-Dlogin.database=app" "-Dpassword.database=pass"  
11. Вызвать отчеты командой ./gradlew allureserve
