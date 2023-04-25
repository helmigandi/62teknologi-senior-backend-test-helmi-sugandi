# 62teknologi-senior-backend-test-helmi-sugandi

Sorry, this project is not finished as shown in the test.

## Running Database

`docker compose up -d`

## Get Nearest Business by Latitude and Longitude

- **Method**

  GET

- **URL**

  localhost:8080/api/v1/business

- **Params**

  - latitude: double
  - longitude: double

- **Response (200 - Ok)**   

  `localhost:8080/api/v1/business?longitude=106.96493038469359&latitude=-6.214604658252743`

  ```bash
  [
    {
        "id": 1,
        "alias": "molinari-delicatessen-san-francisco",
        "name": "Molinari Delicatessen",
        "coordinate": {
            "longitude": 106.96659663520195,
            "latitude": -6.210203076565325
        },
        "distance": 520.51815864,
        "attributes": [
            {
                "alias": "request_a_quote",
                "name": "Request a Quote"
            },
            {
                "alias": "reservation",
                "name": "Reservation"
            }
        ]
    },
    ...
  ]
  ```
  
- **Response (400 - Bad Request)**

  ```bash
  {
    "timestamp": "2023-04-25T16:04:40.924+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/api/v1/business"
  }
  ```
