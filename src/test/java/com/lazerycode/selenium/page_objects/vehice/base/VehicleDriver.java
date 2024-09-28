package com.lazerycode.selenium.page_objects.vehice.base;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDriver {
  private String driverName;         // Tên lái xe
  private String phoneNumber;         // Số điện thoại lái xe
  private String driverCode;          // Mã lái xe
  private String vehicleType;         // Loại phương tiện
  private String licensePlate;        // Biển số xe
  private String status;              // Trạng thái
  private String creationDate; // Ngày tạo
  private String updateDate;   // Ngày cập nhật
  private String description;          // Diễn giải

  public VehicleDriver(String driverName, String phoneNumber, String driverCode, String vehicleType, String licensePlate, String status) {
    this.driverName = driverName;
    this.phoneNumber = phoneNumber;
    this.driverCode = driverCode;
    this.vehicleType = vehicleType;
    this.licensePlate = licensePlate;
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VehicleDriver that = (VehicleDriver) o;
    return Objects.equals(driverName, that.driverName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(driverCode, that.driverCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driverName, phoneNumber, driverCode);
  }
}
