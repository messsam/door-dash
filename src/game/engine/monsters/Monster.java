package game.engine.monsters;

import game.engine.Role;

public abstract class Monster implements Comparable<Monster> {
	private final String name, description;
    private final Role originalRole;
	private Role role;
    private int energy, position, confusionTurns;
	private boolean frozen, shielded;

    public Monster(String name, String description, Role originalRole, int energy) {
        setEnergy(energy);
        this.name = name;
        this.description = description;
        this.originalRole = originalRole;
        role = originalRole;
        // position and confusionTurns are set to the first index [0] by default.
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
    public void setEnergy(int energy) { this.energy = Math.max(energy, 0); }
    public void setPosition(int position) {
        if (position >= 0) this.position = position % 100;
        else throw new IllegalArgumentException("Position must not be negative");
    }
	public void setFrozen(boolean frozen) { this.frozen = frozen; }
	public void setShielded(boolean shielded) { this.shielded = shielded; }
	public void setConfusionTurns(int confusionTurns) { this.confusionTurns = confusionTurns; }

	@Override public int compareTo(Monster other) { return this.position - other.position; }
}