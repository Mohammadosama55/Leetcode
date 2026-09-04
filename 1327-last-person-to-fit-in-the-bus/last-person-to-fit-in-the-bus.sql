# Write your MySQL query statement below
with CumulativeWeight as (
    select
        person_name,
        turn,
        sum(weight)over(order by turn asc)as total_weight
        from Queue
)
select 
    person_name
    from CumulativeWeight
    where total_weight <=1000
    order by turn desc
    limit 1;