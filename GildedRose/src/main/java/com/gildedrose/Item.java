package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private String[] contained_cases = {"Conjured", "Backstage passes"};
 

    public void updateItem(){
        
        String Switch_test_name = name;

        int i;
        for(i = 0; i < contained_cases.length; i++) 
        if(name.contains(contained_cases[i])){
            Switch_test_name = contained_cases[i];   
            break; 
        } 

        switch(Switch_test_name){

                default :
                    quality +=(-1);
                    if (sellIn == 0){
                        quality +=(-1);
                    } 
                    break;

                case "Conjured":
                    quality +=(-2);
                    if (sellIn == 0){
                            quality +=(-2);
                        } 
                    break; 

                case "Backstage passes":
                        quality ++;
                    if (sellIn == 0){
                        quality = 0;
                    } else if (sellIn < 6) {
                        quality +=2;
                    } else if (sellIn < 11) {
                        quality ++;
                        }
                    break;    
    
                case "Sulfuras, Hand of Ragnaros":
                    break; 
    
                case "Aged Brie":
                    quality ++;
                    if (sellIn == 0){
                        quality ++; 
                    }
                    break;
                }

                

        sellIn = Math.max(0, (sellIn - 1));
        quality = Math.max(0,Math.min(50, (quality)));
    
    }
        
    
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn =  Math.max(0, sellIn );
        this.quality = Math.min(50, Math.max(0, quality));
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}