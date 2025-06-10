# test_report_portal
## Описание проекта
Автоматизированные тесты для Report Portal, включающие UI и API тестирование.  
Проект демонстрирует
- Создание виджета через UI
- Создание Dashboard через API
- Поддержку мультибраузерности (Chrome, Edge)
- Генерацию отчетов Allure


## Технологии
- Java 17
- Selenium WebDriver
- RestAssured
- JUnit 5
- Allure Reports
- Maven
- 
## Структура проекта
- `src/test/java/com/report_portal/ui` — UI тесты
- `src/test/java/com/report_portal/api` — API тесты
- `src/main/java/com/report_portal/pages` — Page Objects
- `src/main/java/com/report_portal/framework` — Управление браузерами
- `src/main/resources` — Конфигурационные файлы

## Запуск тестов

1. Клонируйте репозиторий
   ```bash
   git clone https://github.com/Sonchello/test_report_portal.git
   ```
2. Перейдите в папку проекта
   ```bash
   cd test_report_portal
   ```
3. Запустите тесты
   ```bash
   mvn clean test
   ```


## Генерация и просмотр Allure-отчетов
1. После выполнения тестов отчеты Allure будут сгенерированы автоматически в папке `allure-results`
2. Для просмотра отчета нужно выполнить команду
   ```bash
   mvn allure:serve
   ```
Откроется браузер со следующими отчетами

![{FD2DEBBD-FF71-4C64-B49F-6C17E34FC715}](https://github.com/user-attachments/assets/3f211787-6905-42e6-bfdf-5dba789e085d)

![{9D111E60-A622-4719-AA95-E94CE17D19EC}](https://github.com/user-attachments/assets/83c8832c-f933-40ab-a94e-278790fda526)



## Создание Pull Request
1. Все изменения проиходят в ветке `dev`
2. После завершения работы создается Pull Request из `dev` в `master` 

