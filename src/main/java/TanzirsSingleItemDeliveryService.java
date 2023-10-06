import java.util.Scanner;
import java.util.Arrays;

/**
 * We have a delivery service that delivers items for a fee based on the delivery mileage
 * Need to intake the item, quantity, how many miles they are from the delivery station
 * Will create a set amount of items to choose from
 * sum an order of multiple items
 * create summary of total at the end
 */

public class TanzirsSingleItemDeliveryService {
    public static void main(String[] args) {

        String fees = "";
        int deliveryFee;
        int priceOfProduct = 0;
        String deliveryProduct = "";
        String[] productList = {"rice", "beans", "eggs", "chicken", "steak"};

        Scanner deliveryScanner = new Scanner(System.in);

        while (true) {
            System.out.print("What product do you want?");
            String userInput = deliveryScanner.nextLine();
            //set user input to a usable variable
            deliveryProduct = userInput.toLowerCase();

            //converts productList to a list which then checks the deliveryProduct against the list
            boolean isProductInList = Arrays.asList(productList).contains(deliveryProduct);

            //once isProductInList is true, the if loop with nested switch to assign a value to the
            //deliveryProduct begins. Else condition initiates if it is none of the stated values
            if (isProductInList == true) {
                //You might ask, why make a switch case for the products?
                //Because we not Amazon and we only carry specific items
                //Conceptually we can definitely intake whatever, but let's showcase how to use switches
                switch (deliveryProduct) {
                    case "rice":
                        priceOfProduct = 3;
                        break;
                    case "beans":
                        priceOfProduct = 2;
                        break;
                    case "eggs":
                        priceOfProduct = 10;  //they're organic ok?
                        break;
                    case "chicken":
                        priceOfProduct = 8;
                        break;
                    case "steak":
                        priceOfProduct = 250; //dat a5 wagyu
                        break;
                    default:
                        // This will never be triggered because of the isProductInList check.
                        break;
                }
                break;
            } else {
                System.out.println("We only provide the following products: " + Arrays.toString(productList));
            }
        }

        //assigns qty of item
        System.out.println("How many you want?");
        int deliveryQuantity = deliveryScanner.nextInt();
        //assigns mileage
        System.out.println("How far you live in miles?");
        int deliveryMileage = deliveryScanner.nextInt();

        //can honestly complete the deliveryFee step here, but using a switch is more fun!
        //applies a zone name to a specific mileage amnt to be used later
        if (deliveryMileage <= 5 && deliveryMileage >= 0) {
            fees = "Zone 1";
        } else if (deliveryMileage <= 15 && deliveryMileage >= 6) {
            fees = "Zone 2";
        } else if (deliveryMileage <= 25 && deliveryMileage >= 16) {
            fees = "Zone 3";
        } else if (deliveryMileage <= 50 && deliveryMileage >= 26) {
            fees = "Zone 4";
        } else if (deliveryMileage > 50 && deliveryMileage < 15000) {
            fees = "Zone 5";
        } else {
            System.out.println("Where do you live, Mars?");
        }

        //update delivery fee value for which delivery zone the customer is in
        switch (fees) {
            case "Zone 1":
                deliveryFee = 2;
                break;
            case "Zone 2":
                deliveryFee = 5;
                break;
            case "Zone 3":
                deliveryFee = 10;
                break;
            case "Zone 4":
                deliveryFee = 15;
                break;
            case "Zone 5":
                deliveryFee = 20;
                break;
            default:
                System.out.println("Congrats, you have broken the system. Free delivery for you!");
                deliveryFee = 0;
                break;
        }

        int totalPrice = deliveryFee + (deliveryQuantity * priceOfProduct);

        System.out.println("Product      Qty      Price       Miles      Total");
        System.out.println(	"----         ---      -----      -----      -----");
        System.out.println(deliveryProduct + "         " + deliveryQuantity + "       " + priceOfProduct + "         " + deliveryMileage + "         " + totalPrice);
        System.out.println("            Thank you come again!");
        }

    }
