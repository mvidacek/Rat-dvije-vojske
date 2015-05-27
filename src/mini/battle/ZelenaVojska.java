package mini.battle;

// Zelena vojska ima vecu normalnu snagu
public class ZelenaVojska extends Vojska{

    public ZelenaVojska(int brojVojnika) {
         super(brojVojnika);
        this.moral = 1.0;
        this.normalnaSnaga = 70;
        this.snagaVojske = normalnaSnaga;
    }        
    
}
