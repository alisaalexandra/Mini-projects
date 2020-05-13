package com.petclinic.ui;

import java.util.Scanner;

public class PetAppUI {

    private VetUI vetUI =  new VetUI();
    private PetUI petUI = new PetUI();
    private ConsultUI consultUI = new ConsultUI();

    public void startPetappUI(){
        Scanner scanner =  new Scanner(System.in);
        int option =  -1;
        while (option != 0 ) {

            System.out.println("Pet app");
            System.out.println("1.Veterinarian management");
            System.out.println("2.Pet management");
            System.out.println("3.Consult management");
            System.out.println("0.EXIT");
            option = scanner.nextInt();
            scanner.nextLine();
            if(option == 1){
                vetUI.startVeterinarUI();
            }else if(option==2){
                petUI.startPetUI();
            }else if(option==3){
                consultUI.startConsultUI();
            }

        }
    }
}
