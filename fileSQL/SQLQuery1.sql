CREATE DATABASE DATA_JAVA4
--VIDEO
GO
CREATE TABLE User_TB(
	ID			int		PRIMARY KEY IDENTITY,
	Username	nvarchar(10)  NOT NULL,
	Password	nvarchar(50) NOT NULL,
	Email		nvarchar(100) NOT NULL,
	Admin		bit		NOT NULL DEFAULT 0
)

GO
CREATE TABLE Video_TB(
	ID			int				PRIMARY KEY IDENTITY,
	Tittle		nvarchar(255)	NOT NULL,
	Href		nvarchar(255)	unique NOT NULL,
	Poster		nvarchar(255)	NULL,
	Views		int				NOT NULL DEFAULT 0,
	Description nvarchar(255)	NOT NULL,
	Active		bit				NOT NULL DEFAULT 1 
)


GO
CREATE TABLE Favorite_TB(
	ID			int				PRIMARY KEY IDENTITY,
	ID_User		int				foreign key references User_TB(ID),
	ID_Video	int				foreign key references Video_TB(ID),
	LikeDate	datetime		NULL
)

GO
CREATE TABLE Share_TB(
	ID			int		PRIMARY KEY IDENTITY,
	ID_User		int		foreign key references User_TB(ID),
	ID_Video	int		foreign key references Video_TB(ID),
	Emails		nvarchar(255)	unique	NOT NULL,
	ShareDate	datetime	NULL
)


-- INSERT TABLE VIDEO
GO
INSERT INTO Video_TB(Tittle, Href, Poster, Views, Description, Active)
VALUES
(N'BẦU TRỜI NĂM ẤY', '63MS9mXmWlk?si=CgQ7diduzCP3EyuK', 'bautroinamay.jpg', 25, 
N'Bầu Trời Năm Ấy - Sean x Hast x AnFang (Official Lyric Video)"Bầu trời năm ấy vẫn thế vẫn mãi xanh"',1),
(N'MÌNH ANH NƠI NÀY', 'w2cEVsySsNI?si=_iOiXGWpq4h7rwfX', 'minhanhnoinay.jpg', 21,
N'MÌNH ANH NƠI NÀY - NIT ft. SING', 1),
(N'Có Không Giữ Mất Đừng Tìm', 'zFFET9PEdGA?si=-xjul4WLNXNX5G3P', 'cokhonggiu.jpg', 45, 
N'MV Official Có Không Giữ Mất Đừng Tìm của ca sỹ Cảnh Minh', 1),
(N'ĐỪNG VÌ ANH MÀ KHÓC', 'omacvKrg-ys?si=RCzJ0MKucwngLzGA', 'dungvianhmakhoc.jpg', 15,
N'Quang Hùng MasterD - ĐỪNG VÌ ANH MÀ KHÓC / Official Music Video', 0),
(N'Thuỷ Triều', '7ig2lXjozdw?si=DQN5io1mR7acFtZE','thuytrieu.jpg', 23,
N'Quang Hùng MasterD - ‘Thuỷ Triều’ - Official Visualizer', 1),
(N'NGÔI NHÀ HẠNH PHÚC', 'vKuHQRTS20U?si=l7EaXuVX_tizmoTX', 'ngoinhahanhphuc.jpg', 32,
N'NGÔI NHÀ HẠNH PHÚC - NHẬT PHÁT (học trò Nguyễn Trần Trung Quân) live at Lululola',1),
(N'Âm Thầm Bên Em', 'LG4OC1dvUCQ?si=ULLnRCekjQc5N0bP', 'amthambenem.jpg', 56,
N'Âm Thầm Bên Em · Sơn Tùng M-TP',1),
(N'Làm Vợ Anh Nhé', '3sxk_GgpJpc?si=oMLBuKUchFzhGoBC', 'lamvoanhnhe.jpg', 23,
N'Làm Vợ Anh Nhé  | Chi Dân ( Offical MV) | MUSO - Cảm xúc âm nhạc',1),
(N'Chờ Đợi Có Đáng Sợ ','MTWYLuj1y3g?si=Qk12VxWKkCtDUsou', 'chodoicodangso.jpg', 19,
N'Chờ Đợi Có Đáng Sợ - Andiez | Live at XIN CHÀO HÀN QUỐC - XIN CHAO GANGWON-DO',1),
(N'Như Anh Đã Thấy Em', 'cPbp2iFaZRo?si=KdvJCcQN6AECWkpy','nhuanhdathayem.jpg', 14, 
N'Như Anh Đã Thấy Em (CTTDE2) - PhucXp ft. Freak D',1),
(N'Phụ Tình', 'd8rXacGdR_4?si=wT4MklfOxGsctxka', 'phutinh.jpg',83,
N'Phụ Tình - Trịnh Đình Quang [Official MV] ', 1),
(N'Nếu Em Còn Tồn Tại', '1Zn4L7vi9gg?si=gphxRLgbHXnomCwF', 'neuemcontontai.jpg', 20, 
N'[Official Mv] Nếu Em Còn Tồn Tại - Trịnh Đình Quang ', 1),
(N'TỪNG YÊU','hhk1N3ovPpI?si=5XWzHHPQ3DJGawJP','tungyeu.jpg',24,
N'TỪNG YÊU - PHAN DUY ANH  [OFFICIAL MUSIC VIDEO]',1),
(N'Sai Lầm Của Anh','yn028QF2FPs?si=Ozrytbpa3TCznoqp','sailamcuaanh.jpg',42,
N'Sai Lầm Của Anh - Đình Dũng [Lyrics Mv]',1),
(N'Sự Thật Sau Một Lời Hứa','cQtzw0XHqMw?si=Lo1G6hF-vi5xrDrA','suthatsauloihua.jpg',34,
N'Sự Thật Sau Một Lời Hứa - Chi Dân ( Lyric Video ) - Anh không phải người em tìm kiếm lâu nay',1)
SELECT * FROM Video_TB
DELETE FROM Video_TB;
DBCC CHECKIDENT ('Video_TB', RESEED, 0);
Select * from Video_TB where Tittle like N'%th%'


