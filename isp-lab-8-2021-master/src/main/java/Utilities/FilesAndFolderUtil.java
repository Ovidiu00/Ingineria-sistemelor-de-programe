package Utilities;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilesAndFolderUtil {

    public static void createFolder(String folder){
        File d = new File(folder);
        d.mkdirs();
    }

    public static List<String> getFilesInFolder(String folder){
        File file = null;
        String[] paths;
        file = new File(folder);
        return Arrays.asList(file.list());
    }

    public static List<String> readAllFileLines(String file) throws Exception{
        Path path = Paths.get(file);
        byte[] bytes = Files.readAllBytes(path);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }


}
