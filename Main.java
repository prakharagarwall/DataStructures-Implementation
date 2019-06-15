//I tried to comment as much as possible to make the understanding of code easy.
//Prakhar Agarwal
//In this code I have implemented all the fuctions, I have created two hashmaps initially to store all the data
//I have made only one class, and there are methods for different question asked during the assignment.
//Here are the coding exercises. Read the provided JSON into your JAVA program and
//
//        1.  Display the data stored in Java Collections.
//        2.  Query the above collection :Given a lot number, retrieve all the information regarding the lot.
//        3.  Sort the lots based on profit
//        4.  Determine the seller who has the highest lots
//        5.  Determine tax based on country code
        //explaining data stored in map, so lets take the map 
        //key is the lot number eg. 12 is the lot number
        //Now in the value we have an arraylist, whose first value is the country code, then, the sellertype,
        // then the seller id, then the member type, then member id, then, purchase price and then sale price.


import java.util.*;
public class Main {

    static Map<Integer, ArrayList<String>> map; //data related to articulat lot, where key is lotnumber
    static Map<String, Integer> tax; // for tax with country
    public static void main(String[] args) {
        map = new HashMap<Integer, ArrayList<String>>();
        tax = new HashMap<String, Integer>();
        //Storing data in both the maps.
        tax.put("DEU",19);
        tax.put("ESP",21);
        //explaining data stored in map, so lets take the map first data
        //key is the lot eg. 12 is the lot number
        //Now in the value we have an arraylist, whose first value is the country code, then, the sellertype,
        // then the seller id, then the member type, then member id, then, purchase price and then sale price.
        map.put(12, new ArrayList<>(Arrays.asList("DEU", "S", "100", "M", "700", "10000", "15000")));
        map.put(13, new ArrayList<>(Arrays.asList("ESP", "S", "100", "M", "700", "1000", "2000")));
        map.put(14, new ArrayList<>(Arrays.asList("ESP", "S", "101", "M", "701", "7000", "7000")));
        map.put(15, new ArrayList<>(Arrays.asList("DEU", "S", "101", "M", "701", "10000", "15000")));
        map.put(16, new ArrayList<>(Arrays.asList("DEU", "S", "100", "M", "701", "3000", "2900")));
        //Here you will be prompted with the input you want to provide
        System.out.println("Select the option you want to see :");
        System.out.println("1.  Be able to read the JSON data and store it in a java collection or a data structure \n" +
                "2.  Query the above collection :Given a lot number, retrieve all the information regarding the lot.\n" +
                "3.  Sort the lots based on profit \n" +
                "4.  Determine the seller who has the highest lots\n" +
                "5.  Determine tax based on country code");
        System.out.println("Enter the option :");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        //Switch case to make it more user friendly
        switch (number) {
            case 1:
                System.out.println(map); // Printing the complete details for all the lots
                break;
            case 2:
                System.out.println("Enter the lot number "); //Providing the details of particular lot number
                Scanner x = new Scanner(System.in);
                int y = x.nextInt();
                if(map.containsKey(y))
                System.out.println("Lot number "+y+" has data "+map.get(y));
                else
                    System.out.println("Lot number does not exist");
                break;
            case 3:
                sort(); //Sorting the lot based on profit
                break;
            case 4:
                highestLots(); //providing the seller id with the highest number of lots
                break;
            case 5:
                taxCalculate(); //calculating the tax for the lot Id provided based on the country code.
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    //This Method provides you the highest number of lots that a seller has

    private static void highestLots() {
        Map<String, Integer> hs = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> arr = new ArrayList<>();
            arr.addAll(entry.getValue());

            hs.put(arr.get(2), hs.getOrDefault(arr.get(2), 0) + 1);

        }

        int count = 0;
        String maxSid = null;

        for (Map.Entry<String, Integer> entry : hs.entrySet()) {

            if (entry.getValue() > count) {
                count = entry.getValue();
                maxSid = entry.getKey();
            }
        }
        System.out.println("Seller with Seller ID: "+ maxSid);


    }
//This Method provides you the tax calculation for a particular lot with respect to a country, in this I have extracted data from
    //two maps, I made.
    private static void taxCalculate() {
        System.out.println("Enter the lot number to calculate tax");
        Scanner x = new Scanner(System.in);
        int y = x.nextInt();
        if(map.containsKey(y))
        {
            ArrayList<String> list = map.get(y);
            String str = list.get(0);
            int saletax = tax.get(str);
            int saleprice = Integer.parseInt(list.get(6));
            System.out.println("Tax will be : " + saleprice * saletax / 100);
        }
        else
        System.out.println("Lot number does not exist");
    }

    //This Method provides you the sorted list of all the lots with respect to the profit
    private static void sort() {
        int Sp,Pp,k=0,p=0;
        String[] id = new String[map.size()];
        int[] profit = new int[map.size()];
        ArrayList<String> arr;
        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            arr = new ArrayList<>();
            arr.addAll(entry.getValue());
            id[k++]=Integer.toString(entry.getKey());
            profit[p++] = Integer.parseInt(arr.get(6)) - Integer.parseInt(arr.get(5));

        }
        final List<String> stringListCopy = Arrays.asList(id);
        ArrayList<String> sortedList = new ArrayList(stringListCopy);
        Collections.sort(sortedList, (left, right) -> profit[stringListCopy.indexOf(left)] - profit[stringListCopy.indexOf(right)]);

        for(int i=0;i<sortedList.size();i++)
        {
            System.out.println(sortedList.get(i));
            System.out.println(map.get(Integer.parseInt(sortedList.get(i))));
        }

    }
}
