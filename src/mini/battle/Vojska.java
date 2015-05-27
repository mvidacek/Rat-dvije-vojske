package mini.battle;


public class Vojska {
    
    protected int brojVojnika;
    protected double moral;
    protected int snagaVojske;
    protected int normalnaSnaga = 50;
    
    public Vojska(int brojVojnika)
    {
        this.brojVojnika = brojVojnika;
        this.moral = 1.0;
        this.snagaVojske = normalnaSnaga;
    }

    /**
     * @return the brojVojnika
     */
    public int getBrojVojnika() {
        return brojVojnika;
    }

    /**
     * @param brojVojnika the brojVojnika to set
     */
    public void setBrojVojnika(int brojVojnika) {
        this.brojVojnika = brojVojnika;
    }

    /**
     * @return the moral
     */
    public double getMoral() {
        return moral;
    }

    /**
     * @param moral the moral to set
     */
    public void setMoral(double moral) {
        this.moral = moral;
    }

    /**
     * @return the snagaVojske
     */
    public int getSnagaVojske() {
        return (int) ((snagaVojske + brojVojnika / 10) * moral);
    }

    /**
     * @param snagaVojske the snagaVojske to set
     */
    public void setSnagaVojske(int snagaVojske) {
        this.snagaVojske = snagaVojske;
    }
    
    public void vratiSnaguUNormalu(){
        this.snagaVojske = normalnaSnaga;
    }    
    
}
