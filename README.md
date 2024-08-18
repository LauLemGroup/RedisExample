# RedisExample - [LauLem.com](https://www.laulem.com)
Demo of using a Redis cache with Spring Data and with @Cacheable

## Getting Started

### Reference Documentation
* Redis launch :
  * https://redis.io/docs/data-types/timeseries/quickstart/
  * https://www.baeldung.com/spring-data-redis-tutorial
  * https://www.baeldung.com/spring-boot-redis-cache

### Redis launch
```
#  Start server
docker run -p 6379:6379 -it --rm redis/redis-stack-server

# Access to the server with redis CLI
docker run -it --network host --rm redis redis-cli -h localhost -p 6379
```

Récupération des informations liées aux clés via redis-cli
```
KEYS *
# Result :
1) "userItems::SimpleKey []"
2) "user::user:2"

TYPE "userItems::SimpleKey []"
# Result : string

GET "userItems::SimpleKey []"
# Result : "[\"java.util.ArrayList\",[{\"@class\":\"com.laulem.redis.example.dto.UserDto\",\"id\":2,\"firstName\":\"Alexandre\",\"lastName\":\"Lemaire\"}]]"

 GET "user::user:2"
# Result : "{\"@class\":\"com.laulem.redis.example.dto.UserDto\",\"id\":2,\"firstName\":\"Alexandre\",\"lastName\":\"Lemaire\"}"
```

### URL
* Cluster (not in this tutorial): https://redis.io/docs/management/scaling/
* Encryption: https://redis.io/docs/management/security/encryption/
* Access Control List: https://redis.io/docs/management/security/acl/
* Data access control: https://docs.redis.com/latest/rc/security/access-control/data-access-control/
