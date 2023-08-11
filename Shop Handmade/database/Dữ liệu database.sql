SELECT * FROM shop_hand_made2.app_user;
use shop_hand_made2;

INSERT INTO app_user (name, phone_number, address, gender, day_of_birth, email, password, is_delete) 
VALUES 
('Nguyễn Thị Hương', '09887654321', '123 Đường Hồ Tùng Mậu, Quận 1, TP. HCM', 0, '1990-01-01', 'huongnguyen@example.com', 'matkhau123',0),
('Trần Văn Nam', '0144456789', '456 Đường Lê Lai, Quận 2, TP. HCM', 1, '1995-05-05', 'namtran@example.com', 'matkhau456',0),
('Lê Thị Thuỳ Linh', '0987213456', '789 Đường Lý Thường Kiệt, Quận 3, TP. HCM', 0, '1985-12-25', 'linhle@example.com', 'matkhau789',0),
('Phạm Văn Hùng', '0912345578', '321 Đường Nguyễn Huệ, Quận 1, TP. HCM', 1, '1998-09-15', 'hungpham@example.com', 'matkhau101112',0),
('Trần Thị Bình', '0987004321', '456 Đường Nguyễn Công Trứ, Quận 4, TP. HCM', 0, '1992-06-30', 'binhtran@example.com', 'matkhau131415',0),
('Nguyễn Văn Khánh', '0123456789', '789 Đường Trần Phú, Quận 5, TP. HCM', 1, '1988-02-14', 'khanhnguyen@example.com', 'matkhau161718',0),
('Lê Thị Minh Anh', '0987123456', '123 Đường Nguyễn Thái Bình, Quận 1, TP. HCM', 0, '1993-11-20', 'anhle@example.com', 'matkhau192021',0),
('Phạm Văn Tài', '0912345678', '456 Đường Lê Thị Riêng, Quận 10, TP. HCM', 1, '1996-08-05', 'taipham@example.com', 'matkhau222324',0),
('Trần Thị Kim Ngân', '0987784321', '789 Đường Tô Hiến Thành, Quận 11, TP. HCM', 0, '1991-04-10', 'ngantran@example.com', 'matkhau252627',0);

INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('1', '1');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('2', '2');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('3', '3');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('4', '3');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('5', '3');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('6', '3');
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES ('7', '3');

INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (1, 1);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (2, 2);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (3, 3);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (4, 3);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (5, 3);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (6, 3);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (7, 3);
INSERT INTO `shop_hand_made2`.`user_role` (`id_user`, `id_role`) VALUES (8, 2);
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://anhsang.edu.vn/wp-content/uploads/anh-dai-dien-buon-cho-nam16.jpg' WHERE (`id` = '1');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://img2.thuthuatphanmem.vn/uploads/2018/11/30/anh-dai-dien-anime-dep_104204759.jpg' WHERE (`id` = '2');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa5rdyWMG-dGDY-2gdSzeYwYWxS90DDx1I101sCTkWCg&s' WHERE (`id` = '3');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://phunugioi.com/wp-content/uploads/2020/01/anh-avatar-supreme-dep-lam-dai-dien-facebook.jpg' WHERE (`id` = '4');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://haycafe.vn/wp-content/uploads/2021/12/hinh-anh-avatar-dep-cho-con-gai-dai-dien-Facebook-Zalo-Tiktok.jpg' WHERE (`id` = '5');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9hxm2v23bvo7WVnh2s90hcnk3abb55Wse19Ea4YicX1CF8Q57F1t9YGWPlq2BPYYJQ5A&usqp=CAU' WHERE (`id` = '6');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://demoda.vn/wp-content/uploads/2022/03/avatar-nu-1.jpg' WHERE (`id` = '7');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN3hVZeLqrd_NUeDTXA3rnRuk1iexMWh-wiXHqBK2W&s' WHERE (`id` = '8');
UPDATE `shop_hand_made2`.`app_user` SET `img` = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDV7hjZBH-EXHmM9CTjAZR-nDDtdonZ-9uK5rso1FTqQ0r3IPGiJbWxSZZO43FEK9rtcU&usqp=CAU' WHERE (`id` = '9');
INSERT INTO types (name) VALUES 
('Đồ trang trí phòng ngủ'),
('Đồ trang trí phòng khách'),
('Đồ trang trí nhà bếp'),
('Đồ trang trí phòng làm việc'),
('Đồ handmade dùng cho gia đình');
INSERT INTO product (name, prices, description, date_submitted, quantity, type_product,is_delete) VALUES 
('Ghế handmade trang trí phòng khách', 100000, 'Ghế bằng chất liệu gỗ tự nhiên, được thiết kế tinh tế và trang trí thủ công', '2022-12-01', 10, 1,0),
('Bàn handmade phòng làm việc', 150000, 'Bàn làm từ gỗ cao cấp và sơn màu tự nhiên, được hoàn thiện bằng tay', '2022-11-01', 5, 4,0),
('Khung tranh thêu tay', 5000000, 'Khung tranh thêu tay với họa tiết hoa sen đẹp mắt, làm từ chất liệu vải cao cấp', '2023-01-10', 20, 1,0),
('Chậu cây cảnh handmade', 30000, 'Chậu cây cảnh bằng gốm sứ handmade, được trang trí thủ công bằng những hoa văn độc đáo', '2022-10-15', 15, 2,0),
('Túi xách handmade', 70000, 'Túi xách bằng da thật và được may thủ công, có nhiều ngăn tiện lợi', '2023-03-20', 8, 5,0),
('Áo len handmade', 40000, 'Áo len thủ công bằng sợi len tinh tế và ấm áp, có nhiều màu sắc cho bạn lựa chọn', '2022-12-15', 12, 5,0),
('Đồ trang trí handmade cho phòng ngủ', 80000, 'Bộ đồ trang trí gồm chăn ga gối nệm handmade, sử dụng chất liệu vải cao cấp', '2023-02-25', 6, 1,0);
('Đèn handmade trang trí phòng khách', 120000, 'Đèn bàn handmade từ chất liệu gỗ và kim loại, được trang trí bằng những họa tiết độc đáo', '2022-09-20', 3, 1,0);



