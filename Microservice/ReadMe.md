# Project microservice đơn giản

1. Cấu trúc project

Cấu trúc chính gồm 3 app nhỏ gộp thành:
- Home: nơi ứng dụng chính chạy - http://localhost:8081
- Apple: ứng dụng chi tiết lấy sản phẩm thuộc apple - http://localhost:8083
- Samsung: ứng dụng chi tiết lấy sản phẩm thuộc samsung - http://localhost:8082
- Ngoài ra còn có EurekaServer tạm thời dùng để kiểm tra các ứng dụng đang hoạt động nhằm mục đích server dicovery sau này.
  
2. Chi tiết project

2.1 Xây dựng 2 đối tượng chính:
* Device:
```java
  public class Device {
    private String name;
    private String type;
    private String brand;
  }
```
*Devices:
```java
public class Devices {
    private List<Device> listDevices;
}
```
2.2 Luồng chạy
* Home app:
  * Controller: sử dụng `@Controller` để trả về view và `Thymeleaf` để render giao diện
  * Sủ dụng `RestTemplate` để gọi vào 2 ưng dụng còn lại.
* Samsung và Apple:
  * Controller: sủ dụng `@RestController` để trả về dữ liệu cần