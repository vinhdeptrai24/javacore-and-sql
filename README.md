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

* method normalizecode để chuyển code về đúng định dạng và kiểm tra đúng định dạng của code
* method test để in ra kết quả code nếu sai thì throw exception

+sử dụng trim() để lại bỏ khoảng trống đầu cuối

+sử dụng toUpperCase() để chuyển thành chuỗi in hoa

+sử dụng regex\[A-Z0-9]{3,20} để ép chuỗi chỉ gồm ký tự và chữ số trong độ dài từ 3-20

+CASE biên:

* nếu mã null thì throw IllegalArgumentException với message : code không được để rỗng.
* nếu mã rỗng thì throw IllegalArgumentException với message : code không đáp ứng định dạng
* nếu mã dài quá độ dài quy định throw IllegalArgumentException với message : code không đáp ứng định dạng
* nếu mã gồm các ký tự đặc biệt throw IllegalArgumentException với message : code không đáp ứng định dạng



**B2**

\+sử dụng method calculate total:

Ném IllegalArgumentException khi: một trong hai mảng là null, hai mảng khác độ dài, có số lượng ≤ 0 hoặc có đơn giá < 0.

+sử dụng method test:

dùng try catch để throw message exception

**B3**

\+sử dụng method countword:

* nếu text null hoặc để trống thì return khoảng trống không giá trị
* khai báo biến clean bằng text viết thường bỏ khoảng trắng đầu cuối
* dùng vòng for lần lượt lấy từng từ trong mảng sau đi đã dùng split \\\\s+ để cắt từng từ qua từng khoảng trống
* map.getorDefault để đếm từng từ trong map nếu từ chưa có để là 0 và cộng thêm 1 ghi lại vào map



**B4**

+class Product:

**\*constructer:**

* code được chuẩn hóa và throw exception nếu dính điều kiện của normalizecode
* kiểm tra tính hợp lệ của name,stock,price

\*method increaseStock

* quantity ≤ 0 ném IllegalArgumentException; không đủ hàng ném IllegalStateException, và tồn kho giữ nguyên.

\*method decreaseStock

* quantity ≤ 0 ném IllegalArgumentException.

**\*tham khảo AI:**

boolean equals:chuẩn hóa 2 product có code giống nhau thành 1 đối tượng

int hashcode:để quyết định phần tử nào vào ô nào nếu được chuẩn hóa thành 1 đối tượng sẽ được cho vào 1 ô



**B5**

**method oderStatus nextsStatus:**

\+nếu trạng thái null hoặc action null hoặc rỗng throw exception

+s bằng action.trim(),toUpperCase() để chuyển thành viết hoa và bỏ dấu cách đầu cuối

\+sử dụng switch case cho 4 trạng thái 

* nếu action là CONFIRM và trạng thái hiện tại là NEW thì sẽ chuyển trạng thái mới là CONFIRMED
* nếu action là SHIP và trạng thái hiện tại là CONFIRMED sẽ chuyển trạng thái mới là SHIPPING
* nếu action là COMPLETE và trạng thái hiện tại là SHIPPING thì sẽ chuyển sang trạng thái mới là DONE
* nếu action là CANCEL và trạng thái hiện tại là NEW hoặc CONFIRM thì chuyển trạng thái mới là CANCELLEd
* default nếu action không thuộc 1 trong 4 trạng thái trên thì throw exception
* nếu trạng thái hiện tại không thuộc các điều kiện trong case sẽ throw exception

**method test**

## **C SQL với PostgreSQl**

**C1**

bảng customers

* ID kiểu dữ liệu bigint dùng generated by default để id tự động tăng dù khi nhập vào không nhập id
* full\_name kiểu dữ liệu varchar bắt buộc
* email kiểu dữ liệu varchar bắt buộc
* phone kiểu dữ liệu varchar 
* create\_at kiểu timestamp set default là current\_timestamp thời điểm được thêm vào

bảng products

* ID kiểu dữ liệu bigint dùng generated by default để id tự động tăng dù khi nhập vào không nhập id
* code kiểu dữ liệu varchar ,not null bắt buộc và UNIQUE không trùng
* name kiểu dữ liệu varchar ,not null bắt buộc
* price kiểu dữ liệu bigint ,not null và sử dụng CHECK(>=0) điều kiện là >=0 
* stock kiểu dữ liệu int đặt Default tồn kho mặc định là 0 và điều kiện check phải lớn hơn bằng 0

