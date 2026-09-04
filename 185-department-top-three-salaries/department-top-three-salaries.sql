# Write your MySQL query statement below
with RankedSalaries as (
    select
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        Dense_rank()over(
            partition by e.departmentId
            order by e.salary desc
        )as rk
        from Employee e
        join Department d
        On e.departmentId=d.id
)
select 
    Department,
    Employee,
    Salary
    from RankedSalaries
    where rk <=3;