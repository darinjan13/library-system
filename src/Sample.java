import java.io.File;

public interface Sample {
    String FOLDER_PATH = "C:\\Users\\admin\\IdeaProjects\\library-system\\src\\Books";
    String CHECKED_OUT_PATH = "C:\\Users\\admin\\IdeaProjects\\library-system\\src\\CheckedOutBooks";
    File FOLDER = new File(FOLDER_PATH);
    File[] FILES = FOLDER.listFiles();
//    String[] FILE_NAMES = new String[FILES.length];

}
