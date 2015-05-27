package mini.battle;

//Plava vojska ima bonus na broj vojnika
public class PlavaVojska extends Vojska{

    public PlavaVojska(int brojVojnika) {
        super(brojVojnika + brojVojnika/10);
        this.moral = 1.0;
        this.snagaVojske = normalnaSnaga;
    }
    
    
}
