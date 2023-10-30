## Exercício M02S06
### Mini projeto, CRUD de tarefas

#### URL's GET:
GET http://localhost:8080/clamed/task

GET http://localhost:8080/clamed/task?status=PENDING

GET http://localhost:8080/clamed/task?priority=HIGH

GET http://localhost:8080/clamed/task?owner=Fulano

#### Método POST (JSON):
```json
{
  "description": "Tarefa 1",
  "status": "PENDING",
  "priority": "MEDIUM",
  "assigneeName": "Fulano"
}
```

#### Método PUT (JSON):
PUT http://localhost:8080/clamed/task/{id}
```json
{
  "description": "Tarefa alteração",
  "status": "COMPLETED",
  "priority": "HIGH",
  "assigneeName": "Beltrano"
}
```
#### URL DELETE:
PUT http://localhost:8080/clamed/task/{id}

