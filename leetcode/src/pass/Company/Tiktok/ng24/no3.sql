SELECT CONCAT('Hello ', u.email, ', you have ', COUNT(t.id), ' open tasks assigned.') AS message
from users_tasks ut join users u on u.id = ut.user_id JOIN tasks t on t.id = ut.task_id
WHERE t.status in ("Open","In Progress")
GROUP BY u.email
ORDER BY u.email