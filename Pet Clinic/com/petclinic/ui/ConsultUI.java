package com.petclinic.ui;

import com.petclinic.persistence.model.ConsultModel;
import com.petclinic.persistence.model.PetModel;
import com.petclinic.persistence.model.VetModel;
import com.petclinic.services.ConsultService;
import com.petclinic.services.PetService;
import com.petclinic.services.VetService;

import java.util.List;
import java.util.Scanner;

public class ConsultUI {
    private ConsultService consultService = new ConsultService();
    private VetService vetService = new VetService();
    private PetService petService = new PetService();

    private Scanner scanner = new Scanner(System.in);
    int option = -1;

    public void startConsultUI() {
        while (option != 0) {
            System.out.println("1.View consults" +
                    "\n2.Add consult" +
                    "\n3.Update description" +
                    "\n0.Back");
            option=scanner.nextInt();
            scanner.nextLine();
            if(option==1){
                viewConsults();
            }else if(option==2){
                addConsult();
            }else if (option==3){
                updateDescription();
            }
        }
    }

    public void viewConsults(){
        List<ConsultModel> consults = consultService.viewConsults();
        consults.stream().forEach(parameter -> System.out.println("Veteranian: " + parameter.getVet().getLastName() + " "+
                parameter.getVet().getFirstName() + "\nPet's owner name: " + parameter.getPet().getOwnerName() +
                "\nRace: " + parameter.getPet().getRace() + "\nDescription: " + parameter.getDescription()));
    }

    public void addConsult(){
        List<VetModel> vetModelList = vetService.getAllVeterniars();
        vetModelList.forEach(vetModel ->
                System.out.println("ID: " + vetModel.getCod() +" " +  vetModel.getFirstName() + " " + vetModel.getLastName()));
        System.out.println("Enter ID: ");
        VetModel vet = vetService.findByID(scanner.nextLong());
        List<PetModel> petModelList = petService.viewPets();
        petModelList.forEach(petModel ->
                System.out.println("ID: " + petModel.getCod() + "\nOwner: " + petModel.getOwnerName() + "\nRace: " + petModel.getRace()));
        System.out.println("Enter ID: ");
        PetModel pet = petService.findByID(scanner.nextLong());
        ConsultModel consult = new ConsultModel();
        System.out.println("Enter date: ");
        consultService.addConsult(vet,pet,scanner.next());
    }

    public void updateDescription(){
        List<ConsultModel> consults = consultService.viewConsults();
        consults.stream().forEach(parameter -> System.out.println("Veteranian: " + parameter.getVet().getLastName() + " "+
                parameter.getVet().getFirstName() + "\nPet's owner name: " + parameter.getPet().getOwnerName() +
                "\nRace: " + parameter.getPet().getRace() + "\nDescription: " + parameter.getDescription()));
        System.out.println("Enter ID: ");
        ConsultModel consult = consultService.findByID(scanner.nextLong());
        System.out.println("Enter new description: ");
        consultService.updateDescription(consult,scanner.next());
    }
}
