package leetcode.pattern.builder.meal;

import leetcode.pattern.builder.item.Item;

import java.util.ArrayList;

/**
 * Created by Joshua on 5/14/17.
 */
public abstract class Meal {

    private ArrayList<Item> arrayList = new ArrayList<Item>();

    public void addItem(Item item){
        arrayList.add(item);
    }

    public void showItems(){

        for(int i=0;i<arrayList.size();i++){
            Item item=arrayList.get(i);
            System.out.println(String.format("Item: %s, Packing: %s, Price: %s",item.name(),item.packing(),item.price()));
        }
    }

    public float getCost(){
        float total=0f;
        for(int i=0;i<arrayList.size();i++){
            Item item=arrayList.get(i);
            total+=item.price();
        }
        return total;
    }
}
