public class clas {
    private String ClassName;

    public void MakeClass(String ClassName, character Player) {
        switch (ClassName) {
            default:
                this.ClassName = ClassName;
                break;
            case "Warrior":
                Player.setCharStats(5, 0, 10, 50, 10, 0, 0);
                break;
            case "Mage":
                Player.setCharStats(0, 10, 0, 0, 0, 10, 0);
                break;
            case "Assassin":
                Player.setCharStats(10, 0, 50, 0, 0, 20, 50);
                break;
        }
    }
}
