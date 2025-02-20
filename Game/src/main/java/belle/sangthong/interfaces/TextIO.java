package belle.sangthong.interfaces;

public interface TextIO {
    boolean yesNo(String prompt);

    String getString();

    void addString(String s);

    void clear();

    void exit();
}
