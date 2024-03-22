package game;

import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.IOException;
import java.util.Scanner;

public class Skeleton {

    static GameController gameController;

    public static void main(String[] args) {

        boolean end = false;

        gameController = new GameController();

        //Students
        Student testS1 = new Student();
        Student testS2 = new Student();
        Student testS3 = new Student();

        //Instructors
        Instructor testI1 = new Instructor();
        Instructor testI2 = new Instructor();
        Instructor testI3 = new Instructor();
        Instructor testI4 = new Instructor();

        //Rooms
        Room testR1 = new RegularRoom();
        Room testR2 = new RegularRoom();
        Room testR3 = new RegularRoom();

        //Items
        Camambert testCam = new Camambert();
        Dice testDice = new Dice();
        FFP2 testFFP = new FFP2();
        GlassOfBeer testGOB = new GlassOfBeer();
        SlideRule testSR = new SlideRule();
        Transistor testT1 = new Transistor();
        Transistor testT2 = new Transistor();
        TVSZ testTVSZ = new TVSZ();
        WetRag testWR = new WetRag();

        while(!end){
            System.out.println("1-Move");
            System.out.println("2-Character Goes To Character");
            System.out.println("3-Drop Item");
            System.out.println("4-Use Item");
            System.out.println("5-Pick Up Item");
            System.out.println("6-Idle Action");
            System.out.println("7-Merge Rooms");
            System.out.println("8-Split Room");
            System.out.println("9-Attack Item Effect");
            System.out.println("0-Exit\n");
            System.out.println("Valassz egy menupontot: ");
            int selectedMain;
            Scanner sc = new Scanner(System.in);
            selectedMain = Integer.parseInt(sc.next());

            //Main select
            switch (selectedMain){

                //Exit
                case 0:{
                    end = true;
                    break;
                }

                //Move
                case 1:{
                    System.out.println("1-Student Move");
                    System.out.println("2-Instructor Move\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedMove1;
                    Scanner sc2 = new Scanner(System.in);
                    selectedMove1 = Integer.parseInt(sc2.next());

                    //Select move1
                    switch (selectedMove1){

                        //Student Move
                        case 1:{
                            System.out.println("1-Transistor Jump");
                            System.out.println("2-Simple Move\n");
                            System.out.println("Valassz egy menupontot: ");
                            int selectedMove2;
                            Scanner sc3 = new Scanner(System.in);
                            selectedMove2 = Integer.parseInt(sc3.next());

                            //Select move2
                            switch(selectedMove2){

                                //Transistor Jump
                                case 1:{
                                    break;
                                }

                                //Simple move
                                case 2:{
                                    break;
                                }
                            }
                            break;
                        }

                        //Instructor move
                        case 2:{
                            break;
                        }
                    }
                    break;
                }

                //Character Goes To Character
                case 2:{
                    System.out.println("1-Instructor Goes To Student");
                    System.out.println("2-Student Goes To Instructor\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedCGTC;
                    Scanner sc4 = new Scanner(System.in);
                    selectedCGTC = Integer.parseInt(sc4.next());

                    //Select Character Goes To Character
                    switch (selectedCGTC){

                        //Instructor Goes To Student
                        case 1:{
                            break;
                        }

                        //Student Goes To Student
                        case 2:{
                            break;
                        }

                    }
                    break;
                }

                //Drop Item
                case 3:{
                    System.out.println("1-Drop GlassOfBeer");
                    System.out.println("2-Drop Dice");
                    System.out.println("3-Drop FFP2");
                    System.out.println("4-Drop TVSZ");
                    System.out.println("5-Drop Transistor");
                    System.out.println("6-Drop WetRag");
                    System.out.println("7-Drop Camambert\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToDrop;
                    Scanner sc5 = new Scanner(System.in);
                    selectedItemToDrop = Integer.parseInt(sc5.next());

                    //Select Item
                    switch(selectedItemToDrop){

                        //GlassOfBeer
                        case 1:{
                            break;
                        }

                        //Dice
                        case 2:{
                            break;
                        }

                        //FFP2
                        case 3:{
                            break;
                        }

                        //TVSZ
                        case 4:{
                            break;
                        }

                        //Transistor
                        case 5:{
                            break;
                        }

                        //WetRag
                        case 6:{
                            break;
                        }

                        //Camambert
                        case 7:{
                            break;
                        }

                    }
                    break;
                }

                //Use Item
                case 4:{
                    System.out.println("1-Use GlassOfBeer");
                    System.out.println("2-Use Dice");
                    System.out.println("3-Use FFP2");
                    System.out.println("4-Use TVSZ");
                    System.out.println("5-Use Transistor");
                    System.out.println("6-Use WetRag");
                    System.out.println("7-Use Camambert\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToUse;
                    Scanner sc6 = new Scanner(System.in);
                    selectedItemToUse = Integer.parseInt(sc6.next());

                    //Select Item
                    switch(selectedItemToUse){

                        //GlassOfBeer
                        case 1:{
                            break;
                        }

                        //Dice
                        case 2:{
                            break;
                        }

                        //FFP2
                        case 3:{
                            break;
                        }

                        //TVSZ
                        case 4:{
                            break;
                        }

                        //Transistor
                        case 5:{
                            break;
                        }

                        //WetRag
                        case 6:{
                            break;
                        }

                        //Camambert
                        case 7:{
                            break;
                        }

                    }
                    break;
                }

                //Pick Up Item
                case 5:{
                    System.out.println("1-Pick Up GlassOfBeer");
                    System.out.println("2-Pick Up Dice");
                    System.out.println("3-Pick Up FFP2");
                    System.out.println("4-Pick Up TVSZ");
                    System.out.println("5-Pick Up SlideRule\n");
                    System.out.println("6-Pick Up Transistor");
                    System.out.println("7-Pick Up WetRag");
                    System.out.println("8-Pick Up Camambert");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToPickUp;
                    Scanner sc7 = new Scanner(System.in);
                    selectedItemToPickUp = Integer.parseInt(sc7.next());

                    //Select Item
                    switch(selectedItemToPickUp) {

                        //GlassOfBeer
                        case 1: {
                            break;
                        }

                        //Dice
                        case 2: {
                            break;
                        }

                        //FFP2
                        case 3: {
                            break;
                        }

                        //TVSZ
                        case 4: {
                            break;
                        }

                        //SlideRule
                        case 5: {
                            break;
                        }

                        //Transistor
                        case 6: {
                            break;
                        }

                        //WetRag
                        case 7: {
                            break;
                        }

                        //Camambert
                        case 8:{
                            break;
                        }
                    }
                    break;
                }

                //Idle Action
                case 6:{
                    break;
                }

                //Merge Rooms
                case 7:{
                    break;
                }

                //Split Room
                case 8:{
                    break;
                }

                //AttackItem
                case 9:{
                    System.out.println("1-Attack TVSZ Effect");
                    System.out.println("2-Attack WetRag Effect");
                    System.out.println("2-Attack GlassOfBeer Effect\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedAttack;
                    Scanner sc8 = new Scanner(System.in);
                    selectedAttack = Integer.parseInt(sc8.next());

                    break;
                }
            }
        }


    }
}