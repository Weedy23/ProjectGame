public class Loot {
    private String name;
    private Integer rarity;
    private Integer attack;
    private Integer intelligence;
    private Integer hp;
    private Integer defense;

    public static Loot makeLoot(String name, int rarity, int attack, int intelligence, int hp, int defense) {
        Loot loot = new Loot();
        loot.name = name;
        loot.rarity = rarity;
        loot.attack = attack;
        loot.intelligence = intelligence;
        loot.hp = hp;
        loot.defense = defense;

        return loot;
    }

    public static Loot generateLootOrNothing(int playerLevel) {
        int n = (int) (Math.random() * 10);

        if (n < 5) {
            int rarity = (int) (Math.random() * 10);
            switch (n) {
                case 0:
                    return makeLoot("Bronze Sword", rarity, (playerLevel + rarity) * 2, 0, rarity, rarity);
                case 1:
                    return makeLoot("Silver Sword", rarity, (playerLevel + rarity) * 3, 0, (playerLevel + rarity), (playerLevel + rarity));
                case 2:
                    return makeLoot("Magik Sword", rarity, (playerLevel + rarity) * 4, rarity * 10, (playerLevel + rarity) * 2, (playerLevel + rarity) * 2);
                case 3:
                    return makeLoot("Magik Staff", rarity, 0, (playerLevel + rarity) * 4, 0, 0);
                case 4:
                    return makeLoot("Assassin's blade", rarity, (playerLevel + rarity) * 10, 0, 100, 100);
            }
        }
        return null;
    }

    public String viewLootStat() {
        return "Rarity: " + rarity.toString()  + " Attack: " + attack.toString() + " Intelligence: " + intelligence.toString() + " Hp: " + hp.toString() + " Defense: " + defense.toString();
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public int getAttack() {
        return attack;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }
}
