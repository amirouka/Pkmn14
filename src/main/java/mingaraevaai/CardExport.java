package mingaraevaai;
import ru.mirea.pkmn.Card;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CardExport {
    public static final long serialVersionUID = 1L;
    public void serializeCardToFile(Card card) throws IOException {
        FileOutputStream fos = new FileOutputStream(card.getName() + ".crd");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(card);
        oos.close();
        fos.close();
    }
}