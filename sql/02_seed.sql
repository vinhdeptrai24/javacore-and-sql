INSERT INTO customers (id, full_name, email, phone)
VALUES (1, 'Nguyễn Văn An', 'an.nguyen@gmail.com', '0901000001'),
       (2, 'Trần Thị Bình', 'binh.tran@yahoo.com', '0901000002'),
       (3, 'Lê Văn Cường', 'cuong.le@gmail.com', NULL),
       (4, 'Phạm Thị Dung', 'dung.pham@inviv.vn', '0901000004');

INSERT INTO products (id, code, name, price, stock)
VALUES (1, 'P01', 'Bàn phím cơ', 850000, 10),
       (2, 'P02', 'Chuột không dây', 250000, 0),
       (3, 'P03', 'Tai nghe', 450000, 5),
       (4, 'P04', 'Màn hình 24 inch', 3200000, 2),
       (5, 'P05', 'Lót chuột', 50000, 100);

INSERT INTO orders (id, customer_id, status)
VALUES (1, 1, 'DONE'),
       (2, 1, 'DONE'),
       (3, 2, 'CONFIRMED'),
       (4, 3, 'CANCELLED'),
       (5, 2, 'NEW');

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES (1, 1, 1, 800000),
       (1, 5, 2, 50000),
       (2, 3, 1, 450000),
       (3, 2, 2, 250000),
       (3, 5, 1, 50000),
       (4, 4, 1, 3200000),
       (5, 1, 2, 850000);

SELECT setval('customers_id_seq', 4),
       setval('products_id_seq', 5),
       setval('orders_id_seq', 5),
       setval('order_items_id_seq', 7);
