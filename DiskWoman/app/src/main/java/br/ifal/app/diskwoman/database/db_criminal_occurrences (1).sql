create database db_criminal_occurences;
use db_criminal_occurences;

create table tb_involved_age (
	invo_age_id INT PRIMARY KEY AUTO_INCREMENT,
    invo_age VARCHAR(100) NOT NULL
);

create table tb_sexes (
	sex_id INT PRIMARY KEY AUTO_INCREMENT,
	sex_sex ENUM('FEMALE', 'MALE')
);

create table tb_involved (
	invo_id INT PRIMARY KEY AUTO_INCREMENT,
    invo_name TEXT NOT NULL,
    invo_invo_age_id INT,
    invo_sex_id INT,
    FOREIGN KEY(invo_invo_age_id) REFERENCES tb_involved_age (invo_age_id),
    FOREIGN KEY(invo_sex_id) REFERENCES tb_sexes (sex_id)
);

create table tb_addresses (
	addr_id INT PRIMARY KEY AUTO_INCREMENT,
	addr_neighborhood VARCHAR(45) NOT NULL,
    addr_street TEXT NOT NULL,
    addr_number VARCHAR(4) NOT NULL,
    addr_zip_code VARCHAR(45) NOT NULL,
    addr_city VARCHAR(45) NOT NULL
);

create table tb_offenders_age (
	offe_age_id INT PRIMARY KEY AUTO_INCREMENT,
	offe_age VARCHAR(100) NOT NULL
);

create table tb_offenders (
	offe_id INT PRIMARY KEY AUTO_INCREMENT,
    offe_name TEXT,
	offe_appearence TEXT NOT NULL,
    offe_offe_age_id INT,
    FOREIGN KEY(offe_offe_age_id) REFERENCES tb_offenders_age (offe_age_id)
);

create table tb_users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name TEXT,
    user_email VARCHAR(100)
);

create table tb_occurrences (
	occu_id INT PRIMARY KEY AUTO_INCREMENT,
    occu_title TEXT NOT NULL,
    occu_description TEXT NOT NULL,
    occu_image LONGBLOB,
    occu_media LONGBLOB,
    occu_invo_id INT,
    occu_offe_id INT,
    occu_addr_id INT,
    occu_user_id INT,
    occu_date DATE,
    occu_status ENUM('EM ESPERA', 'EM ANDAMENTO', 'CONCLUÍDO'),
    FOREIGN KEY(occu_invo_id) REFERENCES tb_involved (invo_id),
    FOREIGN KEY(occu_offe_id) REFERENCES tb_offenders (offe_id),
    FOREIGN KEY(occu_addr_id) REFERENCES tb_addresses (addr_id),
    FOREIGN KEY(occu_user_id) REFERENCES tb_users(user_id)
    
);


create table tb_polices(
	poli_id INT PRIMARY KEY AUTO_INCREMENT,
    poli_name VARCHAR(45) NOT NULL,
    poli_occu_id INT,
    poli_addr_id INT,
    FOREIGN KEY(poli_occu_id) REFERENCES tb_occurrences (occu_id),
    FOREIGN KEY(poli_addr_id) REFERENCES tb_addresses (addr_id)
);
