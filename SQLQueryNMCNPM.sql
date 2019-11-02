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

create table HoaDon
(
	MaHoaDon char(10) primary key,
	MaBan char(10) not null,
	MaNhanVien char(10),
	MaKH char(10),
	NgayTaoHD datetime not null,
	TongTien money not null,
	constraint fk_hd_mb foreign key (MaBan) references Ban (MaBan),
	constraint fk_hd_mnv foreign key (MaNhanVien) references NhanVien (MaNhanVien),
	constraint fk_hh_mkh foreign key (MaKH) references KhachHang (MaKH)
)

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

create table DoUong
(
	MaDoUong char(10) primary key,
	MaDanhMuc char(10) not null,
	TenDoUong char(30) not null,
	MoTaDoUong char(30) not null,
	AnhDoUong image,
	GiaDoUong money not null,
	constraint fk_dm_mdm foreign key (MaDanhMuc) references DanhMuc(MaDanhMuc),
)

create table ChiTietDoUong
(
	MaHoaDon char(10),
	MaDoUong char(10),
	SoLuongDoUong int not null,
	constraint pk_ctdu_mhd_mdu primary key (MaHoaDon,MaDoUong),
	constraint fk_ctdu_mhd foreign key (MaHoaDon) references HoaDon (MaHoaDon),
	constraint fk_ctdu_mdu foreign key (MaDoUong) references DoUong (MaDoUong)
)

create table MonAn
(
	MaMonAn char(10) primary key,
	MaDanhMuc char(10) not null,
	TenMonAn char(30) not null,
	MoTaMonAn char(30) not null,
	AnhMonAn image,
	GiaMonAn money not null,
	constraint fk_dm_mdm foreign key (MaDanhMuc) references DanhMuc(MaDanhMuc),
)

create table ChiTietMonAn
(
	MaHoaDon char(10) not null,
	MaMonAn char(10) not null,
	SoLuongMonAn int not null,
	constraint pk_ctma_mhd_mma primary key (MaHoaDon,MaMonAn),
	constraint fk_ctma_mhd foreign key (MaHoaDon) references HoaDon (MaHoaDon),
	constraint fk_ctma_mma foreign key (MaMonAn) references MonAn (MaMonAn)
)

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