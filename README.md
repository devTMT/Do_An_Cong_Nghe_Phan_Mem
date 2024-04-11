`POST /api/v1/auth/login`

User login.

**Request Body**

```json
{
  "email": "email",
  "password": "password"
}
```

**Response**

```json
{
  "id": 1,
  "email": "email",
  "fullName": "fullName",
  "birthdate": "1999-11-10",
  "workDate": "2023-03-06",
  "phone": "0123456789",
  "address": "address",
  "role": 0,
  "department": "IT",
  "remainDays": 9
}
```

`GET /api/v1/leave_request/pagination_manager`

Get all leave requests.

**Response**

```json
{
  "content": [
    {
      "startDate": "2023-03-06",
      "endDate": "2023-03-06",
      "reason": "Sick",
      "status": 2,
      "createdAt": "2023-03-06",
      "username": "username",
      "manager": "manager name"
    },
    {
      "startDate": "2023-03-06",
      "endDate": "2023-03-06",
      "reason": "Sick",
      "status": 2,
      "createdAt": "2023-03-06",
      "username": "username",
      "manager": "manager name"
    }
  ],
  "pageNo": 1,
  "pageSize": 5,
  "totalElements": 20,
  "totalPages": 2,
  "last": false
}
```

`PUT /api/v1/leave_request/update_status/{id}`

Update leave request status.

**Request Body**

```json
{
  "id": 1,
  "status": 0,
  "manager": 0
}
```

**Response**

```json
{
  "id": 1,
  "status": 0,
  "manager": 0
}
```