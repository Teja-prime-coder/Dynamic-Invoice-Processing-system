package aroma;

import java.util.*;

public class DynamicInvoiceProcessing {

    private static final Map<String, Map<String, String>> carDetails = new LinkedHashMap<>();
    private static final Map<String, Integer> accessoryPrices = new LinkedHashMap<>();
    private static final Map<String, String> accessoryDescriptions = new LinkedHashMap<>();
    static {
        carDetails.put("Land Rover Defender", Map.of(
            "Price", "10400000",
            "Rating", "4.5",
            "Engine", "1997 cc - 5000 cc",
            "Power", "296 - 518 bhp",
            "Torque", "400 Nm - 650 Nm",
            "Transmission", "Automatic",
            "Top Speed", "191 kmph",
            "Drive Type", "AWD"
        ));
        carDetails.put("Land Rover Range Rover", Map.of(
            "Price", "23600000",
            "Rating", "4.5",
            "Engine", "2996 cc - 2998 cc",
            "Ground Clearance", "219 mm",
            "Power", "346 - 394 bhp",
            "Torque", "550 Nm - 700 Nm",
            "Seating Capacity", "5, 7",
            "Drive Type", "AWD"
        ));
        carDetails.put("Land Rover Range Rover Velar", Map.of(
                "Price Range", "Rs.87.90 Lakh",
                "Rating", "4.4",
                "Engine", "1997 cc",
                "Power", "201.15 - 246.74 bhp",
                "Torque", "365 Nm - 430 Nm",
                "Transmission", "Automatic",
                "Top Speed", "210 kmph",
                "Drive Type", "AWD",
                "Global NCAP Safety Rating", "5 Star"
            ));
            carDetails.put("Land Rover Discovery", Map.of(
                "Price Range", "Rs.97 Lakh - Rs.1.43 Cr",
                "Rating", "4.1",
                "Engine", "1997 cc - 2998 cc",
                "Power", "296.36 - 355 bhp",
                "Torque", "400 Nm - 650 Nm",
                "Transmission", "Automatic",
                "Drive Type", "AWD",
                "Fuel", "Diesel / Petrol"
            ));
            carDetails.put("Land Rover Range Rover Sport", Map.of(
                "Price Range", "Rs.1.40 Cr",
                "Rating", "4.3",
                "Engine", "2997 cc - 2998 cc",
                "Power", "345.98 - 394 bhp",
                "Torque", "550 Nm - 700 Nm",
                "Transmission", "Automatic",
                "Top Speed", "234 kmph",
                "Drive Type", "AWD"
            ));
            carDetails.put("Land Rover Range Rover Evoque", Map.of(
                "Price Range", "Rs.67.90 Lakh",
                "Rating", "4.3",
                "Engine", "1997 cc",
                "Power", "201 - 247 bhp",
                "Torque", "365 Nm - 430 Nm",
                "Transmission", "Automatic",
                "Top Speed", "221 kmph",
                "Drive Type", "AWD"
            ));
            carDetails.put("Land Rover Discovery Sport", Map.of(
                "Price Range", "Rs.67.90 Lakh",
                "Rating", "4.2",
                "Engine", "1997 cc - 1999 cc",
                "Power", "245.4 bhp",
                "Torque", "365 Nm - 430 Nm",
                "Transmission", "Automatic",
                "Top Speed", "200 kmph",
                "Drive Type", "4WD"
            ));
        accessoryPrices.put("Family Accessory Pack", 889129);
        accessoryDescriptions.put("Family Accessory Pack", "Seat Back Stowage, Centre Armrest, Click & Go (Base), Premium Seat Back Stowage");
        accessoryPrices.put("Executive Accessory Pack", 1345369);
        accessoryDescriptions.put("Executive Accessory Pack", "Click & Go (Base), Coat Hanger, Mirror Cover Kit (Gloss Black), Mudflaps, Rubber Mats, Phone Connect and Charge Dock");
        accessoryPrices.put("Comfort Accessory Pack",880509 );
        accessoryDescriptions.put("Comfort Accessory Pack", "Fixed or Deployable Side Step, Loadspace Treadplate Finisher");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("          KEEP CALM, it's a LAND ROVER          ");
        System.out.println("*******************************************\n");
        System.out.println("Welcome to the Land Rover Dynamic Invoice Processing System!");
        System.out.print("Please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Please enter your contact number: ");
        String customerContact = scanner.nextLine();
        System.out.print("Please enter your PAN Card Number: ");
        String customerPan = scanner.nextLine();
        System.out.print("Please enter the last ITR filing year: ");
        String itrYear = scanner.nextLine();
        System.out.print("Please enter your ITR Acknowledgment Number: ");
        String itrAckNumber = scanner.nextLine();
        String selectedCar = null;
        Map<String, String> selectedCarDetails = null;
        while (true) {
            System.out.println("\nAvailable Car Models:");
            int index = 1;
            for (String carModel : carDetails.keySet()) {
                Map<String, String> details = carDetails.get(carModel);
                System.out.printf("%d. %s: Rs.%s (Rating: %s)%n",
                    index, carModel, details.get("Price"), details.get("Rating"));
                index++;
            }
            System.out.print("\nEnter the car model number to select (or enter 0 to quit): ");
            int carChoice = scanner.nextInt();
            scanner.nextLine(); 
            if (carChoice == 0 || carChoice < 1 || carChoice > carDetails.size()) {
                System.out.println("Invalid choice or exiting. Goodbye!");
                return;
            }
            String newCar = (String) carDetails.keySet().toArray()[carChoice - 1];
            Map<String, String> newCarDetails = carDetails.get(newCar);
            System.out.println("\nSelected Car: " + newCar);
            System.out.println("-------------------------------------------");
            for (Map.Entry<String, String> entry : newCarDetails.entrySet()) {
                System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
            }
            System.out.println("-------------------------------------------");
            System.out.print("\nDo you want to keep this car or select another one? (no to keep, yes to choose another): ");
            String keepChoice = scanner.nextLine();
            if (keepChoice.equalsIgnoreCase("no")) {
                selectedCar = newCar;
                selectedCarDetails = newCarDetails;
                break;
            }
        }
        System.out.println("\n*******************************************");
        System.out.println("            LAND ROVER WARRANTY");
        System.out.println("*******************************************");
        System.out.println("The Land Rover Warranty is a comprehensive package of benefits designed to meet a high standard of after sales care and support.");
        System.out.println("\nShould a vehicle purchased through a MENA* Land Rover authorised retailer require repair or replacement as a result of a manufacturing defect,");
        System.out.println("the part will be repaired or replaced completely free of charge** by any MENA Land Rover Authorised Repairer, regardless of any change of vehicle ownership during the period of cover.***");
        System.out.println("\nAll new Land Rover vehicles have a comprehensive warranty coverage period of 5 years/150,000 km, whichever occurs first.");
        System.out.println("\nAll new vehicles sold on or after June 1st, 2018 will benefit from Land Rover regional warranty. The vehicle is covered by the manufacturer’s warranty terms in");
        System.out.println("the region to which it was delivered for first sale through the Land Rover authorised retailer. Specifications and warranty may differ in other regions.");
        System.out.println("\nIf the vehicle is to be registered or used in another region, further activation may be required and exclusions may apply and warranty conditions may be affected.");
        System.out.println("\nFor the purpose of warranty, regions are defined as USA, China, Europe & UK (excluding Turkey), Turkey, Russia, Overseas, Australia & New Zealand, Africa, Middle East & North Africa (MENA), and Latin America.");
        System.out.println("Please contact your nearest retailer for further details.");
        System.out.println("\n* Countries part of Middle East North Africa (MENA) region are: Algeria, Armenia, Azerbaijan, Bahrain, Egypt, Georgia, Iraq, Jordan, Kazakhstan, Kuwait, Lebanon, Morocco, Oman, Pakistan, Palestine, Qatar, Saudi Arabia, Tunisia, United Arab Emirates, and Yemen.");
        System.out.println("\n** Applies to only vehicles purchased and repaired within the MENA region. Any vehicles purchased or registered or used outside the MENA region will require further warranty activation for a charge.");
        System.out.println("Please contact your Land Rover authorised retailer for further details.");
        System.out.println("\n*** Terms and conditions apply");
        System.out.println("*******************************************");
        System.out.print("\nDo you accept the terms and conditions of the Land Rover Warranty? (Yes/No): ");
        String warrantyChoice = scanner.nextLine();
        if (!warrantyChoice.equalsIgnoreCase("Yes")) {
            System.out.println("You have not accepted the terms and conditions. Exiting the system.");
            return;
        }
        String selectedAccessory = "None";
        int accessoryPrice = 0;
        while (true) {
            System.out.println("\nAvailable Accessory Packs:");
            int index = 1;
            for (String accessory : accessoryPrices.keySet()) {
            	System.out.printf("%d. %s: Rs.%d%nDescription: %s%n", 
            		    index, accessory, accessoryPrices.get(accessory), accessoryDescriptions.get(accessory));
                index++;
            }
            System.out.print("\nEnter the accessory pack number to select (or enter 0 for no accessories): ");
            int accessoryChoice = scanner.nextInt();
            scanner.nextLine();
            if (accessoryChoice == 0) {
                break;
            }
            if (accessoryChoice > 0 && accessoryChoice <= accessoryPrices.size()) {
                selectedAccessory = (String) accessoryPrices.keySet().toArray()[accessoryChoice - 1];
                accessoryPrice = accessoryPrices.get(selectedAccessory);
            }
            System.out.print("\nDo you want to keep this accessory or select another one? (Yes to keep, No to choose another): ");
            String keepAccessoryChoice = scanner.nextLine();
            if (keepAccessoryChoice.equalsIgnoreCase("Yes")) {
                break;
            }
        }
        double gstRate = 0.28; 
        double tcsRate = 0.01; 
        double tcsRateNoPAN = 0.20; 
        double tcsRateNoITR = 0.05; 
        double totalPrice = Integer.parseInt(selectedCarDetails.get("Price")) + accessoryPrice;
        double gstAmount = totalPrice * gstRate;
        double tcsAmount = totalPrice * tcsRate;
        if (customerPan.isEmpty()) {
            tcsAmount = totalPrice * tcsRateNoPAN;
        } else if (itrYear.isEmpty()) {
            tcsAmount = totalPrice * tcsRateNoITR;
        }
        double finalPrice = totalPrice + gstAmount + tcsAmount;
        System.out.println("\n*******************************************");
        System.out.println("Invoice Summary:");
        System.out.println("-------------------------------------------");
        System.out.println("Selected Car: " + selectedCar);
        System.out.println("Price: Rs." + selectedCarDetails.get("Price"));
        System.out.println("Selected Accessory: " + selectedAccessory);
        System.out.println("Accessory Price: Rs." + accessoryPrice);
        System.out.printf("GST (28%%): Rs.%.2f%n", gstAmount);
        System.out.printf("TCS (1%%): Rs.%.2f%n", tcsAmount);
        System.out.printf("Final Price: Rs.%.2f%n", finalPrice);
        System.out.println("\nThank you for choosing Land Rover!");
        System.out.println("*******************************************");
    }
}
