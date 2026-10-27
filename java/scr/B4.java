package scr;

import java.util.HashSet;
import java.util.Set;

class Product{
    private String code;
    private String name;
    private long price;
    private int stock;

    public Product(String code, String name, long price, int stock) {
        this.code = B1.normalizecode(code);
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name không được trống");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price không được âm");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("stock không được âm");
        }
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int decreasestock(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("quantity phải lớn hơn 0");
        }
        if (quantity > stock) {
            throw new IllegalStateException("Không đủ hàng: còn " + stock + ", cần " + quantity);
        }
        return stock-=quantity;
    }
    public int increasestock(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("quantity phải lớn hơn 0");
        }
        return stock+=quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Product)) return false;
        return code.equals(((Product) o).code);
    }
    @Override
    public int hashCode(){
        return code.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
public class B4 {
    static void main(String[] args) {
        Set<Product> set=new HashSet<>();
        set.add(new Product("P-01", "Bút", 5000, 10));
        set.add(new Product("p-01", "Bút bi", 6000, 5));
        System.out.println("size = " + set.size());
        Product p = new Product("ab1", "Vở", 12000, 5);
        p.decreasestock(3);
        System.out.println(p);

        try {
            p.decreasestock(10);
        } catch (IllegalStateException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        System.out.println("Tồn sau khi lỗi: " + p.getStock());

        try {
            p.increasestock(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
