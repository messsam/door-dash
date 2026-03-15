package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import game.engine.monsters.Monster;
import game.engine.dataloader.DataLoader;

public class Game {
    private final Board board;
    private final ArrayList<Monster> allMonsters;
    private final Monster player, opponent;
    private Monster current;

    public Game(Role playerRole) throws IOException {
        board = new Board(DataLoader.readCards());
        allMonsters = DataLoader.readMonsters();
        player = selectRandomMonsterByRole(playerRole);
        opponent = selectRandomMonsterByRole(playerRole==Role.SCARER?Role.LAUGHER:Role.SCARER);
        current = player;
    }

    public Board getBoard() { return board; }
    public ArrayList<Monster> getAllMonsters() { return allMonsters; }
    public Monster getPlayer() { return player; }
    public Monster getOpponent() { return opponent; }
    public Monster getCurrent() { return current; }
    public void setCurrent(Monster current) { this.current = current; }

    private Monster selectRandomMonsterByRole(Role role) {
        Monster random;
        do {
            random = allMonsters.get((int)(Math.random()*allMonsters.size()));
        } while (random.getRole() != role);
        return random;
    }
}