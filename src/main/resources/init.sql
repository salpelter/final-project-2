create table if not exists locations (
    location_id int primary key identity(1,1),
    area varchar(100),
    expected_min_results int
);

-- just a makeshift way, for demonstration purposes only
insert into locations (area, expected_min_results)
select new.area, new.expected_min_results
from (values
          ('რუსთაველის გამზ.', 12),
          ('პეკინის გამზ.', 2),
          ('ვაჟა-ფშაველას გამზ.', 19)
     ) as new(area, expected_min_results)
where not exists (
    select 1
    from locations as original
    where original.area = new.area
);