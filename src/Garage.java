

public class Garage {
    private static final int MAX=10;//DECLARING THE SIZE OF THE QUEUE BY USING A FINAL VARIABLE CALLED 'MAX'.
    private Queue parkingList=new Queue(MAX);//DECLARING A 'parkingList' OF TYPE QUEUE AND INITIALIZE IT TO A NEW INSTANCE OF QUEUE CLASS
    private Queue waitingList=new Queue(MAX);//DECLARING A 'waitingList' OF TYPE QUEUE AND INITIALIZE IT TO A NEW INSTANCE OF QUEUE CLASS.THIS HOLDS THE CARS THAT ARE WAITING TO PARK


//METHOD TO PARK THE CAR
    public void parkingCar(Car car){
        //IF THE PARKING LIST IS FULL THEN THE CAR IS ADDED TO THE WAITING LIST
        if(parkingList.isFull()){
            System.out.println("The parking is full the car is added to the waiting list");
            waitingList.enqueue(car);
        }else{
            //IF THE PARKING LIST IS NOT FULL,ENQUEUE THE CAR TO THE PARKING LIST
            parkingList.enqueue(car);
            System.out.println("The car "+car.getLicensePlateNum()+" is added to the parking");
        }
    }
//METHOD TO DEPART A CAR
    public void departureCar(String plateNum) {
        int moves = 1;//DECLARE A 'moves' VARIABLE TO COUNT THE MOVES OF THE CAR
        boolean found = false;//DECLARE A 'found' VARIABLE TO CHECK WHETHER THE CAR IS FOUND

        for(int i=parkingList.front;i<=parkingList.rear;i++){//TRAVERSNG THE parkingList TO  FIND THE RELEVANT CAR IS PRESENT IN THE QUEUE
            if(parkingList.queue[i].getLicensePlateNum().equals(plateNum)){//IF THE GIVEN LICENSE PLATE NUMBER IS EQUALS TO A LICENSE PLATE NUMBER OF A CAR IN THE parkingList,CHANGE THE VALUE OF THE 'found' VARIABLE TO 'true'
                found=true;
                moves=(i- parkingList.front)+1;//GET THE NUMBER OF MOVES THAT THE CAR HAS MOVED INCLUDING DEPARTURE

                //MOVING THE OTHER CARS TO THE NORTH
                for(int j=i;j< parkingList.rear;j++){
                    parkingList.queue[j]=parkingList.queue[j+1];
                }
                parkingList.rear--;
                break;
            }


        }
        //IF THE CAR CANNOT FOUND IN THE parkingList THE CHECK THE waitingList
        if(!found){
            for (int i= waitingList.front;i<= waitingList.rear;i++){//TRAVERSING THE waitingList TO  FIND THE RELEVANT CAR IS PRESENT IN THE QUEUE
                if(waitingList.queue[i].getLicensePlateNum().equals(plateNum)){//IF THE GIVEN LICENSE PLATE NUMBER IS EQUALS TO A LICENSE PLATE NUMBER OF A CAR IN THE waitingList,CHANGE THE VALUE OF THE 'found' VARIABLE TO 'true'
                    found=true;
                    moves=0;//DECLARING MOVES TO THE ZERO BECAUSE IT IS GIVEN

                    //MOVING OTHER CARS TO THE NORTH
                    for(int j=i;j< waitingList.rear;j++){
                        waitingList.queue[j]=waitingList.queue[j+1];
                    }
                    waitingList.rear--;
                    break;
                }
            }
        }

        if(found){//IF 'found' IS TRUE
            int remainSpace=MAX-(parkingList.rear- parkingList.front+1);//GET THE REMAINING SPACE OF THE parkingList
            System.out.println("Car "+plateNum+" departs. Moved "+moves+" times.");//DISPLAY THE MESSAGE THAT THE CAR DEPARTS
            System.out.println("The parking line available for "+remainSpace+" cars.");//DISPLAY THE NUMBER OF SPACE REMAIN IN THE parkingList
        }else{//IF 'found' IS NOT TRUE THEN DISPLAY THE CAR NOT FOUND MESSAGE
            System.out.println("Car "+plateNum+" not found");
        }


        }
    }








