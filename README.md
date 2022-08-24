# Retail
## REST Design

1. User
-  Create pelanggan

*POST*  | `api/v1/pelanggan` |
--- | --- |
*Content-Type* | `aplication/json` |
Auth | Bearer Token |

    - Body:
      ```
      {    
          "id":1,
          "alamat":"menteng",
          "email":"hana@gmail.com",
          "jenis_kelamin":"perempuan",
          "nama_pelanggan":"hana",
          "no_hp":112211212,
          "no_rekening":123456789111,
          "saldo":5000,
          "ttl":"1990-03-12",
          "umur":33,
          "username":"hanadiah"
      }
      ```
      
    - Response:
      ```
      {
          "code": (respon code),
          "message":"Successfully created"
      }
      ``` 
      
-  Read Pelanggan

*GET*  | `api/v1/pelanggan` |
--- | --- |
*Content-Type* | `aplication/json` |
Auth | Bearer Token |

    - Request:
      ```
      {
            "id":1,
       }
      ```
      
    - Response:
      ```
      {
          "code": (respon code),
          "message":"Successfully created"
      }
      ```  

-  Update Pelanggan

*PUT*  | `api/v1/pelanggan` |
--- | --- |
*Content-Type* | `aplication/json` |
Auth | Bearer Token |

    - Request:
      ```
      {
            "id":1,
            "alamat":"Senen",
       }
      ```
      
    - Response:
      ```
      {
          "code": (respon code),
          "message":"Successfully created"
      }
      ``` 
      
-  Delete Pelanggan
  
*Delete*  | `api/v1/pelanggan` |
--- | --- |
*Content-Type* | `aplication/json` |
Auth | Bearer Token |

    - Request:
      ```
      {
            "id":1,
       }
      ```
      
    - Response:
      ```
      {
          "code": (respon code),
          "message":"Successfully created"
      }
      ```     
      
