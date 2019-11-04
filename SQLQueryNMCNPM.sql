create database CAFE
use CAFE

create table KhachHang
(
	MaKH char(10) primary key,
	TenKH nvarchar(30) not null
)

-- Insert rows into table 'TableName'
INSERT INTO KhachHang
VALUES
	('KH_1', N'Nguyễn Duy Cần'),
	('KH_2', N'Nguyễn Anh Khoa'),
	('KH_3', N'Lâm Kiều Minh'),
	('KH_4', N'Hoàng Thảo My')

create table Ban
(
	MaBan char(10) primary key,
	SoLuongCho int not null,
	ViTri nvarchar(30)
)

INSERT INTO Ban
VALUES
	('TABLE_#1', '5', N'Cửa sổ'),
	('TABLE_#2', '10', N'Cửa sổ'),
	('TABLE_#3', '15', N'Sảnh'),
	('TABLE_#4', '20', N'Sảnh'),
	('TABLE_#5', '5', N'Lầu'),
	('TABLE_#6', '10', N'Lầu'),
	('TABLE_#7', '15', N'Lầu'),
	('TABLE_#8', '20', N'Sảnh'),
	('TABLE_#9', '5', N'Cửa sổ')

create table ChucVu
(
	MaChucVu char(10) primary key,
	TenChucVu nvarchar(30) not null,
)

INSERT INTO ChucVu
VALUES
	('CV_1', N'Bồi bàn'),
	('CV_2', N'Bếp'),
	('CV_3', N'Thu ngân'),
	('CV_4', N'Quản lý'),
	('CV_5', N'Chủ')

create table NhanVien
(
	MaNhanVien char(10) primary key,
	MaChucVu char(10) not null,
	TaiKhoan char(20) not null,
	MatKhau char(20) not null,
	TenNhanVien nvarchar(30) not null,
	DiaChi nvarchar(50) not null,
	SDT char(10) not null,
	constraint fk_nv_mcv foreign key (MaChucVu) references ChucVu (MaChucVu),
)

INSERT INTO NhanVien
VALUES
	('NV_1', 'CV_1', 'haminhthuan', 'haminhthuanpass', N'Hà Minh Thuận', N'Sadek, Đồng Tháp', '0375829573'),
	('NV_2', 'CV_2', 'doanngocthuong', 'doanngocthuongpass', N'Đoàn Ngọc Thưởng', N'Vị Thanh, Hậu Giang', '0945687215'),
	('NV_3', 'CV_3', 'huynhtanky', 'huynhtankypass', N'Huỳnh Tấn Kỷ', N'Vị Thủy, Hậu Giang', '0874521687'),
	('NV_4', 'CV_4', 'doanhoangtinh', 'doanhoangtinhpass', N'Đoàn Hoàng Tính', N'Tháp Mười, Đồng Tháp', '074589615')

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
	TenDanhMuc nvarchar(10) not null,
)

INSERT INTO DanhMuc
VALUES
	('DM_1', N'Ăn sáng'),
	('DM_2', N'Ăn trưa'),
	('DM_3', N'Ăn tối'),
	('DM_4', N'Đồ ngọt'),
	('DM_5', N'Nước')

create table Mon
(
	MaMon char(10) primary key,
	MaDanhMuc char(10) not null,
	TenMon nvarchar(30) not null,
	MoTaMon char(60),
	Anh char(200),
	GiaMon char(10) not null,
	constraint fk_dm_mdmm foreign key (MaDanhMuc) references DanhMuc(MaDanhMuc),
)

