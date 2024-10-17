package ru.mirea.pkmn;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static ru.mirea.pkmn.CardImport.evolvesFrom;

public class PkmnApplication {

    public static void main(String[] args) {
        CardImport cardImport = new CardImport();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет юный ловец покемонов!\nЕсли хочешь записать свою карту введи 1, если хочешь прочитать чью - то карту введи 2");
        int a = scanner.nextInt();

        Card card;
        if(a == 1) {
            try {
                card = cardImport.createCardFromFile("src/main/resources/my_card.txt");

                System.out.println(card);
                System.out.println("Карта первой стадии");
                if(evolvesFrom != null)
                    System.out.println(evolvesFrom);

                CardExport cardExport = new CardExport();
                cardExport.serializeCardToFile(card, card.getName());
                System.out.println("Карта сериализована в файл: " + card.getName() + ".crd");

            } catch (FileNotFoundException e) {
                System.err.println("Файл my_card.txt не найден: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при сериализации: " + e.getMessage());
            }
        } else if(a == 2) {
            try {
                System.out.println("Введите имя файла с картой (например, Raichu.crd): ");
                String fileName = scanner.next();
                String filePath = "src/main/resources/" + fileName;
                byte[] bytes = Files.readAllBytes(Paths.get(filePath));
                card = cardImport.deserializeCardFromBytes(bytes);
                System.out.println(card);

            } catch (FileNotFoundException e) {
                System.err.println("Файл *.crd не найден: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при сериализации: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Не ну ты смотри что вводишь");
        }
    }
}
