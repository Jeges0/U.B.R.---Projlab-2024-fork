package game.rooms;
import game.characters.Character;

import java.io.Serializable;

public class GasRoom extends Room  implements Serializable {

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    @Override
    public void onEntered(Character c1) {
        c1.stun(2);
        for(Character ch : this.getCharacters()){
            ch.meet(c1);
        }
    }
}
