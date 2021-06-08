public class Ability {
    private int BaseAttack = 10;
    private int StrongAttack = 30;
    private int Heal = 20;
    private int BaseAbility = 10;
    private int SpecialAbility = 30;

    public void MakeAbility(int BaseAttack, int StrongAttack, int Heal, int BaseAbility, int SpecialAbility) {
        this.BaseAttack = BaseAttack;
        this.StrongAttack = StrongAttack;
        this.Heal = Heal;
        this.BaseAbility = BaseAbility;
        this.SpecialAbility = SpecialAbility;
    }

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
}
