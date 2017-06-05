import java.util.Scanner;

class list1 {
    private int data;
    private list1 next;

    public void insert(list1 head, int data) {

        while (head.next != null) {
            head = head.next;
        }
        list1 node = new list1();
        head.next = node;
        node.data = data;
    }

    public void print(list1 head) {
        System.out.println("print");
        while (head.next != null) {
            head = head.next;
            System.out.println(head.data);
        }
    }

    public void delete(list1 head, int data, boolean delete) {
        list1 temp = head;
        //with delete boolean it is common function for 
        while (head != null) {
            if (head.data == data) {
                System.out.println("match found");
                if (delete) {
                    temp.next = temp.next.next;
                }
                return;
            }
            temp = head;
            head = head.next;
        }
        System.out.println("match not found");
    }

    public static void main(String s[]) {
        Scanner inp = new Scanner(System.in);
        int v, data;
        list1 start = new list1();

        do {
            System.out.println("\n1 insert :");
            System.out.println("\n2 delete :");
            System.out.println("\n3 search :");
            System.out.println("\n4 print  :");
            System.out.println("\n5 exit   :");
            v = inp.nextInt();
            switch (v) {
            case 1: {
                data = inp.nextInt();
                start.insert(start, data);
                System.out.println("value inserted" + data);
            }
                break;
            case 2: {
                data = inp.nextInt();
                start.delete(start, data, true);
            }
                break;
            case 3: {
                data = inp.nextInt();
                start.delete(start, data, false);
            }
                break;
            case 4: {
                start.print(start);

            }
                break;
            default:
                break;
            }
        } while (v != 5);

    }
}
