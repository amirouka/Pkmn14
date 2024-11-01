package mingaraevaai;
import ru.mirea.pkmn.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardImport {
    public static final long serialVersionUID = 1L;
    public static Card evolvesFrom;

    public Card createCardFromFile(String filePath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

        Card card = new Card();

        card.setPokemonStage(PokemonStage.valueOf(reader.readLine().toUpperCase()));
        card.setName(reader.readLine());
        card.setHp(Integer.parseInt(reader.readLine()));
        card.setPokemonType(EnergyType.valueOf(reader.readLine().toUpperCase()));

        String evolutionFrom = reader.readLine();
        if (!evolutionFrom.equals("-")) {
            evolvesFrom = createCardFromFile(evolutionFrom);
            card.setEvolvesFrom(evolvesFrom);
        }

        String attack = reader.readLine();
        List<AttackSkill> attackSkillList = new ArrayList<>();
        String[] tokens = attack.split(",");
        if (tokens.length == 1){
            String[] args = tokens[0].split("/");
            attackSkillList.add(new AttackSkill(args[0], args[1], Integer.valueOf(args[2].trim())));
        }
        else if (tokens.length == 2){
            String[] args = tokens[0].split("/");
            attackSkillList.add(new AttackSkill(args[0], args[1], Integer.valueOf(args[2].trim())));
            args = tokens[1].split("/");
            attackSkillList.add(new AttackSkill(args[0], args[1], Integer.valueOf(args[2].trim())));
        }

        String weakness = reader.readLine();
        if (!weakness.equals("-")) {
            card.setWeaknessType(EnergyType.valueOf(weakness.toUpperCase()));
        }

        String resistance = reader.readLine();
        if (!resistance.equals("-")) {
            card.setResistanceType(EnergyType.valueOf(resistance.toUpperCase()));
        }

        card.setRetreatCost(reader.readLine());
        card.setGameSet(reader.readLine());
        card.setRegulationMark(reader.readLine().charAt(0));


        String[] ownerInfo = reader.readLine().split("/");
        card.setPokemonOwner(new Student(ownerInfo[0], ownerInfo[1], ownerInfo[2], ownerInfo[3]));

        card.setNumber(reader.readLine());
        reader.close();
        bis.close();

        return card;
    }

    public Card deserializeCardFromFile(String filePath) throws IOException, ClassNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        ObjectInputStream ois = new ObjectInputStream(bis);
        Card card = (Card) ois.readObject();
        ois.close();
        bis.close();
        return card;
    }

    public Card deserializeCardFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Card card = (Card) ois.readObject();
        ois.close();
        bais.close();
        return card;
    }
}