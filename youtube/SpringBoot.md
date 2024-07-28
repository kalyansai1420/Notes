# Spring Boot

- **Spring Cloud**
  - It provides tools for developers to quickly build some of the common patterns in distributed systems.
  - Configuration management, Service discovery, Circuit breakers, Intelligent routing, Micro-proxy, Control bus, Short lived microservices and contract testing
  - Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns.
  - They will work well in any distributed environment, including the developer's own laptop, bare metal data centers and managed platforms such as Cloud Foundry

- **Services we are going to build**
  - Product Service
    - Create and view Products, acts as Product Catalog
  - Order Service
    - Can Order Products
  - Inventory Service
    - Can check if product is in stock or not
  - Notofication Service
    - Can send notifications, after order is placed.
  - Order Service, Inventory Service and Notification Service are going to interact with each other
  - Synchronous and Asynchronous Communication


## Project
- **Reference**
  - [Code and Explanation](https://programmingtechie.com/2024/03/28/spring-boot-microservices-tutorial/)

- **Spring Initializr**
  - Maven
  - 3.2.4
  - Java
  - com.kalyan.microservices
  - product-service(aritifact)
  - product-service(name)
  - Product Service(description)
  - com.kalyan.microservices.product
  - Jar
  - 21
  - Dependencies
    - Lombok
    - Spring Web
    - Spring Data MongoDb
    - Testcontainers

- **Maven**
  - mvn clean verify
    - To check the project is build successfully or not.

- docker-compose.yml
  - version: '4'
  - services:
    - mongodb:
      - image: mongo
      - container_name: mongo
      - ports:
        - "27017:27017"
      - environment:
        - MONGO_INITDB_ROOT_USERNAME: root
        - MONGO_INITDB_ROOT_PASSWORD: password
        - MONGO_INITDB_DATABASE : product-service
      - volumes:
        - ./data:/data/db
- application.properties
  - spring.data.mongodb.uri = mongodb://root:password@localhost:27017/product-service@authSource=admin
- Product.java
```java
@Document(value = 'product')
@AllArgsConstructor
@NoArgsContructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
```

- ProductRepo.java
```java
public interface ProductRepository extends MongoRespository<Product, String>{

}
```

- ProductController.java
```java
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts
    }

}


```

- ProductRequest.java (Prosent in the dto)

```java
public record ProductRequest(String id,String name, String description, BigDecimal price) {}


```

- ProductService.java
  - By using records we don't need to access field in the records we directly access using field name not need to write getters and setters for records

```java
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductReponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(),product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductReponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
```

- ProductResponse.java (Present in dto)
  
```java
public record ProductReponse(String id, String name, String descrption, BigDecimal price){

}

```

- Run the application

- Integration Tests

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplication {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
    
    @LocalServerPost
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port; 
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct(){
        String requestBody = """
        {
            "name":"iPhone 15",
            "description" : "iPhone 15 is a smartphone from apple."
            "price" :1500
        }
        """;

        RestAssured.given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post("/api/product")
            .then()
            .statusCode(201)
            .body("id",Matchers.notNullValue())
            .body("name",Matchers.equalTo("iPhone 15"))
            .body("description",Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
            .body("price",Matchers.equalTo(1500))


    }
}
```

- POM.xml

```sh
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>5.3.2</version>
</dependency>
```


## Order Service

- Dependecies
  - Spring Web
  - Lombok
  - Spring Data Jpa
  - MySQL Driver
  - TestContainers
  - Flyway Migration

- docker-compose.yml
- version: '4'
- services:
  - mysql
    - image : mysql:8.3.0
    - container_name : mysql
    - environment :
      - MYSQL_ROOT_PASSWORD : mysql
    - ports :
      - "3306:3306"
    - volumes :
      - ./mysql:/var/lib/mysql 
      - ./docker/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql

- open terminal
  - docker compose up -d

- application.properties

```sh
spring.application.name = order-service
spring.datasoource.url = jdbc:mysql://localhost:3306/order-service
spring.datasource.username = root
spring.datasource.password = mysql
spring.jpa.hibernate.ddl-auto = none
server.port = 8081
``` 

- docker folder -> mysql folder -> init.sql
  - CREATE DATABASE IF NOT EXISTS order_service;

- Order.java

```java
@Entity
@Table(name='t_orders')
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
```

- Repo

```java
public Interface OrderRepository extends JpaRepository<Order, Long> {

}
```


- Service

```java

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        // map OrderRequest to Otder object
        // save order to OrderRepository

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }
}

```

- DTO
```java
public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity){

}

```

- Controller
  
```java
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }




}

```

- resources folder -> db.migration folder -> V1__init.sql

```sh
CREATE TABLE `t_orders`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255) DEFAULT NULL,
    `sku_code` varchar(255),
    `price` decimal(19,2)
    `quantity` int(11),
    PRIMARY KEY ('id')
);
```


## Inventory Service

- Dependecies
  - Lombok
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Testcontainers
  - Flyway Migration

- docker-compose.yml
- version:'4'
- services:
  - mysql:
    - image: mysql:8.3.0
    - container_name:mysql
    - ports:
      - "3306:3306"
    - environment:
      - MYSQL_ROOT_PASSWORD: mysql
    - volumes:
      - ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
      - ./docker/mysql/data:/var/lib/mysql


- mysql -> init.sql
```sh
CREATE DATABASE IF NOT EXISTS inventory_service;
```


- application.properties
  - port:8082


- resources --> db.migration --> V1__init.sql
```sh
CREATE TABLE `t_inventory`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code` varchar(255) DEFAULT NULL,
    `quantity` int(11) DEFAULT NULL,
    PRIMARY KEY('id')
);
```
- resources --> db.migration --> V2__add_inventory.sql
```sh
insert into t_inventory(quantity,sku_code)
value (100,'iphone_15'),
        (100,'pixel_8'),
        (100,'galaxy_24'),
        (100,'oneplus_12');
```

- Model

```java

@Entity
@Table(name = 't_inventory')
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
    
}
```

- Repository

```java
@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity){
        
    }

}
```