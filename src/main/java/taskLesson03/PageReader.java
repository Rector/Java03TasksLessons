package taskLesson03;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PageReader {

    private String path;
    private int page;
    private int charactersPerPage;

    PageReader(String path, int page, int charactersPerPage){
        this.path = path;
        this.page = page;
        this.charactersPerPage = charactersPerPage;
        readingPageInText(path, page, charactersPerPage);
    }


    private void readAndPrint(RandomAccessFile raf) throws IOException{
        int x;
        for (int i = 0; i < charactersPerPage; i++) {
            x = raf.read();
            System.out.print((char) x);
        }
    }


    private void readingPageInText(String path, int page, int charactersPerPage) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            long t = System.currentTimeMillis();

            if (page == 1) {
                readAndPrint(raf);
                System.out.println();
            } else if (page > 1 && page < (raf.length() / charactersPerPage)) {
                raf.seek((page - 1) * charactersPerPage);
                readAndPrint(raf);
                System.out.println();
            } else {
                System.out.println("Указанной страницы не существует");
            }

            System.out.println("Чтение и вывод информации со страницы в миллисекундах: "
                    + (System.currentTimeMillis() - t));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
