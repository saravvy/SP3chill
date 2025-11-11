import utils.FileIO;
import utils.TextUI;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileIO io = new FileIO();
        HoveMenu HoveMenu   = new HoveMenu();
        StartMenu StartMenu = new StartMenu();

    StartMenu.showChoices();
    StartMenu.switchChoices(io);
    HoveMenu.displayMainMenu();
        HoveMenu.switchChoice(io);





    }
}