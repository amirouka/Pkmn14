package ru.mirea.pkmn;
import java.io.*;

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

        String[] attacks = reader.readLine().split(",");
        for (String attack : attacks) {
            String[] attackParts = attack.trim().split("/");
            if (attackParts.length >= 3) {
                AttackSkill attackSkill = new AttackSkill(
                        attackParts[1].trim(),
                        attackParts[0].trim(),
                        Integer.parseInt(attackParts[2].trim())
                );
                card.addAttackSkill(attackSkill);
            } else {
                System.err.println("Неверный формат данных атаки: " + attack);
            }
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