package S10_DSA.bai_tap.ArrayList;

public class TestMyArrayList {
    public static class Student {
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

    public static void main(String[] args) {
        Student a = new Student(1, "Tài");
        Student b = new Student(2, "Định");
        Student c = new Student(3, "Nghĩa");
        Student d = new Student(4, "Minh");
        Student e = new Student(5, "Phúc");
        Student f = new Student(5, "Sỹ");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        MyArrayList<Student> newMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
//        studentMyArrayList.add(t, 2);
        studentMyArrayList.getSize();

//        for (int i = 0; i < studentMyArrayList.getSize(); i++){
//            Student student = (Student) studentMyArrayList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//        }

//        System.out.println(studentMyArrayList.getSize());
//        System.out.println(studentMyArrayList.get(2).getName());

//        System.out.println(studentMyArrayList.indexOf(d));
//        System.out.println(studentMyArrayList.contains(f));

        newMyArrayList = studentMyArrayList.clone();
        Student student = newMyArrayList.remove(2);
        System.out.println(student.getName());

//        for (int i = 0; i < newMyArrayList.getSize() ; i++) {
//            System.out.println(newMyArrayList.get(i).getName());
//        }
    }
}