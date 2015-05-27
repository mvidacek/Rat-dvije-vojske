package mini.battle;

import java.util.Scanner;


public class MiniBattle {

    
    public static void main(String[] args) {                
        Scanner ulaz = new Scanner(System.in);
        boolean nastavi = true;
        while(nastavi){
            System.out.println("Dobro dosli u miny battle.");
            System.out.println("Prvo radite svoju vojsku");
            Vojska mojaVojska = napraviVojsku(ulaz);
            System.out.println("Sada radite protivnicku vojsku");
            Vojska protivnickaVojska = napraviVojsku(ulaz);            
            if(mojaVojska.getBrojVojnika() != 0 && protivnickaVojska.getBrojVojnika() != 0){
                System.out.println("Vojska koja prva padne na 0 preostalih vojnika gubi bitku.");
                if(razrijesiBitku(mojaVojska, protivnickaVojska)){
                    System.out.println("Cestitam, pobjedili ste.");
                } else{
                    System.out.println("Bojim se da ste izgubili.");
                }
            }
            nastavi = provjeri(ulaz);            
        }
        
    }

    private static int unesiBroj(Scanner ulaz) {
        int broj = 0;
        try{
            broj = Integer.parseInt(ulaz.nextLine());
            return broj;
        } catch(Exception ex){
            System.out.println("Mora biti prirodan broj, ne smije sadrzavati slova i znakove.");
            return 0;
        }
    }

    private static boolean razrijesiBitku(Vojska mojaVojska, Vojska protivnickaVojska) {
        Dogadjaj bojnopolje = new Dogadjaj();        
        int mojaSnagaOvajKrug = 0;
        int protivnickaSnagaOvajKrug = 0;
        while(true){
            //Protivnik pobjedjuje i u slucaju da su obje vojske ostale bez vojnika
            if(mojaVojska.getBrojVojnika() <= 0){
                return false;
            //ja pobjedujem
            }else if(protivnickaVojska.getBrojVojnika() <= 0){
                return true;
            }
            //bitka se nastavlja
            else{
                if(mojaVojska.getBrojVojnika() > protivnickaVojska.getBrojVojnika()){
                    mojaVojska.setMoral(1.2);
                    protivnickaVojska.setMoral(0.9);                    
                }
                else if(mojaVojska.getBrojVojnika() < protivnickaVojska.getBrojVojnika()){
                    mojaVojska.setMoral(0.9);
                    protivnickaVojska.setMoral(1.2);
                }
                else{
                    mojaVojska.setMoral(1.0);
                    protivnickaVojska.setMoral(1.0);
                }
                mojaVojska.vratiSnaguUNormalu();
                protivnickaVojska.vratiSnaguUNormalu();
                bojnopolje.slucajniUvjet();
                switch(bojnopolje.getTrenutniUvjet()){
                    case 0:
                        mojaSnagaOvajKrug = mojaVojska.getSnagaVojske();
                        protivnickaSnagaOvajKrug = protivnickaVojska.getSnagaVojske();
                        break;
                     case 1:
                        mojaSnagaOvajKrug = (int)(mojaVojska.getSnagaVojske() * 0.1);
                        protivnickaSnagaOvajKrug = (int)(protivnickaVojska.getSnagaVojske() * 0.1);
                        break;
                    case 2:
                        mojaVojska.setBrojVojnika(mojaVojska.getBrojVojnika() - (mojaVojska.getBrojVojnika() / 10));
                        protivnickaVojska.setBrojVojnika(protivnickaVojska.getBrojVojnika() - (protivnickaVojska.getBrojVojnika() / 10));
                        mojaSnagaOvajKrug = mojaVojska.getSnagaVojske();
                        protivnickaSnagaOvajKrug = protivnickaVojska.getSnagaVojske();
                        break;
                    case 3:
                        mojaSnagaOvajKrug = (int)(mojaVojska.getSnagaVojske() * 1.2);
                        protivnickaSnagaOvajKrug = protivnickaVojska.getSnagaVojske();
                        break;
                    case 4:
                        mojaSnagaOvajKrug = mojaVojska.getSnagaVojske();
                        protivnickaSnagaOvajKrug = (int)(protivnickaVojska.getSnagaVojske() * 1.2);
                        break;
                    default:
                        break;
                }
                mojaVojska.setBrojVojnika(mojaVojska.getBrojVojnika() - protivnickaSnagaOvajKrug);
                protivnickaVojska.setBrojVojnika(protivnickaVojska.getBrojVojnika() - mojaSnagaOvajKrug);
            }
        }        
    }

    private static Vojska napraviVojsku(Scanner ulaz) {
        System.out.print("Odaberite boju svoje vojske: Plava(1), Zelena(2), Crvena(3): ");
        int odabirBoje = 1;
        try{
            odabirBoje = Integer.parseInt(ulaz.nextLine());
        }catch(Exception ex){
            System.out.println("Brojevi moraju biti 1, 2 ili 3. Dodjeljen vam je broj 1.");
        }
        System.out.print("Odaberite broj svojih vojnika (mora biti prirodni broj): ");
        int brojVojnika = unesiBroj(ulaz);        
        switch(odabirBoje){
            case 1:
                return new PlavaVojska(brojVojnika);                
            case 2:
                return new ZelenaVojska(brojVojnika);
            case 3:
                return new CrvenaVojska(brojVojnika);
                //Ako je za boju upisan nepropisan broj dodjeljena je plava vojska
            default:
                return new PlavaVojska(brojVojnika);                
        }
    }

    private static boolean provjeri(Scanner ulaz) {
        System.out.println("Zelite li nastaviti? (Y/N): ");
            String odabir;
            try{
                odabir = ulaz.nextLine();
            return ("Y".equals(odabir) || "y".equals(odabir));
            } catch(Exception ex){
                return false;
            }
    }    
}
