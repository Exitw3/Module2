package S10_DSA.bai_tap.LinkeDlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Tài");
        Student student2 = new Student(2, "Định");
        Student student3 = new Student(3, "Nghĩa");
        Student student4 = new Student(4, "Cường");
        Student student5 = new Student(5, "Phúc");
        Student student6 = new Student(5, "Phúc");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);
        myLinkedList.addFirst(student4);
        myLinkedList.addFirst(student5);
        myLinkedList.addLast(student3);
        myLinkedList.add(2, student5);

        myLinkedList.remove(3);

//        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();
//
//        for (int i = 0; i < cloneLinkedList.size(); i++) {
//            Student student = (Student) cloneLinkedList.get(i);
//            System.out.println(student.getName());
//        }

//        System.out.println(myLinkedList.containst(student6));
        System.out.println(myLinkedList.indexOf(student2));
    }
}