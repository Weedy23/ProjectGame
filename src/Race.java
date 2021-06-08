public class Race {
    private String RaceName;

    public void MakeRace(String RaceName, character Player) {
        switch (RaceName) {
            default:
                this.RaceName = RaceName;
            case "Human":
                Player.setCharStats(0, 10, 0, 0, 0, 10, 0);
                break;
            case "Orc":
                Player.setCharStats(10, 0, 10, 50, 10, 0, 20);
                break;
            case "Elf":
                Player.setCharStats(0, 0, 50, 0, 0, 5, 10);
                break;
        }
    }
}
