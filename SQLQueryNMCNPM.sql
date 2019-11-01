create database CAFE 
use CAFE

create table KhachHang(
	MaKH char(10) primary key,
	TenKH char(30) not null
)

create table Ban(
	MaBan char(10) primary key,
	SoLuongCho int not null,
	ViTri char(30) not null
)

create table ChucVu(
	MaChucVu char(10) primary key,
	TenChucVu char(30) not null,
)

create table NhanVien(
	MaNhanVien char(10) primary key,
	MaChucVu char(10),
	TaiKhoan char(20) not null,
	MatKhau char(20) not null,
	TenNhanVien char(30) not null,
	DiaChi char(50) not null,
	SDT char(10) not null,
	constraint fk_nv_mcv foreign key (MaChucVu) references ChucVu (MaChucVu),
)

create table HoaDon(
	MaHoaDon char(10) primary key,
	MaBan char(10),
	MaNhanVien char(10),
	MaKH char(10),
	NgayTaoHD datetime not null,
	TongTien money not null,
	constraint fk_hd_mb foreign key (MaBan) references Ban (MaBan),
	constraint fk_hd_mnv foreign key (MaNhanVien) references NhanVien (MaNhanVien),
	constraint fk_hh_mkh foreign key (MaKH) references KhachHang (MaKH)
)


create table DoUong(
	MaDoUong char(10) primary key,
	TenDoUong char(30) not null,
	MoTaDoUong char(30) not null,
	AnhDoUong image,
	GiaDoUong money not null,
)

create table ChiTietDoUong(
	MaHoaDon char(10),
	MaDoUong char(10),
	SoLuongDoUong int not null,
	constraint pk_ctdu_mhd_mdu primary key (MaHoaDon,MaDoUong),
	constraint fk_ctdu_mhd foreign key (MaHoaDon) references HoaDon (MaHoaDon),
	constraint fk_ctdu_mdu foreign key (MaDoUong) references DoUong (MaDoUong)
)

create table MonAn(
	MaMonAn char(10) primary key,
	TenMonAn char(30) not null,
	MoTaMonAn char(30) not null,
	AnhMonAn image,
	GiaMonAn money not null,
)

create table ChiTietMonAn(
	MaHoaDon char(10),
	MaMonAn char(10),
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


 


