package mini.battle;

//Moral crvene vojske ne moze pasti ispod 1.0
public class CrvenaVojska extends Vojska{

    public CrvenaVojska(int brojVojnika) {
        super(brojVojnika);
        this.moral = 1.0;
        this.snagaVojske = normalnaSnaga;
    }
    
    @Override
    public void setMoral(double moral) {
        if(moral < 1.0){
            moral = 1.0;
        }
        this.moral = moral;
    }    
}
