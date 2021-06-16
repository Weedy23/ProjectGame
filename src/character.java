public class character {
    private String CharName;
    private int CharAge;
    private Ability CharAbility = new Ability();
    private Stats CharStats = new Stats();
    private int Level;
    private int Experience;
    private String Class;
    private String Race;

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
                    return CharStats.getStrength() + CharAbility.getBaseAttack();
                } else {
                    return 0;
                }
            case "StrongAttack":
                if (CharStats.getStamina() >= 25) {
                    CharStats.setStamina(CharStats.getStamina() - 25);
                    return CharStats.getStrength() + CharAbility.getStrongAttack();
                } else {
                    return 0;
                }
            case "SpecialAbilityOne":
                if (CharStats.getIntelligence() >= 10) {
                    CharStats.setStamina(CharStats.getIntelligence() - 10);
                    return CharStats.getMaxIntelligence() + CharAbility.getBaseAbility();
                } else {
                    return 0;
                }
            case "SpecialAbilityTwo":
                if (CharStats.getIntelligence() >= 25) {
                    CharStats.setStamina(CharStats.getIntelligence() - 25);
                    return CharStats.getMaxIntelligence() + CharAbility.getSpecialAbility();
                } else {
                    return 0;
                }
        }
    }

    public int MakeHeal() {
        return CharStats.getIntelligence() + CharAbility.getHeal();
    }
}
