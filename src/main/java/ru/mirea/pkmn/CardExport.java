package ru.mirea.pkmn;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CardExport {
    public static final long serialVersionUID = 1L;

    public void serializeCardToFile(Card card, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName + ".crd");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(card);
        oos.close();
        fos.close();
    }
}