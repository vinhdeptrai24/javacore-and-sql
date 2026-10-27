--1.Danh sách sản phẩm còn hàng
SELECT code, name, price, stock
FROM products
WHERE stock > 0
order by price desc;
--2.Khách hàng dùng email Gmail
SELECT full_name, email
FROM customers
WHERE email LIKE '%gmail.com';
--3.Các đơn hàng đã hoàn thành
SELECT o.id, c.full_name, o.status
FROM orders o
inner join customers c ON o.customer_id = c.id
where status = 'DONE';
--4.Tổng tiền của từng đơn hàng
SELECT o.id AS order_id, c.full_name, SUM(oi.quantity * oi.unit_price) AS total
FROM orders o
JOIN customers c ON c.id = o.customer_id
JOIN order_items oi ON oi.order_id = o.id
GROUP BY o.id, c.full_name;
--5.Số đơn hàng của từng khách hàng
SELECT c.full_name, COUNT(o.id) AS order_count
FROM customers c
LEFT JOIN orders o ON o.customer_id = c.id
GROUP BY c.id, c.full_name;
--6.Khách hàng có tổng chi tiêu ở các đơn DONE lớn hơn 1.000.000
SELECT c.full_name, SUM(oi.quantity * oi.unit_price) AS spent
FROM customers c
JOIN orders o ON o.customer_id = c.id
JOIN order_items oi ON oi.order_id = o.id
WHERE o.status = 'DONE'
GROUP BY c.id, c.full_name
HAVING SUM(oi.quantity * oi.unit_price) > 1000000;
--7.Sản phẩm chưa từng được bán, không tính các đơn đã hủy
SELECT p.code, p.name
FROM products p
WHERE NOT EXISTS (
    SELECT 1
    FROM order_items oi
    JOIN orders o ON o.id = oi.order_id
    WHERE oi.product_id = p.id
    AND o.status <> 'CANCELLED');
--8.Top 3 sản phẩm bán được nhiều nhất theo tổng số lượng, không tính đơn đã hủy
SELECT p.code, p.name, sum(oi.quantity) as sold
from products p
    join order_items oi on p.id = oi.product_id
    join orders o on o.id = oi.product_id
where status <> 'CANCELLED'
group by p.code, p.name
order by sold desc limit 3;