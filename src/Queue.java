public class Queue {
    public int front, rear, capacity;
    public Car[] queue;

    public Queue(int size) {
        capacity = size;
        front = rear = -1;
        queue = new Car[capacity];
    }
//METHOD TO FIND WHETHER THE QUEUE IS EMPTY
    public boolean isEmpty() {
        return (front == -1);

    }
//METHOD TO FIND WHETHER THE QUEUE IS FULL
    public boolean isFull() {

        return (rear==capacity-1);
    }
//METHOD TO INSERT ELEMENTS TO THE BACK OF THE QUEUE
    public void enqueue(Car car) {
        //CHECK WHETHER THE QUEUE IS FULL.IF FULL CANNOT INSERT ANOTHER ELEMENT.
        if (isFull()) {
            System.out.println("The queue is full ");
            throw new IllegalStateException("Queue is full.Cannot enqueue.");
//IF THE QUEUE IS EMPTY THEN SET THE FRONT POINTER EQUAL TO ZERO.BECAUSE IT IS THE FIRST ELEMENT IN THE QUEUE
        }if (isEmpty()){
            front=0;
        }
        //IF THE QUEUE IS NOT EMPTY THEN INCREASE THE REAR BY ONE AND ADD THE ELEMENT TO THE QUEUE
        rear++;
        queue[rear]=car;


    }
//METHOD TO REMOVE ELEMENTS FROM THE QUEUE
        public Car dequeue () {
//CHECK WHETHER THE QUEUE IS EMPTY.IF IT IS EMPTY CANNOT DELETE ELEMENTS IN THE QUEUE
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return null;
            }
            //ASSIGNING FIRST ELEMENT WHICH WANTED TO DELETE TO A CAR OBJECT
            Car car = queue[front];
            if (front >= rear) {//THIS MEANS WHEN REMOVING THE ELEMENT THE QUEUE BECOME EMPTY.THEREFORE ASSIGNING REAR AND FRONT TO -1
                front = rear = -1;
            } else {
                //IF FRONT>=REAR NOT HAPPENED MEANS THE QUEUE NOT BECOME EMPTY.THEREFORE INCREASE THE VALUE OF FRONT BY 1
                front++;




            }
            //RETURNING THE DELETED CAR OBJECT
            return car;

        }

}

