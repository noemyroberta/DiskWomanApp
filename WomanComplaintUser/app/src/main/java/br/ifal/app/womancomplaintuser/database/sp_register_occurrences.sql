USE db_woman_complaint;

DELIMITER $$
START TRANSACTION;

	CREATE STORED PROCEDURE `sp_register_occurrences` (IN
		var_username TEXT,
        var_email VARCHAR(100),
        var_invo_age VARCHAR(100),
        var_offe_age VARCHAR(100),
        var_offe_name TEXT,
        var_appearence TEXT,
        var_invo_name TEXT,
        )
	
    BEGIN
    
		INSERT INTO `tb_users` (user_name, user_email)
        VALUES (var_username, var_email);
        
        INSERT INTO `tb_involved_age` (invo_age)
        VALUES (var_invo_age);
        
        SET @var_invo_age_id = 0;
        SELECT MAX(`invo_age_id`) FROM `tb_involved_age` INTO @var_invo_age_id; 
        
        INSERT INTO `tb_offenders_age` (offe_age)
        VALUES (var_offe_age);
        
        SET @var_offe_age_id = 0;
        SELECT MAX(`offe_age_id`) FROM `tb_offenders_age` INTO @var_offe_age_id; 
        
        INSERT INTO `tb_offenders` (offe_name, offe_appearence, offe_offe_age_id)
        VALUES (var_offe_name, var_offe_appearence, @var_offe_age_id);
        
        
        
        
        INSERT INTO `tb_involved` (invo_name, invo_invo_age_id, invo_sex_id)
        VALUES (var_invo_name, @var_invo_age_id, @var_invo_sex_id);
        
		INSERT INTO `tb_occurrences` ()
        VALUES ();
    
    END
    
$$
		