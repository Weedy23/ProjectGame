public class character {
    private String CharName;
    private int CharAge;
    private Ability CharAbility = new Ability();
    private Stats CharStats = new Stats();
    private int Level;
    private int Experience;
    private String Class;
    private String Race;
    private Loot CharLoot;

    public void MakeCharacter(String CharName, int CharAge, int Level, int Experience, String ClassName, String RaceName) {
        this.CharName = CharName;
        this.CharAge = CharAge;
        this.Level = Level;
        this.Experience = Experience;
        this.Class = ClassName;
        this.Race = RaceName;
    }

    public void LoadStats(int Strength, int Intelligence, int Stamina, int Hp, int Defense, int CriticalChance, int CriticalPower) {
        CharStats.setStrength(Strength);
        CharStats.setMaxIntelligence(Intelligence);
        CharStats.setIntelligence(Intelligence);
        CharStats.setMaxStamina(Stamina);
        CharStats.setStamina(Stamina);
        CharStats.setMaxHp(Hp);
        CharStats.setHp(Hp);
        CharStats.setDefense(Defense);
        CharStats.setCriticalChance(CriticalChance);
        CharStats.setCriticalPower(CriticalPower);
    }

    public void LoadAbility(int BaseAttack, int StrongAttack, int Heal, int BaseAbility, int SpecialAbility) {
        CharAbility.setBaseAttack(BaseAttack);
        CharAbility.setStrongAttack(StrongAttack);
        CharAbility.setHeal(Heal);
        CharAbility.setBaseAbility(BaseAbility);
        CharAbility.setSpecialAbility(SpecialAbility);
    }

    public String getCharName() {
        return CharName;
    }

    public int getCharAge() {
        return CharAge;
    }

    public int getLevel() {
        return Level;
    }

    public int getExperience() {
        return Experience;
    }

    public String getClassName() {
        return Class;
    }

    public String getRace() {
        return Race;
    }

    public Ability getCharAbility() {
        return CharAbility;
    }

    public Stats getCharStats() {
        return CharStats;
    }

    public Loot getCharLoot() {
        return CharLoot;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public void setCharLoot(Loot charLoot) {
        CharLoot = charLoot;
    }

    public void setCharStats(int Strength, int Intelligence, int Stamina, int Hp, int Defense, int CriticalChance, int CriticalPower) {
        CharStats.setStrength(CharStats.getStrength() + Strength);
        CharStats.setMaxIntelligence(CharStats.getMaxIntelligence() + Intelligence);
        CharStats.setIntelligence(CharStats.getIntelligence() + Intelligence);
        CharStats.setMaxStamina(CharStats.getMaxStamina() + Stamina);
        CharStats.setStamina(CharStats.getStamina() + Stamina);
        CharStats.setHp(CharStats.getHp() + Hp);
        CharStats.setDefense(CharStats.getDefense() + Defense);
        CharStats.setCriticalChance(CharStats.getCriticalChance() + CriticalChance);
        CharStats.setCriticalPower(CharStats.getCriticalPower() + CriticalPower);
    }

    public void LevelUp() {
        if (Experience >= 100 + (Level * 50)) {
            Level++;
            Experience -= 100 + (Level * 50);
        }
    }

    public int MakeAttack(String ability) {
        switch (ability) {
            default:
                if (CharStats.getStamina() + CharStats.getMaxStamina()/20 < CharStats.getMaxStamina()) {
                    CharStats.setStamina(CharStats.getStamina() + CharStats.getMaxStamina() / 20);
                }
                if (CharStats.getIntelligence() + CharStats.getMaxIntelligence()/20 < CharStats.getMaxIntelligence()) {
                    CharStats.setIntelligence(CharStats.getIntelligence() + CharStats.getMaxIntelligence() / 20);
                }
            case "BaseAttack":
                if (CharStats.getStamina() >= 10) {
                    CharStats.setStamina(CharStats.getStamina() - 10);
                    if (CharLoot == null) {
                        return CharStats.getStrength() + CharAbility.getBaseAttack();
                    } else {
                        return CharStats.getStrength() + CharAbility.getBaseAttack() + CharLoot.getAttack();
                    }
                } else {
                    return 0;
                }
            case "StrongAttack":
                if (CharStats.getStamina() >= 25) {
                    CharStats.setStamina(CharStats.getStamina() - 25);
                    if (CharLoot == null) {
                        return CharStats.getStrength() + CharAbility.getStrongAttack();
                    } else {
                        return CharStats.getStrength() + CharAbility.getStrongAttack() + CharLoot.getAttack();
                    }
                } else {
                    return 0;
                }
            case "BaseAbility":
                if (CharStats.getIntelligence() >= 10) {
                    CharStats.setIntelligence(CharStats.getIntelligence() - 10);
                    if (CharLoot == null) {
                        return CharStats.getMaxIntelligence() + CharAbility.getBaseAbility();
                    } else {
                        return CharStats.getMaxIntelligence() + CharAbility.getBaseAbility() + CharLoot.getIntelligence();
                    }
                } else {
                    return 0;
                }
            case "SpecialAbility":
                if (CharStats.getIntelligence() >= 25) {
                    CharStats.setIntelligence(CharStats.getIntelligence() - 25);
                    if (CharLoot == null) {
                        return CharStats.getMaxIntelligence() / 5 + CharAbility.getSpecialAbility();
                    } else {
                        return CharStats.getMaxIntelligence() / 5 + CharAbility.getSpecialAbility() + CharLoot.getIntelligence();
                    }
                } else {
                    return 0;
                }
            case "Heal":
                return CharStats.getIntelligence() + CharAbility.getHeal() + CharLoot.getIntelligence();
        }
    }
}
