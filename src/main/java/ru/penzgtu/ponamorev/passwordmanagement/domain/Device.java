package ru.penzgtu.ponamorev.passwordmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Device must have a name")
    private String name;
    @NotBlank(message = "Device must have an address")
    private String address;

    public Device(String name,
                  String address) {
        this.name = name;
        this.address = address;
    }

    public Device() {}

    @Override
    public String toString() {
        return "Device: id = " + getId() +
                ", name = " + getName() +
                ", address = " + getAddress();
    }
}