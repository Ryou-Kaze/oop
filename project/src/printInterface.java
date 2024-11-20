import java.util.LinkedHashSet;

public interface printInterface {
    void xuatThongTin();
    static void printTags(LinkedHashSet<String> tagsList){
       for (String tag: tagsList){
           System.out.print(tag +",");
       }
    }
}
