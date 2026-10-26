# **javacore-and-sql**



### **A ĐỌC CODE**

**QUY ƯỚC : CÂU LÀM SAI/KHÔNG LÀM ĐƯỢC SẼ VIẾT ĐÁP ÁN Ở SAU**



**A1.**

String s1 = "Java";

String s2 = new String("Java");

String s3 = s2.toUpperCase();

s2.concat(" Core");

System.out.println(s1 == s2); **// false**

System.out.println(s1.equals(s2)); // **true**

System.out.println(s2); // **Java**

System.out.println(s3); // **JAVA**



**A2.**

Long x = 127L, y = 127L;

Long m = 128L, n = 128L;

System.out.println(x == y); **// true**

System.out.println(m == n); **// true  Sai Đ.án: false**

System.out.println(m.equals(n)); **// true**

System.out.println(m.equals(128)); **// false**



**A3.**

static void change(int number, int\[] arr, StringBuilder sb, String s) {

&#x20;   number = 100;

&#x20;   arr\[0] = 100;

&#x20;   sb.append("!");

&#x20;   s = s + "!";

}

// trong main

int number = 1;

int\[] arr = {1};

StringBuilder sb = new StringBuilder("Hi");

String s = "Hi";

change(number, arr, sb, s);

System.out.println(number + " " + arr\[0] + " " + sb + " " + s); **// "100 100 Hi! Hi"  Đ.án:"1 100 Hi! Hi"**



**A4**

int a = 7, b = 2;

System.out.println(a / b); **//3**

System.out.println(a / (double) b); **//3.5**

System.out.println(a % b); **//1**

int max = Integer.MAX\_VALUE;

System.out.println(max + 1); **//    Đ.án:-2147483648**

System.out.println(0.1 + 0.2 == 0.3); **// false**



**A5**

List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 2));

list.remove(2);

System.out.println(list); **//** **10,20,2**

list.remove(Integer.valueOf(2));

System.out.println(list); **// 10,20**



**A6**

String note = null;

boolean isAdmin = true;

boolean ok1 = isAdmin || note != null \&\& note.trim().length() > 0;

System.out.println(ok1); **// true**

boolean ok2 = (isAdmin || note != null) \&\& note.trim().length() > 0;

System.out.println(ok2); **//     Đ.án:NullPointerException**



**A7**

static int parse(String s) {

&#x20;   try {

&#x20;       System.out.println("A");

&#x20;       int n = Integer.parseInt(s.trim());

&#x20;       System.out.println("B");

&#x20;       return n;

&#x20;   } catch (NumberFormatException e) {

&#x20;       System.out.println("C");

&#x20;       return -1;

&#x20;   } finally {

&#x20;       System.out.println("D");

&#x20;   }

}



// trong main, gọi lần lượt:

System.out.println(parse(" 12 ")); **// A B D 12**

System.out.println(parse("abc")); **// A C D -1**

System.out.println(parse(null)); **//  Đ.án: A D Cannot invoke "String.trim()" because "s" is null**



**A8**

class Product {

&#x20;   String code;

&#x20;   Product(String code) { this.code = code; }

}

record ProductRecord(String code) {}



Set<Product> set = new HashSet<>();

set.add(new Product("P01"));

set.add(new Product("P01"));

System.out.println(set.size()); **// 2**



Set<ProductRecord> set2 = new HashSet<>();

set2.add(new ProductRecord("P01"));

set2.add(new ProductRecord("P01"));

System.out.println(set2.size()); **//  Đ.án:1**



## **B CODE JAVA**

**B1**

+sử dụng 2 method 

* method formatcode để chuyển code về đúng định dạng và kiểm tra đúng định dạng của code
* method test để in ra kết quả code nếu sai thì throw exception

+sử dụng trim() để lại bỏ khoảng trống 

+sử dụng toUpperCase() để chuyển thành chuỗi in hoa

+sử dụng regex\[A-Z0-9]{3,20} để ép chuỗi chỉ gồm ký tự và chữ số trong độ dài từ 3-20

+CASE biên:

* nếu mã null thì throw IllegalArgumentException với message : code không được để rỗng.
* nếu mã rỗng thì throw IllegalArgumentException với message : code không đáp ứng định dạng
* nếu mã dài quá độ dài quy định throw IllegalArgumentException với message : code không đáp ứng định dạng
* nếu mã gồm các ký tự đặc biệt throw IllegalArgumentException với message : code không đáp ứng định dạng



**B2**



**B3**



**B4**

