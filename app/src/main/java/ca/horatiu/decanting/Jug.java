package ca.horatiu.decanting;

import java.io.Serializable;

/**
 * Created by Horatiu on 25/06/2016.
 */
public class Jug implements Serializable{
    private int col;
    private int maxCapacity;
    private int volume;

    public Jug(int col, int maxCapacity){
        this.col = col;
        this.maxCapacity = maxCapacity;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getCol(){
        return col;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void empty(){
        volume = 0;
    }

    public void fill(){
        volume = maxCapacity;
    }

    //this method is for pouring liquid to  another jug
    public void pour(Jug other){
        /* This case if for an overflow.
            Ex: 5ml poured into a 2ml bottle. Decrease the pouring one by the difference.
         */
        if (other.getMaxCapacity() <  other.getVolume() + volume){
            volume -= other.getMaxCapacity() - other.getVolume();
            other.setVolume(other.getMaxCapacity());
        }
        else{
            other.setVolume(other.getVolume() + volume); //you pour from yours to the other one!
            volume = 0;
        }
    }

    public int getVolume(){
        return volume;
    }
    
    public String toString(){
      return volume + "";
    }
}
