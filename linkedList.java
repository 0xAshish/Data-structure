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

    public list1 search(list1 head, int data) {
        list1 h1 = head;
        while (h1 != null) {
            if (h1.data == data) {
                System.out.print("data found");
                return h1;
            }
            h1 = h1.next;
        }
        System.out.print("not found");
        return head;
    }

    public void delete(list1 head, int data) {
        while (head != null) {
            if (head.next.data == data) {
                System.out.print("data found");
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }

    }

    public static void main(String s[]) {
        Scanner inp = new Scanner(System.in);
        int v;
        list1 start = new list1();

        System.out.println("\n1 insert :");
        System.out.println("\n2 delete :");
        System.out.println("\n3 search :");
        System.out.println("\n4 print  :");
        System.out.println("\n5 exit   :");

        do {
            v = inp.nextInt();
            int data = 0;
            switch (v) {
            case 1:
                data = inp.nextInt();
                start.insert(start, data);
                System.out.println("value inserted" + data);

                break;
            case 2:
                data = inp.nextInt();
                start.delete(start, data);
                System.out.println("value deleted" + data);
                break;
            case 3:
                data = inp.nextInt();
                list1 node = start.search(start, data);
                break;
            case 4:
                start.print(start);
                break;
            default:
                System.exit(0);
                break;
            }
        } while (true);

    }
}
