package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {


@Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test for quality not going in the negative")
  void test_quality_pos() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    app.updateQuality();
    assert element.quality >= 0 : "Quality in the negative";
  }

 


  @Test
  @DisplayName("Test for Brie quality increase doubling afetr SellIn = 0")
  void test_brie_qual_inc() {
    Item element = new Item("Aged Brie", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    assert element.quality == 9 : "Quality of brie not increasing normally";
  }


 
  @Test
  @DisplayName("Test for Sulfur quality stability >50 and sellin < 0")
  void test_sulf_qual_stab_over50() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -3, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    assert element.quality >= 50 : "Sulfur changing quality";
   }

  @Test
  @DisplayName("Test for Sulfur quality stability 50>")
  void test_sulf_qual_stabunder50() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 3, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    assert element.quality == 48 : "Sulfur changing quality if under 50";
   }


  @Test
  @DisplayName("Test for Backstage passes quality drop to 0 >")
  void test_drop_backstage_incr() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    assert element.quality == 0 : "Backstage not Decreasing quality after show";
   }

   @Test
  @DisplayName("Test for Backstage passes quality +2 and +3 increasing >")
  void test_2_and_3_backstage_incr() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 7; i++) {
      app.updateQuality();
    }
    assert element.quality >= 14 : "Backstage not increasing correctly";
  }


  

  @Test
  @DisplayName("Test for Backstage passes quality +2 and stop at 50")
  void test_2_backstage_incr_reach50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    assert element.quality == 50 : "Backstage passes does not stop at 50 when +2";
     }


  @Test
  @DisplayName("Test for Backstage passes quality +3 and stop at 50")
  void test_3_backstage_incr_reach50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    assert element.quality == 50 : "Backstage passes does not stop at 50 when +3";
    
  }

  @Test
  @DisplayName("Test that decrease quality for random item")
  void test_random_quality_drop() {
    Item element = new Item("foo", 2, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    assert element.quality == 4 : "random item's quality not decreasing correctly";
    
  }

  @Test
  @DisplayName("Test for Brie quality goes to 50 ")
  void test_brie_qual_reach50() {
    Item element = new Item("Aged Brie", 1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    assert element.quality >= 50 : "Quality of not going to 50";
   }


}