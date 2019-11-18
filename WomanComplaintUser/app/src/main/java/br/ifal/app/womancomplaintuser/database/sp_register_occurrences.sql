USE db_woman_complaint;

DELIMITER $$
START TRANSACTION;

	CREATE STORED PROCEDURE `sp_register_occurrences` (IN
		var_name TEXT,
        var_email VARCHAR(100),
        )
	
    BEGIN
    
		INSERT INTO `tb_users` (user_name, user_email)
        VALUES (var_name, var_email);
        
        INSERT INTO `tb_`
    
    END
    
$$
    