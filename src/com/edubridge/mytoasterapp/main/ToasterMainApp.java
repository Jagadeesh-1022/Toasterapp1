package com.edubridge.mytoasterapp.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.mytoasterapp.model.Toaster;
import com.edubridge.mytoasterapp.service.ToasterService;
import com.edubridge.mytoasterapp.service.ToasterServiceImpl;


public class ToasterMainApp {
	public static void main(String[] args) {
		ToasterService service = new ToasterServiceImpl();
		Toaster c = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("welcome to Toaster App");
			System.out.println("*********");
			System.out.println("1. Add Toaster");
			System.out.println("2. view Toaster");
			System.out.println("3. Search Toaster");
			System.out.println("4. Update Toaster");
			System.out.println("5. Delete Toaster");
			System.out.println("6. DeleteAll Toasters");
			System.out.println("0. exit");
			System.out.println("please choose option");
			option = in.nextInt();

			switch (option) {
			case 1:
				System.out.println(" Add NEW TOASTER ");
				System.out.println("-----------------");
				System.out.println("Please enter brand name:");
				String Brand = in.next();
				System.out.println("please enter capacity :");
				String Capacity = in.next();
				System.out.println("please enter Colour:");
				String Colour =in.next();
				System.out.println("please enter Price:");
				Float Price = in.nextFloat();
				System.out.println("please enter rating:");
				Double Rating=in.nextDouble();
				c=new Toaster();
				c.setBrand(Brand);
				c.setCapacity(Capacity);
				c.setColour(Colour);
				c.setPrice(Price);
				c.setRating(Rating);
				
				int status =service.addToaster(c);
				if(status==1) {
					System.out.println("New Toaster added!");

				}else {
					System.out.println("something is wrong!");

				}

				break;
			case 2:
				System.out.println("view All Toasters");
				List<Toaster> toast=service.findToaster();
				System.out.println("BRAND\tCAPACITY\tCOLOUR\tPRICE\tRATING");
				System.out.println("------\t-------\t-------\t-----\t------");

				for(Toaster toaster:toast) {
					System.out.println(toaster.getBrand()+"\t" +toaster.getCapacity()+"\t"+toaster.getColour()+"\t"+toaster.getPrice()+"\t"+toaster.getRating());

				}
				break;
			case 3:
				
				System.out.println("search 	Toaster");
				System.out.println("please enter Toaster brand");
				String searchBrand=in.next();
		        Toaster searchToaster=service.findToasterByBrand(searchBrand);
				if(searchToaster !=null) {
					System.out.println("ID: "+searchToaster.getId());
					System.out.println("Brand: "+searchToaster.getBrand());
					System.out.println("Capacity: "+searchToaster.getCapacity());
					System.out.println("Colour: "+searchToaster.getColour());
					System.out.println("Price:"+searchToaster.getPrice());
					System.out.println("Rating:"+searchToaster.getRating());
					
				}else {
					System.out.println("No Toaster found!");
				}
				
				break;
				
			case 4:
				//System.out.println("update Contact");
				System.out.println("please enter brand name:");
				searchBrand=in.next();				
				searchToaster=service.findToasterByBrand(searchBrand);
				
				if(searchBrand !=null) {
					//displaying existing contact details
					System.out.println("ID: "+searchToaster.getId());  
					System.out.println("Brand: "+searchToaster.getBrand());
					System.out.println("Capacity: "+searchToaster.getCapacity());
					System.out.println("Colour: "+searchToaster.getColour());
					System.out.println("Price:"+searchToaster.getPrice());
					System.out.println("Rating:"+searchToaster.getRating());
					
					//reading contact update info
					System.out.println("please enter updated Brand:");
					Brand=in.next();
					System.out.println("please enter update Capacity:");
					Capacity=in.next();
					System.out.println("please enter update colour:");
					Colour=in.next();
					System.out.println("please enter update price :");
					Price=in.nextFloat();
					System.out.println("please enter update rating:");
					Rating=in.nextDouble();
					
					Toaster updateToaster=new Toaster();
					updateToaster.setBrand(Brand);
                    updateToaster.setCapacity(Capacity);
                    updateToaster.setColour(Colour);
                    updateToaster.setId(searchToaster.getId());
                    
                    int updateStatus =service.updateToaster(updateToaster);
                    if(updateStatus ==1) {
                    	System.out.println("contact updated successfully");
                    }else {
                    	System.out.println("something is wrong !");
                    }
					
				}else {
					System.out.println("contact not found with name");
				}
				break;
			case 5:
				System.out.println("delete toaster");
				System.out.println("please enter toaster name");
				searchBrand = in.next();
				searchToaster = service.findToasterByBrand(searchBrand);
				if(searchToaster !=null) {
					int deleteStatus = service.deleteToasterByBrand(searchBrand);
					if(deleteStatus==1) {
						System.out.println("toaster deleted sucessfully");
					}else {
						System.out.println("something went wrong");
					}
					
				}
						break;
			case 6:
				System.out.println(" Are you sure delete All toasters?[Y/N]");
				String deleteConfirmStatus = in.next();
				if(deleteConfirmStatus.equalsIgnoreCase("Y")){
					service.deleteAllToasters();
					System.out.println("all toasters deleted ");
				}
				break;
			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;
			default:
				System.out.println("invalid option!");
				break;

			}
		} while (option != 0);
	}

}
