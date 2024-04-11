### Database Schema

![Database schema](screenshots\schema.png)

`role`

- 0 - Manager
- 1 - Admin
- 2 - User

`status`

- 0 - Accepted
- 1 - Rejected
- 2 - Waiting

### API

`POST /api/v1/auth/login`

User login.

**Request body**

```json
{
  "email": "user1@gmail.com",
  "password": "00000000"
}
```

**Response**

`200 - Ok`

```json
{
  "id": 3,
  "email": "user1@gmail.com",
  "fullName": "Maxwell Salazar",
  "birthdate": "1997-01-11",
  "workDate": "2023-06-10",
  "phone": "0123456789",
  "address": "21788 Leffler Vista Suite 094",
  "role": 2,
  "department": {
    "id": 1,
    "name": "IT"
  },
  "remainDays": 21
}
```

---

`GET /api/v1/leave_request/{userId}`

Get leave requests by _userId_.

**Response**

`200 - Ok`

```json
{
  "userId": 3,
  "leaveRequests": [
    {
      "id": 1,
      "requestedAt": "2023-08-10T09:12:00",
      "startDate": "2023-08-15",
      "endDate": "2023-08-18",
      "reason": "Sick",
      "status": 0
    },
    {
      "id": 2,
      "requestedAt": "2024-03-02T08:20:00",
      "startDate": "2024-03-03",
      "endDate": "2024-03-10",
      "reason": "Wife gives birth",
      "status": 0
    },
    {
      "id": 3,
      "requestedAt": "2024-04-04T12:38:00",
      "startDate": "2024-05-10",
      "endDate": "2024-05-12",
      "reason": "Visit family",
      "status": 2
    }
  ]
}
```

---

`POST /api/v1/leave_request`

Post leave request.

**Request body**

```json
{
  "userId": 3,
  "startDate": "2024-05-01",
  "endDate": "2024-05-03",
  "createdAt": "2024-04-11T09:13:00",
  "reason": "Sick"
}
```

**Response**

`201 - Created`

```json
{
  "id": 13,
  "startDate": "2024-05-01",
  "endDate": "2024-05-03",
  "createdAt": "2024-04-11T09:13:00",
  "createdBy": 3,
  "reason": "Sick",
  "status": 2
}
```

---

`GET /api/v1/leave_request/pagination`

Get all leave requests.

**Response**

`200 - Ok`

```json
{
  "content": [
    {
      "id": 1,
      "startDate": "2023-08-15",
      "endDate": "2023-08-18",
      "reason": "Sick",
      "status": 0,
      "createdAt": "2023-08-10T09:12:00",
      "username": "Maxwell Salazar",
      "manager": "Craig Berry"
    },
    {
      "id": 2,
      "startDate": "2024-03-03",
      "endDate": "2024-03-10",
      "reason": "Wife gives birth",
      "status": 0,
      "createdAt": "2024-03-02T08:20:00",
      "username": "Maxwell Salazar",
      "manager": "Craig Berry"
    }
  ],
  "pageNo": 0,
  "pageSize": 2,
  "totalElements": 13,
  "totalPages": 7,
  "last": false
}
```

---

`GET /api/v1/leave_request/pagination_with_userid/{userId}`

**Response**

`200 - Ok`

```json
{
  "content": [
    {
      "id": 3,
      "startDate": "2024-05-10",
      "endDate": "2024-05-12",
      "reason": "Visit family",
      "status": 2,
      "createdAt": "2024-04-04T12:38:00",
      "username": "Maxwell Salazar",
      "manager": "Craig Berry"
    }
  ],
  "pageNo": 0,
  "pageSize": 2,
  "totalElements": 1,
  "totalPages": 1,
  "last": true
}
```

---

`PUT /api/v1/leave_request/update_status/{userId}`

Update leave request status.

**Request body**

`200 - Ok`

```json
{
  "id": 3,
  "status": 0,
  "manager_id": 0
}
```

**Response**

```json
{
  "id": 3,
  "status": 0,
  "manager_id": 3
}
```

---

`GET /api/v1/leave_request/pagination_by_search/{keyword}`

Search leave requests by user _fullName_ or _reason_.

**Response**

`200 - Ok`

```json
{
  "content": [
    {
      "id": 6,
      "startDate": "2024-03-07",
      "endDate": "2024-03-08",
      "reason": "Dating",
      "status": 0,
      "createdAt": "2024-03-05T10:55:00",
      "username": "Alec Holden",
      "manager": "Craig Berry"
    },
    {
      "id": 8,
      "startDate": "2024-06-25",
      "endDate": "2024-06-26",
      "reason": "Dating",
      "status": 2,
      "createdAt": "2024-06-21T17:03:00",
      "username": "Floyd Hayward",
      "manager": "Craig Berry"
    }
  ],
  "pageNo": 0,
  "pageSize": 2,
  "totalElements": 2,
  "totalPages": 1,
  "last": true
}
```