package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public void updateItem(){
        

        switch(name){

                default :
                    quality +=(-1);
                    if (sellIn == 0){
                        quality +=(-1);
                    } 
                    break;

                

                case "Backstage passes to a TAFKAL80ETC concert":
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
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
