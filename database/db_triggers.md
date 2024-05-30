### db triggers
- trigger is a piece of procedural code that is automatically executed in response to a specific event occuring within a database.
- used to enforce business rules or perform automatic data processing tasks.
- ex. we can use a trigger to automatically update a record in another table when a specific field is changed in the original table
- two main types of triggers 
  - row-level triggers
  - statement-level triggers

### Mysql Triggers
- stored program which is automatically executed in response to specific events (insert,update,delete)
- 6 types of triggers
  - before insert
  - after insert
  - before update
  - after update
  - before delete
  - after delete

- create trigger : syntax trigger :
```sh
delimiter //
create trigger before_insert_user
before insert
on users for each row
begin 
set NEW.total_salary = NEW.per_hour_salary * NEW.working_hour;
end; //

delimiter ;
```


- create update trigger : update total salary based on updation on perhour salary and working houor

```sh
delimiter //
create trigger before_update_user
before update
on users for each row
begin 
set NEW.total_salary = NEW.per_hour_salary * NEW.working_hour;
end ;//
delimeter ;
```

- create delete trigger 
- create trigger : to update account_count of users

```sh
delimiter //
create trigger before_opne_account
before insert
on accounts for each row
begin
update users set acc_count = acc_couont + 1 where user_id = NEW.user_id;
end; //
delimiter ;
```


- create trigger : close account trigger 

```sh
delimiter //
create trigger before_close_account
before delete
on accounts for each row
begin
update users set acc_count = acc_count -1 where user_id = OLD.user_id;
end; //
delimiter ;
```