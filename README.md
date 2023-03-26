# Teckstack
- Postgres
- Java 17
# ROLE
- Admin
- User
# API
# signup
**URI**: /api/v1/auth/signup <br/>
**Method**: POST <br/>
**Request Body**: <br/>
```
{
    "name": "string",
    "username": "string",
    "email": "string",
    "password": "string"
}
```
**Response 200 OK**
```
string
```

# sign in
**URI**: /api/v1/auth/signin <br/>
**Method**: POST <br/>
**Request Body**: <br/>
```
{
    "usernameOrEmail": "string",
    "password": "string"
}
```
**Response 200 OK**
```
string
```

## Add todo
**URI**: /api/v1/todos <br/>
**Method**: POST <br/>
**ROLES**: Admin <br/>
**Request Body**: <br/>
```
{
    "category": "String",
    "name": "String",
    "assignee": Integer
}
```
**Response 200 OK**
```
{
    "category": "String",
    "name": "String",
    "assignee": Integer
}
```

# Get todo by assignee
**URI**: /api/v1/todos <br/>
**Method**: GET <br/>
**ROLES**: Admin, User <br/>
**Request params**: <br/>
1. assignee: String (required)
2. page: Integer (Optional, default value: 0)
3. limit: Integer (Optional, default value: 100)
**Response 200 OK**
```
[
    {
        "id": "Integer",
        "category": "String",
        "name": "String",
        "assignee": "Integer"
    }
]
```