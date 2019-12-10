package pl.sda.programowanie1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class Filess {
    public void walk(String path) throws IOException {
        java.nio.file.Files.walk(Paths.get(path))
                .filter(x -> x.toFile().isFile())
                .forEach(System.out::println);
    }
    public void findByPredicate(String path, Predicate<Path> predicate) throws IOException {
        if (Paths.get(path).toFile().isFile()) System.out.println("podana ścieżka jest ścieżką pliku");
        if (!Paths.get(path).toFile().isDirectory() && !Paths.get(path).toFile().isFile()) System.out.println("Niepoprawny adres");
File file = new File(path);
       String[] names=file.list();
        System.out.println(names.length);
        if (names.length==0) System.out.println("Brak folderów/podfolderów/plików");
Files.walk(Paths.get(path))
        .filter(x->x.toFile().isFile())
        //.filter(predicate)
        .forEach(System.out::println);
    }
}
