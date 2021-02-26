create database Rabbit_s_House
go 
use Rabbit_s_House
go
--use master
--drop database Rabbit_s_House
create table KhachHang
(
	MaKH int identity(1,1) primary key,
	HoTen nvarchar(50) not null,
	SoDT char(11) not null,

)
create table Mon
(
	MaMon int identity(1,1) primary key,
	TenMon nvarchar(50),
	Loai nvarchar(50),
	Gia money,
)

CREATE TABLE NHANVIEN(
	MaNV char(10) primary key,
	TenNV nvarchar(30) NOT NULL,
	GioiTinh bit NOT NULL,
	DiaChi nvarchar(100) NOT NULL,
	SoDT varchar(12) NOT NULL,
	Email varchar(50) NULL,
	UserName nvarchar(30) NOT NULL,
	Password nvarchar(30) NOT NULL,
	MaLTK int NOT NULL,
)
CREATE TABLE LOAITK(
	MaLTK int NOT NULL,
	TenLTK nvarchar(30) NULL,
	CONSTRAINT PK_LOAITK PRIMARY KEY (MaLTK)
)
--create table hoadon
--(
--	MaHD int identity(1,1) primary key,
--	MaKH int references KhachHang(MaKH),
--	MaNV varchar(10) references NhanVien(MaNV),
--	Ngaylap date,
--)
create table hoadon
(
	MaHD int identity(1,1) primary key,
	MaKH int references KhachHang(MaKH),
	MaMon int references Mon(MaMon),
	Soluong int,
	Gia money,
)
--alter table hoadon drop column Gia
--go
ALTER TABLE KhachHang ADD CONSTRAINT CHECK_SDT CHECK(LEN(SoDT)=10)
go
ALTER TABLE NHANVIEN   ADD  CONSTRAINT FK_NhanVien_LoaiTK FOREIGN KEY(MaLTK) REFERENCES LOAITK (MaLTK)
GO

insert into KhachHang values('Aoki Daisuke','1234567890')
insert into KhachHang values(N'Trần Văn Đú','0987654321')
insert into KhachHang values(N'Nguyễn Anh Hùng','4444466666')

insert into Mon values('Cafe den','Cafe',15000)
insert into Mon values(N'Cafe sữa','Cafe',15000)
insert into Mon values(N'Bạc xỉu','Cafe',15000)
insert into Mon values('Coca','NuocNgot',15000)
insert into Mon values('Mirina','NuocNgot',15000)
insert into Mon values('Pepsi','NuocNgot',15000)
insert into Mon values(N'Bánh Tráng Trộn','AnVat',15000)
insert into Mon values(N'Bánh Hoa Quả','AnVat',15000)
insert into Mon values(N'Bánh Dây Tây','AnVat',15000)
insert into Mon values(N'Pancake','AnVat',15000)

--Insert table LOAITK
insert into LOAITK values(1,N'Admin')
insert into LOAITK values(2,N'Nhân Viên Bán Hàng')
insert into LOAITK values(3,N'Nhân Viên Quản Lý Kho')


--Insert table NHANVIEN
insert into NHANVIEN values('NV0001', N'Aoki Daisuke', 1 ,N'Osaka','123456', 'aokidaisuke91@gmail.com','admin','123',1)
insert into NHANVIEN values('NV0002', N'Trần Tiến Đạt', 1 ,N'An Giang', '0913131788', 'đâtt@gmail.com','nvdat','123',2)
insert into NHANVIEN values('NV0003', N'Nguyễn Kim Ngân',0 ,N'Bình Dương', '098123733', 'vinhquang@gmail.com','nkngan','123',3)

insert into hoadon values(1, 2, 5, 16977)
insert into hoadon values(3, 1, 2, 43334)
insert into hoadon values(2, 3, 1, 45453)
go

select k.HoTen, k.SoDT, m.Loai, m.TenMon, m.Gia, h.Soluong from KhachHang k, Mon m, hoadon h where k.MaKH=h.MaKH and m.MaMon=h.MaMon