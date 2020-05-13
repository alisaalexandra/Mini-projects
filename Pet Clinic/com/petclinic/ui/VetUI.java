package com.petclinic.ui;

import com.petclinic.persistence.model.VetModel;
import com.petclinic.services.VetService;

import java.util.List;
import java.util.Scanner;

public class VetUI {

    private VetService vetService = new VetService();
    Scanner scanner = new Scanner(System.in);


    public void startVeterinarUI() {
        int option = -1;
        while (option != 0) {

            System.out.println("Veterinarian management");
            System.out.println("1.View all");
            System.out.println("2.Add veterinarian");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                viewVets();
            } else if (option == 2) {
                addVet();
            }
        }
    }

    public void viewVets() {
        List<VetModel> vetModelList = vetService.getAllVeterniars();
        vetModelList.forEach(vetModel ->
                System.out.println("ID: " + vetModel.getCod() + vetModel.getFirstName() + " " + vetModel.getLastName()));
    }

    public void addVet() {
        VetModel vetModel = new VetModel();
        System.out.println("Enter first name");
        vetModel.setFirstName(scanner.nextLine());

        System.out.println("Enter last name");
        vetModel.setLastName(scanner.nextLine());

        System.out.println("Enter speciality");
        vetModel.setSpeciality(scanner.nextLine());
        System.out.println("Enter address");
        vetModel.setAddress(scanner.nextLine());
        System.out.println("Enter ID: ");
        vetModel.setCod(scanner.nextLong());

        vetService.addVeterniar(vetModel);
    }
}
