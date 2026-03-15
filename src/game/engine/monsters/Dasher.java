package game.engine.monsters;

import game.engine.Role;

public class Dasher extends Monster {
	private int momentumTurns;

    public Dasher(String name, String description, Role role, int energy) {
        super(name, description, role, energy); // momentumTurns is set to 0 by default.
    }

	public int getMomentumTurns() { return momentumTurns; }
	public void setMomentumTurns(int momentumTurns) { this.momentumTurns = momentumTurns; }
}