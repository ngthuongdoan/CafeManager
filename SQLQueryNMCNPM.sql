create database CAFE
use CAFE

create table KhachHang
(
	MaKH char(10) primary key,
	TenKH char(30) not null
)

-- Insert rows into table 'TableName'
INSERT INTO KhachHang
VALUES
	('KH_1', 'Nguyen Duy Can'),
	('KH_2', 'Nguyen Anh Khoa'),
	('KH_3', 'Lam Kieu Minh'),
	('KH_4', 'Hoang Thao My')

create table Ban
(
	MaBan char(10) primary key,
	SoLuongCho int not null,
	ViTri char(30)
)

INSERT INTO Ban
VALUES
	('TABLE_#1', '5', 'Cua so'),
	('TABLE_#2', '10', 'Cua so'),
	('TABLE_#3', '15', 'Sanh'),
	('TABLE_#4', '20', 'Sanh'),
	('TABLE_#5', '5', 'Lau'),
	('TABLE_#6', '10', 'Lau'),
	('TABLE_#7', '15', 'Lau'),
	('TABLE_#8', '20', 'Sanh'),
	('TABLE_#9', '5', 'Cua so')

create table ChucVu
(
	MaChucVu char(10) primary key,
	TenChucVu char(30) not null,
)

INSERT INTO ChucVu
VALUES
	('CV_1', 'Boi ban'),
	('CV_2', 'Bep'),
	('CV_3', 'Thu ngan'),
	('CV_4', 'Quan ly'),
	('CV_5', 'Chu')

create table NhanVien
(
	MaNhanVien char(10) primary key,
	MaChucVu char(10) not null,
	TaiKhoan char(20) not null,
	MatKhau char(20) not null,
	TenNhanVien char(30) not null,
	DiaChi char(50) not null,
	SDT char(10) not null,
	constraint fk_nv_mcv foreign key (MaChucVu) references ChucVu (MaChucVu),
)

INSERT INTO NhanVien
VALUES
	('NV_1', 'CV_1', 'haminhthuan', 'haminhthuanpass', 'Ha Minh Thuan', 'Sadek, Dong Thap', '0375829573'),
	('NV_2', 'CV_2', 'doanngocthuong', 'doanngocthuongpass', 'Doan Ngoc Thuong', 'Vi Thanh, Hau Giang', '0945687215'),
	('NV_3', 'CV_3', 'huynhtanky', 'huynhtankypass', 'Huynh Tan Ky', 'Vi Thuy, Hau Giang', '0874521687'),
	('NV_4', 'CV_4', 'doanhoangtinh', 'doanhoangtinhpass', 'Doan Hoang Tinh', 'Thap Muoi, Dong Thap', '074589615')

create table HoaDon
(
	MaHoaDon char(10) primary key,
	MaBan char(10) not null,
	MaNhanVien char(10),
	MaKH char(10),
	NgayTaoHD datetime not null,
	TongTien char(10) not null,
	constraint fk_hd_mb foreign key (MaBan) references Ban (MaBan),
	constraint fk_hd_mnv foreign key (MaNhanVien) references NhanVien (MaNhanVien),
	constraint fk_hh_mkh foreign key (MaKH) references KhachHang (MaKH)
)

INSERT INTO HoaDon
VALUES
	('HD_1', 'TABLE_#1', 'NV_3', 'KH_1', '20190618 10:34:09 AM', '305000'),
	('HD_2', 'TABLE_#4', 'NV_3', 'KH_2', '20190618 10:34:09 PM', '5250000')

create table DanhMuc
(
	MaDanhMuc char(10) primary key,
	TenDanhMuc char(10) not null,
)

INSERT INTO DanhMuc
VALUES
	('DM_1', 'An sang'),
	('DM_2', 'An trua'),
	('DM_3', 'An toi'),
	('DM_4', 'Do ngot'),
	('DM_5', 'Nuoc')

create table Mon
(
	MaMon char(10) primary key,
	MaDanhMuc char(10) not null,
	TenMon char(30) not null,
	MoTaMon char(60),
	Anh char(200),
	GiaMon char(10) not null,
	constraint fk_dm_mdmm foreign key (MaDanhMuc) references DanhMuc(MaDanhMuc),
)

