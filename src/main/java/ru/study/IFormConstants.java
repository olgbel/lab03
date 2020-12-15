package ru.study;

public interface IFormConstants {

    String HEADER = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Простой RESTful сервис</title>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta http-equiv=\"Cache-Control\" content=\"no-cache, no-store, must-revalidate\" />\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>RESTful сервис по работе с каталогом</h1>";

    String FOOTER = "</body>\n" +
            "</html>";

    String TABLE1 = "<form action=\"start\" method=\"GET\">\n" +
            "    <table>\n" +
            "        <tr>Посмотреть содержимое каталога:</tr>\n" +
            "        <tr>\n" +
            "            <td style=\"text-align: right;\">Directory:</td>\n" +
            "            <td><input type=\"text\" name=\"directoryForView\" size=\"24\"/></td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td><input type=\"submit\" name=\"viewContent\" value=\"Посмотреть содержимое\"/></td>\n" +
            "        </tr>\n" +
            "    </table>";

    String TABLE2 = "</br>\n" +
            "    <table>\n" +
            "        <tr>Поиск файла или каталога:</tr>\n" +
            "        <tr>\n" +
            "            <td style=\"text-align: right;\">Directory:</td>\n" +
            "            <td><input type=\"text\" name=\"directoryForSearch\" size=\"24\"/></td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td style=\"text-align: right;\">Имя файла или каталога:</td>\n" +
            "            <td><input type=\"text\" name=\"name\" size=\"24\"/></td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td><input type=\"submit\" name=\"find\" value=\"Поиск\"/></td>\n" +
            "        </tr>\n" +
            "    </table>\n" +
            "</form>";

    String EMPTY_CATALOG_ERROR = "Каталог не может быть пустым!";

    String EMPTY_NAME_ERROR = "Имя файла/каталога не может быть пустым!";
}
