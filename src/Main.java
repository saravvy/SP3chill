import utils.FileIO;
import utils.TextUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIO io = new FileIO();
        HoveMenu HoveMenu   = new HoveMenu();
        StartMenu StartMenu = new StartMenu();

        boolean done = false;

        StartMenu.showChoices();
        while (!done) {

            StartMenu.switchChoices(io);
            HoveMenu.menuText();
            HoveMenu.displayMainMenu(io);
            StartMenu.showChoices();
        }




    }
}