INSERT INTO Mon
VALUES
	-- Them an sang
	('MA_1', 'DM_1', 'Bánh mì', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\banhmi.jpg', '20000'),
	('MA_2', 'DM_1', 'Bún riêu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\bunrieu.jpg', '35000'),
	('MA_3', 'DM_1', 'Cơm tấm', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\comtam.jpg', '30000'),
	('MA_4', 'DM_1', 'Hủ tiếu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\hutieu.jpg', '35000'),
	('MA_5', 'DM_1', 'Mì', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\mi.jpg', '35000'),
	-- Them an trua
	('MA_6', 'DM_2', 'Cá kho', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\cakho.jpg', '30000'),
	('MA_7', 'DM_2', 'Canh chua', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\canhchua.jpg', '40000'),
	('MA_8', 'DM_2', 'Canh xà lách', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\canhxalach.jpg', '35000'),
	('MA_9', 'DM_2', 'Rau xào', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\rauxao.jpg', '50000'),
	('MA_10', 'DM_2', 'Thịt kho', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\thitkho.jpg', '30000'),
	-- Them an toi
	('MA_11', 'DM_3', 'Beefsteak', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\beefsteak.jpg', '100000'),
	('MA_12', 'DM_3', 'Pasta', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\pasta.jpg', '55.000'),
	('MA_13', 'DM_3', 'Soup cà chua', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupcachua.png', '40000'),
	('MA_14', 'DM_3', 'Soup carrot', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupcarrot.jpg', '40000'),
	('MA_15', 'DM_3', 'Soup thịt gà và nui', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupthitganui.jpg', '55000'),
	('MA_16', 'DM_3', 'Thịt bò nướng', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\thitbonuong.jpg', '200000'),
	('MA_17', 'DM_3', 'Thịt dê nướng', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\thitdenuong.jpg', '250000'),
	-- Them nuoc
	('MA_18', 'DM_5', 'Cà phê đen', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\capheden.jpg', '20000'),
	('MA_19', 'DM_5', 'Latte', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\latte.jpg', '40000'),
	('MA_20', 'DM_5', 'Mocha', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\mocha.jpg', '50000'),
	('MA_21', 'DM_5', 'Rượu vang mật ong', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\ruouvangmatong.jpg', '60000'),
	('MA_22', 'DM_5', 'Combo rượu vang', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\comboruouvang.jpg', '300000'),
	-- Them banh
	('MA_23', 'DM_4', 'Bánh mocha', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\banhmocha.jpg', '35000'),
	('MA_24', 'DM_4', 'Irish Brownie', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\irishbrownie.jpg', '40000'),
	('MA_25', 'DM_4', 'Kem', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\kem.jpg', '35000'),
	('MA_26', 'DM_4', 'Tiramisu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\tiramisu.jpg', '35000')

create table ChiTietMon
(
	MaHoaDon char(10) not null,
	MaMon char(10) not null,
	SoLuongMon int not null,
	constraint pk_ctma_mhd_mm primary key (MaHoaDon,MaMon),
	constraint fk_ctma_mhd foreign key (MaHoaDon) references HoaDon (MaHoaDon),
	constraint fk_ctma_mm foreign key (MaMon) references Mon (MaMon)
)


INSERT INTO ChiTietMon
VALUES
	-- Them mon HD_1 305k
	('HD_1', 'MA_18', 2),
	('HD_1', 'MA_19', 2),
	('HD_1', 'MA_23', 3),
	('HD_1', 'MA_25', 3),
	('HD_1', 'MA_26', 3),
	-- Them mon HD_2 5tr250
	('HD_2', 'MA_22', 1),
	('HD_2', 'MA_23', 10),
	('HD_2', 'MA_24', 10),
	('HD_2', 'MA_15', 20),
	('HD_2', 'MA_12', 20),
	('HD_2', 'MA_16', 10)

select * from HoaDon


--Xóa tất cả dữ liệu trong 1 bảng
delete from KhachHang
delete from HoaDon
delete from MonAn
delete from ChiTietDoUong
delete from ChiTietMonAn
delete from DoUong
delete from Ban
delete from ChucVu
delete from NhanVien
delete from TrangThai

--Xóa bảng
drop table DanhMuc
drop table KhachHang
drop table HoaDon
drop table MonAn
drop table ChiTietDoUong
drop table ChiTietMonAn
drop table DoUong
drop table Ban
drop table ChucVu
drop table NhanVien
drop table TrangThai