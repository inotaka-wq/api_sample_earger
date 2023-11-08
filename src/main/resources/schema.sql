create table if not EXISTS author( 
	id SERIAL primary key,
	first_name varchar(255),
	last_name  varchar(255)
);

create table if not EXISTS book( 
	id SERIAL primary key,
	name varchar(255),
	page_count INT,
	author_id INT,
	FOREIGN KEY(author_id) REFERENCES author(id)
);
