Web десктопный
1) Проверка ссылки кнопки Адреса
1.  Открыть главную страницу
2.  Навести на сервисы и услуги, перейти в Пополнение карт и погашение кредитов
3.  Проверить что все кнопки 'Адреса' в элементах страницы ведут по ссылке https://www.mtsbank.ru/ofisi-i-bankomati/

2) Проверка соответствия подписи в блоках продукта в разделе 'Блог' (Параметризированный, передает названия продуктов)
1.  Открыть главную страницу
2.  Перейти в блог
3.  Вместо 'Все' выбрать необходимый продукт
4.  Проверить что отобразившиеся элементы относятся только к выбранному продукту - проверить соответствие подписи в элементах и названия выбранного продукта

3) Проверка наличия кнопки 'Отправить заявку' в блоках ссылка которых содержит /malomu-biznesu/
1.  Открыть главную страницу
2. Нажать 'Малый бизнес и ИП'
3. Перейти в каждый блок содержащий в ссылке /malomu-biznesu/ и проверить наличие кнопки 'Отправить заявку' в блоках для оформления заявок

4) Проверка появления ошибки не проставления чекбокса соглашения на обработку
1.  Открыть главную страницу
2. Нажать 'Малый бизнес и ИП'
3. Перейти в 'Депозиты'
4. Заполнить форму 'Заявка на депозит для бизнеса'
5. Нажать 'Отправить заявку' и проверить наличие ошибки 'Для обработки вашей заявки вы должны согласиться с условиями'

5) Проверка выпадающих элементов в 'Группах компаний'
1.  Открыть главную страницу
2. Нажать 'Корпоративный бизнес'
3. Навести 'Расчетно-кассовое обслуживание', нажать 'Группам компаний'
4. Проверить что каждый элемент в 'Список услуг' раскрывается при нажатии и заполнен



Web мобильный
1) Проверка отображения нового города при смене (Параметризированный)
1.  Открыть главную страницу
2. Нажать на город и в появившемся списке выбрать новый
3. Проверить что на главной странице отображается выбранный город

2) Проверка процентной ставки по умолчанию в Ипотеке для IT
1.  Открыть главную страницу
2. Внизу страницы раскрыть список 'Частным лицам' и выбрать 'Кредиты и ипотека'
3. Нажать 'Ипотечные программы'
4. Нажать 'Программы', затем 'Ипотека для IT' и проверить что ставка равна '5 %'

3) Проверка появления чекбокса Зарплатный клиент при выборе Рефинансирования в калькуляторе Ипотеки
1.  Открыть главную страницу
2. Внизу страницы раскрыть список 'Частным лицам' и выбрать 'Кредиты и ипотека'
3. Нажать 'Ипотечные программы'
4. Выбрать 'Цель кредита' - 'Рефинансирование кредита' и проверить что появился чекбокс 'Зарплатный клиент ПАО «МТС-Банк»'

4) Проверка скачивания файла Инструкция.PDF
1.  Открыть главную страницу
2. Внизу страницы раскрыть список 'Частным лицам' и выбрать 'Кредиты и ипотека'
3. Нажать 'Ипотечные программы'
4. Выбрать 'Погашение кредита' и нажать 'Инструкция.PDF' для скачивания

5) Проверка теста 'Обмани мошенника'
1.  Открыть главную страницу
2. Внизу страницы раскрыть список 'Помощь клиентам' и выбрать 'Правила безопасности'
3. Внизу страницы в тесте отметить варианты 1-3, 2-3, 3-2, 4-2
4. Убедиться что 'Результат 4/4'



API тесты
1) 'POST' Успешная аутентификация и получение токена
1. Отправить запрос POST Аутентификация пользователя и получение токена

2) 'GET' Успешная проверка списка тарифов
1. Отправить запрос GET для получения списка тарифов
2. Проверка что в списке тарифов есть тарифы из ТЗ

3) 'POST' Успешная проверка метода подачи заявки на кредит
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос POST для получения orderId
3. Проверка что в ответе действительно есть orderId

4) 'POST' Негативная проверка метода подачи заявки на кредит выбрав несуществующий тариф (Параметризированный)
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос POST для получения ошибки что тариф не существует
3. Проверка что в ответе код ошибки совпадает с ожидаемым

5) 'GET' Успешная проверка соответствия статуса ордера в методе получения статуса заявки
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос POST для получения orderId
3. Отправить запрос GET для получения статуса ордера
4. Проверка что значение статуса соответствует статусу в ответе

6) 'GET' Негативная проверка получения статуса несуществующей заявки
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос GET на несуществующую заявки
3. Проверка что в ответе код ошибки совпадает с ожидаемым

7) 'DELETE' Успешное удаление существующей заявки
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос POST для получения orderId
3. Отправить запрос DELETE на удаление

7) 'DELETE' Негативное удаление несуществующей заявки
1. Отправить запрос POST Аутентификация пользователя и получение токена
2. Отправить запрос DELETE на удаление несуществующей заявки
3. Проверка что в ответе код ошибки совпадает с ожидаемым
