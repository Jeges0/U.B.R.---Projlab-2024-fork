package game;

import game.characters.Character;
import game.characters.Cleaner;
import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Skeleton {

    public static GameController gameController;

    public static void main(String[] args) throws IOException {

        gameController = GameController.getInstance();



    }

    public static void testPlay(int asd) {

        if (asd == 1 || asd == 69) {
            try {
                GameInitializer.initMaps("TESTMAP");
            } catch (IOException e) {
                System.out.println("Valami probléma van a fileokkal...");
            } catch (ClassNotFoundException e) {
                System.out.println("Hibás fileok...");
            }
            System.out.println("Beolvasás vége");
        } else if (asd == 0) {
            try {
                testMapBuilder(0);
            } catch (IOException e) {
                System.out.println("Hibás valami...");
            }
        }


        if (asd == 1 || asd == 69) {
            for (Room i : gameController.getInstance().getRooms()) {
                System.out.println(i.toString());
                for (Room j : i.getNeighbours()) {
                    System.out.println("\t" + j.toString());
                }
                for (Item k : i.getItems()) {
                    System.out.println("\t\t" + k.toString());
                }
                for (Character l : i.getCharacters()) {
                    System.out.println("--- \t" + l.toString());
                }
            }
        }


        if (asd == 69) {
            System.out.println("Play");
            gameController.play();
        }
    }

    // 10. beadáshoz test map
    // leírás: 2 játékos, 1 teacher, 1 cleaner, 7 szoba
    // Kiírja a mapot a TESTMAP_rooms.dat és TESTMAP_players.dat állományba
    public static void testMapBuilder(int mode) throws IOException {

        // játékosok:
        Student s1 = new Student();
        Student s2 = new Student();

        // NPC-k:
        Character npc1 = new Instructor();
        Character npc2 = new Cleaner();

        // startRoom:
        Room rs = new RegularRoom(); rs.setMaxCharacter(2);
        rs.putCharacter(s1);
        rs.putCharacter(s2);
        s1.setRoom(rs);
        s2.setRoom(rs);

        // Room1
        Room r1 = new RegularRoom(); r1.setMaxCharacter(4);
        TVSZ r1i1 = new TVSZ();  r1.addItem(r1i1);
        WetRag r1i2 = new WetRag(); r1i2.setWetness(3); r1.addItem(r1i2);

        // Room2
        Room r2 = new RegularRoom(); r2.setMaxCharacter(3);
        r2.putCharacter(npc1);
        npc1.setRoom(r2);

        // Room3
        Room r3 = new RegularRoom(); r3.setMaxCharacter(3);
        Camambert r3i1 = new Camambert(); r3.addItem(r3i1);
        GlassOfBeer r3i2 = new GlassOfBeer(); r3.addItem(r3i2);

        // Room4
        Room r4 = new RegularRoom(); r4.setMaxCharacter(3);
        r4.putCharacter(npc2);
        npc2.setRoom(r4);

        // Room5
        Room r5 = new RegularRoom(); r5.setMaxCharacter(3);
        FFP2 r5i1 = new FFP2(); r5i1.setDurability(3); r5.addItem(r5i1);

        // Room6
        Room r6 = new RegularRoom(); r6.setMaxCharacter(3);
        SlideRule r6i1 = new SlideRule(); r6.addItem(r6i1);

        // Mapping
        rs.addNeighbour(r1);
        r1.addNeighbour(r2);
        r1.addNeighbour(r3);
        r1.addNeighbour(r4);
        r2.addNeighbour(r1);
        r2.addNeighbour(r3);
        r4.addNeighbour(r1);
        r4.addNeighbour(r5);
        r5.addNeighbour(r4);
        r5.addNeighbour(r6);

        // generate finals
        ArrayList<Room> finalRooms = new ArrayList<>();
        ArrayList<Character> finalCharacters = new ArrayList<>();
        finalRooms.add(rs);
        finalRooms.add(r1);
        finalRooms.add(r2);
        finalRooms.add(r3);
        finalRooms.add(r4);
        finalRooms.add(r5);
        finalRooms.add(r6);
        finalCharacters.add(s1);
        finalCharacters.add(s2);
        finalCharacters.add(npc1);
        finalCharacters.add(npc2);

        if (mode == 1) {
            // generate files
            FileOutputStream mapFile = new FileOutputStream("TESTMAP_rooms.dat");
            FileOutputStream charFile = new FileOutputStream("TESTMAP_players.dat");
            ObjectOutputStream map = new ObjectOutputStream(mapFile);
            ObjectOutputStream chars = new ObjectOutputStream(charFile);
            map.writeObject(finalRooms);
            map.flush();
            map.close();
            chars.writeObject(finalCharacters);
            chars.flush();
            chars.close();
        } else if (mode == 0) {
            for (Room i : finalRooms) {
                gameController.addRoom(i);
            }
            for (Character i : finalCharacters) {
                gameController.addCharacter(i);
            }
        }


    }

    // előző beadásokhoz test esetek kiírása
    public static void tests() {
        boolean end = false;

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
                    continue;
                }

                //Move
                case 1:{
                    System.out.println("1-Student Move");
                    System.out.println("2-Instructor Move\n");
                    System.out.println("Valassz egy al-menupontot: ");
                    int selectedMove1;
                    Scanner sc2 = new Scanner(System.in);
                    selectedMove1 = Integer.parseInt(sc2.next());

                    //Select move1
                    switch (selectedMove1){

                        //Student Move
                        case 1:{
                            System.out.println("1-Transistor Jump");
                            System.out.println("2-Simple Move\n");
                            System.out.println("Valassz egy al-al-menupontot: ");
                            int selectedMove2;
                            Scanner sc3 = new Scanner(System.in);
                            selectedMove2 = Integer.parseInt(sc3.next());

                            //Select move2
                            switch(selectedMove2){

                                //Transistor Jump
                                case 1:{
                                    testS1.transistorJump();
                                    break;
                                }

                                //Simple move
                                case 2:{
                                    System.out.println("--> (testS1: Student).move(testR1: Room, testR2: Room)");
                                    testS1.move(testR1, testR2);
                                    System.out.println("<--");
                                    break;
                                }
                            }
                            break;
                        }

                        //Instructor move
                        case 2:{
                            System.out.println("--> (testI1: Instructor).move(testR1: Room, testR2: Room)");
                            testI1.move(testR1, testR2);
                            System.out.println("<--");
                            break;
                        }
                    }
                    break;
                }

                //Character Goes To Character
                case 2:{
                    System.out.println("1-Instructor Goes To Student");
                    System.out.println("2-Student Goes To Instructor\n");
                    System.out.println("Valassz egy al-menupontot: ");
                    int selectedCGTC;
                    Scanner sc4 = new Scanner(System.in);
                    selectedCGTC = Integer.parseInt(sc4.next());

                    //Select Character Goes To Character
                    switch (selectedCGTC){

                        //Instructor Goes To Student
                        case 1:{
                            testS1.meet(testI1);
                            break;
                        }

                        //Student Goes To Student
                        case 2:{
                            testI1.meet(testS1);
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
                            System.out.println("-->(testS1: Student).dropItem(testGOB)");
                            testS1.dropItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2:{
                            System.out.println("-->(testS1: Student).dropItem(testDice)");
                            testS1.dropItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3:{
                            System.out.println("-->(testS1: Student).dropItem(testFFP)");
                            testS1.dropItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //TVSZ
                        case 4:{
                            System.out.println("-->(testS1: Student).dropItem(testTVSZ)");
                            testS1.dropItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Transistor
                        case 5:{
                            System.out.println("-->(testS1: Student).dropItem(testT)");
                            testS1.dropItem(testT1);
                            System.out.println("<--");
                            break;
                        }

                        //WetRag
                        case 6:{
                            System.out.println("-->(testS1: Student).dropItem(testWR)");
                            testS1.dropItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 7:{
                            System.out.println("-->(testS1: Student).dropItem(testCam)");
                            testS1.dropItem(testCam);
                            System.out.println("<--");
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
                    System.out.println("4-Use Transistor");
                    System.out.println("5-Use WetRag");
                    System.out.println("6-Use Camambert\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToUse;
                    Scanner sc6 = new Scanner(System.in);
                    selectedItemToUse = Integer.parseInt(sc6.next());

                    //Select Item
                    switch(selectedItemToUse){

                        //GlassOfBeer
                        case 1:{
                            System.out.println("--> (testS1: Student).useItem(testGOB: GlassOfBeer)");
                            testS1.useItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2:{
                            System.out.println("--> (testS1: Student).useItem(testDice: Dice)");
                            testS1.useItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3:{
                            System.out.println("--> (testS1: Student).useItem(testFFP: FFP2)");
                            testS1.useItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //Transistor
                        case 4:{
                            System.out.println("--> (testS1: Student).useItem(testT1: Transistor)");
                            testS1.useItem(testT1);
                            System.out.println("<--");
                            break;
                        }

                        //WetRag
                        case 5:{
                            System.out.println("--> (testS1: Student).useItem(testWR: WetRag)");
                            testS1.useItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 6:{
                            System.out.println("--> (testS1: Student).useItem(testCam: Camambert)");
                            testS1.useItem(testCam);
                            System.out.println("<--");
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
                    System.out.println("5-Pick Up SlideRule");
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
                            System.out.println("--> (testS1: Student).pickUpItem(testGOB: GlassOfBeer)");
                            testS1.pickUpItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2: {
                            System.out.println("--> (testS1: Student).pickUpItem(testDice: Dice)");
                            testS1.pickUpItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3: {
                            System.out.println("--> (testS1: Student).pickUpItem(testFFP: FFP2)");
                            testS1.pickUpItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //TVSZ
                        case 4: {


                            System.out.println("--> (testS1: Student).pickUpItem(testTVSZ: TVSZ)");
                            testS1.pickUpItem(testTVSZ);
                            System.out.println("<--");

                            break;
                        }

                        //SlideRule
                        case 5: {

                            System.out.println("--> (testS1: Student).pickUpItem(testSR: SlideRule)");
                            testS1.pickUpItem(testSR);
                            System.out.println("<--");

                            break;
                        }

                        //Transistor
                        case 6: {
                            System.out.println("--> (testS1: Student).pickUpItem(testT1: Transistor)");
                            testS1.pickUpItem(testT1);
                            System.out.println("<--");

                            break;
                        }

                        //WetRag
                        case 7: {
                            System.out.println("--> (testS1: Student).pickUpItem(testWR: WetRag)");
                            testS1.pickUpItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 8:{
                            System.out.println("--> (testS1: Student).pickUpItem(testCam: Camambert)");
                            testS1.pickUpItem(testCam);
                            System.out.println("<--");
                            break;
                        }
                    }
                    break;
                }

                //Idle Action
                case 6:{
                    testS1.idle();
                    break;
                }

                //Merge Rooms
                case 7:{
                    gameController.mergeRooms(testR1, testR2);
                    break;
                }

                //Split Room
                case 8:{
                    gameController.slpitRoom(testR1);
                    break;
                }

                //AttackItem
                case 9:{
                    System.out.println("1-Attack TVSZ Effect");
                    System.out.println("2-Attack WetRag Effect");
                    System.out.println("3-Attack GlassOfBeer Effect\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedAttack;
                    Scanner sc8 = new Scanner(System.in);
                    selectedAttack = Integer.parseInt(sc8.next());

                    //Pick Item
                    switch (selectedAttack){

                        //TVSZ Attack Effect
                        case 1: {
                            testTVSZ.onAttacked(testS1, testI1);
                            break;
                        }

                        //WetRag Attack Effect
                        case 2: {
                            testWR.onAttacked(testS1, testI2);
                            break;
                        }

                        //GlassOfBeer Attack Effect
                        case 3: {
                            testGOB.onAttacked(testS1, testI1);
                            break;
                        }
                    }

                    break;
                }
            }
            System.out.println("Press enter to continue..");
            Scanner con = new Scanner(System.in);
            if(con.hasNextLine()){
                continue;
            }
        }
    }
}