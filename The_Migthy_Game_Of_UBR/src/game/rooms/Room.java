package game.rooms;

import game.characters.Character;
import game.items.Item;
import game.items.Transistor;
import game.items.WetRag;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    //A szobaban levo rongyok listaja
    private List<WetRag> wetRags;

    //A szobaban levo tranzisztor
    private Transistor transistor;

    //Megadja, hogy maximum hany db karakter lehet a szobaban egyszerre
    private int maxCharacter;

    //A szobaban levo jatekosok listaja
    private List<Character> listOfCharacters = new ArrayList<>();

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    public abstract void onEntered(Character c1);

    //input: Character c1
    //method: Hozzaadja az parameterkent kapott karaktert a szobahoz
    //return: void
    public void addCharacter(Character c1) {
        System.out.println("\t\t--> (testI1: Character).getRoom()");
        Room from = c1.getRoom();
        from = new RegularRoom();
        System.out.println("\t\t<-- from: Room");

        if (isAccessible(this)){
            System.out.println("\t\t--> (testR2: Room).addCharacter(testI1: Character)");
            this.listOfCharacters.add(c1);
            System.out.println("\t\t<--");

            System.out.println("\t\t--> (testR1: Room).removeCharacter(testI1: Character)");
            from.removeCharacter(c1);
            System.out.println("\t\t<--");

            System.out.println("\t\t--> (testR2: Room).onEntered(testI1: Character)");
            this.onEntered(c1);
            System.out.println("\t\t<--");


            //TODO NEM IS LETEZIK SIMA MEET METODUSUNK CSAK A SZEKVENCIAN

            System.out.println("\t\t--> (testI1: Character).meetStudent()");
            c1.meetStudent();
            System.out.println("\t\t<--");

            System.out.println("\t\t--> (testI1: Character).meetInstructor()");
            c1.meetInstructor();
            System.out.println("\t\t<--");
        }
    }

    //TODO
    public boolean isAccessible(Room r1) {return true;}

    //input: -
    //method: Visszaadja a szobaban talalhato karaktereket
    //return: List<Character>
    public List<Character> getCharacters() {return new ArrayList<>();}

    //input: Character c1
    //method: Kitorli a parameterkent kapott karaktert a szobabol
    //return: void
    public void removeCharacter(Character c1) {}

    //input: Item i1
    //method: Kitörli a parameterkent kapott Itemet a szobabol
    //return: void
    public void removeItem(Item i1) {}

    //input: Item i1
    //method: Hozzaadja a parameterkent kapott Item-et a szobahoz
    //return: void
    public void addItem(Item i1) {}

    //input: List<Item> l1
    //method: Hozzaadja a szobahoz a parameterkent kapott targyakat
    //return: void
    public void addItems(List<Item> l1) {}

    //input: -
    //method: Visszadja a szobaban talalhato targyakat
    //return: List<Item>
    public List<Item> getItems() { return new ArrayList<>();}

    //input: -
    //method: Visszaadja a szomszedos szobakat
    //return: List<Item>
    public List<Room> getNeighbours() {return new ArrayList<>();}

    //input: List<Item> l1
    //method: A parameterkent kapott lista tagjait hozzaadja a szoba szomszedaihoz
    //return: void
    public void addNeighbours(List<Room> l1) {}

    //input: List<Item> l1
    //method: Kitorli a szoba szomszedai kozul a parameterkent kapottakat
    //return: void
    public void removeNeighbours(List<Room> l1) {}

    //input: -
    //method: Visszaadja a szobaban elhelyezett tranzisztort
    //return: Transistor
    public Transistor geTransistor(){return null;}

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba targyainak, es a szomszedos szobainak a felet. Igy valosul meg az osztodas
    //return: void
    public void splitTo(Room other){}

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba osszes szomszedjat, es targyat. Igy valosul meg a szobak osszevonasa
    //return: void
    public void mergeTo(Room other){}

    //input: -
    //method: Atmasolja az r2-vel jelolt szobaba az adott szoba szomszedjait, targyait, es jatekosait
    //return: void
    public void copyToRoom(Room r2){}

    //input: Transistor added
    //method: Hozzaadja a parameterkent kapott tranzisztort a szobahoz
    //return: void
    public void addTransistor(Transistor added){}

    //input: WetRag added
    //method: Hozzaadja a parameterkent kapott rongyot a szobahoz.
    //return: void
    public void addWetRag(WetRag added){}
}