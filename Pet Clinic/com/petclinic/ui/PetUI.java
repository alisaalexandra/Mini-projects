package com.petclinic.ui;

import com.petclinic.persistence.model.PetModel;
import com.petclinic.services.PetService;

import java.util.List;
import java.util.Scanner;

public class PetUI {
    private PetService petService = new PetService();
    private Scanner scanner = new Scanner(System.in);
    int option = -1;

    public void startPetUI() {
        while (option != 0) {
            System.out.println("1.View pets" +
                    "\n2.Add a new pet" +
                    "\n3.Delete an existing pet" +
                    "\n4.Update an existing pet" +
                    "\n0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                viewPets();
            }else if(option==2){
                addPet();
            }else if(option==3){
                detelePet();
            }else if(option==4){
                updatePet();
            }
        }
    }

        public void viewPets() {
            List<PetModel> pets = petService.viewPets();
            pets.stream().forEach(parameter -> System.out.println("Owner name: " + parameter.getOwnerName() + "\nRace: " + parameter.getRace() + "\nDate of birth: " + parameter.getBirthdate() + "\nID: "+ parameter.getCod()));
        }

        public void addPet() {
        PetModel pet = new PetModel();
            System.out.println("Owner name: ");
            pet.setOwnerName(scanner.nextLine());
            System.out.println("Date of birth: ");
            pet.setBirthdate(scanner.next());
            System.out.println("Race: ");
            pet.setRace(scanner.next());
            System.out.println("Is it vaccinated? Y/N");
            String option = scanner.next();
            if(option.equalsIgnoreCase("Y")){
                pet.setVaccinated(true);
            }else if (option.equalsIgnoreCase("N")){
                pet.setVaccinated(false);
            }
            petService.addPet(pet);
        }

        public void detelePet() {
            viewPets();
            System.out.println("Input ID: ");
            petService.deletePet(scanner.nextLong());
        }

        public void updatePet(){
        viewPets();
            System.out.println("Input ID: ");
            PetModel pet = petService.findByID(scanner.nextLong());
            System.out.println("What would you like to update? ");
            System.out.println("1.Owner name" +
                    "\n2.Race" +
                    "\n3.Date of birth" +
                    "\n4.If it's vaccinated or no");
            int pick = scanner.nextInt();
            if(pick==1){
                System.out.println("Input owner name: ");
                pet.setOwnerName(scanner.nextLine());
            }else if(pick==2){
                System.out.println("Input race: ");
                pet.setRace(scanner.next());
            }else if(pick==3){
                System.out.println("Input date: ");
                pet.setBirthdate(scanner.next());
            }else if(pick==4){
                System.out.println("Is it vaccinated?Y/N");
                String option = scanner.next();
                if(option.equalsIgnoreCase("Y")){
                    pet.setVaccinated(true);
                }else if (option.equalsIgnoreCase("N")){
                    pet.setVaccinated(false);
                }
            }
            petService.updatePet(pet);
        }
    }
