package game.engine.monsters;

import game.engine.Constants;
import game.engine.Role;

public abstract class Monster implements Comparable<Monster> {
	private String name;
	private String description;
	private Role role;
	private Role originalRole; // For confusion card
	private int energy;
	private int position;
	private boolean frozen;
	private boolean shielded;
	private int confusionTurns;
	
	public Monster(String name, String description, Role originalRole, int energy) {
		super();
        setEnergy(energy);
        this.name = name;
        this.description = description;
        this.originalRole = role = originalRole;
        // position and confusionTurns are set to 0 by default.
        // frozen and shielded are set to false by default.
	}

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Role getOriginalRole() { return originalRole; }
	public Role getRole() { return role; }
    public int getEnergy() { return energy; }
    public int getPosition() { return position; }
    public boolean isFrozen() { return frozen; }
    public boolean isShielded() { return shielded; }
    public int getConfusionTurns() { return confusionTurns; }
	
	public void setRole(Role role) { this.role = role; }
	public void setEnergy(int energy) { this.energy = Math.max(Constants.MIN_ENERGY, energy); }
	public void setPosition(int position) { this.position = position % Constants.BOARD_SIZE; }
	public void setFrozen(boolean frozen) { this.frozen = frozen; }
	public void setShielded(boolean shielded) { this.shielded = shielded; }
	public void setConfusionTurns(int confusionTurns) { this.confusionTurns = confusionTurns; }
	
	@Override
	public int compareTo(Monster other) { return this.position - other.position; }
}