bảng orders

* ID kiểu dữ liệu bigint dùng generated by default để id tự động tăng dù khi nhập vào không nhập id
* customer\_id kiểu dữ liệu bigint tham chiếu reference từ id ở bảng customers
* status kiểu dữ liệu varchar điều kiện check chỉ chứa NEW,CONFIRMED,SHIPPING,DONE,CANCELLED
* created\_at kiểu TIMESTAMP mặc định là thời gian lúc được thêm vào bảng

bảng order\_items

* ID kiểu dữ liệu bigint dùng generated by default để id tự động tăng dù khi nhập vào không nhập id
* product\_id kiểu dữ liệu bigint tham chiếu reference từ id ở bảng products

order\_id kiểu dữ liệu bigint tham chiếu reference từ id ở bảng orders

quantity kiểu dữ liệu int điều kiện check phải lớn hơn 0

unit\_price kiểu dữ liệu bigint điều kiện check phải lớn hơn hoặc bằng 0

UNIQUE(product\_id,order\_id) Một sản phẩm chỉ xuất hiện một dòng trong mỗi đơn.



**C3**

1.Danh sách sản phẩm còn hàng (stock > 0): code, name, price, stock, sắp xếp theo giá giảm dần.

* sử dụng where để lấy stock >0 và order by price desc để lấy giá giảm dần

2.Khách hàng dùng email Gmail (email kết thúc bằng @gmail.com): full\_name, email.

* dùng where email like '%@gmail.com' để lấy nhưng email có đuôi là @gmail.com

3.Các đơn hàng đã hoàn thành (DONE): mã đơn, tên khách hàng, status.

* dùng join để kết nối dữ liệu từ bảng orders với customers để kiểm tra những đơn hàng đã hoàn thành 

4.Tổng tiền của từng đơn hàng: order\_id, full\_name, total

* dùng sum(quantity\*unit\_price) as totat
* join bảng customer để lấy ra tên khách hàng ứng với mã đơn hàng và join bảng order\_item để lấy ra tổng giá trị cho từng mã đơn hàng ứng với từng customer

5.Số đơn hàng của từng khách hàng

* Dùng LEFT JOIN từ bảng customers sang bảng orders để giữ lại tất cả khách hàng, kể cả khách chưa có đơn (cột của orders khi đó là NULL). 
* Dùng COUNT(o.id) để đếm số đơn, vì COUNT trên một cột chỉ đếm giá trị khác NULL nên khách chưa có đơn ra 0. Cuối cùng GROUP BY theo khách hàng.



6\. Khách hàng có tổng chi tiêu ở các đơn DONE lớn hơn 1.000.000: full\_name, spent.

* Dùng JOIN ba bảng customers, orders, order\_items để nối khách hàng với các dòng hàng của họ. Dùng WHERE status = 'DONE' để chỉ lấy đơn đã hoàn thành. 
* Dùng SUM(quantity \* unit\_price) AS spent kết hợp GROUP BY để tính tổng chi tiêu của từng khách. Dùng HAVING SUM(...) > 1000000 để lọc sau khi đã cộng.



7\. Sản phẩm chưa từng được bán, không tính các đơn đã hủy (CANCELLED): code, name.

* Dùng NOT EXISTS với một truy vấn con: với mỗi sản phẩm, kiểm tra xem có dòng nào trong order\_items thuộc một đơn có status <> 'CANCELLED' hay không. 
* Nếu không có thì sản phẩm đó chưa từng được bán và được lấy ra. Cách này cũng bắt được sản phẩm chỉ xuất hiện trong các đơn đã hủy, vì đơn hủy không tính là đã bán.



8\. Top 3 sản phẩm bán được nhiều nhất theo tổng số lượng, không tính đơn đã hủy: code, name, sold. Nếu bằng nhau thì xếp theo code tăng dần.

* Dùng JOIN ba bảng products, order\_items, orders rồi WHERE status <> 'CANCELLED' để bỏ đơn đã hủy. 
* Dùng SUM(quantity) AS sold và GROUP BY theo sản phẩm để tính tổng số lượng bán. 
* Dùng ORDER BY sold DESC để xếp số lượng giảm dần, nếu bằng nhau thì xếp theo code tăng dần. Cuối cùng LIMIT 3 để lấy 3 sản phẩm đầu.

