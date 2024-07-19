use master
go
alter database AnimeWeb set single_user with rollback immediate
go
Drop DATABASE if exists AnimeWeb;
go
CREATE DATABASE AnimeWeb;
GO

-- Use the newly created database
USE AnimeWeb;
GO

-- Create User table
CREATE TABLE [User] (
    id VARCHAR(50) PRIMARY KEY NOT NULL,
    [password] VARCHAR(100),
    email VARCHAR(100),
    fullname VARCHAR(100),
    [admin] BIT
);
GO

-- Create Genre table
CREATE TABLE Genre (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100)
);
GO

-- Create Studio table
CREATE TABLE Studio (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100)
);
GO

-- Create Video table
CREATE TABLE Video (
    id INT PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    poster VARCHAR(255),
    views INT, -- Changed from 'view' to 'views'
    description TEXT,
    link VARCHAR(255),
    year INT,
    GenreId INT NOT NULL,
	StudioId INT NOT NULL,

    FOREIGN KEY (GenreId) REFERENCES Genre(id),
    FOREIGN KEY (StudioId) REFERENCES Studio(id)

);
GO

-- Create Favorite table
CREATE TABLE Favorite (
    id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    videoId INT NOT NULL,
    UserId VARCHAR(50) NOT NULL,
    FOREIGN KEY (videoId) REFERENCES Video(id),
    FOREIGN KEY (UserId) REFERENCES [User](id)
);
GO
-- Create View table
--DROP TABLE [View] (
--    id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
--    videoId INT NOT NULL,
--    UserId VARCHAR(50) NOT NULL,
--    FOREIGN KEY (videoId) REFERENCES Video(id),
--    FOREIGN KEY (UserId) REFERENCES [User](id)
--);
--GO

