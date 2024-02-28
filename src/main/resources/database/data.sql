INSERT INTO homestay_manage.country(code, name) VALUES("VIETNAM", "Việt Nam");
INSERT INTO homestay_manage.country(code, name) VALUES("INDONESIA", "Indonesia");
INSERT INTO homestay_manage.country(code, name) VALUES("KOREA", "Hàn Quốc");
INSERT INTO homestay_manage.country(code, name) VALUES("JAPAN", "Nhật Bản");
INSERT INTO homestay_manage.country(code, name) VALUES("CHINA", "Trung Quốc");
INSERT INTO homestay_manage.country(code, name) VALUES("USA", "Mỹ");
INSERT INTO homestay_manage.country(code, name) VALUES("ENGLAND", "Anh");

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("NHATRANG", "Nha trang", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("DANANG", "Đà Nẵng", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("VUNGTAU", "Vũng Tàu", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("HANOI", "Hà Nội", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("TPHCM", "Thành Phố Hồ Chí Minh", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("QUANGNGAI", "Quảng Ngãi", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("QUYNHON", "Quy Nhơn", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("PHUQUOC", "Phú Quốc", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("DALAT", "Đà Lạt", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("PHANTHIET", "Phan Thiết", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("SAPA", "Sapa", 1);
INSERT INTO homestay_manage.city(code, name, country_id) VALUES("THAINGUYEN", "Thái Nguyên", 1);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("BALI", "Bali", 2);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("SEOUL", "Seoul", 3);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("TOKYO", "Tokyo", 4);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("HONGKONG", "HongKong", 5);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("LA", "Los Angeles", 6);

INSERT INTO homestay_manage.city(code, name, country_id) VALUES("LONDON", "London", 7);

INSERT INTO homestay_manage.payment(code, name) VALUES("TRANSFER", "Chuyển khoản");
INSERT INTO homestay_manage.payment(code, name) VALUES("QRCODE", "Quét mã QR");
INSERT INTO homestay_manage.payment(code, name) VALUES("ELECTRONICWALLET", "Ví điện tử");

INSERT INTO homestay_manage.role(code, name) VALUES("ADMIN", "Quản trị viên");
INSERT INTO homestay_manage.role(code, name) VALUES("USER", "Người dùng");

INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Biệt thự hướng núi 3 phòng ngủ", "img/da-lat.PNG", 220, 9);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ phòng kính 2 phòng ngủ", "img/nha-trang.PNG", 130, 1);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ cổ hướng biển 2 phòng ngủ", "img/da-nang.PNG", 240, 6);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ chung cư có ban công hướng biển 1 phòng ngủ", "img/da-nang2.PNG", 270, 2);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Villa sang trọng có hồ bơi 3 phòng ngủ", "img/quy-nhon.PNG", 90, 7);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ chung cư sang trọng với 2 phòng ngủ", "img/tp-hcm.PNG", 130, 5);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ chung cư truyền thống", "img/tokyo.PNG", 1320, 15);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Chung cư cửa kính hướng biển", "img/seoul.PNG", 2210, 14);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ rộng đầy đủ tiện nghi", "img/los-angeles.PNG", 1730, 17);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Penthouse cạnh bờ biển", "img/bali.PNG", 1536, 13);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ cạnh bãi biẻn 2 phòng ngủ", "img/hongkong.PNG", 1206, 16);
INSERT INTO homestay_manage.department(title, thumbnail, price, city_id) VALUES("Căn hộ giữa trung tâm thành phố", "img/lodon.PNG", 1805, 18);