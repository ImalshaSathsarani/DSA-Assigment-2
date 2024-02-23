
import java.util.Scanner;//IMPORTING SCANNER CLASS FOR GET USER INPUT AND SCAN THEM.


public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);//DECLARING A SCANNER OBJECT
        Garage g = new Garage();//DECLARING A GARAGE CLASS OBJECT
        String input;

        do{//DECLARING A DO-WHILE LOOP TO CONTINUOUSLY ASK THE USER INPUT
            System.out.println("\n\n\n WELCOME TO THE LAUGHS PARKING SYSTEM");
            System.out.println("You can enter the input line(a/d license plate number) or if you want to exit,enter letter 'E X' ");
        System.out.println("Enter your input:");
       input=sc.nextLine();//GET THE USER INPUT USING SCANNER OBJECT

        int spaceIndex=input.indexOf(' ');//GET THE INDEX OF THE SPACE IN THE GIVEN INPUT
        String action=input.substring(0,spaceIndex);//DIVIDING THE INPUT STRING INTO TWO SUBSTRINGS AND GET THE FIRST STRING AS ACTION
        String plateNo=input.substring(spaceIndex+1);//GET THE SECOND STRING AS THE LICENSE PLATE NUMBER

            //GET A SWITCH CASE TO IMPLEMENT THE PARKING METHOD AND DEPARTURE METHOD
    switch(action){
        case "a"://IF THE ACTION,THE FIRST SUBSTRING OF THE INPUT IS "a",THEN PARK THE CAR IN THE PARKING LINE USING PARKINGCAR METHOD
        Car newCar = new Car(plateNo);
        g.parkingCar(newCar);
        break;

        case "d"://IF THE ACTION,THE FIRST SUBSTRING OF THE INPUT IS "d",THEN DEPART THE CAR IN THE PARKING LINE USING DEOARTURECAR METHOD
            g.departureCar(plateNo);
            break;


        }
}while(!input.equals("E X"));//IF WANT TO EXIT USER SHOULD ENTER THE LETTER 'E' ,THEN THE PROCESS IS TERMINATED



    }
}