INSERT INTO [User] (id, password, email, fullname, admin) 
VALUES 
('user1', '123', 'user1@example.com', 'Minh Phong', 0),
('user2', '123', 'user2@example.com', 'Julien Nguyen', 0),
('sa', '123', 'admin1@example.com', 'Admin', 1), -- Changed admin1 to sa
('user3', '123', 'user3@example.com', 'Duong The', 0);
Go
INSERT INTO Genre (id, name) 
VALUES 
(1, 'Action'),
(2, 'Adventure'),
(3, 'Comedy'),
(4, 'Slice of life'),
(5, 'Fantasy');
Go
INSERT INTO Studio (id, name) 
VALUES 
(1, 'CloverWorks'),
(2, 'Wit Studio'),
(3, 'MAPPA');
Go
-- Insert sample data into Video table
INSERT INTO Video (id,title, poster, views, description, link, year, GenreId, StudioId)
VALUES 
(1,'One Punch Man', 'https://cdn.myanimelist.net/images/anime/1802/124744l.jpg', 1000, 'Before Saitama became the man he is today, he trained and fought endlessly to become a hero. While every scuffle leaves his tracksuit uniform in tatters, he always has it mended for free thanks to his local tailor. One day, however, the tailor informs him that he must close up shop due to pressure from a local gang. Saitama decides to help him out—and gains something irreplaceable in the process.', 'https://www.youtube.com/embed/UU-1oTJ3hQ4?si=1axINHqyEnylLFDF', 2019, 1,1),
(2,'The Greatest Demon Lord Is Reborn as a Typical Nobody', 'https://cdn.myanimelist.net/images/anime/1118/124210l.jpg', 1500, 'Having reached the pinnacle of human potential, Varvatos was so powerful that the rest of humankind began calling him the Demon Lord, both fearing and respecting his overwhelming influence. As a result, he felt alienated from his fellow humans, leading him to desire true companionship—an equal he could call a friend.', 'https://www.youtube.com/embed/SQv0CmSfUBg?si=7cDVYB1SL3FnygZe', 2022, 5,2),
(3,'Tokyo Revengers', 'https://cdn.myanimelist.net/images/anime/1493/113949l.jpg', 800, 'Takemichi Hanagaki s second year of middle school was the highest point in his life. He had respect, a gang of friends he could count on, and even a girlfriend. But that was twelve years ago. Today, he s a nobody: a washed-up nonentity made fun of by children and always forced to apologize to his younger boss. A sudden news report on the Tokyo Manji Gangs cruel murder of the only girlfriend he ever had alongside her brother only adds insult to injury. Half a second before a train ends his pitiful life for good, Takemichi flashes back to that same day 12 years ago, when he was still dating Hinata Tachibana.', 'https://www.youtube.com/embed/z2Yv0MbgyZo?si=JV8u7BxCKXxsjfx7', 2021 , 1,3),
(4,'Spy x Family', 'https://cdn.myanimelist.net/images/anime/1823/119156l.jpg', 1200, 'Corrupt politicians, frenzied nationalists, and other warmongering forces constantly jeopardize the thin veneer of peace between neighboring countries Ostania and Westalis. In spite of their plots, renowned spy and master of disguise "Twilight" fulfills dangerous missions one after another in the hope that no child will have to experience the horrors of war.', 'https://www.youtube.com/embed/RXHGMlHZFvE?si=ud0grUiFkvF41T5P', 2022, 4,1),
(5,'JoJos Bizarre Adventure ', 'https://cdn.myanimelist.net/images/anime/11/55267l.jpg', 2000, 'English nobleman George Joestar and his son Jonathan become indebted to Dario Brando after being rescued from a carriage incident. What the Joestars dont realize, however, is that Dario had no intention of helping them; he believed they were dead and was trying to ransack their belongings. After Darios death 12 years later, George—hoping to repay his debt—adopts his son, Dio.', 'https://www.youtube.com/embed/Uv2WZQqXOJc?si=L_HHAt0H9RuaYdZY', 2012, 2,2),
(6,'Classroom of the Elite', 'https://cdn.myanimelist.net/images/anime/1146/124827l.jpg?_gl=1*1kwal8y*_ga*MTk1MDA0NjE0Ni4xNzA5Nzg2ODU5*_ga_26FEP9527K*MTcwOTc4Njg2NC4xLjEuMTcwOTc4Njg3Mi41Mi4wLjA.', 1000, 'Life back on the cruise following the Island Special Examination is anything but smooth sailing. Almost immediately after their return, the first-year students of Tokyo Metropolitan Advanced Nurturing High School face yet another special exam, with both class and individual points on the line.', 'https://www.youtube.com/embed/4Hyncbil5fs?si=u7e513RRnX6j8P4g', 2022, 4,3),
(7,'Reborn to Master the Blade: From Hero-King to Extraordinary Squire', 'https://cdn.myanimelist.net/images/anime/1044/129594l.jpg', 1500, 'The hero-king Inglis—who dedicated his entire life to building his country—is now approaching death. To award him for his honorable achievements, the goddess Alistia appears and grants him one wish. Having never been able to master the blade, Inglis asks to be reincarnated in order to do so.', 'https://www.youtube.com/embed/eIs9FJuethQ?si=RQV6LwptOnOM3_Wd', 2021, 5,1),
(8,'The Babysitters in the School', 'https://cdn.myanimelist.net/images/anime/8/89978l.jpg', 800, 'After losing both parents in a fatal plane crash, teenager Ryuuichi Kashima must adjust to his new life as the guardian of his younger brother Kotarou. Although Ryuuichi is able to maintain a friendly and kindhearted demeanor, Kotarou is a reserved toddler still too young to understand the reality of the situation. At their parents funeral, they are approached by Youko Morinomiya, the stern chairman of an elite academy, who decides to take them under her care.', 'https://www.youtube.com/embed/7vBvvYzTNGw?si=KOU0zrneZxoC2HQd', 2018, 4,2),
(9,'Wandering Witch: The Journey of Elaina', 'https://cdn.myanimelist.net/images/anime/1802/108501l.jpg', 1200, 'Since childhood, Elaina has always been fascinated by the stories written within her favorite book, especially those about Nike, a renowned witch who had numerous great travels across the world. Wanting to experience the awe of adventure herself, Elaina strives to become a witch, and despite the numerous trials that come her way, she eventually succeeds.', 'https://www.youtube.com/embed/FdWFB2oVXkg?si=GSRcfsbtT2ODjbqC', 2020, 2,3),
(10,'Shironeko Project ZERO CHRONICLE', 'https://cdn.myanimelist.net/images/anime/1072/111360l.jpg', 800, 'The world is divided into two kingdoms: the Kingdom of White, which floats in the heavens and is ruled by their queen Iris, and the Kingdom of Black, which stands upon desolate land below and houses the King of Darkness as its ruler. As of late, forces of evil have amassed great power, posing a threat to the entire world. Being the main representative of the Light, it is Iris duty to maintain the balance of the world and fight off the darkness in her kingdom.', 'https://www.youtube.com/embed/G4_ACGXNRBU?si=Ts1cKRh_Kju8clnU', 2020, 3,1),
(12,'Shironeko Project ZERO CHRONICLE', 'https://cdn.myanimelist.net/images/anime/1072/111360l.jpg', 800, 'The world is divided into two kingdoms', 'https://www.youtube.com/embed/G4_ACGXNRBU?si=Ts1cKRh_Kju8clnU', 2020, 3,1);

