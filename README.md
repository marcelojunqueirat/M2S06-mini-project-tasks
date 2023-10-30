## Exercício M02S06
### Mini projeto, CRUD de tarefas

#### Método POST (JSON):
```json
{
  "description": "Tarefa 1",
  "status": "PENDING",
  "priority": "MEDIUM",
  "assigneeName": "Fulano"
}
```
#### URL's:
```code
GET http://localhost:8080/clamed/task

GET http://localhost:8080/clamed/task?status=PENDING

GET http://localhost:8080/clamed/task?priority=HIGH

GET http://localhost:8080/clamed/task?owner=Fulano
```
