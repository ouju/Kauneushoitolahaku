package Mallit;

public class Yritys {

    private int id;
    private String tunnus;
    private String salasana;

    public Yritys(int id, String tunnus, String salasana) {
        this.id = id;
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    public int detID() {
        return id;
    }
    
    public void setID(int id){
        this.id=id;
    }
    
    public String getTunnus(){
        return tunnus;
    }
    
    public void setTunnut(String tunnus){
        this.tunnus=tunnus;
    }
    
    public String getSalasana(){
        return salasana;
    }
    
    public void setSalasana(String salasana){
        this.salasana=salasana;
    }
}
