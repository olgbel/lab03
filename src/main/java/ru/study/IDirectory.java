package ru.study;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Интерфейс определяет методы для работы с каталогами сервера.
 *
 * @author Ю.Д.Заковряшин, 2018-2020.
 */

public interface IDirectory {
    /**
     * Перечисление определяет тип элемента каталога.
     */
    enum Type {
        /**
         * Определяет каталог
         */
        DIRECTORY,
        /**
         * Определяет файл
         */
        FILE;
    }

    /**
     * Метод позволяет получить список подкаталогов и файлов заданного
     * каталога.
     *
     * @param dirName имя каталога, содержание которого должен вернуть
     *                данный метод.
     * @return коллекция типа , в которой
     * первый параметр содержит строку с именем файла или подкаталога.
     * Второй параметр определяет чем является элемента каталога с данным
     * именем: файлом или каталогом. Если заданный каталог пуст, то метод
     * возвращает пустую коллекцию. Если имя каталога задано неверно
     * (такого каталога нет), то метод возвращает значение null.
     */
    @GET
    @Path("{directory}")
    @Produces("application/json")
    Map<String, Type> getContent(@PathParam("directory") String dirName);

    /**
     * Метод производит поиск файла в заданном каталоге.
     *
     * @param dirName  определяет каталог поиска.
     * @param fileName определяет шаблон имени искомого файла.
     * @return список файлов и подкаталогов заданного каталога dirName,
     * имена которых удовлетворяют заданному шаблону fileName. Первый
     * параметр коллекции (ключ)содержит строку с именем файла или
     * подкаталога. Второй параметр определяет чем является элемента
     * каталога с данным именем: файлом или каталогом. Если заданный
     * каталог пуст, то метод возвращает пустую коллекцию. Если имя то
     * каталога задано неверно (такого каталога нет), метод возвращает
     * значение null.
     */
    @GET
    @Path("find/{directory}")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Type> findFile(@PathParam("directory") String dirName, @QueryParam("file") String fileName);
}
