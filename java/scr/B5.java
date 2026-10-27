package scr;

enum OrderStatus { NEW, CONFIRMED, SHIPPING, DONE, CANCELLED }
public class B5 {
    public static OrderStatus nextStatus(OrderStatus current, String action){
        if(current==null)
            throw new IllegalArgumentException("trạng thái hiện tại không được null");
        if(action==null||action.isBlank())
            throw new IllegalArgumentException("action không được null hoặc rỗng");
        String s=action.toUpperCase().trim();
        switch (s){
            case "CONFIRM":
                if(current==OrderStatus.NEW) return OrderStatus.CONFIRMED;
                break;
            case "SHIP":
                if(current==OrderStatus.CONFIRMED) return OrderStatus.SHIPPING;
                break;
            case "COMPLETE":
                if(current==OrderStatus.SHIPPING) return OrderStatus.DONE;
                break;
            case "CANCEL":
                if(current==OrderStatus.NEW||current==OrderStatus.CONFIRMED) return OrderStatus.CANCELLED;
                break;
            default:
                throw new IllegalArgumentException("action không tồn tại");
        }
        throw new IllegalArgumentException("Không thể " + s + " khi đơn hàng đang ở trạng thái " + current);

    }
    private static void test(OrderStatus current, String action) {
        try {
            System.out.println(current + " + \"" + action + "\" -> " + nextStatus(current, action));
        } catch (IllegalArgumentException e) {
            System.out.println(current + " + \"" + action + "\" -> lỗi: " + e.getMessage());
        }
    }

    static void main(String[] args) {
        System.out.println("=== Hợp lệ ===");
        test(OrderStatus.NEW, "CONFIRM");
        test(OrderStatus.CONFIRMED, " ship ");
        test(OrderStatus.SHIPPING, "complete");
        test(OrderStatus.NEW, "Cancel");
        test(OrderStatus.CONFIRMED, "CANCEL");

        System.out.println("=== Không hợp lệ ===");
        test(null, "CONFIRM");
        test(OrderStatus.NEW, null);
        test(OrderStatus.NEW, "   ");
        test(OrderStatus.NEW, "REFUND");
        test(OrderStatus.DONE, "CANCEL");
        test(OrderStatus.NEW, "SHIP");
    }
}
