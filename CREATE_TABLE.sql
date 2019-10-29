CREATE DATABASE CAFE
USE CAFE

CREATE TABLE HoaDon(
	MaHoaDon varchar(10) primary key,
	MaNhanVien varchar(10) not null,
	MaBan varchar(10) not null,
	MaKH varchar(10) not null,
	NgayTaoHD Date not null,
	TongTien float not null,
)

create table TrangThai(
	MaHoaDon varchar(10) primary key references HoaDon(MaHoaDon),
	TrangThai varchar(10) not null,
)

create table MonAn(
	MaMonAn varchar(10) primary key,
	TenMonAn varchar(30) not null,
	MoTaMonAn varchar(30),
	AnhMonAn image,
	GiaMonAn float not null,
)

create table ChiTietMonAn(
	MaHoaDon varchar(10),
	MaMonAn varchar(10),
	SoLuongMonAn int,
	constraint pk_mhd_mma primary key(MaHoaDon, MaMonAn),
	constraint fk_mhd foreign key(MaHoaDon) references HoaDon(MaHoaDon),
	constraint fk_mma foreign key(MaMonAn) references MonAn(MaMonAn),
)

select a.MaHoaDon from HoaDon as a, ChiTietMonAn as b, MonAn as c
where
	a.MaHoaDon=b.MaHoaDon and
	c.MaMonAn=b.MaMonAn and
	a.MaKH='KH-1'