-- INSERT TABLE USER
GO
INSERT INTO User_TB(Username, Password, Email, Admin) VALUES
(N'LanPhuong','123','lanphuong@gmail.com',0),
(N'TuanAnh2','123','tuananh@gmail.com',0),
(N'YenHoa54', '123','yenhoa@gmail.com',1),
(N'HaiPhuoc43','123','haiphuoc@gmail.com',0),
(N'Ngo32hien','123','ngohien21@gmail.com',0),
(N'lienanh34','123','lienanh321@gmail.com',0),
(N'Thu23Yen','123','thuyen@gmail.com',0),
(N'UyenAnh52','123','anhuyen3416@gmail.com',0),
(N'Truhan423','123','trucnhan650@gmail.com',0),
(N'hai53Tran','123','haitran@gmail.com',0),
(N'HoangVy42','123','hoangvy2132@gmail.com',0),
(N'KhoaDao241','123','khoadao231@gmail.com',0),
(N'DinhPhan53','123','dinhphan43@gmail.com',0),
(N'TriDinh941','123','tritom241@gmail.com',0),
(N'ThuHien14','123','thuhien53@gmail.com',0),
(N'LinhLe14','123','linh31le@gmail.com',0),
(N'TuPham321','123','tupham21@gmail.com',0)

select * from User_TB

DELETE FROM User_TB;
DBCC CHECKIDENT ('User_TB', RESEED, 0);

Select * from User_TB where username like '%HaiPhuoc43%'



--FAVOTITE
DELETE FROM Favorite_TB;
DBCC CHECKIDENT ('Favorite_TB', RESEED, 0);

select * from favorite_TB



--PRODUCT
CREATE PROC [dbo].[spFavoriteByYear](@Year INT)
AS
BEGIN
SELECT
v.Tittle AS 'Tittle',
max(f.LikeDate) AS 'newest',
min(f.LikeDate) AS 'oldest',
count(f.Id) AS 'likecount',
v.Views AS 'views'
FROM favorite_TB f JOIN Video_TB v ON v.id = f.id
WHERE year(f.LikeDate) = @Year
GROUP BY v.Tittle, v.Views
END
GO