INSERT INTO Mon
VALUES
	-- Them an sang
	('MA_01', 'DM_1', N'Bánh mì', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\banhmi.jpg', '20000'),
	('MA_02', 'DM_1', N'Bún riêu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\bunrieu.jpg', '35000'),
	('MA_03', 'DM_1', N'Cơm tấm', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\comtam.jpg', '30000'),
	('MA_04', 'DM_1', N'Hủ tiếu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\hutieu.jpg', '35000'),
	('MA_05', 'DM_1', N'Mì', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\breakfast\\mi.jpg', '35000'),
	-- Them an trua
	('MA_06', 'DM_2', N'Cá kho', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\cakho.jpg', '30000'),
	('MA_07', 'DM_2', N'Canh chua', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\canhchua.jpg', '40000'),
	('MA_08', 'DM_2', N'Canh xà lách', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\canhxalach.jpg', '35000'),
	('MA_09', 'DM_2', N'Rau xào', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\rauxao.jpg', '50000'),
	('MA_10', 'DM_2', N'Thịt kho', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\lunch\\thitkho.jpg', '30000'),
	-- Them an toi
	('MA_11', 'DM_3', N'Beefsteak', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\beefsteak.jpg', '100000'),
	('MA_12', 'DM_3', N'Pasta', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\pasta.jpg', '55.000'),
	('MA_13', 'DM_3', N'Soup cà chua', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupcachua.png', '40000'),
	('MA_14', 'DM_3', N'Soup carrot', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupcarrot.jpg', '40000'),
	('MA_15', 'DM_3', N'Soup thịt gà và nui', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\soupthitganui.jpg', '55000'),
	('MA_16', 'DM_3', N'Thịt bò nướng', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\thitbonuong.jpg', '200000'),
	('MA_17', 'DM_3', N'Thịt dê nướng', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dinner\\thitdenuong.jpg', '250000'),
	-- Them nuoc
	('MA_18', 'DM_5', N'Cà phê đen', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\capheden.jpg', '20000'),
	('MA_19', 'DM_5', N'Latte', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\latte.jpg', '40000'),
	('MA_20', 'DM_5', N'Mocha', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\mocha.jpg', '50000'),
	('MA_21', 'DM_5', N'Rượu vang mật ong', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\ruouvangmatong.jpg', '60000'),
	('MA_22', 'DM_5', N'Combo rượu vang', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\drink\\comboruouvang.jpg', '300000'),
	-- Them banh
	('MA_23', 'DM_4', N'Bánh mocha', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\banhmocha.jpg', '35000'),
	('MA_24', 'DM_4', N'Irish Brownie', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\irishbrownie.jpg', '40000'),
	('MA_25', 'DM_4', N'Kem', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\kem.jpg', '35000'),
	('MA_26', 'DM_4', N'Tiramisu', '', 'E:\\Code\\Java\\CafeManager\\Design\\image\\menu\\dessert\\tiramisu.jpg', '35000')

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

create table TrangThai
(
	MaHoaDon char(10) not null,
	TrangThaiHD BIT not null,
	constraint pk_tt_mhd_tthd primary key (MaHoaDon,TrangThaiHD),
	constraint fk_tt_mhd foreign key (MaHoaDon) references HoaDon (MaHoaDon),
)

insert into TrangThai
VALUES
	('HD_1', 0),
	('HD_2', 0)

select a.TrangThaiHD
from TrangThai as a
where 
	a.MaHoaDon='HD_1'

update TrangThai set TrangThaiHD=0 where 
	a.MaHoaDon='HD_1'

select a.MaHoaDon, a.MaBan
from HoaDon as a, TrangThai as b
where 
	b.TrangThaiHD=0 and
	b.MaHoaDon=a.MaHoaDon

select a.TenMon, b.SoLuongMon
from Mon as a, ChiTietMon as b
where
	b.MaHoaDon='HD_2' AND
	b.MaMon = a.MaMon


--Xóa tất cả dữ liệu trong 1 bảng
delete from KhachHang
delete from HoaDon
delete from Mon
delete from ChiTietMon
delete from Ban
delete from ChucVu
delete from NhanVien
delete from TrangThai

--Xóa bảng
drop table DanhMuc
drop table KhachHang
drop table HoaDon
drop table Mon
drop table ChiTietMon
drop table Ban
drop table ChucVu
drop table NhanVien
drop table TrangThai