package n1e2;

import java.nio.file.attribute.FileTime;

public class FileData implements Comparable<FileData> {
    public String name;
    public char type;
    public String lastModification;

    public FileData(String name, char type, String lastModification) {
        this.name = name;
        this.type = type;
        this.lastModification = lastModification;
    }

    @Override
    public int compareTo(FileData o) {
        return name.compareToIgnoreCase(o.name);
    }
}