INSERT INTO `shop_hand_made2`.`image` (`id`, `img`, `product_id`) VALUES (1, 'https://cosevco.vn/wp-content/uploads/2020/04/tu-lam-ban-ghe-handmade.jpeg', 1);
INSERT INTO `shop_hand_made2`.`image` (`id`, `img`, `product_id`) VALUES (2, 'https://media.loveitopcdn.com/26706/images/uploaded/nhung-kich-thuoc-ghe-sofa-go-chu-l-pho-bien-nhat-13.jpeg', 1);
INSERT INTO `shop_hand_made2`.`image` (`id`, `img`, `product_id`) VALUES (3, 'https://noithatmyhouse.com/wp-content/uploads/2019/12/tu-lam-ban-ghe-handmade.jpeg', 1);
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://afamilycdn.com/2019/7/18/9-156343639506556871206.jpg', '2');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://noithathoaphat.pro/img/uploads/images/blog/41-55/bn-lm-vic-p-1.jpg', '2');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://www.nhadepkientruc.net/wp-content/uploads/2018/05/Trang-tri-phong-ngu-theo-phong-cach-vintage-12.jpg', '2');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://vn-test-11.slatic.net/p/7908bf6744693a5dc3717e9f9f4aa4a7.png', '3');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://vn-live-01.slatic.net/p/9afafe6e973bb9adf4f754f83dfc8133.png', '3');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM9KHLOF9Sv6vRwuytr9NkQoMEXY68IBT0d65Cwi9mchJqEcPrluWh22Ik9s6clQyK6dk&usqp=CAU', '3');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://static-4.happynest.vn/storage/uploads/2020/05/6d1f6b7a8a1238fcfa0bd55280a317e3.jpg', '4');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://cf.shopee.vn/file/97d349e52bd513b8b84f9c02dfccd96b_tn', '4');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://img.cdn.vncdn.io/cdn-pos/71a8b2-3946/art/artCT/20160615_LF7sHxLxDgxgw0x91NHO5U3X.jpg', '4');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://giaumiz.com/wp-content/uploads/2019/05/IMG_7593_medium2.jpg', '6');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsYKycs31VviR_IWRGy1CshqUFstKURJetaLaYBbVxHZGxbQxrrt6PeEnzgZKhwd_1oIU&usqp=CAU', '6');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://tieudungxanh24h.com/cdn/images/tu-trang-tri-phong-ngu-handmade.jpg', '7');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://cosevco.vn/wp-content/uploads/2020/04/trang-tri-phong-ngu-bang-do-handmade_27.jpg', '7');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://noithatanhung.vn/uploads/images/bai-viet/tuyet/11.19/18.11-trang-tri-handmade/03-tri-phong-ngu-bang-giay-thu-cong.jpg', '7');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://bamienads.com/media/1840/den-handmade.jpg?width=333.125&height=500', '8');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://bamienads.com/media/1842/den-handmade-2.jpg?width=500&height=432.53968253968253', '8');
INSERT INTO `shop_hand_made2`.`image` (`img`, `product_id`) VALUES ('https://bamienads.com/media/1841/den-handmade-1.jpg?width=500&height=345', '8');
INSERT INTO `shop_hand_made2`.`cart` (`id`, `date_purchase`, `total_pay`, `id_user`) VALUES (1, '2023/02/02', 50000, 1);
INSERT INTO `shop_hand_made2`.`cart` (`id`, `date_purchase`, `total_pay`, `id_user`) VALUES (2, '2023/02/02', 50000, 2);
INSERT INTO `shop_hand_made2`.`cart` (`id`, `date_purchase`, `total_pay`, `id_user`) VALUES (3, '2023/02/02', 80000, 3);
INSERT INTO `shop_hand_made2`.`cart_detail` (`amount`, `is_flag`, `order_id`, `product_id`) VALUES (2, 0, 1, 1);
INSERT INTO `shop_hand_made2`.`cart_detail` (`amount`, `is_flag`, `order_id`, `product_id`) VALUES (1, 0, 2, 1);
INSERT INTO `shop_hand_made2`.`cart_detail` (`amount`, `is_flag`, `order_id`, `product_id`) VALUES (2, 0, 1, 2);
INSERT INTO `shop_hand_made2`.`cart_detail` (`amount`, `is_flag`, `order_id`, `product_id`) VALUES (5, 0, 3, 1);

select product.*, image.img from product join image   on product.id= image.product_id where is_delete=false  ;
select * from product where  is_delete=false and name like '%%' and type_product=1;
select * from image where image.product_id in  (select id from product where id=1);
 select cart.id as idCart,  product.id as id, product.name as name, product.prices as prices, cart_detail.amount as amount from product join  cart_detail on  product.id=cart_detail.product_id
            join cart on cart.id=cart_detail.order_id join app_user on app_user.id=cart.id_user where app_user.email like 'linhle@example.com'  and cart_detail.is_flag=false