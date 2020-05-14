import UI.GameUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String s = "abc";
        s.toUpperCase();
        System.out.println(s);
        GameUI ui = new GameUI();
        ui.main(args);
    }

}
