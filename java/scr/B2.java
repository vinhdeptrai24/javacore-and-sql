package scr;

public class B2 {
    public static long calculateTotal(int[] quantities, long[] unitPrices){
        if(quantities==null||unitPrices==null)
            throw new IllegalArgumentException("1 trong 2 mảng không được null");
        if(quantities.length!=unitPrices.length)
            throw new IllegalArgumentException("2 mảng phải có độ dài bằng nhau");
        long total =0;
        for(int i=0;i<quantities.length;i++){
            if(quantities[i]<=0)
                throw new IllegalArgumentException("số lượng sản phẩm không có giá trị <= 0");
            if(unitPrices[i]<0)
                throw new IllegalArgumentException("giá trị sản phẩm không được có giá trị <0 ");
            total+=(long)quantities[i]*unitPrices[i];
        }
        return total;
    }
    public static void test(int[] quantities, long[] unitPrices){
        try {
            System.out.println("total: "+calculateTotal(quantities,unitPrices));
        }
        catch (IllegalArgumentException e){
            System.out.println("lỗi: "+e.getMessage());
        }
    }
    static void main(String[] args) {
        test(new int[]{2, 1},new long[]{15000, 30000});
        test(new int[]{},new long[]{});
        test(new int[]{100000},new long[]{50000});
        test(new int[]{1},new long[]{1,2});
        test(new int[]{0},new long[]{15000});
        test(new int[]{2},new long[]{-1});
    }
}
