import java.util.Scanner;
public class Menu {
    public Menu() {
        try (Scanner hover = new Scanner(System.in)) { // DeepSeek (IA).
            // Antes: hover.close()
            int option = 0;
            String frame = "=================================";
            String frame2 = "---------------------------------";
            String frame3 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
            String frame4 = "*********************************";
            Outfits outfits = new Outfits();
            while (option != 3) {
                
                // Menú inicial.
                System.out.println(frame);
                System.out.println("OUTFITS");
                System.out.println("1: Elegir.");
                System.out.println("2: Detalles.");
                System.out.println("3: Salir.");
                System.out.print("\nDigíte la opción deseada: ");
                
                // Manejo de errores.
                try {
                    option = Integer.parseInt(hover.nextLine());
                } catch(Exception optionError) {
                    System.out.println(frame3);
                    System.out.println("¡ERROR!: " + optionError);
                }
                
                // Condicionales.
                if (option == 1) {
                    int shirt = -1;
                    int pants = -1;
                    int shoes = -1;
                    System.out.println("\n<<<ELEGIR>>>");
                    
                    // Camisas.
                    while (shirt > 2 || shirt < 0) {
                        System.out.println(frame2);
                        System.out.println("\nCAMISAS DISPONIBLES");
                        outfits.outfitShirts(option);
                        System.out.print("\nDigíte la camisa deseada: ");
                        try {
                            shirt = Integer.parseInt(hover.nextLine());
                            shirt -= 1;
                            shirt = outfits.shirtCheck(shirt);
                        } catch(Exception shirtError) {
                            System.out.println(frame3);
                            System.out.println("¡ERROR!: " + shirtError);
                        }
                    }
                    
                    // Pantalones.
                    while (pants > 2 || pants < 0) {
                        System.out.println(frame2);
                        System.out.println("\nPANTALONES DISPONIBLES");
                        outfits.outfitPants(option);
                        System.out.print("\nDigíte el pantalón deseado: ");
                        try {
                            pants = Integer.parseInt(hover.nextLine());
                            pants -= 1;
                            pants = outfits.pantsCheck(pants);
                        } catch(Exception pantsError) {
                            System.out.println(frame3);
                            System.out.println("¡ERROR!: " + pantsError);
                        }
                    }
                    
                    // Zapatos.
                    while (shoes > 2 || shoes < 0) {
                        System.out.println(frame2);
                        System.out.println("\nZAPATOS DISPONIBLES");
                        outfits.outfitShoes(option);
                        System.out.print("\nDigíte los zapatos deseados: ");
                        try {
                            shoes = Integer.parseInt(hover.nextLine());
                            shoes -= 1;
                            shoes = outfits.shoesCheck(shoes);
                        } catch(Exception shoesError) {
                            System.out.println(frame3);
                            System.out.println("¡ERROR!: " + shoesError);
                        }
                    }
                    
                    // Print y ciclo.
                    outfits.outfitCycle();
                    System.out.println(frame2);
                    System.out.println("");
                    System.out.println(frame4);
                    System.out.println("\nOUTFIT DEL DÍA");
                    outfits.pickShirt(shirt, option);
                    outfits.pickPants(pants, option);
                    outfits.pickShoes(shoes, option);
                    System.out.println("");
                    System.out.println(frame4);
                    System.out.println("");
                } else if (option == 2) {
                    int detMenu = 0;
                    int shirt = -1;
                    int pants = -1;
                    int shoes = -1;
                    while (detMenu == 0) {
                        
                        // Menú [Detalles].
                        System.out.println(frame2);
                        System.out.println("\n<<<DETALLES>>>");
                        System.out.println("1: Camisas.");
                        System.out.println("2: Pantalones.");
                        System.out.println("3: Zapatos.");
                        System.out.print("\nDigíte la opción deseada: ");
                        try {
                            detMenu = Integer.parseInt(hover.nextLine());
                        } catch(Exception detMenuError) {
                            System.out.println(frame3);
                            System.out.println("¡ERROR!: " + detMenuError);
                            detMenu = 0;
                        }
                        
                        // Condicionales.
                        if (detMenu == 1) {
                            
                            // Camisas.
                            while (shirt > 2 || shirt < 0) {
                                System.out.println(frame2);
                                System.out.println("\nCAMISAS");
                                outfits.outfitShirts(option);
                                System.out.print("\nDigíte la camisa deseada: ");
                                try {
                                    shirt = Integer.parseInt(hover.nextLine());
                                    shirt -= 1;
                                } catch(Exception shirtError) {
                                    System.out.println(frame3);
                                    System.out.println("¡ERROR!: " + shirtError);
                                }
                            }
                            System.out.println(frame2);
                            System.out.println("");
                            System.out.println(frame4);
                            outfits.pickShirt(shirt, option);
                            System.out.println("");
                            System.out.println(frame4);
                            System.out.println("");
                        } else if (detMenu == 2) {
                            
                            // Pantalones
                            while (pants > 2 || pants < 0) {
                                System.out.println(frame2);
                                System.out.println("\nPANTALONES");
                                outfits.outfitPants(option);
                                System.out.print("\nDigíte el pantalón deseado: ");
                                try {
                                    pants = Integer.parseInt(hover.nextLine());
                                    pants -= 1;
                                } catch(Exception pantsError) {
                                    System.out.println(frame3);
                                    System.out.println("¡ERROR!: " + pantsError);
                                }
                            }
                            System.out.println(frame2);
                            System.out.println("");
                            System.out.println(frame4);
                            outfits.pickPants(pants, option);
                            System.out.println("");
                            System.out.println(frame4);
                            System.out.println("");
                        } else if (detMenu == 3) {
                            
                            // Zapatos.
                            while (shoes > 2 || shoes < 0) {
                                System.out.println(frame2);
                                System.out.println("\nZAPATOS");
                                outfits.outfitShoes(option);
                                System.out.print("\nDigíte los zapatos deseados: ");
                                try {
                                    shoes = Integer.parseInt(hover.nextLine());
                                    shoes -= 1;
                                } catch(Exception shoesError) {
                                    System.out.println(frame3);
                                    System.out.println("¡ERROR!: " + shoesError);
                                }
                            }
                            System.out.println(frame2);
                            System.out.println("");
                            System.out.println(frame4);
                            outfits.pickShoes(shoes, option);
                            System.out.println("");
                            System.out.println(frame4);
                            System.out.println("");
                        } else {
                            System.out.println("OPCIÓN INVÁLIDA.");
                            detMenu = 0;
                        }
                    }
                } else if (option == 3) {
                    System.out.println("\nFIN.");
                    System.out.println(frame);
                    break;
                }
            }
        }
    }
}