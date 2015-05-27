package mini.battle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Dogadjaj {
    
    private Map<Integer, String> uvjeti;
    private int trenutniUvjet;
    private Random slucajnost;
    
    
    public Dogadjaj(){
        this.uvjeti = new HashMap<>();
        uvjeti.put(0, "Nema posebnih uvjeta");
        uvjeti.put(1, "Magla, obje vojske gube snagu");
        uvjeti.put(2, "Pozar, obje vojske gube dio vojnika");
        uvjeti.put(3, "Sreca za mene");
        uvjeti.put(4, "Sreca za protivnika");        
    }
    
    public void slucajniUvjet(){
        this.slucajnost = new Random();
        this.setTrenutniUvjet(slucajnost.nextInt(5));
        System.out.println(uvjeti.get(trenutniUvjet));
    }

    /**
     * @return the trenutniUvjet
     */
    public int getTrenutniUvjet() {
        return trenutniUvjet;
    }

    /**
     * @param trenutniUvjet the trenutniUvjet to set
     */
    public void setTrenutniUvjet(int trenutniUvjet) {
        this.trenutniUvjet = trenutniUvjet;
    }
    
    
    
}
