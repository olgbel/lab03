package ru.study;

import javax.ws.rs.Path;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/demo")
public class IDirectoryImpl implements IDirectory {

    @Override
    public Map<String, Type> getContent(String dirName) {
        File dir = new File(dirName);
        File[] content = dir.listFiles();

        if (content == null) return null;
        if (content.length == 0) return new HashMap<>();

        return fileArrayToMap(content);
    }

    @Override
    public Map<String, Type> findFile(String dirName, String fileName) {
        File dir = new File(dirName);
        File[] content = dir.listFiles((d, name) -> name.equals(fileName));

        if (content == null) return null;
        if (content.length == 0) return new HashMap<>();

        return fileArrayToMap(content);
    }

    private Map<String, Type> fileArrayToMap(File[] arr) {
        return Arrays.stream(arr).collect(Collectors.toMap(File::getName, e -> e.isFile() ? Type.FILE : Type.DIRECTORY));
    }
}
