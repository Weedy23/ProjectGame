public class Ability {
    private int BaseAttack = 10;
    private int StrongAttack = 30;
    private int Heal = 20;
    private int BaseAbility = 10;
    private int SpecialAbility = 30;

    public int getBaseAttack() {
        return BaseAttack;
    }

    public int getStrongAttack() {
        return StrongAttack;
    }

    public int getHeal() {
        return Heal;
    }

    public int getBaseAbility() {
        return BaseAbility;
    }

    public int getSpecialAbility() {
        return SpecialAbility;
    }

    public void setBaseAttack(int baseAttack) {
        BaseAttack = baseAttack;
    }

    public void setStrongAttack(int strongAttack) {
        StrongAttack = strongAttack;
    }

    public void setHeal(int heal) {
        Heal = heal;
    }

    public void setBaseAbility(int baseAbility) {
        BaseAbility = baseAbility;
    }

    public void setSpecialAbility(int specialAbility) {
        SpecialAbility = specialAbility;
    }
}
