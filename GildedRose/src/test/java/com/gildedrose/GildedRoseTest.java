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
    //assertEquals("foo", element.name, "the name changed");
    assert element.toString().equals("foo, 0, 0") : "the name changed";
  }

  @Test
  @DisplayName("Test for quality not going in the negative")
  void test_quality_pos() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    app.updateQuality();
    //assert element.quality >= 0 : "Quality in the negative";
    assert element.toString().equals("foo, 0, 0") : "Quality in the negative";
  }

 @Test
  @DisplayName("Test for Brie quality stop at 50 ")
  void test_brie_qual_reach50() {
    Item element = new Item("Aged Brie", 1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    //assert element.quality == 50 : "Quality of not stopping at 50";
    assert element.toString().equals("Aged Brie, 0, 50") : "Quality of not stopping at 50";
  }


  @Test
  @DisplayName("Test for Brie quality increase doubling afetr SellIn = 0")
  void test_brie_qual_inc() {
    Item element = new Item("Aged Brie", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    //assert element.quality == 9 : "Quality of brie not increasing normally";
    assert element.toString().equals("Aged Brie, 0, 9") : "Quality of brie not increasing normally";
  }


 
  @Test
  @DisplayName("Test for Sulfur quality stability >50 and sellin < 0")
  void test_sulf_qual_stab_over50() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -3, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    //assert element.quality >= 50 : "Sulfur changing quality";
    assert element.toString().equals("Sulfuras, Hand of Ragnaros, 0, 50") : "Sulfur changing quality";
  }

  @Test
  @DisplayName("Test for Sulfur quality stability 50>")
  void test_sulf_qual_stabunder50() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 3, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    //assert element.quality == 48 : "Sulfur changing quality if under 50";
    assert element.toString().equals("Sulfuras, Hand of Ragnaros, 0, 48") : "Sulfur changing quality if under 50";
  }


  @Test
  @DisplayName("Test for Backstage passes quality drop to 0 >")
  void test_drop_backstage_incr() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 5; i++) {
      app.updateQuality();
    }
    //assert element.quality == 0 : "Backstage not Decreasing quality after show";
    assert element.toString().equals("Backstage passes to a TAFKAL80ETC concert, 0, 0") : "Backstage not Decreasing quality after show";
  }

   @Test
  @DisplayName("Test for Backstage passes quality +2 and +3 increasing >")
  void test_2_and_3_backstage_incr() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 7; i++) {
      app.updateQuality();
    }
    //assert element.quality >= 14 : "Backstage not increasing correctly";
    assert element.toString().equals("Backstage passes to a TAFKAL80ETC concert, 4, 14") : "Backstage not increasing correctly";
  }


  @Test
  @DisplayName("Test for Backstage passes quality +1 and stop at 50")
  void test_1_backstage_incr_reach50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 25, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 8; i++) {
      app.updateQuality();
    }
    assert element.toString().equals("Backstage passes to a TAFKAL80ETC concert, 17, 50") : "Backstage passes does not stop at 50 when +1";
  }

  @Test
  @DisplayName("Test for Backstage passes quality +2 and stop at 50")
  void test_2_backstage_incr_reach50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    //assert element.quality == 50 : "Backstage passes does not stop at 50 when +2";
    assert element.toString().equals("Backstage passes to a TAFKAL80ETC concert, 7, 50") : "Backstage passes does not stop at 50 when +2";
  }


  @Test
  @DisplayName("Test for Backstage passes quality +3 and stop at 50")
  void test_3_backstage_incr_reach50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 46);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    //assert element.quality == 50 : "Backstage passes does not stop at 50 when +3";
    assert element.toString().equals("Backstage passes to a TAFKAL80ETC concert, 2, 50") : "Backstage passes does not stop at 50 when +3";
  }


  @Test
  @DisplayName("Test that decrease quality for random item")
  void test_random_quality_drop() {
    Item element = new Item("foo", 2, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 4; i++) {
      app.updateQuality();
    }
    //assert element.quality == 4 : "random item's quality not decreasing correctly";
    assert element.toString().equals("foo, 0, 4") : "random item's quality not decreasing correctly";
  }

  // Tests added for newly implemented cases

  @Test
  @DisplayName("Test that decrease quality for Conjured item")
  void test_Conjured_quality_drop() {
    Item element = new Item("Conjured foo", 2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 3; i++) {
      app.updateQuality();
    }
    //assert element.quality == 12 : "random item's quality not decreasing correctly";
    assert element.toString().equals("Conjured foo, 0, 12") : "Conjured item quality not decresing enough";
  }

  @Test
  @DisplayName("Test for Backstage passes for another show // another name >")
  void test_backstage_newname_incr() {
    Item element = new Item("Backstage passes to a foo concert", 11, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 7; i++) {
      app.updateQuality();
    }
    //assert element.quality >= 14 : "Backstage not increasing correctly";
    assert element.toString().equals("Backstage passes to a foo concert, 4, 14") : "Backstage not increasing correctly when using random concert name";
  }

  @Test
  @DisplayName("Test that conjured brie quality decrease >")
  void test_Conjured_brie() {
    Item element = new Item("Conjured Aged Brie", 2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 3; i++) {
      app.updateQuality();
    }
    //assert element.quality == 12 : "random item's quality not decreasing correctly";
    assert element.toString().equals("Conjured Aged Brie, 0, 12")  : "conjured brie quality not decreasing";
  }

  @Test
  @DisplayName("Test that conjured Sulfuras quality decrease >")
  void test_Conjured_sulfuras() {
    Item element = new Item("Conjured Sulfuras, Hand of Ragnaros", 2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    for (int i = 0; i < 3; i++) {
      app.updateQuality();
    }
    //assert element.quality == 12 : "random item's quality not decreasing correctly";
    assert element.toString().equals("Conjured Sulfuras, Hand of Ragnaros, 0, 12")  : "conjured sulfuras quality not decreasing";
  }

}