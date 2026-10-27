--1.Tăng giá sản phẩm P03 thêm 10%. Trước câu UPDATE,
-- viết câu SELECT kiểm tra dữ liệu sẽ bị ảnh hưởng
SELECT id, code, price FROM products WHERE code = 'P03';
UPDATE products
SET price = price * 11 / 10
WHERE code = 'P03';
--2.(Nâng cao) Hủy đơn hàng số 3 và trả lại tồn kho cho các sản phẩm trong đơn