INSERT INTO Favorite (videoId, UserId) 
VALUES 
(1, 'user1'),
(2, 'user2'),
(3, 'user3'),
(4, 'user1'),
(5, 'user2');

GO
----User
	--select * from [User]
--	--delete from [User]
--	--where id = '12'
--	--UPDATE [User]
-- --               SET fullname = 'a', email = 'a'
-- --               WHERE id = 'user1'
----Genre
--	select * from Genre where id= 1
----Studio
	--select * from Studio 
	--where id= 1
--	delete from Studio

----Video
	select * from Video
--	where  GenreId = 1;

--	--video year
--	select distinct year from Video 
--	order by year
	
--	--Video title
--	select * from Video
--    where title like '%an%'

--		--video phan trang
--		select * from Video 
--	order by id, [year] desc
--	OFFSET 6 ROWS
--	FETCH FIRST 6 ROWS ONLY

--	--video som nhat
--	select top 3 * from Video 
--	order by [year] desc, id

--	-- Top view
--	SELECT top 5 * FROM video v
--	order by views desc


--	--UPDATE [dbo].[video]
--	--SET poster = 'https://cdn.myanimelist.net/images/anime/11/55267l.jpg'
--	--WHERE [id] = 5;
--	--UPDATE [dbo].[video]
--	--SET link = 'https://www.youtube.com/embed/G4_ACGXNRBU?si=Ts1cKRh_Kju8clnU'
--	--WHERE [id] = 10;
	 
--	 UPDATE [dbo].[video]
--                SET views = 801
--                WHERE [id] = 10;

--	delete from Video
--	where id=20;
----Favorites
--	select DISTINCT id from Favorite f
--	where f.UserId like 'user1' and f.videoId like 1

--	Delete from Favorite
--	where [videoId] = 'user3'
--	--delete from [User]
--	--where id = 'user3'
--	select * from Video
--	where id in 
--	(select DISTINCT videoId from Favorite f where f.UserId like 'user1')

--	INSERT INTO Favorite (videoId, UserId)
--    VALUES
--     (1,'user1');


---- Report
--	--sum view
--	SELECT SUM(views) AS total_views
--	FROM Video
--	SELECT AVG(views) AS average_views
--	FROM Video

--	SELECT top 1 v.id, v.title, COUNT(f.id) AS num_favorites
--	FROM Video v
--	LEFT JOIN Favorite f ON v.id = f.videoId
--	GROUP BY v.id, v.title
--	ORDER BY num_favorites DESC

--	SELECT top 1 g.id, g.name, COUNT(v.id) AS num_videos
--	FROM Genre g
--	LEFT JOIN Video v ON g.id = v.GenreId
--	GROUP BY g.id, g.name
--	ORDER BY num_videos DESC

--	SELECT top 1 s.id, s.name, COUNT(v.id) AS num_videos
--	FROM Studio s
--	LEFT JOIN Video v ON s.id = v.StudioId
--	GROUP BY s.id, s.name
--	ORDER BY num_videos DESC
