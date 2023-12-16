import java.io.File;

public interface Sample {
    String FOLDER_PATH = "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\Books";
    File FOLDER = new File(FOLDER_PATH);
    File[] FILES = FOLDER.listFiles();
//    String[] FILE_NAMES = new String[FILES.length];

    String[] getFileNames();
}
