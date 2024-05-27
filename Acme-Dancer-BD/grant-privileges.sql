grant select, insert, update, delete 
	on `acme-dancer`.* to 'acme-alumno'@'%';

grant select, insert, update, delete 
	on `acme-dancer`.* to 'acme-academia'@'%';

grant select, insert, update, delete, create, drop, references, index, alter, 
        create temporary tables, lock tables, create view, create routine, 
        alter routine, execute, trigger, show view
    on `acme-dancer`.* to 'acme-admin'@'%';
