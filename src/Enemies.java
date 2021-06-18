public class Enemies {
    private String name;
    private int attack;
    private int hp;
    private int defense;
    private int dodge;
    private int experience;

    public static Enemies makeEnemies(String name, int attack, int hp, int defense, int dodge, int experience) {
        Enemies enemies = new Enemies();
        enemies.name = name;
        enemies.attack = attack;
        enemies.hp = hp;
        enemies.defense = defense;
        enemies.dodge = dodge;
        enemies.experience = experience;
        return enemies;
    }

    public static Enemies generateEnemiesOrNothing(int playerLevel) {
        int n = (int) (Math.random() * 10);

        if (n < 5) {
            switch (n) {
                case 0:
                    return makeEnemies("Zombie", playerLevel * 5, playerLevel * 20, playerLevel * 3, 10, 20);
                case 1:
                    return makeEnemies("Spider", playerLevel * 4, playerLevel * 15, playerLevel * 2, 50, 20);
                case 2:
                    return makeEnemies("Demon", playerLevel * 10, playerLevel * 25, playerLevel * 5, 20, 50);
                case 3:
                    return makeEnemies("Skeleton", playerLevel * 6, playerLevel * 10, playerLevel * 2, 30, 20);
                case 4:
                    return makeEnemies("Dragon", playerLevel * 15, playerLevel * 30, playerLevel * 10, 0, 100);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodge() {
        return dodge;
    }

    public int getExperience() {
        return experience;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
