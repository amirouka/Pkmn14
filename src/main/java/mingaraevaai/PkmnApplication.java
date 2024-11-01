package mingaraevaai;

import com.fasterxml.jackson.databind.JsonNode;
import ru.mirea.pkmn.AttackSkill;
import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.web.http.PkmnHttpClient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PkmnApplication {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        CardImport cardImport = new CardImport();
        Card card = cardImport.createCardFromFile("C:\\Users\\Амира\\Desktop\\Pkmn\\src\\main\\resources\\my_card.txt");

        PkmnHttpClient pkmnHttpClient = new PkmnHttpClient();

        JsonNode cardData = pkmnHttpClient.getPokemonCard(card.getName(), card.getNumber(), card.getHp());
        System.out.println(cardData.toPrettyString());

        List<AttackSkill> skills = new ArrayList<>();

        JsonNode dataNode = cardData.path("data");
        if (dataNode.isArray()) {
            JsonNode cardInfo = dataNode.get(0);

            JsonNode attacks = cardInfo.path("attacks");
            if (attacks.isArray()) {
                for (JsonNode attack : attacks) {
                    String name = attack.path("name").asText();
                    String damage = attack.path("damage").asText("");
                    String cost = attack.path("cost").toString();
                    String text = attack.path("text").asText("");
                    String cleanDamage = damage.replaceAll("[^\\d]", "");
                    int damageValue = cleanDamage.isEmpty() ? 0 : Integer.parseInt(cleanDamage);

                    AttackSkill skill = new AttackSkill(cost, name, damageValue);
                    skill.setDescription(text);
                    skills.add(skill);
                }}}
        card.setSkills(skills);

        Files.write(Paths.get("pokemon" + card.getNumber() + ".json"), cardData.toPrettyString().getBytes());

        CardExport cardExport = new CardExport();
        cardExport.serializeCardToFile(card);
        System.out.println("ТЕКУЩАЯ КАРТА\n");
        System.out.println(card);
    }
}
