create table if not exists locations (
    location_id int primary key identity(1,1),
    area varchar(100),
    expected_min_results int
);

insert into locations
    (area, expected_min_results)
select 'რუსთაველის გამზ.', 12
where not exists (
    select 1 from locations where area = 'რუსთაველის გამზ.'
);
