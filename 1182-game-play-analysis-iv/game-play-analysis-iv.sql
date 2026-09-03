# Write your MySQL query statement below
with RankedLogins As(
    select
        player_id,
        event_date,
        ROW_NUMBER()over (
            PARTITION by player_id
            order by event_date
        )as rk,
        lead(event_date)over(
            partition by player_id
            order by event_date
        )as next_login
        from Activity       
)
select 
   ROUND(
        COUNT(CASE WHEN DATEDIFF(next_login, event_date) = 1 THEN 1 END) / 
        COUNT(DISTINCT player_id), 
        2
    ) AS fraction
FROM RankedLogins
WHERE rk = 1;