package game.engine.dataloader;

import game.engine.cards.*;
import game.engine.cells.*;
import game.engine.monsters.*;
import game.engine.Role;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {

    private static final String CARDS_FILE_NAME = "cards.csv";
    private static final String CELLS_FILE_NAME = "cells.csv";
    private static final String MONSTERS_FILE_NAME = "monsters.csv";

    public static ArrayList<Card> readCards() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CARDS_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] curr = line.split(",");
                switch (curr[0]) {
                    case "ENERGYSTEAL":
                        cards.add(new EnergyStealCard(curr[1], curr[2], Integer.parseInt(curr[3]), Integer.parseInt(curr[4])));
                        break;
                    case "STARTOVER":
                        cards.add(new StartOverCard(curr[1], curr[2], Integer.parseInt(curr[3]), Boolean.parseBoolean(curr[4])));
                        break;
                    case "CONFUSION":
                        cards.add(new ConfusionCard(curr[1], curr[2], Integer.parseInt(curr[3]), Integer.parseInt(curr[4])));
                        break;
                    case "SHIELD":
                        cards.add(new ShieldCard(curr[1], curr[2], Integer.parseInt(curr[3])));
                        break;
                    default:
                        cards.add(new SwapperCard(curr[1], curr[2], Integer.parseInt(curr[3])));
                }
            }
        }
        return cards;
    }
    public static ArrayList<Cell> readCells() throws IOException {
        ArrayList<Cell> cells = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CELLS_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] curr = line.split(",");
                if (curr.length == 3)
                    cells.add(new DoorCell(curr[0], Role.valueOf(curr[1]), Integer.parseInt(curr[2])));
                else {
                    int effect = Integer.parseInt(curr[1]);
                    if (effect > 0) cells.add(new ConveyorBelt(curr[0], effect));
                    else cells.add(new ContaminationSock(curr[0], effect));
                }
            }
        }
        return cells;
    }
    public static ArrayList<Monster> readMonsters() throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MONSTERS_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] curr = line.split(",");
                switch (curr[0]) {
                    case "DASHER":
                        monsters.add(new Dasher(curr[1], curr[2], Role.valueOf(curr[3]), Integer.parseInt(curr[4])));
                        break;
                    case "DYNAMO":
                        monsters.add(new Dynamo(curr[1], curr[2], Role.valueOf(curr[3]), Integer.parseInt(curr[4])));
                        break;
                    case "MULTITASKER":
                        monsters.add(new MultiTasker(curr[1], curr[2], Role.valueOf(curr[3]), Integer.parseInt(curr[4])));
                        break;
                    default:
                        monsters.add(new Schemer(curr[1], curr[2], Role.valueOf(curr[3]), Integer.parseInt(curr[4])));
                }
            }
        }
        return monsters;
    }
}