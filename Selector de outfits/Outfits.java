public class Outfits {
    private String frame;
    // Camisas.
    public Shirt pikachu;
    public Shirt messiShirt;
    public Shirt hoodie;
    public Shirt[] shirtList;
    // Pantalones.
    public Pants jeans;
    public Pants messiShorts;
    public Pants joggers;
    public Pants[] pantsList;
    // Zapatos.
    public Shoes crocs;
    public Shoes messiShoes;
    public Shoes sneakers;
    public Shoes[] shoesList;
    public Outfits() {
        frame = "! ! ! ! !";
        
        // Camisas.
        pikachu = new Shirt();
        pikachu.setShirtParam("AMARILLO", "CAMISETA", "PIKACHU", 51);
        messiShirt = new Shirt();
        messiShirt.setShirtParam("AZULGRANA", "JERSEY", "BARCELONA MESSI 10", 51);
        hoodie = new Shirt();
        hoodie.setShirtParam("CREMA", "HOODIE", "Protección Gélida IV", 51);
        shirtList = new Shirt[3];
        shirtList[0] = pikachu;
        shirtList[1] = messiShirt;
        shirtList[2] = hoodie;
        
        // Pantalones.
        jeans = new Pants();
        jeans.setPantsParam("JEANS AZULES", 51, 4);
        messiShorts = new Pants();
        messiShorts.setPantsParam("SHORTS BARCELONA MESSI 10", 51, 0);
        joggers = new Pants();
        joggers.setPantsParam("JOGGERS VERDE", 51, 6);
        pantsList = new Pants[3];
        pantsList[0] = jeans;
        pantsList[1] = messiShorts;
        pantsList[2] = joggers;
        
        // Zapatos.
        crocs = new Shoes();
        crocs.setShoesParam("SHREK", "CROCS", 51);
        messiShoes = new Shoes();
        messiShoes.setShoesParam("ADIDAS F50", "BOTÍNES", 51);
        sneakers = new Shoes();
        sneakers.setShoesParam("RAYO MCQUEEN", "TENIS", 51);
        shoesList = new Shoes[3];
        shoesList[0] = crocs;
        shoesList[1] = messiShoes;
        shoesList[2] = sneakers;
    }
    
    // Camisas.
    public void outfitShirts(int mode) {
        for (int i = 0; i < shirtList.length; i++) {
            if (mode == 1) {
                if (! shirtList[i].getCDstatus()) {
                    System.out.println(i + 1 + ". " + shirtList[i].getName());
                } else {
                     System.out.println(i + 1 + ". " + shirtList[i].getName() + " **¡USADO!**");
                }
            } else {
                System.out.println(i + 1 + ". " + shirtList[i].getName());
            }
        }
    }
    public void pickShirt(int shirt, int mode) {
        if (mode == 1) {
            shirtList[shirt].setShirtCD(shirtList.length / 2);
            shirtList[shirt].setCDstatus();
            System.out.println("Camisa: " + shirtList[shirt].getName());
        } else {
            shirtList[shirt].getShirtParam();
        }
    }
    public int shirtCheck(int shirt) {
        if (shirtList[shirt].getShirtCD() > 0) {
            System.out.println(frame);
            System.out.println(shirtList[shirt].getName() + " no está disponible hasta dentro de " + shirtList[shirt].getShirtCD() + " ciclo(s)");
            System.out.println(frame);
            shirt = -1;
            return shirt;
        } else {
            return shirt;
        }
    }

    // Pantalones.
    public void outfitPants(int mode) {
        for (int i = 0; i < pantsList.length; i++) {
            if (mode == 1) {
                if (! pantsList[i].getCDstatus()) {
                    System.out.println(i + 1 + ". " + pantsList[i].getName());
                } else {
                    System.out.println(i + 1 + ". " + pantsList[i].getName() + " **¡USADO!**");
                }
            } else {
                System.out.println(i + 1 + ". " + pantsList[i].getName());
                }
        }
    }
    public void pickPants(int pants, int mode) {
        if (mode == 1) {
            pantsList[pants].setPantsCD(pantsList.length / 2);
            pantsList[pants].setCDstatus();
            System.out.println("Pantalón: " + pantsList[pants].getName());
        } else {
            pantsList[pants].getPantsParam();
        }
    }
    public int pantsCheck(int pants) {
        if (pantsList[pants].getPantsCD() > 0) {
            System.out.println(frame);
            System.out.println(pantsList[pants].getName() + " no están disponible hasta dentro de " + pantsList[pants].getPantsCD() + " ciclo(s)");
            System.out.println(frame);
            pants = -1;
            return pants;
        } else {
            return pants;
        }
    }
    
    // Zapatos.
    public void outfitShoes(int mode) {
        for (int i = 0; i < shoesList.length; i++) {
            if (mode == 1) {
                if (shoesList[i].getWear() < 100) {
                    if (! shoesList[i].getCDstatus()) {
                        System.out.println(i + 1 + ". " + shoesList[i].getName());
                    } else {
                         System.out.println(i + 1 + ". " + shoesList[i].getName() + " **¡USADOS!**");
                    }
                } else {
                    System.out.println(i + 1 + ". " + shoesList[i].getName() + " **¡ROTOS!**");
                }
            } else {
                System.out.println(i + 1 + ". " + shoesList[i].getName());
            }
        }
    }
    public void pickShoes(int shoes, int mode) {
        if (mode == 1) {
            shoesList[shoes].setShoesCD(shoesList.length / 2);
            shoesList[shoes].setCDstatus();
            shoesList[shoes].setWear();
            System.out.println("Zapatos: " + shoesList[shoes].getName());
        } else {
            shoesList[shoes].getShoesParam();
        }
    }
    public int shoesCheck(int shoes) {
        if (shoesList[shoes].getWear() == 100) {
            System.out.println(frame);
            System.out.println("¡Los zapatos " + shoesList[shoes].getName() + " están rotos!");
            System.out.println(frame);
            shoes = -1;
            return shoes;
        } else if (shoesList[shoes].getShoesCD() > 0) {
            System.out.println(frame);
            System.out.println(shoesList[shoes].getName() + " no están disponible hasta dentro de " + shoesList[shoes].getShoesCD() + " ciclo(s)");
            System.out.println(frame);
            shoes = -1;
            return shoes;
        } else {
            return shoes;
        }
    }
    
    // Cooldown global.
    public void outfitCycle() {
        
        // Camisas.
        for (int i = 0; i < shirtList.length; i++) {
            if (shirtList[i].getCDstatus()) {
                shirtList[i].cycle();
                if (shirtList[i].getShirtCD() == 0) {
                    shirtList[i].setCDstatus();
                }
            }
        }
        
        // Pantalones.
        for (int i = 0; i < pantsList.length; i++) {
            if (pantsList[i].getCDstatus()) {
                pantsList[i].cycle();
                if (pantsList[i].getPantsCD() == 0) {
                    pantsList[i].setCDstatus();
                }
            }
        }
        
        // Zapatos.
        for (int i = 0; i < shoesList.length; i++) {
            if (shoesList[i].getCDstatus()) {
                shoesList[i].cycle();
                if (shoesList[i].getShoesCD() == 0) {
                    shoesList[i].setCDstatus();
                }
            }
        }
    }
}