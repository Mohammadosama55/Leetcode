# Write your MySQL query statement below
with FilteredStadium as(
    select
        id,
        visit_date,
        people,
        id-Row_Number() over (order by id)as group_id
        from Stadium
        where people >=100
)
select 
    id,
    visit_date,
    people
    from FilteredStadium
    where group_id in (
        select group_id
        from FilteredStadium
        group by group_id
        having count(*)>=3
    )