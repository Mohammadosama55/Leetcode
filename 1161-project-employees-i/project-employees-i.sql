# Write your MySQL query statement below
select
    p.project_id,
    Round(Avg(e.experience_years),2) As average_years
    from Project p
    join Employee e
        on p.employee_id=e.employee_id
        Group By p.project_id;